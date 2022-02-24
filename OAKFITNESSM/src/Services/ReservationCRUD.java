/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Reservation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Utilities.MyConnection;


/**
 *
 * @author mahdi
 */
public class ReservationCRUD {
    
Connection cnxx;

    public ReservationCRUD() {
        cnxx= MyConnection.getInstance().getCnx();
                }
   
      public void ajouterReservation(Reservation ch) {

        String req = "INSERT INTO Reservation (IdReservation,DateReservation,IdUser,NomSalle) VALUES (?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, ch.getIdReservation());
            pst.setDate(2, ch.getDateReservation());
            pst.setInt(3, ch.getIdUser());
            pst.setString(4, ch.getNomSalle());
            pst.executeUpdate();
                        System.out.println("Reservation ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
      public List<Reservation> afficherReservation() {

        List<Reservation> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM reservation";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Reservation ch = new Reservation();
                ch.setIdReservation(rs.getInt("IdReservation"));
                ch.setDateReservation(rs.getDate("DateReservation"));
                ch.setIdUser(rs.getInt("IdUser"));
                ch.setNomSalle(rs.getString("NomSalle"));
                myList.add(ch);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }
      
      public void supprimerReservation(int id)
      {
                  String req = "DELETE FROM reservation WHERE IdReservation='"+id+"' ";
                          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("Reservation supprimé avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          
      }

      
      public void ModifierReservation(Reservation ch, int id)
      {
           String req = "UPDATE reservation SET NomSalle ='"+ch.getNomSalle()+"' , DateReservation='"+ch.getDateReservation()+"' WHERE IdReservation = '"+id+"'";
          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("Reservation modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          
      }
      public List<Reservation> getReservationbySalle(String nom) {

        List<Reservation> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM reservation Where NomSalle='"+nom+"'";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Reservation ch = new Reservation();
                ch.setIdReservation(rs.getInt("IdReservation"));
                ch.setDateReservation(rs.getDate("DateReservation"));
                ch.setIdUser(rs.getInt("IdUser"));
                ch.setNomSalle(rs.getString("NomSalle"));
                myList.add(ch);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }
      public List<Reservation> getReservationBetweenDate(Date debut,Date fin) {

        List<Reservation> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM reservation Where DateReservation BETWEEN ='"+debut+"' AND '"+fin+"'";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Reservation ch = new Reservation();
                ch.setIdReservation(rs.getInt("IdReservation"));
                ch.setDateReservation(rs.getDate("DateReservation"));
                ch.setIdUser(rs.getInt("IdUser"));
                ch.setNomSalle(rs.getString("NomSalle"));
                myList.add(ch);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }
}

