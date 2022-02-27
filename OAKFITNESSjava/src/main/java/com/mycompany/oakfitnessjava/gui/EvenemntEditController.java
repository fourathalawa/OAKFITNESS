/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui;

import com.mycompany.oakfitnessjava.entities.Evenement;
import com.mycompany.oakfitnessjava.services.EvenementCRUD;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Heni Nechi
 */
public class EvenemntEditController implements Initializable {

    
    @FXML
    private TextField tfcreator;
    @FXML
    private TextField tfTitle;
    @FXML
    private DatePicker dpDate;
    @FXML
    private TextArea taDescription;
    @FXML
    private TextField tfAdress;
    @FXML
    private ComboBox<String> cbType;
    @FXML
    private Button btnValider;
    @FXML
    private TextField eid;
    @FXML
    private Label errortitle;
    @FXML
    private Label errordescription;
    @FXML
    private Label errordate;
    @FXML
    private Label erroradress;
    @FXML
    private Label errortype;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    @FXML
    private void UpdateEvent(ActionEvent event) {
        if(tfTitle.getText().isEmpty()){
        errortitle.setVisible(true);
        }
        if(dpDate.getValue()==null){
        errordate.setVisible(true);
        }
        if(taDescription.getText().isEmpty())
        {
        errordescription.setVisible(true);
        }
        if(tfAdress.getText().isEmpty()){
        erroradress.setVisible(true);
        } 
        if(cbType.getValue()==null)
        {
        errortype.setVisible(true);
        }
        if(!tfTitle.getText().isEmpty()){
        errortitle.setVisible(false);
        } 
        if(dpDate.getValue()!=null){
        errordate.setVisible(false);
        }
        if(!taDescription.getText().isEmpty())
        {
        errordescription.setVisible(false);
        }
        if(!tfAdress.getText().isEmpty()){
        erroradress.setVisible(false);
        } 
        if(cbType.getValue()!=null)
        {
        errortype.setVisible(false);
        }
        if(!tfcreator.getText().isEmpty()&&!tfTitle.getText().isEmpty()&&dpDate.getValue()!=null&&!taDescription.getText().isEmpty()&&!tfAdress.getText().isEmpty()&&cbType.getValue()!=null){
        int idCreatorEvenement = Integer.parseInt(tfcreator.getText());
        String TitreEvenement = tfTitle.getText();
        LocalDate DateEvenementl = dpDate.getValue();
        String DescrEvenemnt = taDescription.getText();
        String AdresseEvenemnt = tfAdress.getText();
        String TypeEvenement = cbType.getValue();
        Date DateEvenement = Date.from(DateEvenementl.atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date sqlDate = new java.sql.Date(DateEvenement.getTime());
        System.out.println(sqlDate);
        Evenement e = new Evenement(idCreatorEvenement,sqlDate,TitreEvenement, DescrEvenemnt, AdresseEvenemnt, TypeEvenement);
        EvenementCRUD ecrud = new EvenementCRUD();
        System.out.println(e);
        System.out.println(eid.getText());
        ecrud.ModifierEvenement(e, Integer.parseInt(eid.getText()));
        Stage stage = (Stage) btnValider.getScene().getWindow();
    stage.close();
        }
        
    }
    void SetEvent(Evenement e){
        java.util.Date safeDate = new Date(e.getDateEvenement().getTime());
        LocalDate InsertDate = safeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
       System.out.println(e.getDateEvenement().getClass().getName());
    this.tfTitle.setText(e.getTitreEvenement());
    this.dpDate.setValue(InsertDate);
    this.taDescription.setText(e.getDescrEvenement());
    this.tfAdress.setText(e.getAdresseEvenement());
    this.tfcreator.setText(String.valueOf(e.getIDCreatorEvenement()));
    this.cbType.setValue(e.getTypeEvenement());
    this.eid.setText(String.valueOf(e.getIDEvenement()));
    List<String> list = new ArrayList<String>();
        
        list.add("Online Event");
        list.add("Real Life Event");
        ObservableList obList = FXCollections.observableList(list);
        cbType.setItems(obList);
    }


}
