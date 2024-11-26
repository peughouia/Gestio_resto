/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_resto;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Peughouia
 */
public class dataBase {
    public static Connection connectDB() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/restaurants", "root", ""); // connection a la base de donner 
			return connect;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
}
