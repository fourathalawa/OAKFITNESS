/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.services;

import com.esprit.projectoak.entities.Commentaire;
import com.esprit.projectoak.entities.Reclamation;
import com.esprit.projectoak.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class CommentaireCRUD {

    Connection cnxx;

    public CommentaireCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterCommentaire() {
        String req = "INSERT INTO commentaire (IDPublication,IDUser,Commentaire,DateCommentaire)"
                + "VALUES (1,1,'nn','jj')";
        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(req);

            System.out.println("commentaire ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void ajouterCommentaire2(Commentaire p) {

        String req = "INSERT INTO commentaire (IDPublication,IDUser,Commentaire,DateCommentaire) VALUES (?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, p.getIDPublication());
            pst.setInt(2, p.getIDUser());
            pst.setString(3, p.getCommentaire());
            pst.setString(4, java.time.LocalDate.now().toString());

            pst.executeUpdate();
            System.out.println("commentaire ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void modifierPulication(int id, Commentaire p) {

        String req = "UPDATE commentaire set Commentaire=? WHERE IDCommentaire = ?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, p.getCommentaire());
            pst.setInt(2, id);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void supprimerCommentaire(int id) {

        String req = "Delete FROM commentaire WHERE IDCommentaire = ?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<Commentaire> afficherCommentaire() {
        List<Commentaire> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM commentaire inner join publication"
                    + " on publication.IDpublication = commentaire.IDPublication ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Commentaire per = new Commentaire();
                per.setIDCommentaire(rs.getInt("IDCommentaire"));
                per.setIDPublication(rs.getInt("IDPublication"));
                per.setIDUser(rs.getInt("IDUser"));
                per.setCommentaire(rs.getString(1));
                per.setDateCommentaire(rs.getString(2));
                myList.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
//test
    }

     public ObservableList<Commentaire> extractComment(int id) {
        ObservableList<Commentaire> myList = FXCollections.observableArrayList();
        try {
            Statement st = cnxx.createStatement();
            String req = "Select * FROM commentaire HAVING IDpublication ='" + id + "' ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Commentaire per = new Commentaire();
                per.setNomCommentaire(extractNom(rs.getInt("IDUser")));
                per.setCommentaire(rs.getString(4));
                per.setDateCommentaire(rs.getString(5));
                per.setIDCommentaire(rs.getInt("IDCommentaire"));
                NoteCommentaireCRUD nc = new NoteCommentaireCRUD();
                per.setNote(nc.note((rs.getInt("IDCommentaire"))));
                per.setIDUser((rs.getInt("IDUser")));
                //per.setNote(rs.getInt("IDCommentaire"));
                myList.add(per);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;

    }

    public String extractNom(int id) {
        String nom = "";
        try {
            Statement st = cnxx.createStatement();
            String req = "Select * FROM user WHERE userID ='" + id + "' ";
            ResultSet rs;
            rs = st.executeQuery(req);
             while (rs.next()) {
            nom =  rs.getString(2);
              }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return nom;

    }
        public void modifierPulication2(int id,String comment) {

        String req = "UPDATE commentaire set Commentaire=? WHERE IDCommentaire = ?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, comment);
            pst.setInt(2, id);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

}
