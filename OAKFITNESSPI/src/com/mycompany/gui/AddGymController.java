/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.entities.SalleDeSport;
import com.mycompany.services.SalleDeSportCRUD;
import com.mycompany.services.SessionCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddGymController implements Initializable {

    @FXML
    private TextField idRole;
    @FXML
    private Button idValider;
    @FXML
    private TextField idNom;
    @FXML
    private TextField idPrix;
    @FXML
    private TextField idAdresse;
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
    private Button idBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void Valider(ActionEvent event) {
          SessionCRUD s = new SessionCRUD();
        int id = s.getIdSS();
              String Nom = idNom.getText();
        String Adresse = idAdresse.getText();
        float Prix = Float.parseFloat(idPrix.getText());
        
SalleDeSport us =new SalleDeSport( id,  Nom,  Prix,  Adresse);
SalleDeSportCRUD salle = new SalleDeSportCRUD(); 
salle.ajouterSalle(us);
FXMLLoader loader= new FXMLLoader(getClass().getResource("ManagerProfile.fxml"));
            try{
            Parent root = loader.load();
         ManagerProfileController suac = loader.getController();
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
    private void Back(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("MyGym.fxml"));
            try {
            Parent root = loader.load();
          MyGymController suac = loader.getController();
            idBack.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
