/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projectoak.gui;

import com.esprit.projectoak.entities.Commentaire;
import com.esprit.projectoak.entities.NoteCommentaire;
import com.esprit.projectoak.entities.Publication;
import com.esprit.projectoak.services.CommentaireCRUD;
import com.esprit.projectoak.services.NoteCommentaireCRUD;
import com.esprit.projectoak.utils.MyConnection;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CommentaireController implements Initializable {

    Connection cnxx;
    @FXML
    private Button listen;
   

    public CommentaireController() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public int id;
    Commentaire commentaire = null;
    //  private TextField tf_id;
    private Label lab;
    StringProperty title = new SimpleStringProperty();
    @FXML
    private Label nomDuPub;
    @FXML
    private Label pub;
    @FXML
    private Label DateduPub;
    @FXML
    private TextField Commentaire;
    @FXML
    private TextField idPublication;
    @FXML
    private Button post;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIdPub(String message) {
        this.idPublication.setText(message);
    }

    public void setnom(String text) {
        nomDuPub.setText(text);
    }

    public void setPub(String text) {
        pub.setText(text);
    }

    public void setDate(String text) {
        DateduPub.setText(text);
    }

    public int setId2(String text) {
        int number = Integer.parseInt(text);
        this.id = number;
        //  System.out.println("id " + id);
        return id;
    }

    @FXML
    private TableView<Commentaire> tvCommentaire;
    @FXML
    private TableColumn<Commentaire, String> ft_NameCommentaire;
    @FXML
    private TableColumn<Commentaire, String> ft_Commentaire;
    @FXML
    private TableColumn<Commentaire, String> ft_DateComeentaire;
    @FXML
    private TableColumn<Commentaire, String> ft_edit;
    @FXML
    private TableColumn<Commentaire, String> ft_note;
    @FXML
    private TableColumn<Commentaire, Integer> ft_idComment;
    @FXML
    private TableColumn<Commentaire, Integer> ft_noteValue;
     @FXML
    private TableColumn<Commentaire, Integer> ft_idUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //  System.out.println("title" + valueOf(tf_id.getText()));
        // TODO
        int id3 = this.id;
//String a = tf_id.getText();
//        int number = Integer.parseInt(a);
        int a = getId();
        // System.out.println(a);
        showReclamation(id);
    }
