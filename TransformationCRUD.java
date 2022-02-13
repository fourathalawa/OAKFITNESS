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

        String req = "INSERT INTO transformation (TitreImage,DescreptionImage,ImageAvant,ImageApres,IdUser) VALUES (?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, t.getTitreImage());
            pst.setString(2, t.getDescreptionImage());
            pst.setString(3, t.getImageAvant());
            pst.setString(4, t.getImageApres());
            pst.setInt(5, t.getIdUser());
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
        String req = "UPDATE transformation SET TitreImage ='" + ts.getTitreImage() + "',DescreptionImage ='" + ts.getDescreptionImage() + "',ImageAvant ='" + ts.getImageAvant() + "',ImageApres ='" + ts.getImageApres() + "' WHERE IdImage = '" + IdImage + "'";
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
                per.setIdUser(rs.getInt("IdUser"));
                myList.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }
}

