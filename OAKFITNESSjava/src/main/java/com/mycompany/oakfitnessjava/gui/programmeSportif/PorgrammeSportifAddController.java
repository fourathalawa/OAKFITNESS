/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.programmeSportif;

import com.mycompany.oakfitnessjava.entities.Evenement;
import com.mycompany.oakfitnessjava.entities.ProgrammeSportif;
import com.mycompany.oakfitnessjava.services.EvenementCRUD;
import com.mycompany.oakfitnessjava.services.ProgrammeSportifCRUD;
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
public class PorgrammeSportifAddController implements Initializable {

    @FXML
    private TextField tfCoach;
    @FXML
    private TextField tfDuration;
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
    private Label errorduration;
    @FXML
    private Label errorType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<String> list = new ArrayList<String>();

        list.add("Full Body");
        list.add("Split");
        list.add("Lafay");
        list.add("Shape Training");
        list.add("Crossfit");
        list.add("Calisthenics");
        list.add("Weight loss");
        list.add("Muscle gain");
        ObservableList obList = FXCollections.observableList(list);
        cbType.getSelectionModel().selectFirst();
        cbType.getItems().clear();
        cbType.setItems(obList);
    }

    @FXML
    private void AddFitness(ActionEvent event) {
        if (tfCoach.getText().isEmpty()) {
            errorcoach.setVisible(true);
        }
        if (tfDuration.getText().isEmpty()) {
            errorduration.setVisible(true);
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
        if (!tfDuration.getText().isEmpty()) {
            errorduration.setVisible(false);
        }
        if (!tfMember.getText().isEmpty()) {
            errormember.setVisible(false);
        }
        if (cbType.getValue() != null) {
            errorType.setVisible(false);
        }
        if (cbType.getValue() != null && !tfDuration.getText().isEmpty() && !tfCoach.getText().isEmpty() && !tfMember.getText().isEmpty()) {
            int IDCoach = Integer.parseInt(tfCoach.getText());
            int IDAdherent = Integer.parseInt(tfMember.getText());
            int DureeMois = Integer.parseInt(tfDuration.getText());
            String TypeProgrammeNutritionnel = cbType.getValue();
            ProgrammeSportif ps = new ProgrammeSportif(IDCoach, IDAdherent, DureeMois, TypeProgrammeNutritionnel);
            System.out.println(ps);
            ProgrammeSportifCRUD pscrud = new ProgrammeSportifCRUD();
            pscrud.ajouterProgrammeSportif2(ps);
            Stage stage = (Stage) btnValider.getScene().getWindow();
            stage.close();

        }
    }

}
