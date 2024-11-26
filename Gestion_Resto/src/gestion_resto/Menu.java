/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_resto;

/**
 *
 * @author Peughouia
 */
public class Menu {
    private String nom;
    private String description;
    private String type;
    private double prix;
    private int stock_dispo;

    // Constructeur
    public Menu(String nom, String description, String type, double prix, int stock_dispo) {
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

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Menu: " + nom + ", Prix: " + prix + "fcfa";
    }
}
