/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.programmeNutritionnel;

import com.mycompany.oakfitnessjava.entities.Repas;
import com.mycompany.oakfitnessjava.services.RepasCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Heni Nechi
 */
public class MealtoPlanAddController implements Initializable {

    @FXML
    private Button btnAdd;
    private ObservableList<Repas> data;
    @FXML
    private ComboBox<Repas> cbMeal;
    @FXML
    private TextField pnid;
    @FXML
    private Label errorMeal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RepasCRUD rcrud = new RepasCRUD();
        data = FXCollections.observableArrayList(rcrud.afficherRepas());
        cbMeal.getItems().clear();
        cbMeal.setItems(data);
    }    

    @FXML
    private void AddMealPlan(ActionEvent event) {
        if (cbMeal.getValue()!=null) {
            errorMeal.setVisible(false);
        }
        if (cbMeal.getValue()==null ){
            errorMeal.setVisible(true);
        }
        if(cbMeal.getValue()!=null){
        int rID = cbMeal.getValue().getIDRepas();
        RepasCRUD rcrud = new RepasCRUD();
        rcrud.AjouterRepasAProgramme(Integer.parseInt(pnid.getText()), rID);
        }
    }
    void SetProgramToEdit(int i){
    this.pnid.setText(String.valueOf(i));
    }
    
}
