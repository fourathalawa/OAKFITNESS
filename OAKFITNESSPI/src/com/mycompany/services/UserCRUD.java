/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.entities.Session;
import com.mycompany.entities.User;
import com.mycompany.utils.MyConnection;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/*import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/
import javax.swing.JOptionPane;
import java.util.Random;
import java.lang.Math;
import java.sql.Date;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Fourat Halaoua
 */
public class UserCRUD {

    Connection cnxx;
    private Object txtEmail;

    public UserCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterAdmin(User user) {
        String req1 = "SELECT COUNT(*) as count FROM USER WHERE MailUser='" + user.getMail() + "' OR TelephoneNumberUser='" + user.getTelephone_Number() + "'";
        PreparedStatement st;

        try {
            st = cnxx.prepareStatement(req1);
            ResultSet rs;
            rs = st.executeQuery(req1);
            int count;
            while (rs.next()) {
                count = rs.getInt("count");

                if (count != 1) {
                    PreparedStatement pst;
                    String req = "INSERT INTO user (NomUser,PrenomUser,MailUser,TelephoneNumberUser,DateNaissanceUser,RoleUser,Password) VALUES (?,?,?,?,?,?,?)";
                    pst = cnxx.prepareStatement(req);
                    pst.setString(1, user.getNom());
                    pst.setString(2, user.getPrenom());
                    pst.setString(3, user.getMail());
                    pst.setLong(4, user.getTelephone_Number());
                    pst.setString(5,user.getDate_Naissance());
                    pst.setInt(6, user.getRole());
                    pst.setString(7, user.encrypt(user.getPassword()));
                    pst.executeUpdate();
                    System.out.println("Admin ajouté avec succés");
                } else {
                    System.out.println("Le mail ou le numéro du téléphone déja utilisé !!!!");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ajouterAdhérent(User user) {
        String req1 = "SELECT COUNT(*) as count FROM USER WHERE MailUser='" + user.getMail() + "' OR TelephoneNumberUser='" + user.getTelephone_Number() + "'";
        PreparedStatement st;

        try {
            st = cnxx.prepareStatement(req1);
            ResultSet rs;
            rs = st.executeQuery(req1);
            int count;
            while (rs.next()) {
                count = rs.getInt("count");

                if (count != 1) {
                    String req = "INSERT INTO user (NomUser,PrenomUser,MailUser,TelephoneNumberUser,DateNaissanceUser,RoleUser,NumeroPackUser,DateCommance,Password) VALUES (?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst;

                    pst = cnxx.prepareStatement(req);
                    pst.setString(1, user.getNom());
                    pst.setString(2, user.getPrenom());
                    pst.setString(3, user.getMail());
                    pst.setLong(4, user.getTelephone_Number());
                    pst.setString(5,user.getDate_Naissance());
                    pst.setInt(6, user.getRole());
                    pst.setInt(7, user.getNumero_Pack());
                    pst.setString(8, user.getDate_Commance());
                    pst.setString(9, user.encrypt(user.getPassword()));

                    pst.executeUpdate();
                    System.out.println("Adherent ajouté avec succés");
                } else {
                    System.out.println("Le mail ou le numéro du téléphone déja utilisé !!!!");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ajouterCoach(User user) {
        String req1 = "SELECT COUNT(*) as count FROM USER WHERE MailUser='" + user.getMail() + "' OR TelephoneNumberUser='" + user.getTelephone_Number() + "'";
        PreparedStatement st;

        try {
            st = cnxx.prepareStatement(req1);
            ResultSet rs;
            rs = st.executeQuery(req1);
            int count;
            while (rs.next()) {
                count = rs.getInt("count");

                if (count != 1) {
                    String req = "INSERT INTO user (NomUser,PrenomUser,MailUser,TelephoneNumberUser,DateNaissanceUser,RoleUser,ExperienceUser,DiplomeUser,Password) VALUES (?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst;

                    pst = cnxx.prepareStatement(req);
                    pst.setString(1, user.getNom());
                    pst.setString(2, user.getPrenom());
                    pst.setString(3, user.getMail());
                    pst.setLong(4, user.getTelephone_Number());
                    pst.setString(5,user.getDate_Naissance());
                    pst.setInt(6, user.getRole());
                    pst.setString(7, user.getExperience());
                    pst.setString(8, user.getDiplome());
                    pst.setString(9, user.encrypt(user.getPassword()));

                    pst.executeUpdate();
                    System.out.println("Coach ajouté avec succés");

                } else {
                    System.out.println("Le mail ou le numéro du téléphone déja utilisé !!!!");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ajouterResponsable(User user) {
        String req1 = "SELECT COUNT(*) as count FROM USER WHERE MailUser='" + user.getMail() + "' OR TelephoneNumberUser='" + user.getTelephone_Number() + "'";
        PreparedStatement st;

        try {
            st = cnxx.prepareStatement(req1);
            ResultSet rs;
            rs = st.executeQuery(req1);
            int count;
            while (rs.next()) {
                count = rs.getInt("count");

                if (count != 1) {
                    String req = "INSERT INTO user (NomUser,PrenomUser,MailUser,TelephoneNumberUser,DateNaissanceUser,RoleUser,MatriculeFiscale,Password) VALUES (?,?,?,?,?,?,?,?)";
                    PreparedStatement pst;

                    pst = cnxx.prepareStatement(req);
                    pst.setString(1, user.getNom());
                    pst.setString(2, user.getPrenom());
                    pst.setString(3, user.getMail());
                    pst.setLong(4, user.getTelephone_Number());
                    pst.setString(5,user.getDate_Naissance());
                    pst.setInt(6, user.getRole());
                    pst.setLong(7, user.getMatricule_Fiscale());
                    pst.setString(8, user.encrypt(user.getPassword()));

                    pst.executeUpdate();
                    System.out.println("Responsable ajouté avec succés");
                } else {
                    System.out.println("Le mail ou le numéro du téléphone déja utilisé !!!!");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public ObservableList<User> afficherAdhérent() {

ObservableList<User> myList = FXCollections.observableArrayList();

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

    public ObservableList<User> afficherCoach() {

        ObservableList<User> myList =  FXCollections.observableArrayList();

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

    public ObservableList<User> afficherResponsable() {

        ObservableList<User> myList = FXCollections.observableArrayList();

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
public ObservableList<User> afficherAdmin() {

        ObservableList<User> myList = FXCollections.observableArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM user WHERE RoleUser = 0 ";
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
               
                myList.add(user);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }
public User afficherMember(int id) {

        
 User us = new User();
        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM user WHERE IdUser ='"+id+"' ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

               
                us.setId(rs.getInt("IdUser"));
                us.setNom(rs.getString(2));
                us.setPrenom(rs.getString(3));
                us.setMail(rs.getString(4));
                us.setTelephone_Number(rs.getLong(5));
                us.setDate_Naissance(rs.getString(6));
                us.setPassword(rs.getString(14));
              
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
       return us;
    }
public User afficherCoach(int id) {

        
 User us = new User();
        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM user WHERE IdUser ='"+id+"' ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

               
                us.setId(rs.getInt("IdUser"));
                us.setNom(rs.getString(2));
                us.setPrenom(rs.getString(3));
                us.setMail(rs.getString(4));
                us.setTelephone_Number(rs.getLong(5));
                us.setDate_Naissance(rs.getString(6));
                us.setExperience(rs.getString(10));
                us.setDiplome(rs.getString(11));
                us.setPassword(rs.getString(14));
              
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
       return us;
    }
public User afficherManager(int id) {

        
 User us = new User();
        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM user WHERE IdUser ='"+id+"' ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

               
                us.setId(rs.getInt("IdUser"));
                us.setNom(rs.getString(2));
                us.setPrenom(rs.getString(3));
                us.setMail(rs.getString(4));
                us.setTelephone_Number(rs.getLong(5));
                us.setDate_Naissance(rs.getString(6));
                us.setMatricule_Fiscale(rs.getLong(13));
                us.setPassword(rs.getString(14));
              
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
       return us;
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
        String req = "UPDATE user SET NomUser ='" + user.getNom() + "',PrenomUser ='" + user.getPrenom() + "',MailUser ='" + user.getMail() + "' ,TelephoneNumberUser ='" + user.getTelephone_Number() + "',DateNaissanceUser ='" + user.getDate_Naissance() + "' ,NumeroPackUser ='" + user.getNumero_Pack() + "' ,DateCommance ='" + user.getDate_Commance() + "' ,Password ='" + user.encrypt(user.getPassword()) + "' WHERE idUser = '" + id + "'";
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
        String req = "UPDATE user SET NomUser ='" + user.getNom() + "',PrenomUser ='" + user.getPrenom() + "',MailUser ='" + user.getMail() + "' ,TelephoneNumberUser ='" + user.getTelephone_Number() + "',DateNaissanceUser ='" + user.getDate_Naissance() + "' ,ExperienceUser ='" + user.getExperience() + "' ,DiplomeUser ='" + user.getDiplome() + "' ,Password ='" + user.encrypt(user.getPassword()) + "' WHERE idUser = '" + id + "'";
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
public int  retourneId(String mail)
{
    int id =0;
    try {
            Statement st = cnxx.createStatement();
            String req = "SELECT IdUser FROM user WHERE MailUser ='"+mail+"' ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

               
                id=rs.getInt("IdUser");
              
              
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
    return id;
}
    public int authentification(User user) {
        int role = 7;
        int id=0;
     UserCRUD us= new UserCRUD();
        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT COUNT(*) as count,RoleUser,IdUser FROM USER WHERE MailUser='" + user.getMail() + "' AND Password='" + user.encrypt(user.getPassword()) + "'";
            ResultSet rs;
            rs = st.executeQuery(req);
            int count;
            while (rs.next()) {
                count = rs.getInt("count");

                if (count == 1) {
                    System.out.println("Log in verifié ");
                    role = rs.getInt(2);
                    id = rs.getInt(3);
                    Session s= new Session(id,role);
                   SessionCRUD sc = new SessionCRUD();
                   sc.ajouterSession(s);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        System.out.println(role);
        return role;
    }

    /*public void ResetPassword(User us) {
        int randomCode;
        Random rand = new Random();
        try {
            randomCode = rand.nextInt(999999);
            String host = "smtp.gmail.com";
            String user = "fourat.halaoua@esprit.tn";
            String pass = "191JMT1029**";
            String to = us.getMail();
            String subject = "Reseting Code";
            String message = "Your reset code is " + randomCode;
            boolean sessionDebug = false;
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.host", "host");
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.auth", "true");
            pros.put("mail.smtp.starttls.required", "true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(pros, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            System.out.println("aaaaaaa");
            InternetAddress[] address = {new InternetAddress(to)};
            System.out.println("aaaaaaa");
            msg.setRecipients(Message.RecipientType.TO, address);
            System.out.println("aaaaaaa");
            msg.setSubject(subject);
            msg.setText(message);
            System.out.println("aaaaaaa");
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            System.out.println("aaaaaaa");
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("aaaaaaa");
            transport.close();
            JOptionPane.showMessageDialog(null, "code has been send to the email");
        } catch (Exception ex) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, ex);
            System.out.println(ex);
        }
    }*/

  
}
