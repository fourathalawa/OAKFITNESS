/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.itextpdf.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import entities.Produit;
import java.awt.Image;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static javafx.print.Paper.C;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import services.ProduitCRUD;
import utils.MyConnection;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import static javax.print.attribute.standard.MediaSize.Engineering.C;
import static javax.print.attribute.standard.MediaSizeName.C;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.text.Document;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import javax.swing.text.Document;

/**
 * FXML Controller class
 *
 * @author kriaa
 */
public class FXMLProduitController implements Initializable {
    
    @FXML
    private TextField tfNomProduit;
    @FXML
    private TextField tfCategProduit;
    @FXML
    private TextField tfPrixProduit;
    @FXML
    private RadioButton tfIsAvailable;
    @FXML
    private TextField tfImageProduit;
    @FXML
    private TextField tfStockProduit;
    @FXML
    private TextField tfDescreProduit;
    @FXML
    private TableView<Produit> tvProduit;
    @FXML
    private TableColumn<Produit, Integer> colIdProduit;
    @FXML
    private TableColumn<Produit, String> colNameProduit;
    @FXML
    private TableColumn<Produit, String> colCategProduit;
    @FXML
    private TableColumn<Produit, Float> colPriceProduit;
    @FXML
    private TableColumn<Produit, Integer> colIsAvailable;
    @FXML
    private TableColumn<Produit, String> colImageProduit;
    @FXML
    private TableColumn<Produit, Integer> colStockProduit;
    @FXML
    private TableColumn<Produit, String> colDescreptionProduit;
    @FXML
    private Button btnInsertproduit;
    @FXML
    private Button btndeleteproduit;
    @FXML
    private Button btnupdateproduit;
    @FXML
    private TextField tfIdProduit;
    @FXML
    private Label labelca;
    @FXML
    private RadioButton rbTriNomProduit;
    @FXML
    private RadioButton rbTriPrixProduit;
    @FXML
    private Button btnchooseProduit;
    @FXML
    private Label lbalerteProduit;
    @FXML
    private Button btngeneratepdfProduit;
    @FXML
    private ImageView imageProduit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherProduitTv();
        afficherChiffreAffaire();
        tfIsAvailable.setText("0");
        tfStockProduit.setDisable(true);
        lbalerteProduit.setText("");
        TextFields.bindAutoCompletion(tfCategProduit, "whey", "whey isolate", "whey premium", "mass gainer", "mass gainer anabolic ", "kreatine", "bca");
               javafx.scene.image.Image test = new javafx.scene.image.Image("file:"+tfImageProduit.getText());
        imageProduit.setImage(test); 
        
    }
    
    @FXML
    private void clickoninsertProduit(ActionEvent event) {
        //
        //tfIsAvailable.isSelected(true);
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Insert ", "Insert", JOptionPane.YES_NO_OPTION);
        
        if(opt==0){String NomProduit = tfNomProduit.getText();
        String CategProduit = tfCategProduit.getText();
        String DescrProduit = tfDescreProduit.getText();
        float PrixProduit = Float.parseFloat(tfPrixProduit.getText());
        int IsAvailable = Integer.parseInt(tfIsAvailable.getText());
        String ImageProduit = tfImageProduit.getText();
        int StockProduit = Integer.parseInt(tfStockProduit.getText());
        Produit p = new Produit(NomProduit, CategProduit, DescrProduit, PrixProduit, IsAvailable, ImageProduit, StockProduit);
        ProduitCRUD ps = new ProduitCRUD();
        ps.ajouterProduit(p);
        afficherProduitTv();
        afficherChiffreAffaire();
        tfIsAvailable.setText("0");
        javafx.scene.image.Image test = new javafx.scene.image.Image("file:"+tfImageProduit.getText());
        imageProduit.setImage(test); 
        }
    }
    
    @FXML
    private void onclickdeleteproduit(ActionEvent event) {
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Delete ", "Delete", JOptionPane.YES_NO_OPTION);
        if(opt==0){int IdProduit = Integer.parseInt(tfIdProduit.getText());
        ProduitCRUD ps = new ProduitCRUD();
        ps.supprimerProduit(IdProduit);
        afficherProduitTv();
        afficherChiffreAffaire();
        tfIsAvailable.setText("0");}
        
    }
    
    @FXML
    private void onclickupdateproduit(ActionEvent event) {
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Update ", "Update", JOptionPane.YES_NO_OPTION);
        if(opt==0){int IdProduit = Integer.parseInt(tfIdProduit.getText());
        String NomProduit = tfNomProduit.getText();
        String CategProduit = tfCategProduit.getText();
        String DescrProduit = tfDescreProduit.getText();
        float PrixProduit = Float.parseFloat(tfPrixProduit.getText());
        int IsAvailable = Integer.parseInt(tfIsAvailable.getText());
        String ImageProduit = tfImageProduit.getText();
        int StockProduit = Integer.parseInt(tfStockProduit.getText());
        Produit p = new Produit(NomProduit, CategProduit, DescrProduit, PrixProduit, IsAvailable, ImageProduit, StockProduit);
        ProduitCRUD ps = new ProduitCRUD();
        ps.modifierProduit(p, IdProduit);
        afficherProduitTv();
        afficherChiffreAffaire();

        }
    }
    
    @FXML
    private void getAvailable(ActionEvent event) {
        if (tfIsAvailable.isSelected()) {
            tfIsAvailable.setText("1");
            tfStockProduit.setDisable(false);
            
        } else {
            tfIsAvailable.setText("0");
            tfStockProduit.setDisable(true);
            tfStockProduit.setText("0");
        }
    }
    
    @FXML
    private void get_selected_items(javafx.scene.input.MouseEvent event) {
        Produit p = tvProduit.getSelectionModel().getSelectedItem();
        tfIdProduit.setText(String.valueOf(p.getIdProduit()));
        tfNomProduit.setText(p.getNomProduit());
        tfCategProduit.setText(p.getCategProduit());
        tfPrixProduit.setText(String.valueOf(p.getPrixProduit()));
        tfIsAvailable.setText(String.valueOf(p.getIsAvailable()));
        if (p.getIsAvailable() == 1) {
            tfIsAvailable.setSelected(true);
            tfStockProduit.setDisable(false);
        } else {
            tfIsAvailable.setSelected(false);
            tfStockProduit.setDisable(true);
        }
        tfImageProduit.setText(p.getImageProduit());
        tfStockProduit.setText(String.valueOf(p.getStockProduit()));
        tfDescreProduit.setText(p.getDescrProduit());
        
       javafx.scene.image.Image test = new javafx.scene.image.Image("file:"+tfImageProduit.getText());
        imageProduit.setImage(test); 
       
              
    }
    
    @FXML
    private void vider_text_field(javafx.scene.input.MouseEvent event) {
        tfIdProduit.setText("");
        tfNomProduit.setText("");
        tfCategProduit.setText("");
        tfPrixProduit.setText("");
        tfIsAvailable.setText("0");
        tfIsAvailable.setSelected(false);
        tfStockProduit.setDisable(true);
        tfImageProduit.setText("");
        tfStockProduit.setText("0");
        tfDescreProduit.setText("");
        lbalerteProduit.setText("");
        javafx.scene.image.Image test = new javafx.scene.image.Image("file:"+tfImageProduit.getText());
        imageProduit.setImage(test); 
    }
    
    @FXML
    private void onclicktrierNameProduit(ActionEvent event) {
        rbTriPrixProduit.setSelected(false);
        afficherProduitTrierNomTv();
        
    }
    
    @FXML
    private void onclicktrierPrixProduit(ActionEvent event) {
        rbTriNomProduit.setSelected(false);
        afficherProduitTrierPrixTv();
    }
    
    @FXML
    private void ontypestockProduit(KeyEvent event) {
        String s = event.getCharacter();
        char c = s.charAt(0);
        if (!Character.isDigit(c)) {
            event.consume();
        }
    }
    
    @FXML
    private void OnMouseClickedStock(javafx.scene.input.MouseEvent event) {
        
        lbalerteProduit.setText(" Stock Must Be A Number !");
    }
    
    @FXML
    private void ontypedprixproduit(KeyEvent event) {
        String s = event.getCharacter();
        char c = s.charAt(0);
        //!Character.isDigit(c)||
        if ((c != '.') && (!Character.isDigit(c))) {
            event.consume();
        }
    }
    
    @FXML
    private void OnMouseClickedPrixProduit(javafx.scene.input.MouseEvent event) {
        lbalerteProduit.setText(" Price Must Be A Number !");
        
    }
    
    @FXML
    private void OnMouseClickedDescreptionProduit(javafx.scene.input.MouseEvent event) {
        lbalerteProduit.setText(" Do not exceed 25 characters, including spaces and punctuation!");
    }

    @FXML
    private void OnKeyTypedDescreption(KeyEvent event) {
        String s = tfDescreProduit.getText();
        //(s.length()<20)&&
        if (s.length() > 24) {
            event.consume();
        }
        
    }

    @FXML
    private void OnMouseClickedNomProduit(javafx.scene.input.MouseEvent event) {
        lbalerteProduit.setText(" Product Name Must Be UPCASE and CONCAT!");
    }
    
    @FXML
    private void OnKeyTypedNomProduit(KeyEvent event) {  
        String s = event.getCharacter();
        char c = s.charAt(0);
        if (!Character.isUpperCase(c)) {
            event.consume();
        }
    }
    
       @FXML
    private void OnMouseClickedCategProduit(javafx.scene.input.MouseEvent event) {
        lbalerteProduit.setText("");
    }
    
        @FXML
    private void OnMouseClickedImageProduit(javafx.scene.input.MouseEvent event) {
        lbalerteProduit.setText("");
       
    }
    
    @FXML
    private void onclickchoosefileProduit(ActionEvent event) {
        Stage stage = null;
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("D:\\others"));
        fc.getExtensionFilters().addAll(new ExtensionFilter("PNG Files", "*.png"));
        File file = fc.showOpenDialog(null);
        if (file != null) {
            tfImageProduit.setText(file.getAbsolutePath());
        } else {
            System.out.println("file not valid ");
        }
    }
    Connection cnxx;
    
    public FXMLProduitController() {
        cnxx = MyConnection.getInstance().getCnx();
    }
    
    public void afficherProduitTv() {
        ProduitCRUD ps = new ProduitCRUD();
        List<Produit> list = ps.afficherProduit();
        colIdProduit.setCellValueFactory(new PropertyValueFactory<>("IdProduit"));
        colNameProduit.setCellValueFactory(new PropertyValueFactory<>("NomProduit"));
        colCategProduit.setCellValueFactory(new PropertyValueFactory<>("CategProduit"));
        colPriceProduit.setCellValueFactory(new PropertyValueFactory<>("PrixProduit"));
        colIsAvailable.setCellValueFactory(new PropertyValueFactory<>("IsAvailable"));
        colImageProduit.setCellValueFactory(new PropertyValueFactory<>("ImageProduit"));
        // colImageProduit.setCellValueFactory(new PropertyValueFactory<>(new ImageView ("ImageProduit")));
        //colImageProduit.setCellValueFactory(new PropertyValueFactory<Produit,ImageView >("ImageProduit"));
        //ImageView photo =new ImageView(new Image(this.getClass().getResourceAsStream("D:\others\affiche.png")) {});
        //new ImageView("ImageProduit"); 
        //ImageView image_view = new ImageView("ImageProduit");       
        colStockProduit.setCellValueFactory(new PropertyValueFactory<>("StockProduit"));
        colDescreptionProduit.setCellValueFactory(new PropertyValueFactory<>("DescrProduit"));
        tvProduit.setItems((ObservableList<Produit>) list);
    }
    
    public void afficherChiffreAffaire() {
        ProduitCRUD ps = new ProduitCRUD();
        float ca = ps.calculerChiffreAffaire();
        labelca.setText(String.valueOf(ca));

    }
    
    public void afficherProduitTrierNomTv() {
        ProduitCRUD ps = new ProduitCRUD();
        List<Produit> list = ps.afficherProduitTrier1();
        colIdProduit.setCellValueFactory(new PropertyValueFactory<>("IdProduit"));
        colNameProduit.setCellValueFactory(new PropertyValueFactory<>("NomProduit"));
        colCategProduit.setCellValueFactory(new PropertyValueFactory<>("CategProduit"));
        colPriceProduit.setCellValueFactory(new PropertyValueFactory<>("PrixProduit"));
        colIsAvailable.setCellValueFactory(new PropertyValueFactory<>("IsAvailable"));
        colImageProduit.setCellValueFactory(new PropertyValueFactory<>("ImageProduit"));
        colStockProduit.setCellValueFactory(new PropertyValueFactory<>("StockProduit"));
        colDescreptionProduit.setCellValueFactory(new PropertyValueFactory<>("DescrProduit"));
        tvProduit.setItems((ObservableList<Produit>) list);
    }
    
    public void afficherProduitTrierPrixTv() {
        ProduitCRUD ps = new ProduitCRUD();
        List<Produit> list = ps.afficherProduitTrierPrix();
        colIdProduit.setCellValueFactory(new PropertyValueFactory<>("IdProduit"));
        colNameProduit.setCellValueFactory(new PropertyValueFactory<>("NomProduit"));
        colCategProduit.setCellValueFactory(new PropertyValueFactory<>("CategProduit"));
        colPriceProduit.setCellValueFactory(new PropertyValueFactory<>("PrixProduit"));
        colIsAvailable.setCellValueFactory(new PropertyValueFactory<>("IsAvailable"));
        colImageProduit.setCellValueFactory(new PropertyValueFactory<>("ImageProduit"));
        colStockProduit.setCellValueFactory(new PropertyValueFactory<>("StockProduit"));
        colDescreptionProduit.setCellValueFactory(new PropertyValueFactory<>("DescrProduit"));
        tvProduit.setItems((ObservableList<Produit>) list);
    }

    @FXML
    private void onclickedgeneratepdfProduit(javafx.scene.input.MouseEvent event) throws com.lowagie.text.DocumentException {
        String path="";
        JFileChooser j =new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x=j.showSaveDialog(j);
        if(x==JFileChooser.APPROVE_OPTION)
        {
        path = j.getSelectedFile().getPath();
        } 
        
        com.lowagie.text.Document doc = new com.lowagie.text.Document();
         try{
         PdfWriter.getInstance(doc, new FileOutputStream(path+".pdf"));
         doc.open();
        
         PdfPTable tbl= new PdfPTable(7);
        
         tbl.addCell("ID Product");
         tbl.addCell("Product Name");
         tbl.addCell("Product Category");
         tbl.addCell("Product Price");
         tbl.addCell("Product Availability");
         tbl.addCell("Product Stock");
         tbl.addCell("Product Descreption");
         for(int i=0 ; i < tvProduit.getItems().size() ;i++ )
         {
         Produit p =tvProduit.getItems().get(i);
         String  idProduit  =String.valueOf( p.getIdProduit());
         String  nameProduit  =String.valueOf( p.getNomProduit());
         String  CategoryProduit  =String.valueOf( p.getCategProduit());
         String  PriceProduit  =String.valueOf( p.getPrixProduit());
         String  AvailabilityProduit  =String.valueOf( p.getIsAvailable());
         String  StockProduit  =String.valueOf( p.getStockProduit());
         String  DescreptionProduit  =String.valueOf( p.getDescrProduit());
        
         tbl.addCell(idProduit);
         tbl.addCell(nameProduit);
         tbl.addCell(CategoryProduit);
         tbl.addCell(PriceProduit);
         tbl.addCell(AvailabilityProduit);
         tbl.addCell(StockProduit );
         tbl.addCell(DescreptionProduit);
         
        
         }
         
          doc.add(tbl);
         }catch(FileNotFoundException ex){Logger.getLogger(ProduitMain.class.getName()).log(Level.SEVERE,null,ex);
         }


        doc.close();
        
    }



 
}
