/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.entities.Challenge;
import com.mycompany.entities.SalleDeSport;
import com.mycompany.services.ChallengeCRUD;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddChallengeController implements Initializable {

    @FXML
    private TextField idRole;
    @FXML
    private TextField idOP;
    @FXML
    private TextField idH;
    @FXML
    private TextField idT;
    @FXML
    private Button idValider;
    @FXML
    private DatePicker idSD;
    @FXML
    private DatePicker idED;
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
        float OP = Float.parseFloat(idOP.getText());
        float TP = Float.parseFloat(idT.getText());
        float H = Float.parseFloat(idH.getText());
        String Date_S =String.valueOf(idSD.getValue());
        String Date_F =String.valueOf(idED.getValue());
        
Challenge us =new Challenge(Date_S,Date_F,   OP,  TP,  H,id);
ChallengeCRUD salle = new ChallengeCRUD(); 
salle.supprimerChallenge(id);
salle.ajouterChallenge(us);
FXMLLoader loader= new FXMLLoader(getClass().getResource("MemberProfile.fxml"));
            try{
            Parent root = loader.load();
         MemberProfileController suac = loader.getController();
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
    
}
