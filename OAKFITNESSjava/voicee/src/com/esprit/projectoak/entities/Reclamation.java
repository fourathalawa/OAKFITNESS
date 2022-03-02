/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.entities;

/**
 *
 * @author user
 */
public class Reclamation {

    private int IDReclamation;
    private int IDUserReclamation;
    private int CategReclam;
    private String DescrReclam;
    private String DateReclam;
    private int EtatReclamation;
    private int idCommentReclam;

    public int getIdCommentReclam() {
        return idCommentReclam;
    }

    public void setIdCommentReclam(int idCommentReclam) {
        this.idCommentReclam = idCommentReclam;
    }
    

    public int getEtatReclamation() {
        return EtatReclamation;
    }

    public void setEtatReclamation(int EtatReclamation) {
        this.EtatReclamation = EtatReclamation;
    }
    private String pourcentageReclam; 
    private String CommentaireRec;
    private String PubRec;

    public String getCommentaireRec() {
        return CommentaireRec;
    }

    public String getPubRec() {
        return PubRec;
    }

    public void setCommentaireRec(String CommentaireRec) {
        this.CommentaireRec = CommentaireRec;
    }

    public void setPubRec(String PubRec) {
        this.PubRec = PubRec;
    }

    public Reclamation(int IDUserReclamation, int CategReclam, String DescrReclam, String CommentaireRec, String PubRec ,int idCommentReclam) {
        this.IDUserReclamation = IDUserReclamation;
        this.CategReclam = CategReclam;
        this.DescrReclam = DescrReclam;
        this.CommentaireRec = CommentaireRec;
        this.PubRec = PubRec;
        this.idCommentReclam = idCommentReclam;
    }
    

    public Reclamation( int CategReclam, String DescrReclam) {
        this.CategReclam = CategReclam;
        this.DescrReclam = DescrReclam;
    }


    public String getPourcentageReclam() {
        return pourcentageReclam;
    }

    public Reclamation() {
    }

    public void setIDReclamation(int IDReclamation) {
        this.IDReclamation = IDReclamation;
    }

    public void setPourcentageReclam(String pourcentageReclam) {
        this.pourcentageReclam = pourcentageReclam;
    }

    public void setIDUserReclamation(int IDUserReclamation) {

        this.IDUserReclamation = IDUserReclamation;

    }

    public void setCategReclam(int CategReclam) {

        this.CategReclam = CategReclam;

    }

    public void setDescrReclam(String DescrReclam) {
        this.DescrReclam = DescrReclam;
    }

    public void setDateReclam(String DateReclam) {
        this.DateReclam = DateReclam;
    }

    public int getIDReclamation() {
        return IDReclamation;
    }

    public int getIDUserReclamation() {
        return IDUserReclamation;
    }

    public int getCategReclam() {
        return CategReclam;
    }

    public String getDescrReclam() {
        return DescrReclam;
    }

    public String getDateReclam() {
        return DateReclam;
    }

    @Override
    public String toString() {
        return "Reclamation {" + ", IDUserReclamation=" + IDUserReclamation + ", CategReclam=" + CategReclam + ", DescrReclam=" + DescrReclam + ", DateReclam=" + DateReclam + "}" + "\n";
    }
}
