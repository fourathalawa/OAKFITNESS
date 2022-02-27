/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.repas;

import com.mycompany.oakfitnessjava.entities.Repas;
import com.mycompany.oakfitnessjava.services.RepasCRUD;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heni Nechi
 */
public class MealAddController implements Initializable {

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
        if (tabreak.getText().isEmpty()) {
            errorbreak.setVisible(true);
        }
        if (talunch.getText().isEmpty()) {
            errorlunch.setVisible(true);
        }
        if (tadinner.getText().isEmpty()) {
            errordinner.setVisible(true);
        }
        if (tfcalorie.getText().isEmpty()) {
            errorcalorie.setVisible(true);
        }
        if (cbactive.getValue() == null) {
            erroractiverest.setVisible(true);
        }
        if (!tabreak.getText().isEmpty()) {
            errorbreak.setVisible(false);
        }
        if (!talunch.getText().isEmpty()) {
            errorlunch.setVisible(false);
        }
        if (!tadinner.getText().isEmpty()) {
            errordinner.setVisible(false);
        }
        if (!tfcalorie.getText().isEmpty()) {
            errorcalorie.setVisible(false);
        }
        if (cbactive.getValue() != null) {
            erroractiverest.setVisible(false);
        }
        if (!tabreak.getText().isEmpty() && !talunch.getText().isEmpty() && !tadinner.getText().isEmpty() && !tfcalorie.getText().isEmpty() && cbactive.getValue() != null) {
            String PDej = tabreak.getText();
            String Dej = talunch.getText();
            String Dinn = tadinner.getText();
            int Calorie = Integer.parseInt(tfcalorie.getText());
            String ActiveOrRest = cbactive.getValue();
            Repas r = new Repas(PDej, Dej, Dinn, Calorie, ActiveOrRest);
            RepasCRUD rcrud = new RepasCRUD();
            rcrud.ajouterRepas2(r);
            Stage stage = (Stage) btnAdd.getScene().getWindow();
            stage.close();;
        }
    }

}
