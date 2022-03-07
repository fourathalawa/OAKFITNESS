/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Produit;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import services.ProduitCRUD;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author kriaa
 */
public class FXMLProduitClientController implements Initializable {

    @FXML
    private TableColumn<Produit,Integer> colIdProduitC;
    @FXML
    private TableColumn<Produit,String> colNomProduitC;
    @FXML
    private TableColumn<Produit, String> colCategProduitC;
    @FXML
    private TableColumn<Produit, Float> colPrixProduitC;
    @FXML
    private TableColumn<Produit, Integer> colStockProduitC;
    @FXML
    private TableColumn<Produit, String> colDescrProduitC;
    @FXML
    private ImageView produitimageviewclient;
    @FXML
    private TableView<Produit> tvclientProduit;
    @FXML
    private TableColumn<Produit, String> colImageProduitC;
    @FXML
    private TableColumn<Produit, Integer> colAvailabilityProduitC;
    @FXML
    private AnchorPane tfimageproduitclient;
    @FXML
    private TextField tfimageproduitcl;
    @FXML
    private ImageView ourlogoImageProduitClient;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherProduitClienTv();
        
        javafx.scene.image.Image logo = new javafx.scene.image.Image("file:"+"D:\\others\\logo.png");
        ourlogoImageProduitClient.setImage(logo); 
    }    
        Connection cnxx;
    
    public FXMLProduitClientController() {
        cnxx = MyConnection.getInstance().getCnx();
    }
     public void afficherProduitClienTv() {
        ProduitCRUD ps = new ProduitCRUD();
        List<Produit> list = ps.afficherProduit();
        colIdProduitC.setCellValueFactory(new PropertyValueFactory<>("IdProduit"));
        colNomProduitC.setCellValueFactory(new PropertyValueFactory<>("NomProduit"));
        colCategProduitC.setCellValueFactory(new PropertyValueFactory<>("CategProduit"));
        colPrixProduitC.setCellValueFactory(new PropertyValueFactory<>("PrixProduit"));
        colAvailabilityProduitC.setCellValueFactory(new PropertyValueFactory<>("IsAvailable"));
       // colImageProduitC.setCellValueFactory(new PropertyValueFactory<>("ImageProduit"));      
        colStockProduitC.setCellValueFactory(new PropertyValueFactory<>("StockProduit"));
        colDescrProduitC.setCellValueFactory(new PropertyValueFactory<>("DescrProduit"));
        tvclientProduit.setItems((ObservableList<Produit>) list);
    }

    @FXML
    private void ProduitClientgetitem(MouseEvent event) {
        Produit p = tvclientProduit.getSelectionModel().getSelectedItem();
       tfimageproduitcl.setText(p.getImageProduit());
       javafx.scene.image.Image test = new javafx.scene.image.Image("file:"+tfimageproduitcl.getText());
       tfimageproduitcl.setDisable(true);
        produitimageviewclient.setImage(test); 
    }
}
