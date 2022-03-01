/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.entities.User;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddAdminController implements Initializable {

    @FXML
    private TextField idRole;
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
    private DatePicker idDateNaissance;
    @FXML
    private Hyperlink idEvents;
    @FXML
    private Hyperlink idNews;
    @FXML
    private Hyperlink idPrograms;
    @FXML
    private Hyperlink idShop;
    @FXML
    private Hyperlink idProduct;
    @FXML
    private Hyperlink idAboutUs;
    @FXML
    private Hyperlink idComplaint;
    @FXML
    private Hyperlink idUsers;
    @FXML
    private TextField idNomAA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Valider(ActionEvent event) {
        String Nom = idNomAA.getText();
                String Prenom = idPrenom.getText();
         String Date_naissance =String.valueOf(idDateNaissance.getValue());
        String Mail = idMail.getText();
        String Password = idPassword.getText();
        int role = Integer.parseInt(idRole.getText());
        long numTelephone =Integer.parseInt(idNumeroTelephone.getText()) ;
User us =new User( Nom,  Prenom,  Mail,  numTelephone,  Date_naissance, role, Password);
UserCRUD user = new UserCRUD(); 

user.ajouterAdmin(us);FXMLLoader loader= new FXMLLoader(getClass().getResource("UserListAdmin.fxml"));
            try{
            Parent root = loader.load();
         UserListAdminController suac = loader.getController();
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
    private void programRedirect(ActionEvent event) {
    }

    @FXML
    private void shopRedirect(ActionEvent event) {
    }

    @FXML
    private void productRedirect(ActionEvent event) {
    }

    @FXML
    private void aboutUsRedirect(ActionEvent event) {
    }

    @FXML
    private void complaintRedirect(ActionEvent event) {
    }

    @FXML
    private void usersRedirect(ActionEvent event) {
    }
    
}
