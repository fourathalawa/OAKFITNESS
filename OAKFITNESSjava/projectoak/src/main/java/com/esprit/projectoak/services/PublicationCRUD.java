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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            pst.setString(3, java.time.LocalDate.now().toString());
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
                per.setImagePublication(rs.getString(3));
                per.setDatePublication(rs.getString(4));
                per.setPublication(rs.getString(5));
                per.comm = extractComment(rs.getInt("IDpublication"));
                myList.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public List<Publication> triPulication(int n) {
        List<Publication> myList = new ArrayList();
        if (n == 1) {
            try {
                Statement st = cnxx.createStatement();
                String req = "SELECT * FROM publication ORDER BY DatePublication ASC";
                ResultSet rs;
                rs = st.executeQuery(req);
                while (rs.next()) {

                    Publication per = new Publication();

                    per.setIDpublication(rs.getInt("IDpublication"));
                    per.setIDuser(rs.getInt("IDuser"));
                    per.setImagePublication(rs.getString(3));
                    per.setDatePublication(rs.getString(4));
                    per.setPublication(rs.getString(5));
                    per.comm = extractComment(rs.getInt("IDpublication"));
                    myList.add(per);
                }
                System.out.println(myList);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                //   return null;
            }
        } else if (n == 2) {
            try {
                Statement st = cnxx.createStatement();
                String req = "SELECT * FROM publication ORDER BY DatePublication DESC";
                ResultSet rs;
                rs = st.executeQuery(req);
                while (rs.next()) {

                    Publication per = new Publication();

                    per.setIDpublication(rs.getInt("IDpublication"));
                    per.setIDuser(rs.getInt("IDuser"));
                    per.setImagePublication(rs.getString(3));
                    per.setDatePublication(rs.getString(4));
                    per.setPublication(rs.getString(5));
                    per.comm = extractComment(rs.getInt("IDpublication"));
                    myList.add(per);
                }
                System.out.println(myList);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                //   return null;
            }
        } else {
            System.out.println("parametre invalide!");
        }
        return myList;
    }

    public List<Publication> chercherPublication(String mot) {
        List<Publication> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM publication WHERE Publication LIKE '%" + mot + "%' ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Publication per = new Publication();

                per.setIDpublication(rs.getInt("IDpublication"));
                per.setIDuser(rs.getInt("IDuser"));
                per.setImagePublication(rs.getString(3));
                per.setDatePublication(rs.getString(4));
                per.setPublication(rs.getString(5));
                per.comm = extractComment(rs.getInt("IDpublication"));
                myList.add(per);
            }
            System.out.println("recherche resulatat du mot:  " + mot + "  " + myList);
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
            String req = "Select * FROM commentaire HAVING IDpublication ='" + id + "' ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Commentaire per = new Commentaire();

                per.setIDCommentaire(rs.getInt("IDCommentaire"));
                per.setIDPublication(rs.getInt("IDPublication"));
                per.setIDUser(rs.getInt("IDUser"));
                per.setCommentaire(rs.getString(4));
                per.setDateCommentaire(rs.getString(5));
                per.setNomCommentaire(extractNom(rs.getInt("IDUser")));
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

}
