/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.oakfitnessjava.entities;

/**
 *
 * @author Heni Nechi
 */
public class Evenement {
    private int IDEvenement;
    private String TitreEvenement;
    private String DescrEvenement;
    private String AdresseEvenement;
    private String TypeEvenement;
    
    public Evenement(){
    }

    public Evenement(int IDEvenement, String TitreEvenement, String DescrEvenement, String AdresseEvenement, String TypeEvenement) {
        this.IDEvenement = IDEvenement;
        this.TitreEvenement = TitreEvenement;
        this.DescrEvenement = DescrEvenement;
        this.AdresseEvenement = AdresseEvenement;
        this.TypeEvenement = TypeEvenement;
    }

    public Evenement(String TitreEvenement, String DescrEvenement, String AdresseEvenement, String TypeEvenement) {
        this.TitreEvenement = TitreEvenement;
        this.DescrEvenement = DescrEvenement;
        this.AdresseEvenement = AdresseEvenement;
        this.TypeEvenement = TypeEvenement;
    }
    

    public int getIDEvenement() {
        return IDEvenement;
    }

    public void setIDEvenement(int IDEvenement) {
        this.IDEvenement = IDEvenement;
    }

    public String getTitreEvenement() {
        return TitreEvenement;
    }

    public void setTitreEvenement(String TitreEvenement) {
        this.TitreEvenement = TitreEvenement;
    }

    public String getDescrEvenement() {
        return DescrEvenement;
    }

    public void setDescrEvenement(String DescrEvenement) {
        this.DescrEvenement = DescrEvenement;
    }

    public String getAdresseEvenement() {
        return AdresseEvenement;
    }

    public void setAdresseEvenement(String AdresseEvenement) {
        this.AdresseEvenement = AdresseEvenement;
    }

    public String getTypeEvenement() {
        return TypeEvenement;
    }

    public void setTypeEvenement(String TypeEvenement) {
        this.TypeEvenement = TypeEvenement;
    }

    @Override
    public String toString() {
        return "Evenement{" + "IDEvenement=" + IDEvenement + ", TitreEvenement=" + TitreEvenement + ", DescrEvenement=" + DescrEvenement + ", AdresseEvenement=" + AdresseEvenement + ", TypeEvenement=" + TypeEvenement + '}';
    }
    
    
}
