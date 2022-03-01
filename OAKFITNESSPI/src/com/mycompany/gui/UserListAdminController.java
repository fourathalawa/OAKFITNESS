/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.entities.User;
import com.mycompany.services.UserCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author User
 */
public class UserListAdminController implements Initializable {

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
    private TableColumn<User,String> idEmail;
    @FXML
    private TableColumn<User,String> idPhone;
    @FXML
    private TableView<User> idTableCoach;
    @FXML
    private TableColumn<User,String> idNameC;
    @FXML
    private TableColumn<User,String> idPrenomC;
    @FXML
    private TableColumn<User,String> idEmailC;
    @FXML
    private TableColumn<User,String>idDateNaissanceC;
    @FXML
    private TableColumn<User,String> idPhoneC;
    @FXML
    private TableColumn<User,String> idExperienceC;
    @FXML
    private TableColumn<User,String>idDiplomeC;
    @FXML
    private TableView<User> idTableManager;
    @FXML
    private TableColumn<User,String> idNameM;
    @FXML
    private TableColumn<User,String> idPrenomM;
    @FXML
    private TableColumn<User,String>idMailM;
    @FXML
    private TableColumn<User,String> idNaissanceM;
    @FXML
    private TableColumn<User,String> idPhoneM;
    @FXML
    private TableColumn<User,String> idTaxM;
    @FXML
    private TableView<User> idTableAdmin;
    @FXML
    private TableColumn<User,String> idNameA;
    @FXML
    private TableColumn<User,String> idPrenomA;
    @FXML
    private TableColumn<User,String> idMailA;
    @FXML
    private TableColumn<User,String> idNaissanceA;
    @FXML
    private TableColumn<User,String> idPhoneA;
    @FXML
    private TableColumn<User,String> idPrenom;
    @FXML
    private TableColumn<User,String> idDateNaissance;
    @FXML
    private TableColumn<User,String> idNom;
    @FXML
    private Button idAddAdmin;
    @FXML
    private TextField idId;
    @FXML
    private Button idDelete;
    @FXML
    private Button idlog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadDataAdmin();
       loadDataMember();
       loadDataCoach();
       loadDataManager();
       
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
   
private void loadDataAdmin()
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

    @FXML
    private void AddAdmin(ActionEvent event) {
        
           FXMLLoader loader= new FXMLLoader(getClass().getResource("AddAdmin.fxml"));
            try {
            Parent root = loader.load();
            AddAdminController aad = loader.getController();
            idAddAdmin.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Delete(MouseEvent event) {
        UserCRUD user = new UserCRUD();
        ObservableList<User> locataire =  idTableMember.getSelectionModel().getSelectedItems();
        String mail = locataire.get(0).getMail();
        int id = user.retourneId(mail);
        System.out.println(id);
        String i = String.valueOf(id);
       idId.setText(i);
    }

    @FXML
    private void DeleteUser(ActionEvent event) {
         UserCRUD user = new UserCRUD();
      int   id=Integer.parseInt(idId.getText());
      user.supprimerUser(id);
      loadDataMember();
      loadDataCoach();
      loadDataAdmin();
      loadDataManager();
    }

    @FXML
    private void DeleteCoach(MouseEvent event) {
         UserCRUD user = new UserCRUD();
        ObservableList<User> locataire =  idTableCoach.getSelectionModel().getSelectedItems();
        String mail = locataire.get(0).getMail();
        int id = user.retourneId(mail);
        System.out.println(id);
        String i = String.valueOf(id);
       idId.setText(i);
    }

    @FXML
    private void DeleteManager(MouseEvent event) {
         UserCRUD user = new UserCRUD();
        ObservableList<User> locataire =  idTableManager.getSelectionModel().getSelectedItems();
        String mail = locataire.get(0).getMail();
        int id = user.retourneId(mail);
        System.out.println(id);
        String i = String.valueOf(id);
       idId.setText(i);
    }

    @FXML
    private void DeleteAdmin(MouseEvent event) {
         UserCRUD user = new UserCRUD();
        ObservableList<User> locataire =  idTableAdmin.getSelectionModel().getSelectedItems();
        String mail = locataire.get(0).getMail();
        int id = user.retourneId(mail);
        System.out.println(id);
        String i = String.valueOf(id);
       idId.setText(i);
    }

    @FXML
    private void logout(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("SignIn.fxml"));
            try {
            Parent root = loader.load();
            SignInController aad = loader.getController();
            idlog.getScene().setRoot(root);
           
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
