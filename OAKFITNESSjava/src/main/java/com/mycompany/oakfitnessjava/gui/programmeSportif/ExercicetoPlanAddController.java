/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.programmeSportif;


import com.mycompany.oakfitnessjava.entities.Exercice;
import com.mycompany.oakfitnessjava.services.ExerciceCRUD;
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
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Heni Nechi
 */
public class ExercicetoPlanAddController implements Initializable {

    @FXML
    private ComboBox<Exercice> cbExercice;
    @FXML
    private Button btnAdd;
    private ObservableList<Exercice> data;
    @FXML
    private TextField psid;
    @FXML
    private ComboBox<String> day;
    @FXML
    private Label errorExercice;
    @FXML
    private Label ErrorDay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ExerciceCRUD excrud = new ExerciceCRUD();
        data = FXCollections.observableArrayList(excrud.afficherExercice());
        cbExercice.getItems().clear();
        cbExercice.setItems(data);
        List<String> listday = new ArrayList<String>();
        listday.add("Monday");
        listday.add("Tuesday");
        listday.add("Wedensday");
        listday.add("Tursday");
        listday.add("Friday");
        listday.add("Saturday");
        listday.add("Sunday");
        ObservableList obList = FXCollections.observableList(listday);
        day.getItems().clear();
         day.setItems(obList);
        
    }    

    @FXML
    private void AddExercicetoplan(ActionEvent event) {
        if (cbExercice.getValue()==null) {
            errorExercice.setVisible(true);
        }
        if (day.getValue()==null ){
            ErrorDay.setVisible(true);
        }
        if (cbExercice.getValue()!=null) {
            errorExercice.setVisible(false);
        }
        if (day.getValue()!=null ){
            ErrorDay.setVisible(false);
        }
        if(day.getValue()!=null&cbExercice.getValue()!=null){
        int eID = cbExercice.getValue().getIDExercice();
        ExerciceCRUD excrud = new ExerciceCRUD();
        excrud.AjouterExerciceAProgramme(Integer.parseInt(psid.getText()), eID, day.getValue());
        }

        
    }
    void SetProgramToEdit(int i)
    {
    this.psid.setText(String.valueOf(i));
    }
    
}
