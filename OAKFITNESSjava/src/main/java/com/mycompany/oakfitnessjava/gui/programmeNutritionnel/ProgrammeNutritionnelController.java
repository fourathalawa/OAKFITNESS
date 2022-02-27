/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.programmeNutritionnel;

import com.mycompany.oakfitnessjava.entities.ProgrammeNutritionnel;

import com.mycompany.oakfitnessjava.services.ProgrammeNutritionnelCRUD;
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
public class ProgrammeNutritionnelController implements Initializable {

    @FXML
    private Button btnDelete;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnAdd;
    @FXML
    private TableView<ProgrammeNutritionnel> nutritable;
    @FXML
    private TableColumn<ProgrammeNutritionnel, Integer> col_coach;
    @FXML
    private TableColumn<ProgrammeNutritionnel, Integer> col_member;
    @FXML
    private TableColumn<ProgrammeNutritionnel, Integer> col_calo;
    @FXML
    private TableColumn<ProgrammeNutritionnel, String> col_type;
    @FXML
    private TableColumn<ProgrammeNutritionnel, Integer> col_id;
    private ObservableList<ProgrammeNutritionnel> data;
    @FXML
    private Button btnMeal;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ProgrammeNutritionnelCRUD pncrud = new ProgrammeNutritionnelCRUD();
        data = FXCollections.observableArrayList(pncrud.afficherProgrammeNutritionnel());
        col_coach.setCellValueFactory(new PropertyValueFactory<>("IDCoach"));
        col_member.setCellValueFactory(new PropertyValueFactory<>("IDAdherent"));
        col_calo.setCellValueFactory(new PropertyValueFactory<>("Calorie"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("TypeProgrammeNutritionel"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("IDProgrammeNutritionnel"));
        nutritable.setItems(null);
        
        nutritable.setItems(data);

    }

    @FXML
    private void DeleteNutri(ActionEvent event) {
        ProgrammeNutritionnel pn = nutritable.getSelectionModel().getSelectedItem();
        if (pn != null) {
            ProgrammeNutritionnelCRUD pncrud = new ProgrammeNutritionnelCRUD();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to delete  this diet plan ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                pncrud.supprimerProgrammeNutritionnel(pn.getIDProgrammeNutritionnel());

            } else if (alert.getResult() == ButtonType.NO) {
                alert.close();
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select a diet plan to delete"), close);
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
    private void EditNutri(ActionEvent event) {
        ProgrammeNutritionnel pn = nutritable.getSelectionModel().getSelectedItem();
        if (pn != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProgrammeNutriEdit.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                ProgrammeNutriEditController psec = fxmlLoader.getController();
                psec.SetFitness(pn);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Edit a Fitness Plan");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ProgrammeNutritionnel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select a diet plan to edit"), close);
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
    private void AddNutri(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProgrammeNutriAdd.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Add a Fitness Plan");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProgrammeNutritionnel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openDetailsMeals(ActionEvent event) {
        ProgrammeNutritionnel pn = nutritable.getSelectionModel().getSelectedItem();
       
        if (pn != null) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProgrammeDetailsMeals.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                ProgrammeDetailsMealsController pdmc = fxmlLoader.getController();
                System.out.println(pdmc);
                pdmc.set(pn.getIDProgrammeNutritionnel());
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Edit a Fitness Plan");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ProgrammeNutritionnel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select a diet plan to edit"), close);
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
