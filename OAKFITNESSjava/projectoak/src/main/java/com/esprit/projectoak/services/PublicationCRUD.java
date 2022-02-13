/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.services;

import com.esprit.projectoak.entities.Commentaire;
import com.esprit.projectoak.entities.Publication;
import com.esprit.projectoak.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class PublicationCRUD {

    Connection cnxx;

    public PublicationCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterPulication() {
        String req = "INSERT INTO publication (IDuser,ImagePublication,DatePublication,Publication)"
                + "VALUES (2,'nknkn','knknk','kkq')";
        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(req);

            System.out.println("Publication ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void ajouterPulication2(Publication p) {

        String req = "INSERT INTO publication (IDuser,ImagePublication,DatePublication,Publication) VALUES (?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, p.getIDuser());
            pst.setString(2, p.getImagePublication());
            pst.setString(3, p.getDatePublication());
            pst.setString(4, p.getPublication());

            pst.executeUpdate();
            System.out.println("publication ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void modifierPulication(int id, Publication p) {

        String req = "UPDATE publication set ImagePublication=?,Publication=? WHERE IDpublication = ?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, p.getImagePublication());
            pst.setString(2, p.getPublication());
            pst.setInt(3, id);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void supprimerPublication(int id) {

        String req = "Delete FROM publication WHERE IDpublication = ?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<Publication> afficherPulication() {
        List<Publication> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM publication";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Publication per = new Publication();

                per.setIDpublication(rs.getInt("IDpublication"));
                per.setIDuser(rs.getInt("IDuser"));
                per.setDatePublication(rs.getString(4));
                per.setImagePublication(rs.getString(2));
                per.setPublication(rs.getString(3));
                per.comm = extractComment(rs.getInt("IDpublication"));
                myList.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }
public List<Commentaire> extractComment(int id) {
 List<Commentaire> myList = new ArrayList();
        try {
            Statement st = cnxx.createStatement();
        String req = "Select * FROM commentaire HAVING IDpublication ='"+id+"' ";
         ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Commentaire per = new Commentaire();

                per.setIDCommentaire(rs.getInt("IDCommentaire"));
                per.setIDPublication(rs.getInt("IDPublication"));
                per.setIDUser(rs.getInt("IDUser"));
                per.setCommentaire(rs.getString(4));
                per.setDateCommentaire(rs.getString(5));
                myList.add(per);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
     
    }

}
