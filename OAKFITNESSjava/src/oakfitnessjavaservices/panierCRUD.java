/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oakfitnessjavaservices;

import oakfitnessjavaEntities.panier;
import utils.myCnx;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author touns
 */
public class panierCRUD {

    Connection cnxx;

    public panierCRUD() {
        cnxx = myCnx.getInstance().getCnx();
    }

    public void ajouterpanier(panier p) {
        String Request = "INSERT INTO panier (id_client,id_produit,quantity,total)"
               +" VALUES (?,?,?,((select prix from produit where produit.id=?)*quantity))" 
                + " where (select stock from produit where produit.id=?) > quantity";
        String Request2 = "update produit set stock=stock-? where id=?" ;

        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(Request2);
           
            pst.setInt(1,p.getQuantity());
            pst.setInt(2,p.getId_produit());
            pst.executeUpdate();
            System.out.println("stock updated");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        try {
            pst = cnxx.prepareStatement(Request);
            pst.setInt(1, p.getId_client());
            pst.setInt(2, p.getId_produit());
            pst.setInt(3, p.getQuantity());
            pst.setInt(4, p.getId_produit());
            pst.setInt(5, p.getId_produit());
            pst.executeUpdate();
            System.out.println("produit ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<panier> afficherpanier(int id) {
        List<panier> myList = new ArrayList();

        try {
            
            String req = "SELECT * FROM panier where id_client=?";
            PreparedStatement st = cnxx.prepareStatement(req);
            st.setInt(1,id);
            ResultSet rs;
            rs = st.executeQuery();
            while (rs.next()) {

                panier ex = new panier();
                ex.setId(rs.getInt(1));
                ex.setId_client(rs.getInt(2));
                ex.setId_produit(rs.getInt(3));
                ex.setQuantity(rs.getInt(4));
                 ex.setTotal(rs.getInt(5));
                myList.add(ex);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //   return null;
        }
        return myList;
    }

    public void supprimerPanier(int id) {
        String Request = "DELETE FROM panier WHERE id=? ";

        PreparedStatement pst;

        try {
            
            pst = cnxx.prepareStatement(Request);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Produit supprimé avec succés");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void ModifierQteProduit(int Qte, int idproduit) {
        String req = "UPDATE panier SET qte =? WHERE Idproduit = ?";
        
        
        try {
            PreparedStatement pst=cnxx.prepareStatement(req);
            pst.setInt(1,Qte);
            pst.setInt(2,idproduit);
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Quantité modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public double calculerTotalPanier(int id) {
        double total=0;

        try {
         
            String req = "SELECT sum(total) FROM panier where id_client=?";
            
            PreparedStatement pst=cnxx.prepareStatement(req);
            
            pst.setInt(1,id);
            ResultSet rs=pst.executeQuery();
            
            while (rs.next()) {

                total=rs.getDouble("sum(total)");
               
              
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //   return null;
        }

      
        return total;
    }

    public boolean viderPanier(int id) {

        try {
            PreparedStatement st = cnxx.prepareStatement("Delete from panier where id_client=?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
            
        }

    }

}
