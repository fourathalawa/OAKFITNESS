/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.services;

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
public class RepasCRUD {
    Connection cnxx;

    public RepasCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterRepas() {
        String Request = "INSERT INTO Repas (PDej,Dej,Dinn,RestOrActive)"
                + " VALUES ('test','test','test','test')";
        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(Request);
            System.out.println("Repas Ajouter avec succes!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void ajouterRepas2(Repas R){
    String Request = "INSERT INTO Repas (PDej,Dej,Dinn,RestOrActive)"
                + " VALUES (?,?,?,?)";
    
    PreparedStatement  pst;
    try {
            pst = cnxx.prepareStatement(Request);
            pst.setString(1, R.getPDej());
            pst.setString(2, R.getDej());
            pst.setString(3, R.getDinn());
            pst.setString(4, R.getRestOrActive());
            pst.executeUpdate();
                        System.out.println("Repas ajouté avec succés");
 } catch (SQLException ex) {
            System.err.println(ex.getMessage());    
        }
    
    }
    

    public List<Repas> afficherRepas() {
         List<Repas> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM Repas";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Repas R = new Repas();
                R.setPDej(rs.getString(2));
                R.setDej(rs.getString(3));
                R.setDinn(rs.getString(4));
                R.setRestOrActive(rs.getString(5));
                myList.add(R);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //   return null;
        }
        return myList;
    }
      
      public void supprimerRepas(int id)
      {
                  String Request = "DELETE FROM Repas WHERE IDRepas='"+id+"' ";
                          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(Request);
            pst.executeUpdate();
                        System.out.println("Repas supprimé avec succés");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
          
      }

      
      public void ModifierRepas(Repas R, int id)
      {
           String req = "UPDATE Repas SET PDej ='"+R.getPDej()+"',Dej ='"+R.getDej()+"',Dinn ='"+R.getDinn()+"', RestOrActive ='"+R.getRestOrActive()+"' WHERE IDRepas = '"+id+"'";
          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("Repas modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          
      }
         public void AjouterRepasAProgramme(int IDR, int IDPn) {
        String req = "INSERT INTO programmen_repas (IDProgrammeNutritionnel,IDRepas) VALUES (?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);

            pst.setInt(1, IDR);
            pst.setInt(2, IDPn);
            pst.executeUpdate();
            System.out.println("Repas ajouté à programme avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimerRepasDeProgramme(int id) {
        String Request = "DELETE FROM programmen_repas WHERE IDRepas='" + id + "' ";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(Request);
            pst.executeUpdate();
            System.out.println("Repas supprimé de programme avec succés");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    
}
