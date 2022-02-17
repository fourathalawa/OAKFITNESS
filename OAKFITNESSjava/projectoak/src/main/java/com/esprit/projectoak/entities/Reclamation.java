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
    private String pourcentageReclam;

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

    public Reclamation(int IDUserReclamation, int CategReclam, String DescrReclam, String DateReclam) {
        this.IDUserReclamation = IDUserReclamation;
        this.CategReclam = CategReclam;
        this.DescrReclam = DescrReclam;
        this.DateReclam = DateReclam;
    }

    public Reclamation(int IDReclamation, int IDUserReclamation, int CategReclam, String DescrReclam, String DateReclam) {
        this.IDReclamation = IDReclamation;
        this.IDUserReclamation = IDUserReclamation;
        this.CategReclam = CategReclam;
        this.DescrReclam = DescrReclam;
        this.DateReclam = DateReclam;
    }

    @Override
    public String toString() {
        return "Reclamation {" + "IDReclamation=" + IDReclamation + ", IDUserReclamation=" + IDUserReclamation + ", CategReclam=" + CategReclam + ", DescrReclam=" + DescrReclam + ", DateReclam=" + DateReclam + "}" + "\n";
    }
}
