/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.entities;

/**
 *
 * @author user
 */
public class Commentaire {

    public void setNote(int note) {
        this.note = note;
    }

    private int IDCommentaire;
    private int IDPublication;
    private int IDUser;
    private String Commentaire;
    private String DateCommentaire;
    private String NomCommentaire;
    private int note;

    public int getNote() {
        return note;
    }

    public Commentaire(int IDPublication, int IDUser, String Commentaire) {
        this.IDPublication = IDPublication;
        this.IDUser = IDUser;
        this.Commentaire = Commentaire;
    }

    
    public void setNomCommentaire(String NomCommentaire) {
        this.NomCommentaire = NomCommentaire;
    }

    public String getNomCommentaire() {
        return NomCommentaire;
    }

    public Commentaire() {
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
   @Override
    public String toString() {
        return "Commentaire {" + "IDCommentaire=" + IDCommentaire + ", IDPublication=" + IDPublication + ", IDUser=" + IDUser + ", Commentaire=" + Commentaire + ", DateCommentaire=" + DateCommentaire + "nom= " + NomCommentaire + " } \n";
    }

    public Commentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

}
