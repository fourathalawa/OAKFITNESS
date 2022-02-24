/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.WishList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Utilities.MyConnection;


/**
 *
 * @author mahdi
 */
public class WishListCRUD {
    
 Connection cnxx;

    public WishListCRUD() {
        cnxx= MyConnection.getInstance().getCnx();
                }
    /*public void ajouterChallengeD() {
        String req = "INSERT INTO challenge (DateDebut,DateFin,Objectif,IdUser) VALUES ('02/24/2015','07/04/2015','aaaaa',17)";
        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(req);
            System.out.println("Challenge ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }*/
      public void ajouterWishList(WishList ch) {

        String req = "INSERT INTO wishlist (IdWishlist,IdProduit,IdUser,Note) VALUES (?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, ch.getIdWishList());
            pst.setInt(2, ch.getIdProduit());
            pst.setInt(3, ch.getIdUser());
            pst.setString(4, ch.getNote());
            pst.executeUpdate();
                        System.out.println("Wishlist ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
      public List<WishList> afficherWishList() {

        List<WishList> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM wishlist";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                WishList ch = new WishList();
                ch.setIdWishList(rs.getInt("IdWishList"));
                ch.setIdProduit(rs.getInt(2));
                ch.setIdUser(rs.getInt(3));
                ch.setNote(rs.getString(4));
                myList.add(ch);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }
      
      public void supprimerWishList(int id)
      {
                  String req = "DELETE FROM wishlist WHERE IdWishList='"+id+"' ";
                          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("wishlist supprimé avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          
      }

      
      public void ModifierChallenge(WishList ch, int id)
      {
           String req = "UPDATE wishlist SET note ='"+ch.getNote()+"' WHERE idWishList = '"+id+"'";
          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("WishList modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          
      }
      
      
}