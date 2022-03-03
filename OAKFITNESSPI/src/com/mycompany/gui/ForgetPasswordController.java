/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.services.UserCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ForgetPasswordController implements Initializable {

    @FXML
    private TextField idMail;
    @FXML
    private Button idSubmit;
    @FXML
    private Label idLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SendPassword(ActionEvent event) {
         String Mail = idMail.getText();
         UserCRUD user = new UserCRUD();
         String nom =user.checkMail(Mail);
         if(nom !="")
         {
             user.ResetPassword(Mail);
             idLabel.setText("An email containing your password has been sent to "+Mail +"." );
         }
         else 
         {
             idLabel.setText("Email does not exist ");
         }
    }
    
}
