/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.OAKfitness.entities;

/**
 *
 * @author user
 */
public class Reclamation {

    private int IDReclamation;
    private int IDUserReclamation;
    private String DescrReclam;
    private String CategReclam;
    private String DateReclam;
    private String ImageReclam;

    public Reclamation(int IDReclamation, int IDUserReclamation, String DescrReclam, String CategReclam, String DateReclam, String ImageReclam) {
        this.IDReclamation = IDReclamation;
        this.IDUserReclamation = IDUserReclamation;
        this.DescrReclam = DescrReclam;
        this.CategReclam = CategReclam;
        this.DateReclam = DateReclam;
        this.ImageReclam = ImageReclam;
    }

    public Reclamation(int IDUserReclamation, String DescrReclam, String CategReclam, String DateReclam, String ImageReclam) {
        this.IDUserReclamation = IDUserReclamation;
        this.DescrReclam = DescrReclam;
        this.CategReclam = CategReclam;
        this.DateReclam = DateReclam;
        this.ImageReclam = ImageReclam;
    }

    public int getIDReclamation() {
        return IDReclamation;
    }

    public int getIDUserReclamation() {
        return IDUserReclamation;
    }

    public String getDescrReclam() {
        return DescrReclam;
    }

    public String getCategReclam() {
        return CategReclam;
    }

    public String getDateReclam() {
        return DateReclam;
    }

    public String getImageReclam() {
        return ImageReclam;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "IDReclamation=" + IDReclamation + ", IDUserReclamation=" + IDUserReclamation + ", DescrReclam=" + DescrReclam + ", CategReclam=" + CategReclam + ", DateReclam=" + DateReclam + ", ImageReclam=" + ImageReclam + '}';
    }

    public void setIDReclamation(int IDReclamation) {
        this.IDReclamation = IDReclamation;
    }

    public void setIDUserReclamation(int IDUserReclamation) {
        this.IDUserReclamation = IDUserReclamation;
    }

    public void setDescrReclam(String DescrReclam) {
        this.DescrReclam = DescrReclam;
    }

    public void setCategReclam(String CategReclam) {
        this.CategReclam = CategReclam;
    }

    public void setDateReclam(String DateReclam) {
        this.DateReclam = DateReclam;
    }

    public void setImageReclam(String ImageReclam) {
        this.ImageReclam = ImageReclam;
    }

}
