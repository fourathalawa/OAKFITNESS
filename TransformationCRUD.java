/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Transformation;
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
public class TransformationCRUD {

    Connection cnxx;

    public TransformationCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterTransformation(Transformation t) {

        String req = "INSERT INTO transformation (TitreImage,DescreptionImage,ImageAvant,ImageApres,PoidAvant,PoidApres,TailleAvant,TailleApres,IdUser) VALUES (?,?,?,?,?,?,?,?,?)";
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
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<Transformation> afficherTransformation() {

        List<Transformation> myList = new ArrayList();

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
                per.setImageAvant(rs.getString("PoidAvant"));
                per.setImageApres(rs.getString("PoidApres"));
                per.setImageAvant(rs.getString("TailleAvant"));
                per.setImageApres(rs.getString("TailleApres"));
                per.setIdUser(rs.getInt("IdUser"));
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

        List<Transformation> myList = new ArrayList();

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
		
		String requete="SELECT (PoidApres/(TailleApres*TailleApres)) As Imc FROM transformation WHERE IdImage = '" + IdImage + "'";//limit 1
		
		
		
				
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
}

