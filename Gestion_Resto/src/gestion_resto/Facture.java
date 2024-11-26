/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_resto;
import java.util.ArrayList;
/**
 *
 * @author Peughouia
 */
public class Facture {
    private ArrayList<Commande> commandes;
    
    // Constructeur
    public Facture() {
        commandes = new ArrayList<>();
    }
    
    //Méthode pour ajouter une commande à la facture
    public void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }
    
    // Méthode pour calculer le total de la facture
    public double calculerTotalFacture() {
        double totalFacture = 0;
        for (Commande commande : commandes) {
            totalFacture += commande.calculerTotal();
        }
        return totalFacture;
    }
    
    public void afficherFacture() {
        System.out.println("Facture:");
        for (Commande commande : commandes) {
            commande.afficherCommande();  // Afficher chaque commande
            System.out.println();  // Ligne vide pour séparer les commandes
        }
        System.out.println("Total facture: " + calculerTotalFacture() + "€");
    }

    public ArrayList<Commande> getCommandes() {
        return commandes;
    }
    
    public static void main(String[] args) {
        // Création de quelques objets Menu
        Menu menu1 = new Menu("pizza", "monsongo","plat",1500,15);
        Menu menu2 = new Menu("pizza2", "monsongo","plat",2000,15);
        Menu menu3 = new Menu("pizza3", "monsongo","plat",3500,15);
        
        //ArrayList<Menu> menus = new ArrayList<>();
        // Création d'une commande
        Commande commande1 = new Commande();
        // Ajout des menus à la commande
        commande1.ajouterMenu(menu1);
        commande1.ajouterMenu(menu2);
        
        //ArrayList<Menu> menus2 = new ArrayList<>();
        Commande commande2 = new Commande();
        commande2.ajouterMenu(menu3);
        commande2.ajouterMenu(menu1);
        
        Facture facture = new Facture();
        facture.ajouterCommande(commande1);
        facture.ajouterCommande(commande2);

        // Affichage de la commande avec le total
        facture.afficherFacture();
    }
}
