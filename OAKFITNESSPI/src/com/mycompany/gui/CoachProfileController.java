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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CoachProfileController implements Initializable {

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
    private TextField idExperience;
    @FXML
    private TextField idDiplome;
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
       SessionCRUD s = new SessionCRUD();
        int id = s.getIdSS();
        loadDataCoach(id);
    }    

    @FXML
    private void Modifier(ActionEvent event) {
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
    private void loadDataCoach(int id)
    {
       
        
      UserCRUD user = new UserCRUD();
      User us = user.afficherCoach(id);
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
       idExperience.setText(us.getExperience());
       idDiplome.setText(us.getDiplome());
    }
}
