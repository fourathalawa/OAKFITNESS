/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.exercice;

import com.mycompany.oakfitnessjava.entities.Evenement;
import com.mycompany.oakfitnessjava.entities.Exercice;
import com.mycompany.oakfitnessjava.gui.EvenemntEditController;
import com.mycompany.oakfitnessjava.gui.EventsDetailsWindowController;
import com.mycompany.oakfitnessjava.services.EvenementCRUD;
import com.mycompany.oakfitnessjava.services.ExerciceCRUD;
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
public class ExerciceDetailsWindowController implements Initializable {

    @FXML
    private TableView<Exercice> exercice;
    @FXML
    private TableColumn<Exercice, String> col_exercice;
    @FXML
    private TableColumn<Exercice, String> col_type;
    @FXML
    private TableColumn<Exercice, String> col_muscle;
    @FXML
    private TableColumn<Exercice, String> col_video;
    @FXML
    private TableColumn<Exercice, String> col_description;
    @FXML
    private TableColumn<Exercice, String> col_diff;
    @FXML
    private TableColumn<Exercice, String> col_og;
    @FXML
    private TableColumn<Exercice, String> col_duration;
    @FXML
    private TableColumn<Exercice, Integer> col_id;
    @FXML
    private Button openEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private Button openAdd;
    @FXML
    private ObservableList<Exercice> data;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ExerciceCRUD excrud = new ExerciceCRUD();
        data = FXCollections.observableArrayList(excrud.afficherExercice());
   

        col_type.setCellValueFactory(new PropertyValueFactory<>("TypeExercice"));
        col_exercice.setCellValueFactory(new PropertyValueFactory<>("NomExercice"));
        col_muscle.setCellValueFactory(new PropertyValueFactory<>("Muscle"));
        col_video.setCellValueFactory(new PropertyValueFactory<>("Video"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("DescrExercice"));
        col_diff.setCellValueFactory(new PropertyValueFactory<>("DiffExercice"));
        col_og.setCellValueFactory(new PropertyValueFactory<>("JusteSalleExercice"));
        col_duration.setCellValueFactory(new PropertyValueFactory<>("DureeExercice"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("IDExercice"));

        exercice.setItems(null);
        exercice.setItems(data);
        
    }    

    @FXML
    private void openExerciceEdit(ActionEvent event) {
        Exercice e = exercice.getSelectionModel().getSelectedItem();
        if (e != null) {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExerciceEdit.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                ExerciceEditController eec = fxmlLoader.getController();
                eec.set(e);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Edit an Event");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EventsDetailsWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select an exercice to edit"), close);
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
    private void DeleteExercice(ActionEvent event) {
        Exercice e = exercice.getSelectionModel().getSelectedItem();
        if (e != null) {
            ExerciceCRUD excrud = new ExerciceCRUD();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to delete '" + e.getNomExercice()+ "' ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                excrud.supprimerExercice(e.getIDExercice());
               
            } else if (alert.getResult() == ButtonType.NO) {
                alert.close();
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select an exercice to delete"), close);
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
    private void openExerciceAdd(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExerciceAdd.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Add an Exercice");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ExerciceDetailsWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
