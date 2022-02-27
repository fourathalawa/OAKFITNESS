/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.services;

import com.mycompany.oakfitnessjava.entities.ProgrammeNutritionnel;
import com.mycompany.oakfitnessjava.entities.Repas;
import com.mycompany.oakfitnessjava.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heni Nechi
 */
public class ProgrammeNutritionnelCRUD {

    Connection cnxx;

    public ProgrammeNutritionnelCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterProgrammeNutritionnel() {
        String Request = "INSERT INTO ProgrammeNutritionnel (IDCoach,IDAdherent,Calorie,TypeProgrammeNutritionnel)"
                + " VALUES (1,1,1,'test')";
        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(Request);
            System.out.println("Programme Nutritionnel Ajouter avec succes!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ajouterProgrammeNutritionnel2(ProgrammeNutritionnel P) {
        String Request = "INSERT INTO ProgrammeNutritionnel (IDCoach,IDAdherent,Calorie,TypeProgrammeNutritionnel)"
                + " VALUES (?,?,?,?)";

        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(Request);
            pst.setInt(1, P.getIDCoach());
            pst.setInt(2, P.getIDAdherent());
            pst.setInt(3, P.getCalorie());
            pst.setString(4, P.getTypeProgrammeNutritionel());
            pst.executeUpdate();
            System.out.println("ProgrammeNutritionnel ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<ProgrammeNutritionnel> afficherProgrammeNutritionnel() {
        List<ProgrammeNutritionnel> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM ProgrammeNutritionnel";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                ProgrammeNutritionnel ps = new ProgrammeNutritionnel();
                ps.setIDProgrammeNutritionnel(rs.getInt(1));
                ps.setIDCoach(rs.getInt(2));
                ps.setIDAdherent(rs.getInt(3));
                ps.setCalorie(rs.getInt(4));
                ps.setTypeProgrammeNutritionel(rs.getString(5));
                myList.add(ps);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //   return null;
        }
        return myList;
    }

    public void supprimerProgrammeNutritionnel(int id) {
        String Request = "DELETE FROM ProgrammeNutritionnel WHERE IDProgrammeNutritionnel='" + id + "' ";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(Request);
            pst.executeUpdate();
            System.out.println("ProgrammeNutritionnel supprimé avec succés");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void ModifierProgrammeNutritionnel(ProgrammeNutritionnel PS, int id) {
        String req = "UPDATE ProgrammeNutritionnel SET IDCoach ='" + PS.getIDCoach() + "',IDAdherent ='" + PS.getIDAdherent() + "', Calorie ='" + PS.getCalorie() + "', TypeProgrammeNutritionnel ='" + PS.getTypeProgrammeNutritionel() + "' WHERE IDProgrammeNutritionnel = '" + id + "'";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("ProgrammeNutritionnel modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<Repas> AfficherRepasDeProgramme(int id) {
        List<Repas> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * from repas WHERE IDRepas in (SELECT IDRepas FROM programmen_repas as pnr WHERE pnr.IDProgrammeNutritionnel='" + id + "')";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Repas r = new Repas();
                r.setIDRepas(rs.getInt("IDRepas"));
                r.setPDej(rs.getString(2));
                r.setDej(rs.getString(3));
                r.setDinn(rs.getString(4));
                r.setCalorie(rs.getInt(5));
                r.setRestOrActive(rs.getString(6));
                myList.add(r);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //   return null;
        }
        return myList;
    }
    public List<Repas> AfficherRepasDeProgrammeUserDay(int idu,String jour) {
        List<Repas> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * from repas WHERE IDRepas in (SELECT IDRepas FROM programmen_repas as pnr,programmenutritionnel as pn WHERE (pnr.IDProgrammeNutritionnel=pn.IDProgrammeNutritionnel) AND pnr.JourRepas ='"+jour+"' AND pn.IDAdherent='"+idu+"')";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Repas r = new Repas();
                r.setIDRepas(rs.getInt("IDRepas"));
                r.setPDej(rs.getString(2));
                r.setDej(rs.getString(3));
                r.setDinn(rs.getString(4));
                r.setCalorie(rs.getInt(5));
                r.setRestOrActive(rs.getString(6));
                myList.add(r);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //   return null;
        }
        return myList;
    }
}
