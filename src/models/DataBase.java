/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL_COREI5
 */
public class DataBase {
    private static final String URL = "jdbc:mysql://localhost/db_aeropuerto";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    public Connection conectarBD(){
       Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("\nExito al conectarse a la DB");
            return conexion;
        } catch (Exception error) {
            System.out.println("\nProblemas en la conexión" + error);
            return null;
        }
    }
}
