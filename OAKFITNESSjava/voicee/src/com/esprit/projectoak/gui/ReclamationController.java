/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projectoak.gui;

import com.esprit.projectoak.entities.Reclamation;
import com.esprit.projectoak.services.ReclamationCRUD;
import com.esprit.projectoak.utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ReclamationController implements Initializable {
    Connection cnxx;
    @FXML
    private ChoiceBox<String> ch_Category;
    private String[] category = {"Event","Login in","Other"};
    @FXML
    private Label nomDuPub;

    public ReclamationController() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    @FXML
    private Button btn_AjouterReclamation;
    @FXML
    private TextField tf_descreptionReclamation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            ch_Category.getItems().addAll(category);

    }    

    @FXML
    private void ft_valider(ActionEvent event) {
        insertReclamtion();
    }
    
    private void insertReclamtion(){
        int cat=0;
        String DescrReclam = tf_descreptionReclamation.getText();
        String CategReclam =ch_Category.getValue();
        
        String pub = tf_descreptionReclamation.getText();
         if (pub.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
             }
         else {
        if(CategReclam == "Commentaire"){
            cat = 1;
        }
        else if(CategReclam == "publication"){
            cat = 2;
        }
        else {
            
         cat = 3;
        }
        int IDUserReclamation = 1;
        Reclamation p = new Reclamation(cat, DescrReclam);
        ReclamationCRUD rc = new ReclamationCRUD();
        rc.ajouterReclamation2(p);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText(null);
                                alert.setContentText("Report added");
                                alert.showAndWait();
        
        
    }

    }
    
}
