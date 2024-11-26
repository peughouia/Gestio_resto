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
public class Commande {
    private ArrayList<Menu> menus;

    public Commande(/*ArrayList<Menu> menus*/) {
        this.menus = new ArrayList<>();
    }
    
    
    public void ajouterMenu(Menu menu) {
        menus.add(menu);
    }
    
    public double calculerTotal() {
        double total = 0;
        for (Menu menu : menus) {
            total += menu.getPrix();
        }
        return total;
    }
    
    public void afficherCommande() {
        System.out.println("Commande:");
        for (Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println("Total: " + calculerTotal() + "€");
    }
    
    public ArrayList<Menu> getMenus() {
        return menus;
    }
    
    public static void main(String[] args) {
        // Création de quelques objets Menu
        Menu menu1 = new Menu("pizza", "monsongo","plat",1500,15);
        Menu menu2 = new Menu("pizza2", "monsongo","plat",2000,15);
        Menu menu3 = new Menu("pizza3", "monsongo","plat",3500,15);
        
        //ArrayList<Menu> menus = new ArrayList<>();
        // Création d'une commande
        Commande commande = new Commande();

        // Ajout des menus à la commande
        commande.ajouterMenu(menu1);
        commande.ajouterMenu(menu2);
        commande.ajouterMenu(menu3);

        // Affichage de la commande avec le total
        commande.afficherCommande();
    }
}
