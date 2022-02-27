/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author touns
 */



public class myCnx {
    public String url="jdbc:mysql://localhost/oakfitness2";
    public String login="root";
    public String pwd="";
    Connection cnx;
    public static myCnx instance;

    public myCnx() {
        try {
          cnx =  DriverManager.getConnection(url,login,pwd);
          System.out.println("Connexion etablie!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public Connection getCnx() {
        return cnx;
    }

   public static myCnx getInstance() {

        if (instance == null) {

            instance = new myCnx();
        }
        return instance;

    }


}