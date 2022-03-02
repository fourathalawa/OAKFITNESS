/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.services;

import com.esprit.projectoak.entities.User;
import com.esprit.projectoak.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class userCRUD {

    Connection cnxx;

    public userCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajoutUser(User u) {
        String req = "INSERT INTO user (userID,userName,userMail) VALUES (?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, u.getUserID());
            pst.setString(2, u.getUserName());
            pst.setString(3, u.getUserMail());
            pst.executeUpdate();
            System.out.println("user ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void supprimerUser(int id){
        System.out.println("i deleted this user");
    }
}
