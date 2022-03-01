/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.entities;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;

/**
 *
 * @author user
 */
public class Publication {

    private int IDpublication;
    private String SIDpublication;
    private int IDuser;
    private String ImagePublication;
    private String DatePublication;
    private String Publication;
    private String NomPublication;
    private Button button;

    public Publication(int IDuser, String Publication) {
        this.IDuser = IDuser;
        this.Publication = Publication;
    }

//    public Publication(int IDpublication, int IDuser, String ImagePublication, String DatePublication, String Publication, String NomPublication) {
//        this.IDpublication = IDpublication;
//        this.IDuser = IDuser;
//        this.ImagePublication = ImagePublication;
//        this.DatePublication = DatePublication;
//        this.Publication = Publication;
//        this.NomPublication = NomPublication;
//       // this.button = new Button("view"); 
//    }

    public String getSIDpublication() {
        return SIDpublication;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Button getButton() {
        return button;
    }

    public void setNomPublication(String NomPublication) {
        this.NomPublication = NomPublication;
    }

    public String getNomPublication() {
        return NomPublication;
    }
    public List<Commentaire> comm = new ArrayList(); 


    public Publication(int IDuser, String ImagePublication, String DatePublication, String Publication) {
        this.IDuser = IDuser;
        this.ImagePublication = ImagePublication;
        this.DatePublication = DatePublication;
        this.Publication = Publication;
    }

    public Publication() {
    }

    public void setIDpublication(int IDpublication) {
        this.IDpublication = IDpublication;
    }

    public Publication(String ImagePublication, String Publication) {
        this.ImagePublication = ImagePublication;
        this.Publication = Publication;
    }

    public void setIDuser(int IDuser) {
        this.IDuser = IDuser;
    }

    public void setSIDpublication(String SIDpublication) {
        this.SIDpublication = SIDpublication;
    }

    public void setImagePublication(String ImagePublication) {
        this.ImagePublication = ImagePublication;
    }

    public void setDatePublication(String DatePublication) {
        this.DatePublication = DatePublication;
    }

    public void setPublication(String Publication) {
        this.Publication = Publication;
    }

    public int getIDpublication() {
        return IDpublication;
    }
  public String getIDpublicationString() {
        String s =  String.valueOf(IDpublication);
        return s;
    }
  

    public int getIDuser() {
        return IDuser;
    }

    public String getImagePublication() {
        return ImagePublication;
    }

    public String getDatePublication() {
        return DatePublication;
    }

    public String getPublication() {
        return Publication;
    }

    public Publication(int IDpublication, int IDuser, String ImagePublication, String DatePublication, String Publication) {
        this.IDpublication = IDpublication;
        this.IDuser = IDuser;
        this.ImagePublication = ImagePublication;
        this.DatePublication = DatePublication;
        this.Publication = Publication;

    }
  @Override
    public String toString() {
        return "Publication {" + "IDpublication=" + IDpublication + ", IDuser=" + IDuser + ", ImagePublication=" + ImagePublication + ", DatePublication=" + DatePublication + ", Publication=" + Publication+ "}" +"\n"+ comm +"\n";
    }
}

