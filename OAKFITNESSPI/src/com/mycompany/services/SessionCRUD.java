/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.entities.Session;
import com.mycompany.entities.User;
import com.mycompany.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class SessionCRUD {
        Connection cnxx;

    public SessionCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    SessionCRUD(int id, int role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 public void ajouterSession(Session ch) {

        String req = "INSERT INTO session (idUser,roleUser) VALUES (?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, ch.getId());
            pst.setInt(2, ch.getRole());
            pst.executeUpdate();
            System.out.println("Session ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
  public void supprimerSession() {
        String req = "TRUNCATE TABLE session";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Session supprimé avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
  public int getIdSS() {

        int id=0;

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT idUser FROM session";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                
               id =rs.getInt("idUser");
              
     
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return id;
    }

}
