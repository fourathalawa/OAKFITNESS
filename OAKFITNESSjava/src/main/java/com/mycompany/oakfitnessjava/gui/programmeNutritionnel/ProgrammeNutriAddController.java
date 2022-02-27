/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.programmeNutritionnel;

import com.mycompany.oakfitnessjava.entities.ProgrammeNutritionnel;
import com.mycompany.oakfitnessjava.services.ProgrammeNutritionnelCRUD;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heni Nechi
 */
public class ProgrammeNutriAddController implements Initializable {

    @FXML
    private TextField tfCoach;
    @FXML
    private TextField tfMember;
    @FXML
    private ComboBox<String> cbType;
    @FXML
    private Button btnValider;
    @FXML
    private Label errorcoach;
    @FXML
    private Label errormember;
    @FXML
    private Label errorType;
    @FXML
    private TextField tfCalorie;
    @FXML
    private Label errorCalorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<String> list = new ArrayList<String>();

          list.add("Weight Loss");
        list.add("Mass Gain");
        list.add("Lean Gain");
        list.add("Dirty Gain");
        ObservableList obList = FXCollections.observableList(list);
        cbType.getSelectionModel().selectFirst();
        cbType.getItems().clear();
        cbType.setItems(obList);
    }

    @FXML
    private void AddDiet(ActionEvent event) {
        if (tfCoach.getText().isEmpty()) {
            errorcoach.setVisible(true);
        }
        if (tfCalorie.getText().isEmpty()) {
            errorCalorie.setVisible(true);
        }
        if (tfMember.getText().isEmpty()) {
            errormember.setVisible(true);
        }
        if (cbType.getValue() == null) {
            errorType.setVisible(true);
        }
        if (!tfCoach.getText().isEmpty()) {
            errorcoach.setVisible(false);
        }
        if (!tfCalorie.getText().isEmpty()) {
            errorCalorie.setVisible(false);
        }
        if (!tfMember.getText().isEmpty()) {
            errormember.setVisible(false);
        }
        if (cbType.getValue() != null) {
            errorType.setVisible(false);
        }
        if (cbType.getValue() != null && !tfCalorie.getText().isEmpty() && !tfCoach.getText().isEmpty() && !tfMember.getText().isEmpty()) {
            int IDCoach = Integer.parseInt(tfCoach.getText());
            int IDAdherent = Integer.parseInt(tfMember.getText());
            int Calorie = Integer.parseInt(tfCalorie.getText());
            String TypeProgrammeNutritionnel = cbType.getValue();
            ProgrammeNutritionnel pn = new ProgrammeNutritionnel(IDCoach, IDAdherent, Calorie, TypeProgrammeNutritionnel);
            ProgrammeNutritionnelCRUD pscrud = new ProgrammeNutritionnelCRUD();
            pscrud.ajouterProgrammeNutritionnel2(pn);
            Stage stage = (Stage) btnValider.getScene().getWindow();
            stage.close();

        }
    }

    
}
