/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author kriaa
 */
public class FXMLProduitGraphController implements Initializable {

    @FXML
    private BarChart<?, ?> barchart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
            Statement stmt = cnxx.createStatement();
            String sql ="SELECT NomProduit,PrixProduit from produit";
            ResultSet rst = stmt.executeQuery(sql);
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Float> prices = new ArrayList<Float>();
        while(rst.next()){
        names.add(rst.getString(1));
        prices.add(rst.getFloat(2)); 
        }
        rst.close();

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Product Table"); 
        for(int i=0 ; i<names.size(); i++)
        {
        dataSeries1.getData().add(new XYChart.Data(names.get(i),prices.get(i)) );
        }
        barchart.getData().add(dataSeries1);
       /* VBox vbox = new VBox(barchart);
        Scene scene  = new Scene(vbox, 400 , 200);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(450);*/
        } catch (SQLException ex) {
            Logger.getLogger(FXMLProduitGraphController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
        Connection cnxx;

    public FXMLProduitGraphController() {
        cnxx = MyConnection.getInstance().getCnx();
    }
}
