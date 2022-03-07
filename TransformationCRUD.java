/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Transformation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import utils.MyConnection;

/**
 *
 * @author kriaa
 */
public class TransformationCRUD {

    Connection cnxx;

    public TransformationCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterTransformation(Transformation t) {

        String req = "INSERT INTO transformation (TitreImage,DescreptionImage,ImageAvant,ImageApres,PoidAvant,PoidApres,TailleAvant,TailleApres,IdUser,Tlike) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, t.getTitreImage());
            pst.setString(2, t.getDescreptionImage());
            pst.setString(3, t.getImageAvant());
            pst.setString(4, t.getImageApres());
            pst.setFloat(5, t.getPoidAvant());
            pst.setFloat(6, t.getPoidApres());
            pst.setFloat(7, t.getTailleAvant());
            pst.setFloat(8, t.getTailleApres());
            pst.setInt(9, t.getIdUser());
            pst.setInt(10, t.getTlikes());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<Transformation> afficherTransformation() {

        List<Transformation> myList = FXCollections.observableArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM transformation";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Transformation per = new Transformation();
                per.setIdImage(rs.getInt("IdImage"));
                per.setTitreImage(rs.getString("TitreImage"));
                per.setDescreptionImage(rs.getString("DescreptionImage"));
                per.setImageAvant(rs.getString("ImageAvant"));
                per.setImageApres(rs.getString("ImageApres"));
                per.setPoidAvant(rs.getFloat("PoidAvant"));
                per.setPoidApres(rs.getFloat("PoidApres"));
                per.setTailleAvant(rs.getFloat("TailleAvant"));
                per.setTailleApres(rs.getFloat("TailleApres"));
                per.setIdUser(rs.getInt("IdUser"));
                per.setTlikes(rs.getInt("Tlike"));
                myList.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public void supprimerTransformation(int IdImage) {
        String req = "DELETE FROM transformation WHERE IdImage='" + IdImage + "' ";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Transformation supprimé avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void modifierTransformation(Transformation ts, int IdImage) {
        String req = "UPDATE transformation SET TitreImage ='" + ts.getTitreImage() + "',DescreptionImage ='" + ts.getDescreptionImage() + "',ImageAvant ='" + ts.getImageAvant() + "',ImageApres ='" + ts.getImageApres() + "',PoidAvant ='" + ts.getPoidAvant() + "',PoidApres ='" + ts.getPoidApres() +"',TailleAvant ='" + ts.getTailleAvant() + "',TailleApres ='" + ts.getTailleApres() + "' WHERE IdImage = '" + IdImage + "'";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Transformation modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

public List<Transformation> afficherTransformationTrier1() {

        List<Transformation> myList = FXCollections.observableArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM transformation ORDER BY TitreImage";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Transformation per = new Transformation();
                per.setIdImage(rs.getInt("IdImage"));
                per.setTitreImage(rs.getString("TitreImage"));
                per.setDescreptionImage(rs.getString("DescreptionImage"));
                per.setImageAvant(rs.getString("ImageAvant"));
                per.setImageApres(rs.getString("ImageApres"));
                per.setPoidAvant(rs.getFloat("PoidAvant"));
                per.setPoidApres(rs.getFloat("PoidApres"));
                per.setTailleAvant(rs.getFloat("TailleAvant"));
                per.setTailleApres(rs.getFloat("TailleApres"));
                per.setIdUser(rs.getInt("IdUser"));
                per.setTlikes(rs.getInt("Tlike"));
                myList.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

public float calculerAvantIMC(int IdImage) {
		float reponse=0;
		
		String requete="SELECT (PoidAvant/(TailleAvant*TailleAvant)) As Imc FROM transformation WHERE IdImage = '" + IdImage + "'";//limit 1
		
		
		
				
		try {
                        ResultSet res=null;
			Statement st = cnxx.createStatement();
			res = st.executeQuery(requete);
			if(res.next()) {
				reponse = res.getFloat("Imc");
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.err.println(ex.getMessage());
		}
		
		return reponse;
	}

public float calculerApresIMC(int IdImage) {

		float reponse=0;
		
		String requete="SELECT (PoidApres/(TailleApres*TailleApres)) As Imca FROM transformation WHERE IdImage = '" + IdImage + "'";//limit 1
		
		
		
				
		try {
                        ResultSet res=null;
			Statement st = cnxx.createStatement();
			res = st.executeQuery(requete);
			if(res.next()) {
				reponse = res.getFloat("Imca");
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.err.println(ex.getMessage());
		}
		
		return reponse;
	}
    public void LikeTransformation(int IdImage) {
        String req = " UPDATE transformation SET Tlike=Tlike+1 WHERE IdImage = '" + IdImage + "'";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Transformation Like avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
public void unLikeTransformation(int IdImage) {
        String req = " UPDATE transformation SET Tlike=Tlike-1 WHERE IdImage = '" + IdImage + "'";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Transformation unLike avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
//
public List<Transformation> afficherTransformationLike() {

        List<Transformation> myList = FXCollections.observableArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM transformation ORDER BY Tlike DESC ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Transformation per = new Transformation();
                per.setIdImage(rs.getInt("IdImage"));
                per.setTitreImage(rs.getString("TitreImage"));
                per.setDescreptionImage(rs.getString("DescreptionImage"));
                per.setImageAvant(rs.getString("ImageAvant"));
                per.setImageApres(rs.getString("ImageApres"));
                per.setPoidAvant(rs.getFloat("PoidAvant"));
                per.setPoidApres(rs.getFloat("PoidApres"));
                per.setTailleAvant(rs.getFloat("TailleAvant"));
                per.setTailleApres(rs.getFloat("TailleApres"));              
                per.setIdUser(rs.getInt("IdUser"));
                per.setTlikes(rs.getInt("Tlike"));
                myList.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }
}