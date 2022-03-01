/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.entities.SalleDeSport;
import com.mycompany.entities.User;
import com.mycompany.services.SalleDeSportCRUD;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class MyGymController implements Initializable {

    @FXML
    private TextField idRole;
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
    private Hyperlink idProfile;
    @FXML
    private TableView<SalleDeSport> idTableSalle;
    @FXML
    private TableColumn<SalleDeSport, String> idAdresse;
    @FXML
    private TableColumn<SalleDeSport, String> idName;
   
    @FXML
    private Button idAddGym;
    @FXML
    private TableColumn<SalleDeSport, String> idPrix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         loadDataGym();
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
    private void ProfileRedirect(ActionEvent event) {
    }

    @FXML
    private void AddGym(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("AddGym.fxml"));
            try {
            Parent root = loader.load();
          AddGymController suac = loader.getController();
            idAddGym.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadDataGym()
    {
        
       SalleDeSportCRUD salle= new SalleDeSportCRUD ();
ObservableList <SalleDeSport> mylist= salle.afficherSalles(); 
       
       idName.setCellValueFactory(new PropertyValueFactory<SalleDeSport,String>("Nom"));
       idAdresse.setCellValueFactory(new PropertyValueFactory<SalleDeSport,String>("Adresse"));
      idPrix.setCellValueFactory(new PropertyValueFactory<SalleDeSport,String>("PrixSeance"));
              idTableSalle.setItems(mylist);

    }
}
