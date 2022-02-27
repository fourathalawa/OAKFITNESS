/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.repas;

import com.mycompany.oakfitnessjava.entities.Repas;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Heni Nechi
 */
public class MealEditController implements Initializable {

    @FXML
    private TextArea tabreak;
    @FXML
    private TextArea talunch;
    @FXML
    private TextArea tadinner;
    @FXML
    private TextField tfcalorie;
    @FXML
    private ComboBox<String> cbactive;
    @FXML
    private Button btnAdd;
    @FXML
    private Label errorbreak;
    @FXML
    private Label errorlunch;
    @FXML
    private Label errordinner;
    @FXML
    private Label errorcalorie;
    @FXML
    private Label erroractiverest;
    @FXML
    private TextField mid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<String> list = new ArrayList<String>();
        list.add("ACTIVE");
        list.add("REST");
        ObservableList obList = FXCollections.observableList(list);
        cbactive.getItems().clear();
        cbactive.setItems(obList);
    }    

    @FXML
    private void AddMeal(ActionEvent event) {
    }
    void setMeal(Repas r){
        this.mid.setText(String.valueOf(r.getIDRepas()));
    this.tabreak.setText(r.getPDej());
    this.talunch.setText(r.getDej());
    this.tadinner.setText(r.getDinn());
    this.cbactive.setValue(r.getRestOrActive());
    this.tfcalorie.setText(String.valueOf(r.getCalorie()));
            
            
            
            
            
    }
}
