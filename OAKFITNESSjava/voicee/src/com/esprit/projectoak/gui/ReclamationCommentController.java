/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projectoak.gui;

import com.esprit.projectoak.entities.Reclamation;
import com.esprit.projectoak.services.ReclamationCRUD;
import java.net.URL;
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
public class ReclamationCommentController implements Initializable {

    @FXML
    private Button btn_AjouterReclamation;
    @FXML
    private TextField tf_descreptionReclamation;
    @FXML
    private ChoiceBox<String> ch_Category;
    private String[] category = {"Harrasment", "Hate speech", "Spam"};
    @FXML
    private Label nomDuPub;
    @FXML
    private Label pubRec;
    @FXML
    private Label CommentRec;
    @FXML
    private Label idUserOfPub;
    @FXML
    private Label idcommentReclam;

    void setPub(String pubb, String recc , String iddd , String idc) {
        pubRec.setText(pubb);
        CommentRec.setText(recc);
        idUserOfPub.setText(iddd);
        idcommentReclam.setText(idc);
    }

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
             int cat=0;
        String DescrReclam = tf_descreptionReclamation.getText();
        String CategReclam =ch_Category.getValue();
        String pub = pubRec.getText();
        String com = CommentRec.getText();
        int id = Integer.parseInt(idUserOfPub.getText());
        int idcc = Integer.parseInt(idcommentReclam.getText());
        
        String pub2 = tf_descreptionReclamation.getText();
         if (pub2.isEmpty() ) {
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
       // int IDUserReclamation = 1;
        Reclamation p = new Reclamation(id, cat, DescrReclam , pub , com , idcc);
       // Reclamation p = new Reclamation(IDUserReclamation, cat, DescrReclam);
        ReclamationCRUD rc = new ReclamationCRUD();
        rc.ReclamerComment(p);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText(null);
                                alert.setContentText("Report added");
                                alert.showAndWait();
        
        
    }

    }

}
