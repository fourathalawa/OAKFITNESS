/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.entities.SessionUser;
import com.mycompany.entities.User;
import com.mycompany.services.SessionCRUD;
import com.mycompany.services.UserCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SignInController implements Initializable {

    @FXML
    private TextField idMail;
    @FXML
    private TextField idPassword;
    @FXML
    private Button idLoginIn;
    @FXML
    private Hyperlink idSignUp;
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
    private Hyperlink Password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
SessionCRUD s = new SessionCRUD();
s.supprimerSession();
    }    

    @FXML
    private void LogIn(ActionEvent event) {
        String Mail = idMail.getText();
        String Password = idPassword.getText();
    //   String Role = idRole.getText();
User us =new User( Mail,Password);
UserCRUD user = new UserCRUD(); 
int id= user.authentification(us);
if( id !=7)
{
    if(id == 1)
    {
           FXMLLoader loader= new FXMLLoader(getClass().getResource("MemberProfile.fxml"));
            try {
            Parent root = loader.load();
            MemberProfileController suac = loader.getController();
            idLoginIn.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
}
    else  if(id == 2)
    {
           FXMLLoader loader= new FXMLLoader(getClass().getResource("CoachProfile.fxml"));
            try {
            Parent root = loader.load();
           CoachProfileController suac = loader.getController();
            idLoginIn.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
}
     else  if(id == 3)
    {
           FXMLLoader loader= new FXMLLoader(getClass().getResource("ManagerProfile.fxml"));
            try {
            Parent root = loader.load();
          ManagerProfileController suac = loader.getController();
            idLoginIn.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
}
     else  if(id == 0)
    {
           FXMLLoader loader= new FXMLLoader(getClass().getResource("UserListAdmin.fxml"));
            try {
            Parent root = loader.load();
        UserListAdminController suac = loader.getController();
            idLoginIn.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
}
}
    }

    @FXML
    private void SignUp(ActionEvent event)  {
       
           FXMLLoader loader= new FXMLLoader(getClass().getResource("SignUpAdherent.fxml"));
            try {
            Parent root = loader.load();
            SignUpAdherentController suac = loader.getController();
            idLoginIn.getScene().setRoot(root);
           
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
    private void ForgetPassword(ActionEvent event) {
        
           FXMLLoader loader= new FXMLLoader(getClass().getResource("ForgetPassword.fxml"));
            try {
            Parent root = loader.load();
            ForgetPasswordController suac = loader.getController();
            Password.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
