/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.entities.User;
import com.mycompany.services.SessionCRUD;
import com.mycompany.services.UserCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ManagerUpdateController implements Initializable {

    @FXML
    private TextField idRole;
    @FXML
    private TextField idNom;
    @FXML
    private TextField idPrenom;
    @FXML
    private TextField idPassword;
    @FXML
    private Button idValider;
    @FXML
    private DatePicker idDateNaissance;
    @FXML
    private TextField idTax;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Valider(ActionEvent event) {
         SessionCRUD s = new SessionCRUD();
        int id = s.getIdSS();
        String Nom = idNom.getText();
                String Prenom = idPrenom.getText();
         String Date_naissance =String.valueOf(idDateNaissance.getValue());
        String Password = idPassword.getText();
        long tax = Integer.parseInt(idTax.getText()) ;
        int role = 3;
        String Mail  = null ;
        long numTelephone=0;
 
User us =new User( Nom,  Prenom,  Mail,  numTelephone,  Date_naissance,  tax,  role, Password);
UserCRUD user = new UserCRUD(); 

user.ModifierAdhrent(us,id);
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
    
}
