/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.entities.User;
import com.mycompany.services.UserCRUD;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SignUpAdherentController implements Initializable {

    @FXML
    private TextField idNom;
    @FXML
    private TextField idPrenom;
    @FXML
    private DatePicker idDateNaissance =  new DatePicker();;
    @FXML
    private TextField idMail;
    @FXML
    private TextField idNumeroTelephone;
    @FXML
    private TextField idPassword;
    @FXML
    private Button idValider;
    @FXML
    private TextField idRole;
    @FXML
    private TextField idRole1;
    @FXML
    private Hyperlink idEvents;
    @FXML
    private Hyperlink idNews;
    @FXML
    private Hyperlink idGallery;
    @FXML
    private Hyperlink idShop;
    @FXML
    private Hyperlink idForum;
    @FXML
    private Hyperlink idAboutUs;
    @FXML
    private Hyperlink idCoach;
    @FXML
    private Hyperlink idmanager;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Valider(ActionEvent event) {
       
        String Nom = idNom.getText();
                String Prenom = idPrenom.getText();
         String Date_naissance =String.valueOf(idDateNaissance.getValue());
        String Mail = idMail.getText();
        String Password = idPassword.getText();
        int role = Integer.parseInt(idRole.getText());
        long numTelephone =Integer.parseInt(idNumeroTelephone.getText()) ;
User us =new User( Nom,  Prenom,  Mail,  numTelephone,  Date_naissance, role , Password);
UserCRUD user = new UserCRUD(); 

user.ajouterAdhérent(us);
FXMLLoader loader= new FXMLLoader(getClass().getResource("SignIn.fxml"));
            try{
            Parent root = loader.load();
        SignInController suac = loader.getController();
            idValider.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void eventsRedirect(ActionEvent event) {
    }

    @FXML
    private void newsRedirect(ActionEvent event) {
    }

    @FXML
    private void galleryRedirect(ActionEvent event) {
    }

    @FXML
    private void shopRedirect(ActionEvent event) {
    }

    @FXML
    private void forumRedirect(ActionEvent event) {
    }

    @FXML
    private void aboutUsRedirect(ActionEvent event) {
    }

   

    @FXML
    private void ManagerRedirect(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("SignUpManager.fxml"));
            try{
            Parent root = loader.load();
         SignUpManagerController suac = loader.getController();
            idmanager.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void coachredirection(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("SignUpCoach.fxml"));
            try{
            Parent root = loader.load();
         SignUpCoachController suac = loader.getController();
            idCoach.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
