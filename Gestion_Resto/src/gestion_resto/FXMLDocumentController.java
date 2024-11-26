package gestion_resto;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


public class FXMLDocumentController implements Initializable {
    
    @FXML
	private AnchorPane Incription_Form;
        

	@FXML
	private Button btn_Create;

	@FXML
	private Button btn_dejaCompte;

	@FXML
	private Button c_btnConnexion;

	@FXML
	private PasswordField c_mdp;

	@FXML
	private Hyperlink c_mdp_oublier;

	@FXML
	private TextField c_nom;

	@FXML
	private Button insc_btn;

	@FXML
	private PasswordField insc_mdp;

	@FXML
	private TextField insc_nom;

	@FXML
	private ComboBox<String> insc_question;

	@FXML
	private TextField inscr_reponse;

	@FXML
	private AnchorPane side_form;
        
	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;

	private Alert alert;
        
	@FXML
	private PasswordField inscr_cle;
        
	@FXML
	private AnchorPane c_connexion;
        
	@FXML
	private TextField adresse_insc;

	@FXML
	public void loginBtn() {
		if (c_nom.getText().isEmpty() || c_mdp.getText().isEmpty()) {
			alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erreur message");
			alert.setHeaderText(null);
			alert.setContentText("Les champs Nom/Mot de passe ne sont pas remplis");
			alert.showAndWait();
		} else {
			// Vérifier d'abord dans la table gérant
			String selectGerant = "SELECT * FROM gerant WHERE nom=? AND mdp=?";
			// Puis dans la table caissier
			String selectCaissier = "SELECT * FROM caissier WHERE nom=? AND mdp=?";

			connect = dataBase.connectDB();

			try {
				// Vérification gérant
				prepare = connect.prepareStatement(selectGerant);
				prepare.setString(1, c_nom.getText());
				prepare.setString(2, c_mdp.getText());
				result = prepare.executeQuery();

				if (result.next()) {
					// Connexion réussie en tant que gérant
					alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Connexion Gérant");
					alert.setHeaderText(null);
					alert.setContentText("Connexion réussie en tant que Gérant!");
					alert.showAndWait();
					// TODO: Redirection vers l'interface gérant
				} else {
					// Vérification caissier
					prepare = connect.prepareStatement(selectCaissier);
					prepare.setString(1, c_nom.getText());
					prepare.setString(2, c_mdp.getText());
					result = prepare.executeQuery();

					if (result.next()) {
						// Connexion réussie en tant que caissier
						alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("Connexion Caissier");
						alert.setHeaderText(null);
						alert.setContentText("Connexion réussie en tant que Caissier!");
						alert.showAndWait();
						// TODO: Redirection vers l'interface caissier
					} else {
						alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Échec de connexion");
						alert.setHeaderText(null);
						alert.setContentText("Identifiants incorrects");
						alert.showAndWait();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	public void regBtn() {
		if (insc_nom.getText().isEmpty() || insc_mdp.getText().isEmpty()
			|| inscr_cle.getText().isEmpty() || insc_question.getSelectionModel().getSelectedItem() == null
			|| inscr_reponse.getText().isEmpty()) {
			alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erreur message");
			alert.setHeaderText(null);
			alert.setContentText("Veuillez remplir tous les champs");
			alert.showAndWait();
		} else {
			connect = dataBase.connectDB();

			try {
				// Vérifier d'abord si la clé existe dans la table gérant
				String verifCle = "SELECT id FROM gerant WHERE cle = ?";
				prepare = connect.prepareStatement(verifCle);
				prepare.setString(1, inscr_cle.getText());
				result = prepare.executeQuery();

				if (!result.next()) {
					alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Erreur");
					alert.setHeaderText(null);
					alert.setContentText("Clé gérant invalide!");
					alert.showAndWait();
					return;
				}

				int gerantId = result.getInt("id");

				// Vérifier si le nom existe déjà dans la table caissier
				String verifNom = "SELECT nom FROM caissier WHERE nom = ?";
				prepare = connect.prepareStatement(verifNom);
				prepare.setString(1, insc_nom.getText());
				result = prepare.executeQuery();

				if (result.next()) {
					alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Erreur");
					alert.setHeaderText(null);
					alert.setContentText("Ce nom de caissier existe déjà!");
					alert.showAndWait();
					return;
				}

				// Insertion dans la table caissier
				String insertCaissier = "INSERT INTO caissier (nom, mdp, question, reponse, gerant_id, date_creation, adresse) VALUES (?, ?, ?, ?, ?, ?, ?)";
				prepare = connect.prepareStatement(insertCaissier);
				prepare.setString(1, insc_nom.getText());
				prepare.setString(2, insc_mdp.getText());
				prepare.setString(3, insc_question.getSelectionModel().getSelectedItem());
				prepare.setString(4, inscr_reponse.getText());
				prepare.setInt(5, gerantId);
				prepare.setDate(6, new java.sql.Date(new Date().getTime()));
				prepare.setString(7, adresse_insc.getText());

				int resultat = prepare.executeUpdate();
				if (resultat > 0) {
					alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Succès");
					alert.setHeaderText(null);
					alert.setContentText("Caissier enregistré avec succès!");
					alert.showAndWait();

					// Réinitialisation des champs
					insc_nom.setText("");
					insc_mdp.setText("");
					inscr_cle.setText("");
					insc_question.getSelectionModel().clearSelection();
					inscr_reponse.setText("");
					adresse_insc.setText("");
					// Animation après l'enregistrement
					TranslateTransition slider = new TranslateTransition();
					slider.setToX(0);
					slider.setNode(side_form);
					slider.setOnFinished((e) -> {
						btn_dejaCompte.setVisible(false);
						btn_Create.setVisible(true);
					});
					slider.play();

				} else {
					alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Erreur");
					alert.setHeaderText(null);
					alert.setContentText("Échec de l'enregistrement du caissier. Veuillez réessayer.");
					alert.showAndWait();
				}

			} catch (Exception e) {
				e.printStackTrace();
				alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Erreur");
				alert.setHeaderText(null);
				alert.setContentText("Erreur lors de l'enregistrement: " + e.getMessage());
				alert.showAndWait();
			}
		}
	}

	private String[] questions = {"Quel est votre couleur favorite?", "Quel est votre nourriture favorite?", "Quel est jour de votre anniversaire?"};

	@FXML
	public void reglquestionList() {
		// Création d'une ObservableList à partir du tableau questions
		ObservableList<String> listQuestions = FXCollections.observableArrayList(questions);
		// Attribution de la liste au ComboBox
		insc_question.setItems(listQuestions);
	}

	@FXML
	// methode pour effectuer les slider 
	public void switchForm(ActionEvent event) {
		TranslateTransition slider = new TranslateTransition(Duration.seconds(0.5), side_form);

		if (event.getSource() == btn_Create) {
			slider.setToX(400);
			slider.setOnFinished((e) -> {
				btn_dejaCompte.setVisible(true);
				btn_Create.setVisible(false);
				reglquestionList(); // Appel de la méthode pour remplir le ComboBox
			});
			slider.play();
		} else if (event.getSource() == btn_dejaCompte) {
			slider.setToX(0);
			slider.setOnFinished((e) -> {
				btn_dejaCompte.setVisible(false);
				btn_Create.setVisible(true);
			});
			slider.play();
		}
	}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        reglquestionList();
    }    
    
}
