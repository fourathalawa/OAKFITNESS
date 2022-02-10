/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.services;

import com.mycompany.oakfitnessjava.entities.Exercice;
import com.mycompany.oakfitnessjava.utils.MyConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Heni Nechi
 */
public class ExerciceCRUD {

    Connection cnxx;

    public ExerciceCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterExercice() {
        String Request = "INSERT INTO EXERCICE (TypeExercice,NomExercice,DescrExercice,DiffExercice,JusteSalleExercice,DureeExercice)"
                + " VALUES ('test','test','test','test','test','test')";
        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(Request);
            System.out.println("Exercice Ajouter avec succes!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void ajouterExercice2(Exercice E){
    String Request = "INSERT INTO EXERCICE (TypeExercice,NomExercice,DescrExercice,DiffExercice,JusteSalleExercice,DureeExercice)"
                + " VALUES (?,?,?,?,?,?)";
    
    PreparedStatement  pst;
    try {
            pst = cnxx.prepareStatement(Request);
            pst.setString(1, E.getTypeExercice());
            pst.setString(2, E.getNomExercice());
            pst.setString(3, E.getDescrExercice());
            pst.setString(4, E.getDiffExercice());
            pst.setString(5, E.getJusteSalleExercice());
            pst.setString(6, E.getDureeExercice());
            pst.executeUpdate();
                        System.out.println("Exercice ajouté avec succés");
 } catch (SQLException ex) {
            System.err.println(ex.getMessage());    
        }
    
    }
    

    public List<Exercice> afficherExercice() {
         List<Exercice> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM exercice";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Exercice ex = new Exercice();
                ex.setTypeExercice(rs.getString(2));
                ex.setNomExercice(rs.getString(3));
                ex.setDescrExercice(rs.getString(4));
                ex.setDiffExercice(rs.getString(5));
                ex.setJusteSalleExercice(rs.getString(6));
                ex.setDureeExercice(rs.getString(7));
                myList.add(ex);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //   return null;
        }
        return myList;
    }
      
      public void supprimerExercice(int id)
      {
                  String Request = "DELETE FROM exercice WHERE IDExercice='"+id+"' ";
                          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(Request);
            pst.executeUpdate();
                        System.out.println("Exercice supprimé avec succés");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
          
      }

      
      public void ModifierExercice(Exercice E, int id)
      {
           String req = "UPDATE exercice SET TypeExercice ='"+E.getTypeExercice()+"',NomExercice ='"+E.getNomExercice()+"',DescrExercice ='"+E.getDescrExercice()+"', DiffExercice ='"+E.getDiffExercice()+"', JusteSalleExercice ='"+E.getJusteSalleExercice()+"',DureeExercice = '"+E.getDureeExercice()+"' WHERE IDExercice = '"+id+"'";
          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("Exercice modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          
      }
    
}