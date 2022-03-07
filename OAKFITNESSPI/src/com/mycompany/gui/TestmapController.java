/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.teamdev.jxmaps.Marker;
import java.awt.Dialog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.naming.Context;
import org.controlsfx.control.textfield.TextFields;


/**
 * FXML Controller class
 *
 * @author ghassen
 */
public class TestmapController implements Initializable {

    @FXML
    private WebView webview;
    @FXML
    private TextField dep;
    
    private Double lng[]={
        10.18,
10.76,
10.6333,
10.1,
10.0,
8.965,
9.8739,
9.4858,
10.0983,
10.1956,
8.7803,
8.7833,
10.5833,
10.5053,
8.8333,
9.1817,
10.8262,
10.3253,
10.45,
10.2189,
10.1406,
10.3167,
11.0622,
10.7361,
8.7,
10.1,
10.2833,
10.3275,
10.5939,
10.3083,
8.1336,
10.2332,
10.6274,
9.3747,
10.1433,
10.9,
10.8167,
10.341,
10.6,
10.77,
11.1167,
11.2167,
10.1693,
10.85,
9.7951,
10.76,
10.8667,
10.9833,
8.4397,
9.7833,
11.0939,
10.12,
9.8411,
10.7167,
9.0258,
9.0736,
9.2382,
10.75,
8.7,
10.5712,
8.9698,
10.0708,
9.665,
10.065,
8.8284,
10.0333,
11.115,
8.5625,
9.6056,
10.67,
7.8816,
9.1294,
10.1833,
11.0,
8.755,
10.34,
8.6667,
9.2,
9.9699,
10.528,
10.5,
10.0498,
8.2203,
9.01,
8.5939,
10.3505,
10.7028
};
   private Double lat[]={36.8008,
34.74,
35.8333,
35.6833,
33.96,
33.705,
37.2744,
35.0381,
33.8814,
36.8625,
36.5011,
34.4167,
35.7333,
33.3547,
35.1667,
36.7256,
35.778,
36.8764,
32.9333,
36.7531,
36.8092,
36.8333,
35.5047,
36.4514,
36.1667,
36.8,
36.7667,
36.7308,
35.8589,
36.7439,
33.9197,
36.7687,
35.7887,
36.0819,
36.4028,
35.67,
35.7122,
36.8698,
36.4167,
34.8,
33.5,
33.1389,
36.6987,
33.8667,
33.8864,
35.64,
36.5667,
36.7833,
36.4503,
37.15,
36.8475,
37.215,
36.8295,
35.3,
33.4572,
35.5433,
37.0564,
36.47,
36.7833,
35.8712,
36.6111,
34.3006,
37.04,
33.9397,
35.9424,
37.1667,
35.2372,
34.9431,
34.6042,
35.72,
33.8722,
35.2297,
37.1667,
35.62,
36.955,
33.0592,
35.5667,
35.85,
33.9851,
34.7414,
36.0333,
37.2454,
33.9858,
33.57,
34.9758,
33.6679,
32.011
};
    private String loc[]={"Tunis",
"Sfax",
"Sousse",
"Kairouan",
"Métouia",
"Kebili",
"Bizerte",
"Sidi Bouzid",
"Gabès",
"Ariana",
"Jendouba",
"Gafsa",
"Msaken",
"Medenine",
"Kasserine",
"Béja",
"Monastir",
"La Marsa",
"Tataouine",
"Ben Arous",
"Le Bardo",
"Le Kram",
"Mahdia",
"Nabeul",
"El Kef",
"Manouba",
"Radès",
"Hammam-Lif",
"Hammam Sousse",
"Ez Zahra",
"Tozeur",
"Mégrine",
"Zaouiet Sousse",
"Siliana",
"Zaghouan",
"Seïada",
"Khunays",
"Sidi Bou Saïd",
"Hammamet",
"Sakiet ez Zit",
"Zarzis",
"Ben Gardane",
"Fouchana",
"Houmt Souk",
"El Hamma",
"Djemmal",
"Korba",
"Menzel Temime",
"Ghardimaou",
"Menzel Bourguiba",
"Kélibia",
"Rass el Djebel",
"Tebourba",
"El Jem",
"Douz",
"Sbiba",
"Sejenane",
"Dar Chabanne",
"Aïne Draham",
"Akouda",
"Bou Salem",
"Skhira",
"Mateur",
"Rhennouch",
"Dahmani",
"El Alia",
"Chebba",
"Feriana",
"El Maknassi",
"Ouardenine",
"Nefta",
"Sbeitla",
"Rhar el Melah",
"Bekalta",
"Tabarka",
"Ghomrassen",
"Thala",
"Maktar",
"Wadhraf",
"Agareb",
"Harqalah",
"El Metline",
"Degache",
"Jemna",
"Thelepte",
"Zarat",
"Dehiba"

    };

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TextFields.bindAutoCompletion(dep,loc);
        
        WebEngine webEngine = webview.getEngine();
        File f = new File(getClass().getClassLoader().getResource("Testmap/map3.html").getFile());
        webEngine.load(f.toURI().toString());
   
        // TODO
    }    

    

    /*private void ajout(ActionEvent event) {
        int i=0;
        int k=0;
        for(int j=0;j<loc.length;j++)
        {
            if(dep.getText().equals(loc[j]))
            {
            i=j;
            }
           
        
        }
        
       Double distance=Math.sqrt(Math.pow((lng[i]-lng[k]),2)+Math.pow((lat[i]-lat[k]),2))*111.16;
       double prix=distance*3;
       

    
        
       System.out.println(lat[i]+" "+lng[i]);
        
        WebEngine webEngine =webview.getEngine();
        webEngine.reload();
        webEngine.loadContent(
        "<form method=\"get\" action=\"https://www.google.com/maps\" target=\"mapframe\">"+
        "<input name=\"saddr\" type=\"hidden\" id=\"saddr\" value=\"'"+loc[k]+"'\">"+
        "<input name=\"output\" type=\"hidden\" value=\"embed\">"+
        "<input name=\"f\" type=\"hidden\" value=\"d\">"+
        "<input name=\"z\" type=\"hidden\" value=\"11\">"+
        "<input name=\"daddr\" type=\"hidden\" id=\"daddr\" value=\"'"+loc[i]+"'\">"+
        "<input type=\"submit\" name=\"Submit\" value=\"Submit\">"+
        "</form>"+
        "<iframe"+
        "name=\"mapframe\" width=\"800\" height=\"900\""+ 
        "src=\"https://www.google.com/maps?z=11&amp;f=d&amp;output=embed&amp;ll='"+lat[i]+"','"+lng[i]+"'\">"
        +"</iframe>");
       // System.out.println(webEngine.getLocation());
        //Alert alert = new Alert(Alert.AlertType.NONE, "votre trajet est: "+distance+"\n"+"prix a payer: "+prix, ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        //alert.show();
       // System.out.println(lat.length+" "+loc.length);
    }

  /*  @FXML
    private void retour(ActionEvent event) throws IOException {
         FXMLLoader root= new FXMLLoader(getClass().getResource("AfficherDelivery.fxml"));
         Parent r1=(Parent) root.load();
         Stage s=new Stage();
         s.setScene(new Scene(r1));
         s.show();
         
         //webview.getChildren().setAll(root);
         //webview.getChildrenUnmodifiable().setAll(root);
            
        
    }*/

    @FXML
    private void ajoutLocation(MouseEvent event) {
        System.out.println(lat.length+" "+loc.length);
    }
    
    
}
