/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.entities.Challenge;
import com.mycompany.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fourat Halaoua
 */
public class ChallengeCRUD {

    Connection cnxx;

    public ChallengeCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterChallenge(Challenge ch) {

        String req = "INSERT INTO challenge (DateDebut,DateFin,PoidInt,PoidOb,Taille,IdUser) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, ch.getDateDebut());
            pst.setString(2, ch.getDateFin());
            pst.setFloat(3, ch.getPoidInt());
            pst.setFloat(4, ch.getPoidOb());
            pst.setFloat(5, ch.getTaille());
            pst.setInt(6, ch.getIdUser());
            pst.executeUpdate();
            System.out.println("Challenge ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<Challenge> afficherChallenge() {

        List<Challenge> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM challenge";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Challenge ch = new Challenge();
                ch.setIdChallenge(rs.getInt("IdChallenge"));
                ch.setDateDebut(rs.getString(2));
                ch.setDateFin(rs.getString(3));
                ch.setPoidInt(rs.getFloat(4));
                ch.setPoidInt(rs.getFloat(5));
                ch.setPoidInt(rs.getFloat(6));
                ch.setPoidInt(rs.getFloat(7));
                ch.setIdUser(rs.getInt(8));
                myList.add(ch);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public void supprimerChallenge(int id) {
        String req = "DELETE FROM challenge WHERE IdUser='" + id + "' ";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Challenge supprimé avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ModifierChallenge(Challenge ch, int id) {
        String req = "UPDATE challenge SET DateDebut ='" + ch.getDateDebut() + "',DateFIN ='" + ch.getDateFin() + "',PoidInt ='" + ch.getPoidInt() + "',PoidOb ='" + ch.getPoidOb() + "',Taille ='" + ch.getTaille() + "' WHERE IdUser = '" + id + "'";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Challenge modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void NouveauPoid(Challenge ch, int id) {
        String req = "UPDATE challenge SET PoidNv ='" + ch.getPoidNv() + "' WHERE IdUser = '" + id + "'";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Progré modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List CalculIMC(int id) {
        float poidInt = 0;
        float poidNv = 0;
        float poidOb = 0;
        float taille = 0;
float imcInt =0;
float imcOb=0;
float imcNv=0;
        List<Float> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT PoidInt,PoidOb,PoidNv,Taille FROM challenge where IdUser ='" + id + "'";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                poidInt = rs.getFloat(1);
                poidOb = rs.getFloat(2);
                poidNv = rs.getFloat(3);
                taille = rs.getFloat(4);
imcInt = poidInt/(taille*taille) ;
imcOb= poidOb/(taille*taille) ;
if(poidNv != 0)
{
    imcNv= poidNv/(taille*taille);
}
myList.add(imcInt);
myList.add(imcOb);
myList.add(imcNv);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }
    
   public float ProgressionChallenge( int id)
   {    float poidInt = 0;
        float poidNv = 0;
        float poidOb = 0;
        float taux=0;
       try {
            Statement st = cnxx.createStatement();
            String req = "SELECT PoidInt,PoidOb,PoidNv FROM challenge where IdUser ='" + id + "'";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                poidInt = rs.getFloat(1);
                poidOb = rs.getFloat(2);
                poidNv = rs.getFloat(3);
                taux =((poidInt-poidNv) *100)/(poidInt-poidOb);
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
       return taux;
   }
}
