/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.entities.User;
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
 * @author User
 */
public class UserCRUD {

    Connection cnxx;

    public UserCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterAdmin(User user) {

        String req = "INSERT INTO user (NomUser,PrenomUser,MailUser,TelephoneNumberUser,DateNaissanceUser,RoleUser,Password) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, user.getNom());
            pst.setString(2, user.getPrenom());
            pst.setString(3, user.getMail());
            pst.setLong(4, user.getTelephone_Number());
            pst.setString(5, user.getDate_Naissance());
            pst.setInt(6, user.getRole());
            pst.setString(9, user.encrypt(user.getPassword()));
            pst.executeUpdate();
            System.out.println("Admin ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ajouterAdhérent(User user) {

        String req = "INSERT INTO user (NomUser,PrenomUser,MailUser,TelephoneNumberUser,DateNaissanceUser,RoleUser,NumeroPackUser,DateCommance,Password) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, user.getNom());
            pst.setString(2, user.getPrenom());
            pst.setString(3, user.getMail());
            pst.setLong(4, user.getTelephone_Number());
            pst.setString(5, user.getDate_Naissance());
            pst.setInt(6, user.getRole());
            pst.setInt(7, user.getNumero_Pack());
            pst.setString(8, user.getDate_Commance());
            pst.setString(9, user.encrypt(user.getPassword()));

            pst.executeUpdate();
            System.out.println("Adherent ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ajouterCoach(User user) {

        String req = "INSERT INTO user (NomUser,PrenomUser,MailUser,TelephoneNumberUser,DateNaissanceUser,RoleUser,ExperienceUser,DiplomeUser,Password) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, user.getNom());
            pst.setString(2, user.getPrenom());
            pst.setString(3, user.getMail());
            pst.setLong(4, user.getTelephone_Number());
            pst.setString(5, user.getDate_Naissance());
            pst.setInt(6, user.getRole());
            pst.setString(7, user.getExperience());
            pst.setString(8, user.getDiplome());
            pst.setString(9, user.encrypt(user.getPassword()));

            pst.executeUpdate();
            System.out.println("Coach ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ajouterResponsable(User user) {

        String req = "INSERT INTO user (NomUser,PrenomUser,MailUser,TelephoneNumberUser,DateNaissanceUser,RoleUser,AdresseSalleSport,MatriculeFiscale,Password) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, user.getNom());
            pst.setString(2, user.getPrenom());
            pst.setString(3, user.getMail());
            pst.setLong(4, user.getTelephone_Number());
            pst.setString(5, user.getDate_Naissance());
            pst.setInt(6, user.getRole());
            pst.setString(7, user.getAdresse_Salle_Sport());
            pst.setLong(8, user.getMatricule_Fiscale());
            pst.setString(9, user.encrypt(user.getPassword()));

            pst.executeUpdate();
            System.out.println("Responsable ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<User> afficherAdhérent() {

        List<User> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM user WHERE RoleUser = 1 ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                User user = new User();
                user.setId(rs.getInt("IdUser"));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setMail(rs.getString(4));
                user.setTelephone_Number(rs.getLong(5));
                user.setDate_Naissance(rs.getString(6));
                user.setRole(rs.getInt(7));
                user.setNumero_Pack(rs.getInt(8));
                user.setDate_Commance(rs.getString(9));
                user.setPassword(user.decrypt(rs.getString(14)));

                myList.add(user);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public List<User> afficherCoach() {

        List<User> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM user WHERE RoleUser = 2 ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                User user = new User();
                user.setId(rs.getInt("IdUser"));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setMail(rs.getString(4));
                user.setTelephone_Number(rs.getLong(5));
                user.setDate_Naissance(rs.getString(6));
                user.setRole(rs.getInt(7));
                user.setExperience(rs.getString(10));
                user.setDiplome(rs.getString(11));
                user.setPassword(user.decrypt(rs.getString(14)));

                myList.add(user);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public List<User> afficherResponsable() {

        List<User> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM user WHERE RoleUser = 3 ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                User user = new User();
                user.setId(rs.getInt("IdUser"));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setMail(rs.getString(4));
                user.setTelephone_Number(rs.getLong(5));
                user.setDate_Naissance(rs.getString(6));
                user.setRole(rs.getInt(7));
                user.setAdresse_Salle_Sport(rs.getString(12));
                user.setMatricule_Fiscale(rs.getLong(13));
                user.setPassword(user.decrypt(rs.getString(14)));
                myList.add(user);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public void supprimerUser(int id) {
        String req = "DELETE FROM user WHERE IdUser='" + id + "' ";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("User supprimé avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ModifierAdhrent(User user, int id) {
        String req = "UPDATE user SET NomUser ='" + user.getNom() + "',PrenomUser ='" + user.getPrenom() + "',MailUser ='" + user.getMail() + "' ,TelephoneNumberUser ='" + user.getTelephone_Number() + "',DateNaissanceUser ='" + user.getDate_Naissance() + "' ,NumeroPackUser ='" + user.getNumero_Pack() + "' ,DateCommance ='" + user.getDate_Commance() + "' ,Password ='" + user.encrypt(user.getPassword())+ "' WHERE idUser = '" + id + "'";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Adhérent modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ModifierCoach(User user, int id) {  //NomUser,PrenomUser,MailUser,TelephoneNumberUser,DateNaissanceUser,ExperienceUser,DiplomeUser
        String req = "UPDATE user SET NomUser ='" + user.getNom() + "',PrenomUser ='" + user.getPrenom() + "',MailUser ='" + user.getMail() + "' ,TelephoneNumberUser ='" + user.getTelephone_Number() + "',DateNaissanceUser ='" + user.getDate_Naissance() + "' ,ExperienceUser ='" + user.getExperience() + "' ,DiplomeUser ='" + user.getDiplome() + "' ,Password ='" + user.encrypt(user.getPassword())+ "' WHERE idUser = '" + id + "'";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Coach modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ModifierResponsable(User user, int id) {  //NomUser,PrenomUser,MailUser,TelephoneNumberUser,DateNaissanceUser,AdresseSalleSport,MatriculeFiscale
        String req = "UPDATE user SET NomUser ='" + user.getNom() + "',PrenomUser ='" + user.getPrenom() + "',MailUser ='" + user.getMail() + "' ,TelephoneNumberUser ='" + user.getTelephone_Number() + "',DateNaissanceUser ='" + user.getDate_Naissance() + "' ,AdresseSalleSport ='" + user.getAdresse_Salle_Sport() + "' ,MatriculeFiscale ='" + user.getMatricule_Fiscale() + "' ,Password ='" + user.encrypt(user.getPassword()) + "' WHERE idUser = '" + id + "'";
        PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
            System.out.println("Responsable modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public int authentification(User user)  {
                int role=7;

        try{
                    Statement st = cnxx.createStatement();
                    String req ="SELECT COUNT(*) as count,RoleUser FROM USER WHERE MailUser='"+user.getMail()+"' AND Password='"+user.encrypt(user.getPassword())+"'" ;
         ResultSet rs;
            rs = st.executeQuery(req);
            int count;
            while(rs.next()){
        count = rs.getInt("count");
            
        if(count==1)
        {
            System.out.println("Log in verifié ");
            role = rs.getInt(2);
        }
            }
    }catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
        return role ;
    }
    
}
