/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

/**
 *
 * @author Fourat Halaoua
 */
public class SalleDeSport {
    private int Id;
    private String Nom;
    private int IdResponsable;
    private float PrixSeance;
    private String Adresse;

    public SalleDeSport(int IdResponsable,String nom,float PrixSeance, String Adresse) {
  
        this.Nom= nom;
        this.PrixSeance=PrixSeance;
        this.IdResponsable = IdResponsable;
        this.Adresse = Adresse;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public float getPrixSeance() {
        return PrixSeance;
    }

    public void setPrixSeance(float PrixSeance) {
        this.PrixSeance = PrixSeance;
    }

    public SalleDeSport() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdResponsable() {
        return IdResponsable;
    }

    public void setIdResponsable(int IdResponsable) {
        this.IdResponsable = IdResponsable;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    @Override
    public String toString() {
        return "SalleDeSport{" + "Id=" + Id + ", Nom=" + Nom + ", IdResponsable=" + IdResponsable + ", PrixSeance=" + PrixSeance + ", Adresse=" + Adresse + '}';
    }

    
    
    
}
