/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_resto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Peughouia
 */
public class Menu {
    private String nom;
    private String description;
    private String type;
    private int prix;
    private int stock_dispo;

    // Constructeur
    public Menu(String nom, String description, String type, int prix, int stock_dispo) {
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.prix = prix;
        this.stock_dispo = stock_dispo;
    }

    // Méthodes d'accès (getters)
    public String getNom() {
        return nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStock_dispo(int stock_dispo) {
        this.stock_dispo = stock_dispo;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getStock_dispo() {
        return stock_dispo;
    }

    public double getPrix() {
        return prix;
    }

    // Méthodes de modification (setters)
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    public boolean saveMenu(){
        dataBase co = new dataBase();
        Connection con = co.connectDB();
        String query = "INSERT INTO menu(nom, description, type, prix, stock_dispo)"+ "VALUES ('"
                +this.nom+"','"+this.description+"','"+this.type+"','"+this.prix+"','"+this.stock_dispo+"')";
        try{
            //Creation de lobjet
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("menu enregistré");
            con.close();
            return true;
        }catch(SQLException e){
            System.out.print("echec");
            e.printStackTrace();
            return false;
        }
    } 

    @Override
    public String toString() {
        return "Menu: " + nom + ", Prix: " + prix + "fcfa";
    }
    
    public static void main(String[] args) {
        // Créer une instance de BookDAO et enregistrer un livre
        Menu menu = new Menu("orange frute", "jus orange base orange et cerise", "boisson", 5000, 30);
        menu.saveMenu();
    }
}
