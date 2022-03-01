/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.entities.User;
import com.mycompany.services.SessionCRUD;
import com.mycompany.services.UserCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class MemberProfileController implements Initializable {

    @FXML
    private TextField idRole;
    @FXML
    private TextField idNom;
    @FXML
    private TextField idPrenom;
    @FXML
    private TextField idMail;
    @FXML
    private TextField idNumeroTelephone;
    @FXML
    private TextField idPassword;
    @FXML
    private Button idValider;
    @FXML
    private TextField idNaissance;
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
    private Button idChallenge;
    @FXML
    private Button idlog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SessionCRUD s = new SessionCRUD();
        int id = s.getIdSS();
        loadDataMember(id);
                
    }    

    @FXML
    private void Modifier(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("MemberUpdate.fxml"));
            try{
            Parent root = loader.load();
          MemberUpdateController suac = loader.getController();
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
    private void loadDataMember(int id)
    {
       
        
      UserCRUD user = new UserCRUD();
      User us = user.afficherMember(id);
      //  ObservableList<Reclamation> list = afficherReclamation();
        idNom.setText(us.getNom());
        idPrenom.setText(us.getPrenom());
        idMail.setText(us.getMail());
        idNaissance.setText(us.getDate_Naissance());
        long a=(us.getTelephone_Number());
        String s =String.valueOf(a);
       idNumeroTelephone.setText(s);
       String pass = us.decrypt(us.getPassword());
       idPassword.setText(pass);
    }

    @FXML
    private void challengeredirection(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("MyChallenge.fxml"));
            try{
            Parent root = loader.load();
          MyChallengeController suac = loader.getController();
            idChallenge.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logout(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("SignIn.fxml"));
            try {
            Parent root = loader.load();
            SignInController aad = loader.getController();
            idlog.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
