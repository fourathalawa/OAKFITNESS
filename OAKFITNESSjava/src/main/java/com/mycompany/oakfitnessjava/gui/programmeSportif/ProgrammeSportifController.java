/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.programmeSportif;

import com.mycompany.oakfitnessjava.entities.Evenement;
import com.mycompany.oakfitnessjava.entities.ProgrammeSportif;
import com.mycompany.oakfitnessjava.services.EvenementCRUD;


import com.mycompany.oakfitnessjava.services.ProgrammeSportifCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Heni Nechi
 */
public class ProgrammeSportifController implements Initializable {

    @FXML
    private Button btnDelete;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnAdd;
    @FXML
    private TableView<ProgrammeSportif> fitnesstable;
    @FXML
    private TableColumn<ProgrammeSportif, Integer> col_coach;
    @FXML
    private TableColumn<ProgrammeSportif, Integer> col_member;
    @FXML
    private TableColumn<ProgrammeSportif, Integer> col_duration;
    @FXML
    private TableColumn<ProgrammeSportif, String> col_type;
    @FXML
    private TableColumn<ProgrammeSportif, Integer> col_id;
    private ObservableList<ProgrammeSportif> data;
    @FXML
    private Button btnExercice;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ProgrammeSportifCRUD pscrud = new ProgrammeSportifCRUD();
        data = FXCollections.observableArrayList(pscrud.afficherProgrammeSportif());
        col_coach.setCellValueFactory(new PropertyValueFactory<>("IDCoach"));
        col_member.setCellValueFactory(new PropertyValueFactory<>("IDAdherent"));
        col_duration.setCellValueFactory(new PropertyValueFactory<>("DureeMois"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("TypeProgrammeSportif"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("IDProgrammeSportif"));

        fitnesstable.setItems(null);
        fitnesstable.setItems(data);
    
}

    @FXML
    private void DeleteFitness(ActionEvent event) {
        ProgrammeSportif ps = fitnesstable.getSelectionModel().getSelectedItem();
        if (ps != null) {
            ProgrammeSportifCRUD pscrud = new ProgrammeSportifCRUD();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to delete  this fitness plan ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                pscrud.supprimerProgrammeSportif(ps.getIDProgrammeSportif());
                
            } else if (alert.getResult() == ButtonType.NO) {
                alert.close();
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select a fitness plan to delete"), close);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(25));

            dialogStage.setScene(new Scene(vbox));
            dialogStage.show();
            EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dialogStage.close();
                }
            };
            close.setOnAction(buttonHandler);
        }

    }

    @FXML
    private void EditFitness(ActionEvent event) {
        ProgrammeSportif ps = fitnesstable.getSelectionModel().getSelectedItem();
        if (ps != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProgrammeSportifEdit.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                PorgrammeSportifEditController psec = fxmlLoader.getController();
                psec.SetFitness(ps);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Edit a Fitness Plan");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ProgrammeSportif.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select a fitness plan to edit"), close);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(25));

            dialogStage.setScene(new Scene(vbox));
            dialogStage.show();
            EventHandler<ActionEvent> buttonHandler = (ActionEvent event1) -> {
                dialogStage.close();
            };
            close.setOnAction(buttonHandler);
        }
    }

    @FXML
    private void AddFitness(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PorgrammeSportifAdd.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Add a Fitness Plan");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProgrammeSportif.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openDetailsExercice(ActionEvent event) {
        ProgrammeSportif ps = fitnesstable.getSelectionModel().getSelectedItem();
        if (ps != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProgrammeDetailsExercice.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                ProgrammeDetailsExerciceController psec = fxmlLoader.getController();
                psec.set(ps.getIDProgrammeSportif());
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Edit a Fitness Plan");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ProgrammeSportif.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select a fitness plan to edit"), close);
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(25));

            dialogStage.setScene(new Scene(vbox));
            dialogStage.show();
            EventHandler<ActionEvent> buttonHandler = (ActionEvent event1) -> {
                dialogStage.close();
            };
            close.setOnAction(buttonHandler);
        }
    }
}
