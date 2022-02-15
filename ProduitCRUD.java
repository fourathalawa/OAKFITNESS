/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entities.Produit;
import utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author kriaa
 */
public class ProduitCRUD {
    Connection cnxx;
   public ProduitCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    } 
    public void ajouterProduit(Produit p) {

        String req = "INSERT INTO produit (NomProduit,CategProduit,DescrProduit,PrixProduit,IsAvailable,ImageProduit) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, p.getNomProduit());
            pst.setString(2, p.getCategProduit());
            pst.setString(3, p.getDescrProduit());
            pst.setFloat(4, p.getPrixProduit());
            pst.setInt(5, p.getIsAvailable());
            pst.setString(6, p.getImageProduit());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public List<Produit> afficherProduit() {

        List<Produit> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM produit";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Produit per = new Produit();
                per.setIdProduit(rs.getInt("IdProduit"));
                per.setNomProduit(rs.getString("NomProduit"));
                per.setCategProduit(rs.getString("CategProduit"));
                per.setDescrProduit(rs.getString("DescrProduit"));
                per.setPrixProduit(rs.getFloat("PrixProduit"));
                per.setIsAvailable(rs.getInt("IsAvailable"));
                per.setImageProduit(rs.getString("ImageProduit"));
                myList.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }
    
    public void supprimerProduit(int IdProduit)
      {
                  String req = "DELETE FROM produit WHERE IdProduit='"+IdProduit+"' ";
                          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("Produit supprimé avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          
      }
    
     public void modifierProduit(Produit p , int IdProduit) {
        String req = "UPDATE produit SET NomProduit ='" + p.getNomProduit() + "',CategProduit ='" + p.getCategProduit() + "',DescrProduit ='" + p.getDescrProduit() + "',PrixProduit ='" + p.getPrixProduit() + "', IsAvailable ='" + p.getIsAvailable() +"',ImageProduit ='" + p.getImageProduit() + "' WHERE IdProduit = '" + IdProduit + "'";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Produit modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
public List<Produit> afficherProduitTrier1() {

        List<Produit> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM produit ORDER BY NomProduit";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Produit per = new Produit();
                per.setIdProduit(rs.getInt("IdProduit"));
                per.setNomProduit(rs.getString("NomProduit"));
                per.setCategProduit(rs.getString("CategProduit"));
                per.setDescrProduit(rs.getString("DescrProduit"));
                per.setPrixProduit(rs.getFloat("PrixProduit"));
                per.setIsAvailable(rs.getInt("IsAvailable"));
                per.setImageProduit(rs.getString("ImageProduit"));
                myList.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

public float calculerChiffreAffaire() {
		float reponse=0;
		
		String requete="SELECT SUM(PrixProduit) As Total FROM produit where IsAvailable = 1";//limit 1
		
		
		
				
		try {
                        ResultSet res=null;
			Statement st = cnxx.createStatement();
			res = st.executeQuery(requete);
			if(res.next()) {
				reponse = res.getFloat("Total");
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.err.println(ex.getMessage());
		}
		
		return reponse;
	}
}

