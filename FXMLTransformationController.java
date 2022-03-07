/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Transformation;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import services.TransformationCRUD;

/**
 * FXML Controller class
 *
 * @author kriaa
 */
public class FXMLTransformationController implements Initializable {

    @FXML
    private ImageView imageavanttrans;
    @FXML
    private ImageView imageaprestrans;
    @FXML
    private TableColumn<Transformation, Integer> colIDTransformation;
    @FXML
    private TableColumn<Transformation, String> colTitle;
    @FXML
    private TableColumn<Transformation, String> colDescreption;
    @FXML
    private TableColumn<Transformation, String> colImageBefore;
    @FXML
    private TableColumn<Transformation, String> colImageAfter;
    @FXML
    private TableColumn<Transformation, Float> colWeightBefore;
    @FXML
    private TableColumn<Transformation, Float> colWeightAfter;
    @FXML
    private TableColumn<Transformation, Float> colHeightBefore;
    @FXML
    private TableColumn<Transformation, Float> colHeightAfter;
    @FXML
    private TableColumn<Transformation, Integer> colVotes;
    @FXML
    private TableColumn<Transformation, Integer> colIDUSERtrans;
    @FXML
    private TableView<Transformation> tvTransfadmin;
    @FXML
    private TextField tfimav;
    @FXML
    private TextField tfimap;
    @FXML
    private TextField tfvotes;
    @FXML
    private Text txtvotes;
    @FXML
    private TextField idTrans;
    @FXML
    private Pane paneanimationtrans;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherTransclTv();
        
    }

    public void afficherTransclTv() {
        TransformationCRUD ps = new TransformationCRUD();
        List<Transformation> list = ps.afficherTransformation();
        colIDTransformation.setCellValueFactory(new PropertyValueFactory<>("IdImage"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("TitreImage"));
        colDescreption.setCellValueFactory(new PropertyValueFactory<>("DescreptionImage"));
        colImageBefore.setCellValueFactory(new PropertyValueFactory<>("ImageAvant"));
        colImageAfter.setCellValueFactory(new PropertyValueFactory<>("ImageApres"));
        colWeightBefore.setCellValueFactory(new PropertyValueFactory<>("PoidAvant"));
        colWeightAfter.setCellValueFactory(new PropertyValueFactory<>("PoidApres"));
        colHeightBefore.setCellValueFactory(new PropertyValueFactory<>("TailleAvant"));
        colHeightAfter.setCellValueFactory(new PropertyValueFactory<>("TailleApres"));
        colVotes.setCellValueFactory(new PropertyValueFactory<>(" Tlike "));
        colVotes.setVisible(false);
        colIDUSERtrans.setCellValueFactory(new PropertyValueFactory<>("IdUser"));

        tvTransfadmin.setItems((ObservableList<Transformation>) list);
    }

    @FXML
    private void slectitemtransadmin(MouseEvent event) {

        TransformationCRUD ps = new TransformationCRUD();
        Transformation p = tvTransfadmin.getSelectionModel().getSelectedItem();
        tfvotes.setText(String.valueOf(p.getTlikes()));
        tfimav.setText(p.getImageAvant());
        tfimap.setText(p.getImageApres());
        txtvotes.setText(String.valueOf(p.getTlikes()));
        idTrans.setText(String.valueOf(p.getIdImage()));

        javafx.scene.image.Image test = new javafx.scene.image.Image("file:" + tfimav.getText());
        imageavanttrans.setImage(test);
        javafx.scene.image.Image test2 = new javafx.scene.image.Image("file:" + tfimap.getText());
        imageaprestrans.setImage(test2);

    }

    @FXML
    private void Deletetransformation(MouseEvent event) {
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Delete ", "Delete", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            int IdTrans = Integer.parseInt(idTrans.getText());
            TransformationCRUD ps = new TransformationCRUD();
            ps.supprimerTransformation(IdTrans);
            afficherTransclTv();

        }
    }

}
