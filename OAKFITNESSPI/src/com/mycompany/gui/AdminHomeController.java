/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.entities.User;
import com.mycompany.services.UserCRUD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AdminHomeController implements Initializable {

    @FXML
    private Hyperlink idEvents;
    @FXML
    private Hyperlink idNews;
    @FXML
    private Hyperlink idPrograms;
    @FXML
    private Hyperlink idShop;
    @FXML
    private Hyperlink idProduct;
    @FXML
    private Hyperlink idAboutUs;
    @FXML
    private Hyperlink idComplaint;
    @FXML
    private Hyperlink idUsers;
    @FXML
    private TableView<User> idTableMember;
    @FXML
    private TableColumn<User, String> idNom;
    @FXML
    private TableColumn<User, String> idPrenom;
    @FXML
    private TableColumn<User, String> idDateNaissance;
    @FXML
    private TableColumn<User, String> idEmail;
    @FXML
    private TableColumn<User, String> idPhone;
    @FXML
    private TableView<User> idTableCoach;
    @FXML
    private TableColumn<User, String>idNameC;
    @FXML
    private TableColumn<User, String>idPrenomC;
    @FXML
    private TableColumn<User, String>idEmailC;
    @FXML
    private TableColumn<User, String> idDateNaissanceC;
    @FXML
    private TableColumn<User, String>idPhoneC;
    @FXML
    private TableColumn<User, String> idExperienceC;
    @FXML
    private TableColumn<User, String> idDiplomeC;
    @FXML
    private TableView<User> idTableManager;
    @FXML
    private TableColumn<User, String> idNameM;
    @FXML
    private TableColumn<User, String> idPrenomM;
    @FXML
    private TableColumn<User, String> idMailM;
    @FXML
    private TableColumn<User, String> idNaissanceM;
    @FXML
    private TableColumn<User, String> idPhoneM;
    @FXML
    private TableColumn<User, String> idTaxM;
    @FXML
    private TableView<User> idTableAdmin;
    @FXML
    private TableColumn<User, String> idNameA;
    @FXML
    private TableColumn<User, String> idPrenomA;
    @FXML
    private TableColumn<User, String> idMailA;
    @FXML
    private TableColumn<User, String> idNaissanceA;
    @FXML
    private TableColumn<User, String> idPhoneA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        loadDataMember();
        loadDataCoach();
        loadDataManager();
        loadDataAdmiin();
    }    

    @FXML
    private void eventsRedirect(ActionEvent event) {
    }

    @FXML
    private void newsRedirect(ActionEvent event) {
    }

    @FXML
    private void programRedirect(ActionEvent event) {
    }

    @FXML
    private void shopRedirect(ActionEvent event) {
    }

    @FXML
    private void productRedirect(ActionEvent event) {
    }

    @FXML
    private void aboutUsRedirect(ActionEvent event) {
    }

    @FXML
    private void complaintRedirect(ActionEvent event) {
    }

    @FXML
    private void usersRedirect(ActionEvent event) {
    }

    private void loadDataMember()
    {
       
        
      UserCRUD user = new UserCRUD();
      ObservableList <User> list = user.afficherAdhérent();
      //  ObservableList<Reclamation> list = afficherReclamation();
        idNom.setCellValueFactory(new PropertyValueFactory<User,String>("Nom"));
        idPrenom.setCellValueFactory(new PropertyValueFactory<User,String>("Prenom"));
        idEmail.setCellValueFactory(new PropertyValueFactory<User,String>("Mail"));
        idDateNaissance.setCellValueFactory(new PropertyValueFactory<User,String>("Date_Naissance"));
        idPhone.setCellValueFactory(new PropertyValueFactory<User,String>("Telephone_Number"));
        idTableMember.setItems(list);
    }

   private void loadDataCoach()
    {
       
        
      UserCRUD user = new UserCRUD();
      ObservableList <User> list = user.afficherCoach();
      //  ObservableList<Reclamation> list = afficherReclamation();
        idNameC.setCellValueFactory(new PropertyValueFactory<User,String>("Nom"));
        idPrenomC.setCellValueFactory(new PropertyValueFactory<User,String>("Prenom"));
        idEmailC.setCellValueFactory(new PropertyValueFactory<User,String>("Mail"));
        idDateNaissanceC.setCellValueFactory(new PropertyValueFactory<User,String>("Date_Naissance"));
        idPhoneC.setCellValueFactory(new PropertyValueFactory<User,String>("Telephone_Number"));
          idExperienceC.setCellValueFactory(new PropertyValueFactory<User,String>("Experience"));
        idDiplomeC.setCellValueFactory(new PropertyValueFactory<User,String>("Diplome"));
        idTableCoach.setItems(list);
    }

 private void loadDataManager()
    {
       
        
      UserCRUD user = new UserCRUD();
      ObservableList <User> list = user.afficherResponsable();
      //  ObservableList<Reclamation> list = afficherReclamation();
        idNameM.setCellValueFactory(new PropertyValueFactory<User,String>("Nom"));
        idPrenomM.setCellValueFactory(new PropertyValueFactory<User,String>("Prenom"));
        idMailM.setCellValueFactory(new PropertyValueFactory<User,String>("Mail"));
        idNaissanceM.setCellValueFactory(new PropertyValueFactory<User,String>("Date_Naissance"));
        idPhoneM.setCellValueFactory(new PropertyValueFactory<User,String>("Telephone_Number"));
        idTaxM.setCellValueFactory(new PropertyValueFactory<User,String>("Matricule_Fiscale"));
        idTableManager.setItems(list);
    }
   
private void loadDataAdmiin()
    {
       
        
      UserCRUD user = new UserCRUD();
      ObservableList <User> list = user.afficherAdmin();
      //  ObservableList<Reclamation> list = afficherReclamation();
        idNameA.setCellValueFactory(new PropertyValueFactory<User,String>("Nom"));
        idPrenomA.setCellValueFactory(new PropertyValueFactory<User,String>("Prenom"));
        idMailA.setCellValueFactory(new PropertyValueFactory<User,String>("Mail"));
        idNaissanceA.setCellValueFactory(new PropertyValueFactory<User,String>("Date_Naissance"));
        idPhoneA.setCellValueFactory(new PropertyValueFactory<User,String>("Telephone_Number"));

        idTableAdmin.setItems(list);
    }


}
