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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ReclamationAdminController implements Initializable {
    Connection cnxx;

    public ReclamationAdminController() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    @FXML
    private TableView<Reclamation> tvReclamation;
    @FXML
    private TableColumn<Reclamation, Integer> IDUserReclamation;
    @FXML
    private TableColumn<Reclamation, String> DescrReclam;
    @FXML
    private TableColumn<Reclamation, Integer> CategReclam;
    @FXML
    private TableColumn<Reclamation, String> DateReclam;
    @FXML
    private TableColumn<Reclamation, Integer> EtatReclamation;
    @FXML
    private Button btn_ModifierReclamation;
    @FXML
    private Button btn_SupprimerReclamation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showReclamationn ();
    }    

    @FXML
    private void modifierReclamation(ActionEvent event) {
    }

    @FXML
    private void Supprimerreclamation(ActionEvent event) {
    }
    

    public void showReclamationn (){
        ReclamationCRUD rc = new ReclamationCRUD();
        ObservableList<Reclamation> list = rc.afficherReclamation2();
      //  ObservableList<Reclamation> list = afficherReclamation();
        IDUserReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("IDUserReclamation"));
        DescrReclam.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("DescrReclam"));
        CategReclam.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("CategReclam"));
        DateReclam.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("CategReclam"));
        EtatReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("EtatReclamation"));
        tvReclamation.setItems(list);
    }
}
