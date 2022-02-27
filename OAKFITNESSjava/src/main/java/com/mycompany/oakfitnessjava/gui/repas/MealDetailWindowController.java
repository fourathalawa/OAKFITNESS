/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.repas;

import com.mycompany.oakfitnessjava.entities.Exercice;
import com.mycompany.oakfitnessjava.entities.Repas;
import com.mycompany.oakfitnessjava.gui.EventsDetailsWindowController;
import com.mycompany.oakfitnessjava.gui.exercice.ExerciceDetailsWindowController;
import com.mycompany.oakfitnessjava.gui.exercice.ExerciceEditController;
import com.mycompany.oakfitnessjava.services.ExerciceCRUD;
import com.mycompany.oakfitnessjava.services.RepasCRUD;
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
public class MealDetailWindowController implements Initializable {

    @FXML
    private TableColumn<Repas, String> col_break;
    @FXML
    private TableColumn<Repas, String> col_lunch;
    @FXML
    private TableColumn<Repas, String> col_dinner;
    @FXML
    private TableColumn<Repas, Integer> col_calorie;
    @FXML
    private TableColumn<Repas, String> col_active;
    @FXML
    private TableColumn<Repas, Integer> col_id;
    private ObservableList<Repas> data;
    @FXML
    private TableView<Repas> meals;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnAdd;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RepasCRUD excrud = new RepasCRUD();
        data = FXCollections.observableArrayList(excrud.afficherRepas());
   

        col_break.setCellValueFactory(new PropertyValueFactory<>("PDej"));
        col_lunch.setCellValueFactory(new PropertyValueFactory<>("Dej"));
        col_dinner.setCellValueFactory(new PropertyValueFactory<>("Dinn"));
        col_calorie.setCellValueFactory(new PropertyValueFactory<>("Calorie"));
        col_active.setCellValueFactory(new PropertyValueFactory<>("RestOrActive"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("IDRepas"));
        meals.setItems(null);
        meals.setItems(data);
        
    }    

    @FXML
    private void openMealEdit(ActionEvent event) {
        Repas r = meals.getSelectionModel().getSelectedItem();
        if (r != null) {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MealEdit.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                MealEditController eec = fxmlLoader.getController();
                eec.setMeal(r);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Edit an Event");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(MealDetailWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select a meal to edit"), close);
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
    private void DeleteMeal(ActionEvent event) {
        Repas r = meals.getSelectionModel().getSelectedItem();
        if (r != null) {
            RepasCRUD rcrud = new RepasCRUD();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to delete this meal ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                rcrud.supprimerRepas(r.getIDRepas());
               
            } else if (alert.getResult() == ButtonType.NO) {
                alert.close();
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select a meal to delete"), close);
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
    private void openMealAdd(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MealAdd.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Add a Meal");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ExerciceDetailsWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
