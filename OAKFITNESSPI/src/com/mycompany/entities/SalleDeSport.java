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
    private int IdResponsable;
    private String Adresse;

    public SalleDeSport(int Id, int IdResponsable, String Adresse) {
        this.Id = Id;
        this.IdResponsable = IdResponsable;
        this.Adresse = Adresse;
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
        return "SalleDeSport{" + "Id=" + Id + ", IdResponsable=" + IdResponsable + ", Adresse=" + Adresse + '}';
    }
    
    
}
