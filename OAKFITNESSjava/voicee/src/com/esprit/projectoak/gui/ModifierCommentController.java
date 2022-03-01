/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projectoak.gui;

import com.esprit.projectoak.entities.Commentaire;
import com.esprit.projectoak.services.CommentaireCRUD;
import com.esprit.projectoak.utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ModifierCommentController implements Initializable {

    Connection cnxx;
    @FXML
    private TextField update_id;

    public ModifierCommentController() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    @FXML
    private TextField ft_comment;
    @FXML
    private Button submit;
    public int id;

// void setTextField(int id, String name, LocalDate toLocalDate, String adress, String email) {
//
//        studentId = id;
//        nameFld.setText(name);
//        birthFld.setValue(toLocalDate);
//        adressFld.setText(adress);
//        emailFld.setText(email);
//
//    }
    void setTextField(String Commentt, String iddd) {
        ft_comment.setText(Commentt);
        update_id.setText(iddd);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

//    private void submit(ActionEvent event) {
//        String Commentairee = ft_comment.getText();
//        String idj = update_id.getText();
//        int number = Integer.parseInt(idj);
//        System.out.println("iddddd" + id);
//        modifierPulication(number, Commentairee);
//    }

    public void modifierPulication(int id, String comment) {

        String req = "UPDATE commentaire set Commentaire=? WHERE IDCommentaire = ?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, comment);
            pst.setInt(2, id);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
//          private void insertCommentaire(int id) {
//
//        String Commentairee = ft_comment.getText();
//        CommentaireCRUD cc = new CommentaireCRUD();
//              System.out.println("comment"+Commentairee);
//              System.out.println("id"+id);
//        cc.modifierPulication2(id, Commentairee);
//    }

    @FXML
    private void submit(ActionEvent event) {
                String Commentairee = ft_comment.getText();
        String idj = update_id.getText();
        int number = Integer.parseInt(idj);
        System.out.println("iddddd" + idj);
                System.out.println("iddddd" + Commentairee);

        modifierPulication(number, Commentairee);
    }

}
