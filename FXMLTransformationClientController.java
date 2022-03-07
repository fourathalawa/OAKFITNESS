/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import com.sun.istack.internal.logging.Logger;
import entities.Transformation;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.TransformationCRUD;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.logging.Level;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import sun.util.logging.PlatformLogger;

/**
 * FXML Controller class
 *
 * @author kriaa
 */
public class FXMLTransformationClientController implements Initializable {

    @FXML
    private TextField tfTransClId;
    @FXML
    private TextField tfTransClTitre;
    @FXML
    private TextField tfTransClDescreption;
    @FXML
    private TextField tfTransClImageAv;
    @FXML
    private TextField tfTransClImageAp;
    @FXML
    private TextField tfTransClPoidAp;
    @FXML
    private TextField tfTransClTailleAv;
    @FXML
    private TextField tfTransClIdUser;

    @FXML
    private Button btnInsertTrans;
    @FXML
    private Button btndeleteTrans;
    @FXML
    private Button btnupdateTrans;
    @FXML
    private TextField tfTransClPoidav;
    @FXML
    private TextField tfTransClTailleAp;
    @FXML
    private TextField tfApvoideTrans;
    @FXML
    private TableColumn<Transformation, Integer> colidtrans;
    @FXML
    private TableColumn<Transformation, String> coltitretrans;
    @FXML
    private TableColumn<Transformation, String> coldescreptrans;
    @FXML
    private TableColumn<Transformation, String> colimagebeftrans;
    @FXML
    private TableColumn<Transformation, String> colimageaftrans;
    @FXML
    private TableColumn<Transformation, Float> colpoidbeftrans;
    @FXML
    private TableColumn<Transformation, Float> colpoidaftrans;
    @FXML
    private TableColumn<Transformation, Float> coltaillebeftran;
    @FXML
    private TableColumn<Transformation, Float> coltailleaftran;
    @FXML
    private TableColumn<Transformation, Integer> colliketran;
    @FXML
    private TableView<Transformation> tvtrans;
    @FXML
    private TableColumn<Transformation, Integer> colIdUsertran;

    @FXML
    private Button voteupbutton;
    @FXML
    private Button voteDownbutton;
    @FXML
    private Label showlikesTrans;
    @FXML
    private Button imgTrans1;
    @FXML
    private Button imgtrans2;
    @FXML
    private ImageView imageav;
    @FXML
    private ImageView imageap;
    @FXML
    private Label imcTav;
    @FXML
    private Label imcTap;
    @FXML
    private Text alertr;
    @FXML
    private ImageView ronnieimage;
    @FXML
    private ImageView imagecapTrans;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        afficherTransclTv();
        /* le templ de l'integration */

        tfTransClIdUser.setText("0");
        tfTransClIdUser.setDisable(true);
        /* le templ de l'integration */
        voteDownbutton.setDisable(true);
        voteupbutton.setDisable(true);
        showlikesTrans.setText("");
        alertr.setText("");

