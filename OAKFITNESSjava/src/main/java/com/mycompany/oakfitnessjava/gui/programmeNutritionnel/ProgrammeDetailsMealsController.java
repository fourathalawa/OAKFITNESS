/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.programmeNutritionnel;

import com.mycompany.oakfitnessjava.entities.Repas;
import com.mycompany.oakfitnessjava.services.ProgrammeNutritionnelCRUD;
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
import javafx.scene.control.TextField;
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
public class ProgrammeDetailsMealsController implements Initializable {

    @FXML
    private TableView<Repas> dietmeals;
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
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField pnid;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
void set(int i){
ProgrammeNutritionnelCRUD pncrud = new ProgrammeNutritionnelCRUD();
System.out.println(i);
        this.pnid.setText(String.valueOf(i));
        data = FXCollections.observableArrayList(pncrud.AfficherRepasDeProgramme(i));
        col_break.setCellValueFactory(new PropertyValueFactory<>("PDej"));
        col_lunch.setCellValueFactory(new PropertyValueFactory<>("Dej"));
        col_dinner.setCellValueFactory(new PropertyValueFactory<>("Dinn"));
        col_calorie.setCellValueFactory(new PropertyValueFactory<>("Calorie"));
        col_active.setCellValueFactory(new PropertyValueFactory<>("RestOrActive"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("IDRepas"));
        dietmeals.setItems(null);
        
        dietmeals.setItems(data);
}
    @FXML
    private void addMealPlan(ActionEvent event) {
        RepasCRUD rcrud = new RepasCRUD();
        try {
            System.out.println(Integer.parseInt(pnid.getText()));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MealtoPlanAdd.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            MealtoPlanAddController mpac = fxmlLoader.getController();
            mpac.SetProgramToEdit(Integer.parseInt(pnid.getText()));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Add an Exercice to a Fitness plan");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProgrammeDetailsMealsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void DeleteMealPlan(ActionEvent event) {
        Repas r = dietmeals.getSelectionModel().getSelectedItem();
        if (r != null) {
            RepasCRUD rcrud = new RepasCRUD();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to delete this meal from this fitness plan?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
               rcrud.supprimerRepasDeProgramme(r.getIDRepas(), Integer.parseInt(pnid.getText()));
            } else if (alert.getResult() == ButtonType.NO) {
                alert.close();
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select an exercice to delete from fitness plan"), close);
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
    
}
