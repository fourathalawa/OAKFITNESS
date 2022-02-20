/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.services;

import com.esprit.projectoak.entities.Commentaire;
import com.esprit.projectoak.entities.NoteCommentaire;
import com.esprit.projectoak.entities.Reclamation;
import com.esprit.projectoak.entities.User;
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
public class NoteCommentaireCRUD {

    Connection cnxx;

    public NoteCommentaireCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void Like(int idCommentaire, int idUSer) { //1 = + 2 = -
        //NoteCommentaire n = new NoteCommentaire();
        // int idComm = p.getIDCommentaire();
        if (check(idCommentaire, idUSer) == 0) {
            String req = "INSERT INTO notecommentaire (userID,IDCommentaire,isLike) VALUES (?,?,?)";
            PreparedStatement pst;
            try {
                pst = cnxx.prepareStatement(req);
                pst.setInt(1, idUSer);
                pst.setInt(2, idCommentaire);
                pst.setInt(3, 1);
                pst.executeUpdate();
                System.out.println("publication ajouté avec succés");

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            System.out.println("can't like 2 times ");
        }

    }

    public void undo(int idCommentaire, int idUSer) { //1 = + 2 = -
        String req = "UPDATE notecommentaire set isLike=0 WHERE userID = ? AND IDCommentaire= ?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, idUSer);
            pst.setInt(2, idCommentaire);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void dislike(int idCommentaire, int idUSer) { //1 = + 2 = -
        //NoteCommentaire n = new NoteCommentaire();
        // int idComm = p.getIDCommentaire();

        String req = "INSERT INTO notecommentaire (userID,IDCommentaire,isLike) VALUES (?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, idUSer);
            pst.setInt(2, idCommentaire);
            pst.setInt(3, -1);
            pst.executeUpdate();
            System.out.println("publication ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public int check(int idCommentaire, int userID) { //1 = + 2 = -
        int total = 0;

        try {
            Statement st = cnxx.createStatement();
            String req = "Select count(*) FROM notecommentaire where IDCommentaire='" + idCommentaire + "' && userID='" + userID + "' ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                total = rs.getInt(1);

            }
            System.out.println(total);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return total;
    }

    public int note(int idCommentaire) { //1 = + 2 = -
        int total = 0;

        try {
            Statement st = cnxx.createStatement();
            String req = "Select SUM(isLike) FROM notecommentaire where IDCommentaire='" + idCommentaire + "' ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                total = rs.getInt(1);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return total;
    }
}
