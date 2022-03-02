/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projectoak.gui;

import com.esprit.projectoak.entities.Publication;
import com.esprit.projectoak.entities.Reclamation;
import com.esprit.projectoak.services.CommentaireCRUD;
import com.esprit.projectoak.services.ReclamationCRUD;
import com.esprit.projectoak.services.userCRUD;
import com.esprit.projectoak.tutorialspoint.SendInlineImagesInEmail;
import com.esprit.projectoak.utils.MyConnection;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ReclamationAdminController implements Initializable {

    Reclamation reclamation = null;
    ReclamationCRUD c = null;

    Connection cnxx;
    @FXML
    private TableColumn<Reclamation, String> ft_edit;
    @FXML
    private TableColumn<Reclamation, Integer> id;

    public ReclamationAdminController() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    @FXML
    private TableView<Reclamation> tvReclamation;
    @FXML
    private TableColumn<Reclamation, Integer> IDUserReclamation;
    @FXML
    private TableColumn<Reclamation, String> DescrReclam;
    @FXML
    private TableColumn<Reclamation, Integer> CategReclam;
    @FXML
    private TableColumn<Reclamation, String> DateReclam;
    @FXML
    private TableColumn<Reclamation, Integer> EtatReclamation;
    @FXML
    private TableColumn<Reclamation, String> ft_pub;
    @FXML
    private TableColumn<Reclamation, String> ft_comment;
    @FXML
    private TableColumn<Reclamation, Integer> ft_idComment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showReclamationn();
    }

    public void showReclamationn() {
        ReclamationCRUD rc = new ReclamationCRUD();
        ObservableList<Reclamation> list = rc.afficherReclamation2();
        //  ObservableList<Reclamation> list = afficherReclamation();
        IDUserReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("IDUserReclamation"));
        DescrReclam.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("DescrReclam"));
        CategReclam.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("CategReclam"));
        DateReclam.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("DateReclam"));
        EtatReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("EtatReclamation"));
        id.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("IDReclamation"));
        ft_pub.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("PubRec"));
        ft_comment.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("CommentaireRec"));
        ft_idComment.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("idCommentReclam"));
        Callback<TableColumn<Reclamation, String>, TableCell<Reclamation, String>> cellFoctory = (TableColumn<Reclamation, String> param) -> {
            // make cell containing buttons
            final TableCell<Reclamation, String> cell = new TableCell<Reclamation, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.REMOVE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#3b3f46;"
                        );

                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {

                            ReclamationCRUD cc = new ReclamationCRUD();
                            reclamation = tvReclamation.getSelectionModel().getSelectedItem();
                            // int number = Integer.parseInt(a);
                            //  System.out.println(reclamation.getIDReclamation());
                            // cc.supprimerReclamation(reclamation.getIDReclamation());
                            if (reclamation.getIDUserReclamation() == -1) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText(null);
                                alert.setContentText("this report is not a comment");
                                alert.showAndWait();
                            } else {
                                if (reclamation.getEtatReclamation() == 0) {
                                    ReclamationCRUD reclamationCRUD = new ReclamationCRUD();
                                    if (reclamationCRUD.nbSupp(reclamation.getIDUserReclamation()) == true) {
                                        userCRUD u = new userCRUD();
                                        u.supprimerUser(reclamation.getIDUserReclamation());
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText(null);
                                alert.setContentText("User banned");
                                alert.showAndWait();
                                    }
                                    CommentaireCRUD commentaireCRUD = new CommentaireCRUD();
                                    commentaireCRUD.supprimerCommentaire(reclamation.getIdCommentReclam());
                                    //  if(reclamation.getEtatReclamation()==0){
                                    reclamationCRUD.ajouterSuppression(reclamation.getIDUserReclamation());
                                    reclamationCRUD.modifierReclamation(reclamation.getIDReclamation());
                                    System.out.println(reclamation.getIDReclamation());
                                //    SendInlineImagesInEmail s = new SendInlineImagesInEmail();
                                //    s.mail();

                                } else {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText(null);
                                    alert.setContentText("report already treated");
                                    alert.showAndWait();
                                }
                            }
                            showReclamationn();

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
        ft_edit.setCellFactory(cellFoctory);

        tvReclamation.setItems(list);
    }
}
