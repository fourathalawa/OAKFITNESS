/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.entities.Challenge;
import com.mycompany.services.ChallengeCRUD;
import com.mycompany.services.SessionCRUD;
import com.mycompany.services.UserCRUD;
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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class MyChallengeController implements Initializable {

    @FXML
    private TextField idOWeight;
    @FXML
    private TextField idTweight;
    private Label idProgression;
    @FXML
    private Button idUpdate;
    @FXML
    private TextField idCWeight;
    @FXML
    private Button idAddChallenge;
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
    private TextField idHeight;
    @FXML
    private TextField idSDate;
    @FXML
    private ProgressBar idProgresion;
    @FXML
    private TextField idEDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SessionCRUD s = new SessionCRUD();
        int id = s.getIdSS();
            LoadDataChallenge(id);
    }    

    @FXML
    private void Update(ActionEvent event) {
         SessionCRUD s = new SessionCRUD();
        int id = s.getIdSS();
        
        float h = Float.parseFloat(idCWeight.getText());
        Challenge cha = new Challenge(h);
        ChallengeCRUD ch = new ChallengeCRUD();
        ch.NouveauPoid(cha,id);
    }

    @FXML
    private void Add(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("AddChallenge.fxml"));
            try {
            Parent root = loader.load();
          AddChallengeController suac = loader.getController();
            idAddChallenge.getScene().setRoot(root);
           
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
    private void LoadDataChallenge(int id)
    {Challenge cha= new Challenge();
        ChallengeCRUD ch = new ChallengeCRUD();
        cha=ch.afficherChallenge(id);
        System.out.println(cha);
        float p =cha.getPoidInt();
        System.out.println(p);
        idOWeight.setText(String.valueOf(p));
        float h =cha.getTaille();
        idHeight.setText(String.valueOf(h));
        float p1 =cha.getPoidOb();
        idTweight.setText(String.valueOf(p1));
        idSDate.setText(cha.getDateDebut());
        idEDate.setText(cha.getDateFin());
        float ss=ch.ProgressionChallenge(id);
         
     //  idProgression.(String.valueOf(ss));
        
    }
}
