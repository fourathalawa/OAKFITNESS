/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.oakfitnessjava.gui;

import com.mycompany.oakfitnessjava.entities.Evenement;
import com.mycompany.oakfitnessjava.services.EvenementCRUD;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
public class EventsDetailsWindowController implements Initializable {

    @FXML
    private Label eventcount;
    @FXML
    private Label eventj1;
    @FXML
    private Button openEdit;
    @FXML
    private TableView<Evenement> eventtable;
    @FXML
    private Button btnDelete;
    @FXML
    private TableColumn<Evenement, String> col_title;
    @FXML
    private TableColumn<Evenement, String> col_date;
    @FXML
    private TableColumn<Evenement, String> col_description;
    @FXML
    private TableColumn<Evenement, String> col_adress;
    @FXML
    private TableColumn<Evenement, String> col_type;
    @FXML
    private TableColumn<Evenement, String> col_creator;
    @FXML
    private TableColumn<Evenement, String> col_id;
    @FXML
    private ObservableList<Evenement> data;
    @FXML
    private DatePicker dpdate2;
    @FXML
    private DatePicker dpdate1;
    @FXML
    private ComboBox<Integer> cbcreator;
    @FXML
    private TextField tfsearch;
    @FXML
    private Button btnFilter;
    @FXML
    private Button setnull;
    @FXML
    private Button setnull2;
    @FXML
    private Button setnull1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        EvenementCRUD ecrud = new EvenementCRUD();
        eventcount.setText(String.valueOf(ecrud.CountEvenement()));
        eventj1.setText(String.valueOf(ecrud.isJ1Count()));
        data = FXCollections.observableArrayList(ecrud.afficherEvenement());
        data.addListener(new ListChangeListener<Evenement>() {

            @Override
            public void onChanged(javafx.collections.ListChangeListener.Change<? extends Evenement> pChange) {
                while (pChange.next()) {
                    // Do your changes here
                    
                    eventtable.refresh();
                    eventcount.setText(String.valueOf(ecrud.CountEvenement()));
                    eventj1.setText(String.valueOf(ecrud.isJ1Count()));
                }
            }
        });

