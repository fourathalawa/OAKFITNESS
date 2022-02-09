/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.entities.Challenge;
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
public class ChallengeCRUD {
    Connection cnxx;

    public ChallengeCRUD() {
        cnxx= MyConnection.getInstance().getCnx();
                }
    public void ajouterChallenge() {

        String req = "INSERT INTO challenge (DateDebut,DateFin,Objectif,IdUser) VALUES ('02/24/2015','07/04/2015','aaaaa',17)";

        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(req);

            System.out.println("Challenge ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
      public void ajouterPersonne2(Challenge ch) {

        String req = "INSERT INTO challenge (DateDebut,DateFin,Objectif,IdUser) VALUES (?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, ch.getDateDebut());
            pst.setString(2, ch.getDateFin());
            pst.setString(3, ch.getObjectif());
            pst.setInt(4, ch.getIdUser());
            pst.executeUpdate();
                        System.out.println("Challenge ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
      public List<Challenge> afficherChallenge() {

        List<Challenge> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM challenge";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Challenge ch = new Challenge();
                ch.setIdChallenge(rs.getInt("IdChallenge"));
                ch.setDateDebut(rs.getString(2));
                ch.setDateFin(rs.getString(3));
                ch.setObjectif(rs.getString(4));
                ch.setIdUser(rs.getInt(5));
                myList.add(ch);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }
      
      public void supprimerChallenge(int id)
      {
                  String req = "DELETE FROM challenge WHERE IdChallenge='"+id+"' ";
                          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("Challenge supprimé avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          
      }

      
      public void ModifierChallenge(Challenge ch, int id)
      {
           String req = "UPDATE challenge SET DateDebut ='"+ch.getDateDebut()+"',DateFIN ='"+ch.getDateFin()+"',Objectif ='"+ch.getObjectif()+"' WHERE idChallenge = '"+id+"'";
          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("Challenge modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          
      }
}
