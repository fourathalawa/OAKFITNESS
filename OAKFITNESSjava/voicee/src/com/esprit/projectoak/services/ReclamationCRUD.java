/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.services;

import com.esprit.projectoak.entities.Reclamation;
import com.esprit.projectoak.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class ReclamationCRUD {

    Connection cnxx;

    public ReclamationCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterReclamation() {
        String req = "INSERT INTO reclamation (IDUserReclamation,CategReclam,DescrReclam,DateReclam)"
                + "VALUES (3,5,'cest un test','22/22/2022')";
        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(req);

            System.out.println("reclamation ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void ajouterReclamation2(Reclamation p) {
        if (p.getCategReclam() > 0 && p.getCategReclam() < 4) {
            String req = "INSERT INTO reclamation (DescrReclam,CategReclam,DateReclam,EtatReclamation,IDUserReclamation) VALUES (?,?,?,?,?)";
            PreparedStatement pst;
            try {
                pst = cnxx.prepareStatement(req);
                pst.setString(1, p.getDescrReclam());
                pst.setInt(2, p.getCategReclam());
                pst.setString(3, java.time.LocalDate.now().toString());
                pst.setInt(4, 0);
                pst.setInt(5, -1);

                pst.executeUpdate();
                System.out.println("reclamation ajouté avec succés");

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            System.out.println("categorie introuvale!");

        }
    }

    public void modifierReclamation(int id) {

        String req = "UPDATE reclamation set EtatReclamation=? WHERE IDReclamation ='" + id + "' ";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, 1);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void supprimerReclamation(int id) {

        String req = "Delete FROM reclamation WHERE IDReclamation = ?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<Reclamation> afficherReclamation() {
        List<Reclamation> myList = new ArrayList();
        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM reclamation";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Reclamation per = new Reclamation();
                // per.setIDReclamation(rs.getInt("IDReclamation"));
                per.setIDUserReclamation(rs.getInt("IDUserReclamation"));
                per.setCategReclam(rs.getInt("CategReclam"));
                per.setDescrReclam(rs.getString(3));
                per.setDateReclam(rs.getString(5));
                myList.add(per);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public void pourcentageCategorie() {
        Map<String, Double> sc = new HashMap<>();
        try {
            Statement st = cnxx.createStatement();
            // String req = "SELECT CategReclam, AVG(CategReclam) AS avgScore FROM reclamation GROUP BY CategReclam";
            String req = "Select CategReclam, (Count(CategReclam)* 100 / (Select Count(*) From reclamation)) as Score From reclamation Group By CategReclam";

            ResultSet rs;
            rs = st.executeQuery(req);

            while (rs.next()) {
                sc.put(rs.getString("CategReclam"), rs.getDouble("Score"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }

        sc.forEach((k, v) -> System.out.println("categorie: " + k + ", pourcentage reclamation seleon categorie: " + v + "%"));
    }

    public void ReclamerComment(Reclamation p) {
        if (p.getCategReclam() > 0 && p.getCategReclam() < 4) {
            String req = "INSERT INTO reclamation (IDUserReclamation,DescrReclam,CategReclam,DateReclam,CommentaireRec,PubRec,EtatReclamation,idCommentReclam) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst;
            try {
                pst = cnxx.prepareStatement(req);
                pst.setInt(1, p.getIDUserReclamation());
                pst.setString(2, p.getDescrReclam());
                pst.setInt(3, p.getCategReclam());
                pst.setString(4, java.time.LocalDate.now().toString());
                pst.setString(5, p.getCommentaireRec());
                pst.setString(6, p.getPubRec());
                pst.setInt(7, 0);
                pst.setInt(8, p.getIdCommentReclam());

                pst.executeUpdate();
                System.out.println("reclamation ajouté avec succés");

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            System.out.println("categorie introuvale!");

        }

    }

    public ObservableList<Reclamation> afficherReclamation2() {
        ObservableList<Reclamation> myList = FXCollections.observableArrayList();
        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM reclamation";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Reclamation per = new Reclamation();
                // per.setIDReclamation(rs.getInt("IDReclamation"));
                per.setIDReclamation(rs.getInt("IDReclamation"));
                per.setIDUserReclamation(rs.getInt("IDUserReclamation"));
                per.setCategReclam(rs.getInt("CategReclam"));
                per.setEtatReclamation(rs.getInt("EtatReclamation"));
                per.setDescrReclam(rs.getString(3));
                per.setDateReclam(rs.getString(5));
                per.setCommentaireRec(rs.getString("CommentaireRec"));
                per.setPubRec(rs.getString("PubRec"));
                per.setIdCommentReclam(rs.getInt("idCommentReclam"));

                myList.add(per);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public void ajouterSuppression(int id) {

        String req = "INSERT INTO suppression (idUserS) VALUES (?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("reclamation ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public boolean nbSupp(int idCommentaire) { //1 = + 2 = -
        int total = 0;
        boolean check = false;
        try {
            Statement st = cnxx.createStatement();
            String req = "Select COUNT(idUserS) FROM suppression where idUserS='" + idCommentaire + "' ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                total = rs.getInt(1);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        System.out.println("total"+total);
        if (total >= 3) {
            check = true;
        }
        return check;
    }

}
