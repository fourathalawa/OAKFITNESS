/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui.exercice;

import com.mycompany.oakfitnessjava.entities.Evenement;
import com.mycompany.oakfitnessjava.entities.Exercice;
import com.mycompany.oakfitnessjava.services.EvenementCRUD;
import com.mycompany.oakfitnessjava.services.ExerciceCRUD;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heni Nechi
 */
public class ExerciceAddController implements Initializable {

    @FXML
    private TextArea tadescr;
    @FXML
    private TextField tfurl;
    @FXML
    private TextField tfmuscle;
    @FXML
    private TextField tfname;
    @FXML
    private TextField tfduration;
    @FXML
    private ComboBox<String> cbtype;
    @FXML
    private ComboBox<String> cbdiff;
    @FXML
    private ComboBox<String> cbog;
    @FXML
    private Button btnAdd;
    @FXML
    private Label errorname;
    @FXML
    private Label errortype;
    @FXML
    private Label errormuscle;
    @FXML
    private Label errorurl;
    @FXML
    private Label errordescr;
    @FXML
    private Label errordiff;
    @FXML
    private Label errorog;
    @FXML
    private Label errorduration;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<String> list = new ArrayList<String>();
        list.add("YES");
        list.add("NO");
        ObservableList obList = FXCollections.observableList(list);
        cbog.getItems().clear();
        cbog.setItems(obList);

        List<String> list2 = new ArrayList<String>();
        list2.add("Fitness");
        list2.add("Crossfit");
        list2.add("Body Building");
        list2.add("Cardio");
        ObservableList obList2 = FXCollections.observableList(list2);
        cbtype.getItems().clear();
        cbtype.setItems(obList2);

        List<String> list3 = new ArrayList<String>();

        list3.add("EASY");
        list3.add("MEDUIM");
        list3.add("HARD");
        ObservableList obList3 = FXCollections.observableList(list3);

        cbdiff.getItems().clear();
        cbdiff.setItems(obList3);
    }

    @FXML
    private void AddExercice(ActionEvent event) {
        if(tfname.getText().isEmpty()){
        errorname.setVisible(true);
        }
        if(tfduration.getText().isEmpty()){
        errorduration.setVisible(true);
        }
        if(cbdiff.getValue()==null){
        errordiff.setVisible(true);
        }
        if(tadescr.getText().isEmpty())
        {
        errordescr.setVisible(true);
        }
        if(tfmuscle.getText().isEmpty()){
        errormuscle.setVisible(true);
        }
        if(tfurl.getText().isEmpty()){
        errorurl.setVisible(true);
        } 
        if(cbog.getValue()==null)
        {
        errorog.setVisible(true);
        }
        if(cbtype.getValue()==null)
        {
        errortype.setVisible(true);
        }
        if(!tfname.getText().isEmpty()){
        errorname.setVisible(false);
        }
        if(!tfduration.getText().isEmpty()){
        errorduration.setVisible(false);
        }
        if(cbdiff.getValue()!=null){
        errordiff.setVisible(false);
        }
        if(!tadescr.getText().isEmpty())
        {
        errordescr.setVisible(false);
        }
        if(!tfmuscle.getText().isEmpty()){
        errormuscle.setVisible(false);
        }
        if(!tfurl.getText().isEmpty()){
        errorurl.setVisible(false);
        } 
        if(cbog.getValue()!=null)
        {
        errorog.setVisible(false);
        }
        if(cbtype.getValue()!=null)
        {
        errortype.setVisible(false);
        }
        
        if(!tfname.getText().isEmpty()&&!tfduration.getText().isEmpty()&&cbdiff.getValue()!=null&&!tadescr.getText().isEmpty()&&!tfmuscle.getText().isEmpty()&&!tfurl.getText().isEmpty()&&cbog.getValue()!=null&&cbtype.getValue()!=null) {
        String TypeExercice = cbtype.getValue();
        String NomExercice = tfname.getText();
        String Muscle = tfmuscle.getText();
        String Video = tfurl.getText();
        String DescExercice = tadescr.getText();
        String DiffExercice = cbdiff.getValue();
        String JusteSalleExerice = cbog.getValue();
        String DureeExercice = tfduration.getText();
        Exercice e = new Exercice(TypeExercice, NomExercice, Muscle, Video, DescExercice, DiffExercice,JusteSalleExerice,DureeExercice);
        ExerciceCRUD excrud = new ExerciceCRUD();
        excrud.ajouterExercice2(e);
        Stage stage = (Stage) btnAdd.getScene().getWindow();
    stage.close();
    
        }
    }

}
