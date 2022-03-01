/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projectoak.gui;

import com.esprit.projectoak.entities.Publication;
import com.esprit.projectoak.services.PublicationCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjouterPublicationController implements Initializable {

    @FXML
    private TextField publication;
    @FXML
    private Button submit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void publication(ActionEvent event) {
    }

    @FXML
    private void submit(ActionEvent event) {
        insertPublication();
    }
//    private void insertReclamtion(){
//        int cat=0;
//        String DescrReclam = tf_descreptionReclamation.getText();
//        String CategReclam =ch_Category.getValue();
//        if(CategReclam == "Commentaire"){
//            cat = 1;
//        }
//        else if(CategReclam == "publication"){
//            cat = 2;
//        }
//        else {
//            
//         cat = 3;
//        }
//        int IDUserReclamation = 1;
//        Reclamation p = new Reclamation(IDUserReclamation, cat, DescrReclam);
//        ReclamationCRUD rc = new ReclamationCRUD();
//        rc.ajouterReclamation2(p);
//       
//        
//        
//    }
    private void insertPublication(){
        
       

        String pub = publication.getText();
         if (pub.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
             }
         else {
        int id = 1;
        Publication p = new Publication(id, pub);
        PublicationCRUD pc = new PublicationCRUD();
        pc.ajouterPulication22(p);
         }
        
   
    
}
}
