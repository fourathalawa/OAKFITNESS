/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.programmeNutritionnel;

import com.mycompany.oakfitnessjava.entities.Repas;
import com.mycompany.oakfitnessjava.services.ProgrammeNutritionnelCRUD;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Heni Nechi
 */
public class MealUserController implements Initializable {

    @FXML
    private Label breakfast;
    @FXML
    private Label dinner;
    @FXML
    private Label type;
    @FXML
    private Label lunch;
    @FXML
    private Label calorie;
    @FXML
    private ComboBox<String> cbCombo;
    private ObservableList<Repas> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> listday = new ArrayList<String>();
        listday.add("Monday");
        listday.add("Tuesday");
        listday.add("Wedensday");
        listday.add("Tursday");
        listday.add("Friday");
        listday.add("Saturday");
        listday.add("Sunday");
        ObservableList obList = FXCollections.observableList(listday);
        cbCombo.getItems().clear();
        cbCombo.setItems(obList);
        // TODO
        int userid = 1;
        ProgrammeNutritionnelCRUD pncrud = new ProgrammeNutritionnelCRUD();
        if(pncrud.AfficherRepasDeProgrammeUserDay(userid, cbCombo.getValue())!=null){
            data = FXCollections.observableArrayList(pncrud.AfficherRepasDeProgrammeUserDay(userid, cbCombo.getValue()));
        }
        
        //System.out.println(data);
        cbCombo.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            data.clear();
            if(pncrud.AfficherRepasDeProgrammeUserDay(userid, cbCombo.getValue())!=null){
            data = FXCollections.observableArrayList(pncrud.AfficherRepasDeProgrammeUserDay(userid, cbCombo.getValue()));
        }
            //System.out.println(data);
            
            if(!data.isEmpty()){
                this.breakfast.setText(data.get(userid).getPDej());
            this.lunch.setText(data.get(userid).getDej());
            this.dinner.setText(data.get(userid).getDinn());
            this.calorie.setText(String.valueOf(data.get(userid).getCalorie()));
            this.type.setText(data.get(userid).getRestOrActive());
            }
            else{
            this.breakfast.setText("Not yet set");
            this.lunch.setText("Not yet set");
            this.dinner.setText("Not yet set");
            this.calorie.setText("Not yet set");
            this.type.setText("Not yet set");
            }
            
            
            
            
        });
        
        
    }

}
