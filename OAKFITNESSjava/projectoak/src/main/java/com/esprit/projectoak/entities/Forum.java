/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.entities;

/**
 *
 * @author user
 */
public class Forum {

    private int IDpublication;
    private int IDuser;
    private String ImagePublication;
    private String DatePublication;
    private String Publication;

    private int IDCommentaire;
    private int IDPublication;
    private int IDUser;
    private String Commentaire;
    private String DateCommentaire;

    public Forum(int IDuser, String ImagePublication, String DatePublication, String Publication, int IDCommentaire, int IDPublication, int IDUser, String Commentaire, String DateCommentaire) {
        this.IDuser = IDuser;
        this.ImagePublication = ImagePublication;
        this.DatePublication = DatePublication;
        this.Publication = Publication;
        this.IDCommentaire = IDCommentaire;
        this.IDPublication = IDPublication;
        this.IDUser = IDUser;
        this.Commentaire = Commentaire;
        this.DateCommentaire = DateCommentaire;
    }

    public void setIDpublication(int IDpublication) {
        this.IDpublication = IDpublication;
    }

    public void setIDuser(int IDuser) {
        this.IDuser = IDuser;
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

    public void setIDCommentaire(int IDCommentaire) {
        this.IDCommentaire = IDCommentaire;
    }

    public void setIDPublication(int IDPublication) {
        this.IDPublication = IDPublication;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public void setDateCommentaire(String DateCommentaire) {
        this.DateCommentaire = DateCommentaire;
    }

    public int getIDpublication() {
        return IDpublication;
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

    public int getIDCommentaire() {
        return IDCommentaire;
    }

    public int getIDPublication() {
        return IDPublication;
    }

    public int getIDUser() {
        return IDUser;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public String getDateCommentaire() {
        return DateCommentaire;
    }

    public Forum(int IDpublication, int IDuser, String ImagePublication, String DatePublication, String Publication, int IDPublication, int IDUser, String Commentaire, String DateCommentaire) {
        this.IDpublication = IDpublication;
        this.IDuser = IDuser;
        this.ImagePublication = ImagePublication;
        this.DatePublication = DatePublication;
        this.Publication = Publication;
        this.IDPublication = IDPublication;
        this.IDUser = IDUser;
        this.Commentaire = Commentaire;
        this.DateCommentaire = DateCommentaire;
    }

    public Forum() {
    }
   @Override
    public String toString() {
        return "Publication {" + "IDpublication=" + IDpublication + ", IDuser=" + IDuser + ", ImagePublication=" + ImagePublication + ", DatePublication=" + DatePublication + ", Publication=" + Publication+ "}" + "\n" +
         "Commentaire {" + "IDCommentaire=" + IDCommentaire + ", IDPublication=" + IDPublication + ", IDUser=" + IDUser + ", Commentaire=" + Commentaire + ", DateCommentaire=" + DateCommentaire + "}" + "\n";
    }


}
