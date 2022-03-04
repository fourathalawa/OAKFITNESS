/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projectoak.gui;

import com.esprit.projectoak.entities.Commentaire;
import com.esprit.projectoak.entities.Publication;
import com.esprit.projectoak.services.CommentaireCRUD;
import com.esprit.projectoak.services.PublicationCRUD;
import com.esprit.projectoak.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.stage.Window;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ForumController implements Initializable {
        int f =0;
    public int id =1;
    Publication publication = null;
    Connection cnxx;
    @FXML
    private TextField search;
    @FXML
    private ImageView image;
    @FXML
    private Button ask;
    public static int b = 0;
    @FXML
    private Button listen;
    @FXML
    private TextField quest;

    public ForumController() {
        cnxx = MyConnection.getInstance().getCnx();
    }
    @FXML
    private TableView<Publication> tvPublication;
    @FXML
    private TableColumn<Publication, String> NomPublication;
    @FXML
    private TableColumn<Publication, String> Publication;
    @FXML
    private TableColumn<Publication, String> DatePublication;
    @FXML
    private TableColumn<Publication, String> View;
    @FXML
    private TableColumn<Publication, String> idPublication;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image2 = new Image("icons/oak.png");
        image.setImage(image2);
        showPublication();
        afficherChercher();
      //   SpeechRecognizerMain c = new SpeechRecognizerMain();
      //  voice();
        //   SpeechRecognizerMain c = new SpeechRecognizerMain();
        //   SpeechRecognizerMain c = new SpeechRecognizerMain();

        //  ask2();
        //  SpeechRecognizerMain s = new SpeechRecognizerMain();
// SpeechRecognizerMain s = new SpeechRecognizerMain();
// s.speechRecognizerThreadRunning = true;
//                    while (s.speechRecognizerThreadRunning) {
//        
//                                if (s.speechRecognitionResult == "one") {
//                                    ask2();
//                                     s.speechRecognizerThreadRunning = false;
//                                  //  speechRecognizerThreadRunning = false;
//                                }
//
//
//                                if ("one".equals(s.speechRecognitionResult)) {
//                                    ask2();
//                                                                         s.speechRecognizerThreadRunning = false;
//
//                                //    speechRecognizerThreadRunning = false;
//                                }
//                        
//
//                    }
    }

    //  System.out.println(s.speechRecognitionResult+"jjjjjjjjjj");
    // System.out.println(s.speechRecognitionResult+"hjjjjj");
    //   ask2();
    //    }
    public ObservableList<Publication> afficherPulication() {
        ObservableList<Publication> myList = FXCollections.observableArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM publication";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Publication per = new Publication();
                per.setIDpublication(rs.getInt("IDPublication"));
                per.setNomPublication(extractNom(rs.getInt("IDUser")));
                per.setPublication(rs.getString(4));
                per.setDatePublication(rs.getString(3));
                int i = (rs.getInt("IDPublication"));
                System.out.println(i);
                String s = String.valueOf(i);
                System.out.println("string " + s);
                per.setSIDpublication(s);
                myList.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public String extractNom(int id) {
        String nom = "";
        try {
            Statement st = cnxx.createStatement();
            String req = "Select * FROM user WHERE userID ='" + id + "' ";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {
                nom = rs.getString(2);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return nom;

    }

    public void showPublication() {
        ObservableList<Publication> list = afficherPulication();
        NomPublication.setCellValueFactory(new PropertyValueFactory<Publication, String>("NomPublication"));
        Publication.setCellValueFactory(new PropertyValueFactory<Publication, String>("Publication"));
        DatePublication.setCellValueFactory(new PropertyValueFactory<Publication, String>("DatePublication"));
        idPublication.setCellValueFactory(new PropertyValueFactory<Publication, String>("SIDpublication"));

        //View.setCellValueFactory(new PropertyValueFactory<Publication,Button>("button"));
        //add cell of button edit 
        Callback<TableColumn<Publication, String>, TableCell<Publication, String>> cellFoctory = (TableColumn<Publication, String> param) -> {
            // make cell containing buttons
            final TableCell<Publication, String> cell = new TableCell<Publication, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.EDIT);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#3b3f46;"
                        );

                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            // student = studentsTable.getSelectionModel().getSelectedItem();
                            publication = tvPublication.getSelectionModel().getSelectedItem();
                            System.out.println("id : " + publication.getIDpublication());

                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("Commentaire.fxml"));
                            try {

                                Parent root = loader.load();
                                CommentaireController cc = loader.getController();
                                // cc.id= 7;
                                System.out.println(publication.getIDpublication());
                                //   cc.setId2(publication.getSIDpublication());
                                //   cc.setId(cc.setId2(publication.getSIDpublication()));
                                //  cc.myFunction(publication.getSIDpublication());
                                cc.showReclamation(cc.setId2(publication.getSIDpublication()));
                                cc.setnom(publication.getNomPublication());
                                cc.setPub(publication.getPublication());
                                cc.setDate(publication.getDatePublication());
                                cc.setIdPub("" + publication.getIDpublication());
                                Parent parent = loader.getRoot();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(parent));
                                //  stage.initStyle(StageStyle.UTILITY);
                                stage.show();

                            } catch (IOException ex) {
                                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                        );

                        HBox managebtn = new HBox(deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        View.setCellFactory(cellFoctory);

        tvPublication.setItems(list);
    }

    @FXML
    private void seach(ActionEvent event) {
    }

    @FXML
    private void ask(ActionEvent event) {  
        TestWord testWord = new TestWord();
        testWord.loadConfigs();
        String pubb = quest.getText();
        if(testWord.filterText(pubb, "") == true)
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("This message was blocked because a bad word was found. If you believe this word should not be blocked, please message support.");
            alert.showAndWait();
        } 
        else  if (pubb.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
            }
            else {
        Publication p = new Publication(id, pubb);
        PublicationCRUD pc = new PublicationCRUD();
        pc.ajouterPulication22(p);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText(null);
                                alert.setContentText("Publication added");
                                alert.showAndWait();
            }
           showPublication();
    }

    public void ask2() {

//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("AjouterPublication.fxml"));
//        try {
//            loader.load();
//        } catch (IOException ex) {
//            Logger.getLogger(CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Parent parent = loader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(parent));
//        stage.initStyle(StageStyle.UTILITY);
//        stage.show();
//        afficherPulication();
        
         Platform.exit();
    }

    public ObservableList<Publication> chercher() {
        ObservableList<Publication> myList = FXCollections.observableArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM publication";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Publication per = new Publication();
                per.setIDpublication(rs.getInt("IDPublication"));
                per.setNomPublication(extractNom(rs.getInt("IDUser")));
                per.setPublication(rs.getString(4));
                per.setDatePublication(rs.getString(3));
                int i = (rs.getInt("IDPublication"));
                System.out.println(i);
                String s = String.valueOf(i);
                System.out.println("string " + s);
                per.setSIDpublication(s);
                myList.add(per);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public void afficherChercher() {
        ObservableList<Publication> list = afficherPulication();
        NomPublication.setCellValueFactory(new PropertyValueFactory<Publication, String>("NomPublication"));
        Publication.setCellValueFactory(new PropertyValueFactory<Publication, String>("Publication"));
        DatePublication.setCellValueFactory(new PropertyValueFactory<Publication, String>("DatePublication"));
        idPublication.setCellValueFactory(new PropertyValueFactory<Publication, String>("SIDpublication"));
        tvPublication.setItems(list);
        FilteredList<Publication> filteredData = new FilteredList<>(list, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(publication -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();

                if (publication.getPublication().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                }

                return false;
            });
        });
        SortedList<Publication> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvPublication.comparatorProperty());
        tvPublication.setItems(sortedData);
    }

//    public synchronized void voice() {
//        int aa = 0;
//        b = 0;
//       
//        while (true) {
//            if (c.a == 1){
//                ask2();
//                b++;
//
//                aa = 1;
//
//            }
//        }
//
//    }

    @FXML
    private void listen(ActionEvent event) {
       SpeechRecognizerMain c = new SpeechRecognizerMain();
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText(null);
                                alert.setContentText("Speak for commands");
                                alert.showAndWait();


    }

}
