/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.entities.SalleDeSport;
import com.mycompany.entities.User;
import com.mycompany.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class SalleDeSportCRUD {
    Connection cnxx;

    public SalleDeSportCRUD() {
                cnxx = MyConnection.getInstance().getCnx();
    }
    
public void ajouterSalle(SalleDeSport ch) {

        String req = "INSERT INTO salledesport (Id_responsable,NomSalle,PrixSeance,Adresse) VALUES (?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
           
            pst.setInt(1, ch.getIdResponsable());
            pst.setString(2, ch.getNom());
            pst.setFloat(3,ch.getPrixSeance());
             pst.setString(4, ch.getAdresse());
            pst.executeUpdate();
            System.out.println("Salle ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public ObservableList<SalleDeSport> afficherSalles() {

              ObservableList<SalleDeSport> myList = FXCollections.observableArrayList();


        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM salledesport";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                SalleDeSport ch = new SalleDeSport();
                ch.setId(rs.getInt("Id_Salle"));
                ch.setAdresse(rs.getString(2));
                ch.setIdResponsable(rs.getInt(3));
                ch.setNom(rs.getString(4));
                ch.setPrixSeance(rs.getFloat(5));
                myList.add(ch);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public void supprimerChallenge(int id) {
        String req = "DELETE FROM salledesport WHERE Id_Salle='" + id + "' ";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Salle supprimé avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ModifierSalle(SalleDeSport ch, int id) {
        String req = "UPDATE salledesport SET Adresse ='" + ch.getAdresse()+ "',Id_responsable ='" + ch.getIdResponsable()+ "',NomSalle = '"+ch.getNom()+"',PrixSalle = '"+ch.getPrixSeance()+"' WHERE Id_Salle = '" + id + "'";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Salle modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