//      public void showReclamationn (){
//        ReclamationCRUD rc = new ReclamationCRUD();
//        ObservableList<Reclamation> list = rc.afficherReclamation2();
//      //  ObservableList<Reclamation> list = afficherReclamation();
//        IDUserReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("IDUserReclamation"));
//        DescrReclam.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("DescrReclam"));
//        CategReclam.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("CategReclam"));
//        DateReclam.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("CategReclam"));
//        EtatReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("EtatReclamation"));
//        tvReclamation.setItems(list);
//    }

    public void showReclamation(int id) {
        System.out.println("dans ma fonction" + getId() + id);
        CommentaireCRUD cc = new CommentaireCRUD();
        ObservableList<Commentaire> list = cc.extractComment(id);
        ft_NameCommentaire.setCellValueFactory(new PropertyValueFactory<Commentaire, String>("NomCommentaire"));
        ft_Commentaire.setCellValueFactory(new PropertyValueFactory<Commentaire, String>("Commentaire"));
        ft_DateComeentaire.setCellValueFactory(new PropertyValueFactory<Commentaire, String>("DateCommentaire"));
        ft_idComment.setCellValueFactory(new PropertyValueFactory<Commentaire, Integer>("IDCommentaire"));
        ft_noteValue.setCellValueFactory(new PropertyValueFactory<Commentaire, Integer>("note"));
        ft_idUser.setCellValueFactory(new PropertyValueFactory<Commentaire, Integer>("IDUser"));

        tvCommentaire.setItems(list);
        //add cell of button edit 
        Callback<TableColumn<Commentaire, String>, TableCell<Commentaire, String>> cellFoctory = (TableColumn<Commentaire, String> param) -> {
            // make cell containing buttons
            final TableCell<Commentaire, String> cell = new TableCell<Commentaire, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#000000;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#000000;"
                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            CommentaireCRUD cc = new CommentaireCRUD();
                            commentaire = tvCommentaire.getSelectionModel().getSelectedItem();
                            // int number = Integer.parseInt(a);
                            System.out.println(commentaire.getIDCommentaire());
                            cc.supprimerCommentaire(commentaire.getIDCommentaire());
                            showReclamation(id);
                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {

                            commentaire = tvCommentaire.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("ModifierComment.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(CommentaireController.class.getName()).log(Level.SEVERE, null, ex);
                            }
//                            
                            ModifierCommentController modifierCommentControllert = loader.getController();
                            String a = "" + commentaire.getIDCommentaire();
                            modifierCommentControllert.setTextField(commentaire.getCommentaire(), a);
                            modifierCommentControllert.modifierPulication(commentaire.getIDCommentaire(), commentaire.getCommentaire());
//                            addStudentController.setUpdate(true);
//                            addStudentController.setTextField(student.getId(), student.getName(), 
//                                    student.getBirth().toLocalDate(),student.getAdress(), student.getEmail());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            showReclamation(id);

//                            
                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        ft_edit.setCellFactory(cellFoctory);
        Callback<TableColumn<Commentaire, String>, TableCell<Commentaire, String>> cellFoctory2 = (TableColumn<Commentaire, String> param) -> {
            // make cell containing buttons
            final TableCell<Commentaire, String> cell = new TableCell<Commentaire, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.MINUS);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PLUS);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:15px;"
                                + "-fx-fill:#000000;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:15px;"
                                + "-fx-fill:#000000;"
                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {

                            commentaire = tvCommentaire.getSelectionModel().getSelectedItem();
                            NoteCommentaireCRUD nc = new NoteCommentaireCRUD();
                            System.out.println(commentaire.getIDCommentaire() + commentaire.getIDUser());
                            int it = nc.check(commentaire.getIDCommentaire(), 1);
                            System.out.println("it" + it);
                            if (it > -1) {
                                nc.dislike(commentaire.getIDCommentaire(), 1);
                            }
                            showReclamation(id);
                            it = 0;
//                           
                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            commentaire = tvCommentaire.getSelectionModel().getSelectedItem();
                            NoteCommentaireCRUD nc = new NoteCommentaireCRUD();
                            System.out.println(commentaire.getIDCommentaire() + commentaire.getIDUser());
                            int it = nc.check(commentaire.getIDCommentaire(), 1);
                            System.out.println("it" + it);
                        
                            if (it < 1) {
                                nc.Like(commentaire.getIDCommentaire(),1);
                            }
                            showReclamation(id);
                            it = 0;

                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        ft_note.setCellFactory(cellFoctory2);

    }

    private void insertCommentaire() {

        String Commentairee = Commentaire.getText();
        String idPub = idPublication.getText();
            if (Commentairee.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
            }
            else if (! Commentairee.isEmpty() ) {
        int idp = Integer.parseInt(idPub);
        Commentaire c = new Commentaire(idp, 1, Commentairee);
        CommentaireCRUD cc = new CommentaireCRUD();
        cc.ajouterCommentaire2(c);
            }
    }

    @FXML
    private void post(ActionEvent event) {
        insertCommentaire();
        showReclamation(id);

    }

    @FXML
    private void listen(ActionEvent event) {
        try {
            // Set property as Kevin Dictionary
            System.setProperty(
                "freetts.voices",
                "com.sun.speech.freetts.en.us"
                    + ".cmu_us_kal.KevinVoiceDirectory");
  
            // Register Engine
            Central.registerEngineCentral(
                "com.sun.speech.freetts"
                + ".jsapi.FreeTTSEngineCentral");
  
            // Create a Synthesizer
            Synthesizer synthesizer
                = Central.createSynthesizer(
                    new SynthesizerModeDesc(Locale.US));
  
            // Allocate synthesizer
            synthesizer.allocate();
  
            // Resume Synthesizer
            synthesizer.resume();
  
            // Speaks the given text
            // until the queue is empty.
            synthesizer.speakPlainText(
                pub.getText(), null);;
            synthesizer.waitEngineState(
                Synthesizer.QUEUE_EMPTY);
  
            // Deallocate the Synthesizer.
           // synthesizer.deallocate();
        }
  
        catch (Exception e) {
            e.printStackTrace();
        }

}
}