        col_title.setCellValueFactory(new PropertyValueFactory<>("TitreEvenement"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("DateEvenement"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("DescrEvenement"));
        col_adress.setCellValueFactory(new PropertyValueFactory<>("AdresseEvenement"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("TypeEvenement"));
        col_creator.setCellValueFactory(new PropertyValueFactory<>("IDCreatorEvenement"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("IDEvenement"));

        eventtable.setItems(null);
        eventtable.setItems(data);
        List<Integer> list = ecrud.CreatorsID();
        ObservableList obList = FXCollections.observableList(list);
        cbcreator.getItems().clear();
        cbcreator.setItems(obList);
        System.out.println(cbcreator.getValue());
        
    }
    //eventtable.setItems()

    @FXML
    private void openEventAdd(ActionEvent event) {
EvenementCRUD ecrud = new EvenementCRUD();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Evenement.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Add an Event");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EventsDetailsWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        eventtable.refresh();
                    eventcount.setText(String.valueOf(ecrud.CountEvenement()));
                    eventj1.setText(String.valueOf(ecrud.isJ1Count()));
    }

    @FXML
    private void DeleteEvent(ActionEvent event) {
        Evenement e = eventtable.getSelectionModel().getSelectedItem();
        if (e != null) {
            EvenementCRUD ecrud = new EvenementCRUD();
            Alert alert = new Alert(AlertType.CONFIRMATION, "Do you really want to delete '" + e.getTitreEvenement() + "' ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                ecrud.supprimerEvenement(e.getIDEvenement());
                eventcount.setText(String.valueOf(ecrud.CountEvenement()));
                eventj1.setText(String.valueOf(ecrud.isJ1Count()));
            } else if (alert.getResult() == ButtonType.NO) {
                alert.close();
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Button close = new Button("OK");
            VBox vbox = new VBox(new Text("You need to select an event to delete"), close);
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
    private void openEventEdit(ActionEvent event) {

        Evenement e = eventtable.getSelectionModel().getSelectedItem();
        if (e != null) {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EvenemntEdit.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                EvenemntEditController edc = fxmlLoader.getController();
                edc.SetEvent(e);
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
            VBox vbox = new VBox(new Text("You need to select an event to edit"), close);
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
    private void Filter(ActionEvent event) {
        EvenementCRUD ecrud = new EvenementCRUD();

        //if search not empty and other fields are empty
        if ((!tfsearch.getText().isEmpty() || tfsearch.getText() != null) && dpdate1.getValue() == null && dpdate2.getValue() == null && cbcreator.getValue() == null) {
            FilteredList<Evenement> FiteredData = new FilteredList<>(data, e -> true);
            FiteredData.setPredicate((Predicate<? super Evenement>) evenement -> {

                if (tfsearch.getText() == null || tfsearch.getText().isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = tfsearch.getText().toLowerCase();
                if (evenement.getTitreEvenement().contains(tfsearch.getText())) {
                    return true;
                } else if (evenement.getTitreEvenement().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }

                return false;
            });

            SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
            sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
            eventtable.setItems(sortedData);
        }
        //if search not empty and two dates not empty but empty combo
        if (!tfsearch.getText().isEmpty() && dpdate1.getValue() != null && dpdate2.getValue() != null && cbcreator.getValue() == null) {
            List<Evenement> NotFilteredDates = ecrud.BetweenDatesEvenement(Date.from(dpdate1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(dpdate2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
            FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);
            FiteredData.setPredicate((Predicate<? super Evenement>) evenement -> {

                if (tfsearch.getText() == null || tfsearch.getText().isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = tfsearch.getText().toLowerCase();
                if (evenement.getTitreEvenement().contains(tfsearch.getText())) {
                    return true;
                } else if (evenement.getTitreEvenement().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }

                return false;
            });

            SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
            sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
            eventtable.setItems(sortedData);

        }
        //if search not empty , date one not emty date two empty , combo is empty
        if (!tfsearch.getText().isEmpty() && dpdate1.getValue() != null && dpdate2.getValue() == null && cbcreator.getValue() == null) {
            List<Evenement> NotFilteredDates = ecrud.FirstDatesEvenement(Date.from(dpdate1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            if (!NotFilteredDates.isEmpty()) {
                ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
                FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);
                FiteredData.setPredicate((Predicate<? super Evenement>) evenement -> {

                    if (tfsearch.getText() == null || tfsearch.getText().isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = tfsearch.getText().toLowerCase();
                    if (evenement.getTitreEvenement().contains(tfsearch.getText())) {
                        return true;
                    } else if (evenement.getTitreEvenement().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }

                    return false;
                });

                SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
                sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
                eventtable.setItems(sortedData);

            }
        }
        //if search not empty , date one emty date two note empty, combo empty
        if (!tfsearch.getText().isEmpty() && dpdate1.getValue() == null && dpdate2.getValue() != null && cbcreator.getValue() == null) {
            List<Evenement> NotFilteredDates = ecrud.LastDatesEvenement(Date.from(dpdate1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            if (!NotFilteredDates.isEmpty()) {
                ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
                FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);

                FiteredData.setPredicate((Predicate<? super Evenement>) evenement -> {

                    if (tfsearch.getText() == null || tfsearch.getText().isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = tfsearch.getText().toLowerCase();
                    if (evenement.getTitreEvenement().contains(tfsearch.getText())) {
                        return true;
                    } else if (evenement.getTitreEvenement().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }

                    return false;
                });

                SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
                sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
                eventtable.setItems(sortedData);

            }
        }
        //
        if (tfsearch.getText().isEmpty() && dpdate1.getValue() != null && dpdate2.getValue() == null && cbcreator.getValue() == null) {
            List<Evenement> NotFilteredDates = ecrud.FirstDatesEvenement(Date.from(dpdate1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            if (!NotFilteredDates.isEmpty()) {
                ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
                FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);

                SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
                sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
                eventtable.setItems(sortedData);

            }
        }
        if (tfsearch.getText().isEmpty() && dpdate1.getValue() == null && dpdate2.getValue() != null && cbcreator.getValue() == null) {
            List<Evenement> NotFilteredDates = ecrud.LastDatesEvenement(Date.from(dpdate2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            if (!NotFilteredDates.isEmpty()) {
                ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
                FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);

                SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
                sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
                eventtable.setItems(sortedData);

            }
        }
        if (tfsearch.getText().isEmpty() && dpdate1.getValue() != null && dpdate2.getValue() != null && cbcreator.getValue() == null) {
            List<Evenement> NotFilteredDates = ecrud.BetweenDatesEvenement(Date.from(dpdate1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(dpdate2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
            FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);
            SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
            sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
            eventtable.setItems(sortedData);
        }
        //combo
        if (!tfsearch.getText().isEmpty() && dpdate1.getValue() == null && dpdate2.getValue() == null && cbcreator.getValue() != null) {

            List<Evenement> NotFilteredDates = ecrud.EvenementCreatedby(cbcreator.getValue());
            if (!NotFilteredDates.isEmpty()) {
                ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
                FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);

                FiteredData.setPredicate((Predicate<? super Evenement>) evenement -> {

                    if (tfsearch.getText() == null || tfsearch.getText().isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = tfsearch.getText().toLowerCase();
                    if (evenement.getTitreEvenement().contains(tfsearch.getText())) {
                        return true;
                    } else if (evenement.getTitreEvenement().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }

                    return false;
                });

                SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
                sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
                eventtable.setItems(sortedData);

            }
        }
        if (tfsearch.getText().isEmpty() && dpdate1.getValue() != null && dpdate2.getValue() == null && cbcreator.getValue() != null) {
            List<Evenement> NotFilteredID = ecrud.EvenementCreatedby(cbcreator.getValue());
            List<Evenement> NotFilteredDates = ecrud.FirstDatesEvenement(Date.from(dpdate1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            NotFilteredDates.retainAll(NotFilteredID);
            if (!NotFilteredDates.isEmpty()) {
                ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
                FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);

                SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
                sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
                eventtable.setItems(sortedData);

            }
        }
        if (tfsearch.getText().isEmpty() && dpdate1.getValue() == null && dpdate2.getValue() != null && cbcreator.getValue() != null) {
            List<Evenement> NotFilteredID = ecrud.EvenementCreatedby(cbcreator.getValue());
            List<Evenement> NotFilteredDates = ecrud.LastDatesEvenement(Date.from(dpdate2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            NotFilteredDates.retainAll(NotFilteredID);
            if (!NotFilteredDates.isEmpty()) {
                ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
                FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);

                SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
                sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
                eventtable.setItems(sortedData);

            }
        }
        if (tfsearch.getText().isEmpty() && dpdate1.getValue() != null && dpdate2.getValue() != null && cbcreator.getValue() != null) {
            List<Evenement> NotFilteredID = ecrud.EvenementCreatedby(cbcreator.getValue());
            List<Evenement> NotFilteredDates = ecrud.BetweenDatesEvenement(Date.from(dpdate1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(dpdate2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            NotFilteredDates.retainAll(NotFilteredID);
            ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
            FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);
            SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
            sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
            eventtable.setItems(sortedData);
        }
        if (!tfsearch.getText().isEmpty() && dpdate1.getValue() == null && dpdate2.getValue() != null && cbcreator.getValue() != null) {
            List<Evenement> NotFilteredID = ecrud.EvenementCreatedby(cbcreator.getValue());
            List<Evenement> NotFilteredDates = ecrud.LastDatesEvenement(Date.from(dpdate2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            NotFilteredDates.retainAll(NotFilteredID);
            if (!NotFilteredDates.isEmpty()) {
                ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
                FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);

                FiteredData.setPredicate((Predicate<? super Evenement>) evenement -> {

                    if (tfsearch.getText() == null || tfsearch.getText().isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = tfsearch.getText().toLowerCase();
                    if (evenement.getTitreEvenement().contains(tfsearch.getText())) {
                        return true;
                    } else if (evenement.getTitreEvenement().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }

                    return false;
                });

                SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
                sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
                eventtable.setItems(sortedData);

            }
        }
        if (!tfsearch.getText().isEmpty() && dpdate1.getValue() != null && dpdate2.getValue() == null && cbcreator.getValue() != null) {
            List<Evenement> NotFilteredID = ecrud.EvenementCreatedby(cbcreator.getValue());
            List<Evenement> NotFilteredDates = ecrud.BetweenDatesEvenement(Date.from(dpdate1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(dpdate2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            NotFilteredDates.retainAll(NotFilteredID);
            if (!NotFilteredDates.isEmpty()) {
                ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredDates);
                FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);

                FiteredData.setPredicate((Predicate<? super Evenement>) evenement -> {

                    if (tfsearch.getText() == null || tfsearch.getText().isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = tfsearch.getText().toLowerCase();
                    if (evenement.getTitreEvenement().contains(tfsearch.getText())) {
                        return true;
                    } else if (evenement.getTitreEvenement().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }

                    return false;
                });

                SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
                sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
                eventtable.setItems(sortedData);

            }
        }
        if (tfsearch.getText().isEmpty() && dpdate1.getValue() == null && dpdate2.getValue() == null && cbcreator.getValue() != null) {
            List<Evenement> NotFilteredID = ecrud.EvenementCreatedby(cbcreator.getValue());
            if (!NotFilteredID.isEmpty()) {
                ObservableList<Evenement> tobeInsertedNotFilterDates = FXCollections.observableArrayList(NotFilteredID);
                FilteredList<Evenement> FiteredData = new FilteredList<>(tobeInsertedNotFilterDates, e -> true);

                SortedList<Evenement> sortedData = new SortedList<>(FiteredData);
                sortedData.comparatorProperty().bind(eventtable.comparatorProperty());
                eventtable.setItems(sortedData);

            }
        }
    }

    @FXML
    private void SetNullCombo(ActionEvent event) {
        cbcreator.setValue(null);
    }

    @FXML
    private void SetNullDate1(ActionEvent event) {
        dpdate1.setValue(null);
    }

    @FXML
    private void SetNullDate2(ActionEvent event) {
        dpdate2.setValue(null);
    }

}
