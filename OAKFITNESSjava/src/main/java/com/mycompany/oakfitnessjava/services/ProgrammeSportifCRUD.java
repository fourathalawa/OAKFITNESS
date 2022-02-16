/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.services;

import com.mycompany.oakfitnessjava.entities.Exercice;
import com.mycompany.oakfitnessjava.entities.ProgrammeSportif;
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
public class ProgrammeSportifCRUD {
    Connection cnxx;

    public ProgrammeSportifCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterProgrammeSportif() {
        String Request = "INSERT INTO ProgrammeSportif (IDCoach,IDAdherent,DureeMois,TypeProgrammeSportif)"
                + " VALUES (1,1,1,'test')";
        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(Request);
            System.out.println("ProgrammeSportif Ajouter avec succes!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void ajouterProgrammeSportif2(ProgrammeSportif P){
    String Request = "INSERT INTO ProgrammeSportif (IDCoach,IDAdherent,DureeMois,TypeProgrammeSportif)"
                + " VALUES (?,?,?,?)";
            
    
    PreparedStatement  pst;
    try {
            pst = cnxx.prepareStatement(Request);
            pst.setInt(1, P.getIDCoach());
            pst.setInt(2, P.getIDAdherent());
            pst.setInt(3, P.getDureeMois());
            pst.setString(4, P.getTypeProgrammeSportif());
            pst.executeUpdate();
                        System.out.println("ProgrammeSportif ajouté avec succés");
 } catch (SQLException ex) {
            System.err.println(ex.getMessage());    
        }
    
    }
    

    public List<ProgrammeSportif> afficherProgrammeSportif() {
         List<ProgrammeSportif> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM ProgrammeSportif";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                ProgrammeSportif ps = new ProgrammeSportif();
                ps.setIDCoach(rs.getInt(2));
                ps.setIDAdherent(rs.getInt(3));
                ps.setDureeMois(rs.getInt(4));
                ps.setTypeProgrammeSportif(rs.getString(5));
                myList.add(ps);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //   return null;
        }
        return myList;
    }
      
      public void supprimerProgrammeSportif(int id)
      {
                  String Request = "DELETE FROM ProgrammeSportif WHERE IDProgrammeSportif='"+id+"' ";
                          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(Request);
            pst.executeUpdate();
                        System.out.println("ProgrammeSportif supprimé avec succés");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
          
      }

      
      public void ModifierProgrammeSportif(ProgrammeSportif PS, int id)
      {
           String req = "UPDATE ProgrammeSportif SET IDCoach ='"+PS.getIDCoach()+"',IDAdherent ='"+PS.getIDAdherent()+"', DureeMois ='"+PS.getDureeMois()+"', TypeProgrammeSportif ='"+PS.getTypeProgrammeSportif()+"' WHERE IDProgrammeSportif = '"+id+"'";
          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("ProgrammeSportif modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          
      }
    public List<Exercice> AfficherExercicesDeProgramme(int id){
    List<Exercice> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT IDExercice,TypeExercice,NomExercice,DescrExercice,DiffExercice,JusteSalleExercice,DureeExercice from exercice WHERE IDExercice in (SELECT IDExercice FROM programmes_exercice as pse WHERE pse.IDProgrammeSportif='"+id+"')";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Exercice ex = new Exercice();
                ex.setIDExercice(rs.getInt("IDExercice"));
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
}