        javafx.scene.image.Image p = new javafx.scene.image.Image("file:C:\\Users\\kriaa\\Desktop\\produit\\ok.png");
        ronnieimage.setImage(p);
    }

    @FXML
    private void selectitemsTranscl(MouseEvent event) {
        voteupbutton.setDisable(false);
        voteDownbutton.setDisable(false);
        TransformationCRUD ps = new TransformationCRUD();
        Transformation p = tvtrans.getSelectionModel().getSelectedItem();
        tfApvoideTrans.setText(String.valueOf(p.getTlikes()));
        showlikesTrans.setText(String.valueOf(p.getTlikes()));
        tfTransClId.setText(String.valueOf(p.getIdImage()));
        tfTransClTitre.setText(p.getTitreImage());
        tfTransClDescreption.setText(p.getDescreptionImage());
        tfTransClImageAv.setText(p.getImageAvant());
        tfTransClImageAp.setText(p.getImageApres());
        tfTransClPoidav.setText(String.valueOf(p.getPoidAvant()));
        tfTransClPoidAp.setText(String.valueOf(p.getPoidApres()));
        tfTransClTailleAv.setText(String.valueOf(p.getTailleAvant()));
        tfTransClTailleAp.setText(String.valueOf(p.getTailleApres()));

        javafx.scene.image.Image test = new javafx.scene.image.Image("file:" + tfTransClImageAv.getText());
        imageav.setImage(test);
        javafx.scene.image.Image test2 = new javafx.scene.image.Image("file:" + tfTransClImageAp.getText());
        imageap.setImage(test2);

        imcTav.setText(String.valueOf(ps.calculerAvantIMC(p.getIdImage())));
        imcTap.setText(String.valueOf(ps.calculerApresIMC(p.getIdImage())));

    }

    @FXML
    private void InsertTrans(MouseEvent event) {
        String Titre = tfTransClTitre.getText();

        String Descrep = tfTransClDescreption.getText();

        String imga = tfTransClImageAv.getText();

        String imgap = tfTransClImageAp.getText();

        String poidap = tfTransClPoidAp.getText();
        String poidav = tfTransClPoidav.getText();
        String taillea = tfTransClTailleAv.getText();
        String tailleap = tfTransClTailleAp.getText();
        String IdUser = tfTransClIdUser.getText();
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Insert ", "Insert", JOptionPane.YES_NO_OPTION);
        if (Titre.isEmpty() || Descrep.isEmpty() || imga.isEmpty() || imgap.isEmpty() || poidap.isEmpty() || poidav.isEmpty() || taillea.isEmpty() || tailleap.isEmpty() || IdUser.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
            if (opt == 0) {
                String TitreTrans = tfTransClTitre.getText();
                String Desc = tfTransClDescreption.getText();
                String ImageavTrans = tfTransClImageAv.getText();
                String ImageapTrans = tfTransClImageAp.getText();
                float PoidAvTrans = Float.parseFloat(tfTransClPoidav.getText());
                float PoidApTrans = Float.parseFloat(tfTransClPoidAp.getText());
                float TailleAvTrans = Float.parseFloat(tfTransClTailleAv.getText());
                float TailleApTrans = Float.parseFloat(tfTransClTailleAp.getText());
                int IdUserTrans = Integer.parseInt(tfTransClIdUser.getText());
                //int likes = Integer.parseInt(tfApvoideTrans.getText());
                Transformation p = new Transformation(TitreTrans, Desc, ImageavTrans, ImageapTrans, PoidAvTrans, PoidApTrans, TailleAvTrans, TailleApTrans, IdUserTrans);
                TransformationCRUD ps = new TransformationCRUD();
                ps.ajouterTransformation(p);
                afficherTransclTv();
            }
        }
    }

    @FXML
    private void deleteTrans(MouseEvent event) {
 String id = tfTransClId.getText();
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Delete ", "Delete", JOptionPane.YES_NO_OPTION);
        if (id.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
        if (opt == 0) {
            int IdTrans = Integer.parseInt(tfTransClId.getText());
            TransformationCRUD ps = new TransformationCRUD();
            ps.supprimerTransformation(IdTrans);
            afficherTransclTv();

        }}
    }

    @FXML
    private void updateTrans(MouseEvent event) {
        String Titre = tfTransClTitre.getText();

        String Descrep = tfTransClDescreption.getText();

        String imga = tfTransClImageAv.getText();

        String imgap = tfTransClImageAp.getText();
        String id = tfTransClId.getText();
        String poidap = tfTransClPoidAp.getText();
        String poidav = tfTransClPoidav.getText();
        String taillea = tfTransClTailleAv.getText();
        String tailleap = tfTransClTailleAp.getText();
        String IdUser = tfTransClIdUser.getText();
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to Update ", "Update", JOptionPane.YES_NO_OPTION);
        if (Titre.isEmpty() || Descrep.isEmpty() || imga.isEmpty() || imgap.isEmpty() || poidap.isEmpty() || poidav.isEmpty() || taillea.isEmpty() || tailleap.isEmpty() || IdUser.isEmpty() || id.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
            if (opt == 0) {
                int IdTransformation = Integer.parseInt(tfTransClId.getText());
                String TitreTrans = tfTransClTitre.getText();
                String Desc = tfTransClDescreption.getText();
                String ImageavTrans = tfTransClImageAv.getText();
                String ImageapTrans = tfTransClImageAp.getText();
                float PoidAvTrans = Float.parseFloat(tfTransClTailleAv.getText());
                float PoidApTrans = Float.parseFloat(tfTransClPoidAp.getText());
                float TailleAvTrans = Float.parseFloat(tfTransClTailleAv.getText());
                float TailleApTrans = Float.parseFloat(tfTransClTailleAp.getText());
                int IdUserTrans = Integer.parseInt(tfTransClIdUser.getText());
                int likes = Integer.parseInt(tfApvoideTrans.getText());
                Transformation p = new Transformation(TitreTrans, Desc, ImageavTrans, ImageapTrans, PoidAvTrans, PoidApTrans, TailleAvTrans, TailleApTrans, IdUserTrans);
                TransformationCRUD ps = new TransformationCRUD();
                ps.modifierTransformation(p, IdTransformation);
                afficherTransclTv();

            }
        }
    }

    public void afficherTransclTv() {
        TransformationCRUD ps = new TransformationCRUD();
        List<Transformation> list = ps.afficherTransformation();
        colidtrans.setCellValueFactory(new PropertyValueFactory<>("IdImage"));
        coltitretrans.setCellValueFactory(new PropertyValueFactory<>("TitreImage"));
        coldescreptrans.setCellValueFactory(new PropertyValueFactory<>("DescreptionImage"));
        colimagebeftrans.setCellValueFactory(new PropertyValueFactory<>("ImageAvant"));
        colimageaftrans.setCellValueFactory(new PropertyValueFactory<>("ImageApres"));
        colpoidbeftrans.setCellValueFactory(new PropertyValueFactory<>("PoidAvant"));
        colpoidaftrans.setCellValueFactory(new PropertyValueFactory<>("PoidApres"));
        coltaillebeftran.setCellValueFactory(new PropertyValueFactory<>("TailleAvant"));
        coltailleaftran.setCellValueFactory(new PropertyValueFactory<>("TailleApres"));
        colIdUsertran.setCellValueFactory(new PropertyValueFactory<>("IdUser"));
        colliketran.setCellValueFactory(new PropertyValueFactory<>("Tlike"));
        colliketran.setVisible(false);

        tvtrans.setItems((ObservableList<Transformation>) list);
    }

    @FXML
    private void vidertransformationClient(MouseEvent event) {
        tfTransClId.setText("");
        tfTransClTitre.setText("");
        tfTransClDescreption.setText("");
        tfTransClImageAv.setText("");
        tfTransClImageAp.setText("");
        tfTransClPoidav.setText("");
        tfTransClPoidAp.setText("");
        tfTransClTailleAv.setText("");
        tfTransClTailleAp.setText("");
        tfTransClIdUser.setText("");
        showlikesTrans.setText("");
        tfApvoideTrans.setText("0");
        alertr.setText("");
        // lbalerteProduit.setText("");
    }

    @FXML
    private void votetrans(MouseEvent event) {
        voteupbutton.setDisable(true);
        voteDownbutton.setDisable(false);
        TransformationCRUD ps = new TransformationCRUD();
        ps.LikeTransformation(Integer.parseInt(tfTransClId.getText()));
        int n = Integer.parseInt(showlikesTrans.getText()) + 1;
        showlikesTrans.setText("" + n);
        tfApvoideTrans.setText("" + n);

    }

    @FXML
    private void voteDowntrans(MouseEvent event) {
        voteDownbutton.setDisable(true);
        voteupbutton.setDisable(false);
        TransformationCRUD ps = new TransformationCRUD();
        ps.unLikeTransformation(Integer.parseInt(tfTransClId.getText()));
        int n = Integer.parseInt(showlikesTrans.getText()) - 1;
        showlikesTrans.setText("" + n);
        tfApvoideTrans.setText("" + n);

    }

    @FXML
    private void imgTrans1filechooser(MouseEvent event) {
        Stage stage = null;
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("D:\\others"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        File file = fc.showOpenDialog(null);
        if (file != null) {
            tfTransClImageAv.setText(file.getAbsolutePath());
        } else {
            System.out.println("file not valid ");
        }
    }

    @FXML
    private void imgTrans2filechooser(MouseEvent event) {

        Stage stage = null;
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("D:\\others"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
        File file = fc.showOpenDialog(null);
        if (file != null) {
            tfTransClImageAp.setText(file.getAbsolutePath());
        } else {
            System.out.println("file not valid ");
        }
    }

    @FXML
    private void alerteTitreTrans(MouseEvent event) {
        alertr.setText("Title must be UPCASE !");
    }

    @FXML
    private void alerteDescTrans(MouseEvent event) {
        alertr.setText(" Must be less then 25 letters");
    }

    @FXML
    private void alerteimagebefore(MouseEvent event) {
        alertr.setText("must exist ");
    }

    @FXML
    private void alertepoidav(MouseEvent event) {
        alertr.setText("must be Number (KG)");
    }

    @FXML
    private void alertepoidapres(MouseEvent event) {
        alertr.setText("must be Number (KG)");
    }

    @FXML
    private void alertetailleav(MouseEvent event) {
        alertr.setText("must be Number (m)");
    }

    @FXML
    private void alertetailleapres(MouseEvent event) {
        alertr.setText("must be Number (m)");
    }

    @FXML
    private void alerteimageafter(MouseEvent event) {
        alertr.setText("must exist ");
    }

    @FXML
    private void OnkeypressedImagebef(KeyEvent event) {

    }

    @FXML
    private void OnkeypressedImageAf(KeyEvent event) {
    }

    @FXML
    private void TitreTransCS(KeyEvent event) {
        String s = event.getCharacter();
        char c = s.charAt(0);
        if (!Character.isUpperCase(c)) {
            event.consume();
        }
    }

    @FXML
    private void DescreptionTransCS(KeyEvent event) {
        String s = tfTransClDescreption.getText();
        //(s.length()<20)&&
        if (s.length() > 24) {
            event.consume();
        }
    }

    @FXML
    private void poidavTransCS(KeyEvent event) {
        String s = event.getCharacter();
        char c = s.charAt(0);
        //!Character.isDigit(c)||
        if ((c != '.') && (!Character.isDigit(c))) {
            event.consume();
        }
    }

    @FXML
    private void poidapTransCS(KeyEvent event) {
        String s = event.getCharacter();
        char c = s.charAt(0);
        //!Character.isDigit(c)||
        if ((c != '.') && (!Character.isDigit(c))) {
            event.consume();
        }
    }

    @FXML
    private void tailleavCS(KeyEvent event) {
        String s = event.getCharacter();
        char c = s.charAt(0);
        //!Character.isDigit(c)||
        if ((c != '.') && (!Character.isDigit(c))) {
            event.consume();
        }
    }

    @FXML
    private void tailleapCS(KeyEvent event) {
        String s = event.getCharacter();
        char c = s.charAt(0);
        //!Character.isDigit(c)||
        if ((c != '.') && (!Character.isDigit(c))) {
            event.consume();
        }
    }

    @FXML
    private void screenshottrans(MouseEvent event){
        try{
      /*      String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(j);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }*/
        Robot robot = new Robot();
        Rectangle rectangle = new Rectangle(0,0,2000,1000);
        BufferedImage image = robot.createScreenCapture(rectangle);
        Image nyImage = SwingFXUtils.toFXImage(image, null);  
        ImageIO.write(image, "jpg", new File("capture.jpg"));
        //imagecapTrans.setImage(nyImage);
        Desktop.getDesktop().open(new File("capture.jpg"));
        }
        catch(Exception ex){
           // Logger.getLogger(FXMLTransformationClientController.class.getName()).log(Level.SEVERE ,null ,ex);
        
        }
    }

}
