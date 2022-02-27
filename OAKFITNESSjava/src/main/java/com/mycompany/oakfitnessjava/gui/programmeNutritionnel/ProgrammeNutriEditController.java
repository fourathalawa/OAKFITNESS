/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.programmeNutritionnel;

import com.mycompany.oakfitnessjava.entities.ProgrammeNutritionnel;
import com.mycompany.oakfitnessjava.entities.ProgrammeSportif;
import com.mycompany.oakfitnessjava.services.ProgrammeNutritionnelCRUD;
import com.mycompany.oakfitnessjava.services.ProgrammeSportifCRUD;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heni Nechi
 */
public class ProgrammeNutriEditController implements Initializable {

    @FXML
    private TextField tfCoach;
    @FXML
    private TextField tfCalorie;
    @FXML
    private TextField tfMember;
    @FXML
    private Button btnValider;
    @FXML
    private ComboBox<String> cbType;
    @FXML
    private Label errorcoach;
    @FXML
    private Label errormember;
    @FXML
    private Label errorType;
    @FXML
    private TextField pnid;
    @FXML
    private Label errorCalorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EditDiet(ActionEvent event) {
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
            int DureeMois = Integer.parseInt(tfCalorie.getText());
            String TypeProgrammeNutritionnel = cbType.getValue();
            ProgrammeNutritionnel pn = new ProgrammeNutritionnel(IDCoach, IDAdherent, DureeMois, TypeProgrammeNutritionnel);
            System.out.println(pn);
            ProgrammeNutritionnelCRUD pncrud = new ProgrammeNutritionnelCRUD();
            pncrud.ModifierProgrammeNutritionnel(pn,Integer.parseInt(pnid.getText()));
            Stage stage = (Stage) btnValider.getScene().getWindow();
            stage.close();

        }
    
    }

    void SetFitness(ProgrammeNutritionnel pn) {

        this.tfCoach.setText(String.valueOf(pn.getIDCoach()));
        this.tfMember.setText(String.valueOf(pn.getIDAdherent()));
        this.tfCalorie.setText(String.valueOf(pn.getCalorie()));
        this.cbType.setValue(pn.getTypeProgrammeNutritionel());
        this.pnid.setText(String.valueOf(pn.getIDProgrammeNutritionnel()));
        List<String> list = new ArrayList<String>();
        list.add("Weight Loss");
        list.add("Mass Gain");
        list.add("Lean Gain");
        list.add("Dirty Gain");
        ObservableList obList = FXCollections.observableList(list);

        cbType.setItems(obList);

    }
    
}
