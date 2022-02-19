/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.entities;

/**
 *
 * @author Heni Nechi
 */
public class Exercice {

    private int IDExercice;
    private String TypeExercice;
    private String NomExercice;
    private String DescrExercice;
    private String DiffExercice;
    private String JusteSalleExercice;
    private String DureeExercice;

    public Exercice() {

    }

    public Exercice(int IDExercice, String TypeExercice, String NomExercice, String DescrExercice, String DiffExercice, String JusteSalleExercice, String DureeExercice) {
        this.IDExercice = IDExercice;
        this.TypeExercice = TypeExercice;
        this.NomExercice = NomExercice;
        this.DescrExercice = DescrExercice;
        this.DiffExercice = DiffExercice;
        this.JusteSalleExercice = JusteSalleExercice;
        this.DureeExercice = DureeExercice;
    }

    public Exercice(String TypeExercice, String NomExercice, String DescrExercice, String DiffExercice, String JusteSalleExercice, String DureeExercice) {
        this.TypeExercice = TypeExercice;
        this.NomExercice = NomExercice;
        this.DescrExercice = DescrExercice;
        this.DiffExercice = DiffExercice;
        this.JusteSalleExercice = JusteSalleExercice;
        this.DureeExercice = DureeExercice;
    }

    public int getIDExercice() {
        return IDExercice;
    }

    public void setIDExercice(int IDExercice) {
        this.IDExercice = IDExercice;
    }

    public String getTypeExercice() {
        return TypeExercice;
    }

    public void setTypeExercice(String TypeExercice) {
        this.TypeExercice = TypeExercice;
    }

    public String getNomExercice() {
        return NomExercice;
    }

    public void setNomExercice(String NomExercice) {
        this.NomExercice = NomExercice;
    }

    public String getDescrExercice() {
        return DescrExercice;
    }

    public void setDescrExercice(String DescrExercice) {
        this.DescrExercice = DescrExercice;
    }

    public String getDiffExercice() {
        return DiffExercice;
    }

    public void setDiffExercice(String DiffExercice) {
        this.DiffExercice = DiffExercice;
    }

    public String getJusteSalleExercice() {
        return JusteSalleExercice;
    }

    public void setJusteSalleExercice(String JusteSalleExercice) {
        this.JusteSalleExercice = JusteSalleExercice;
    }

    public String getDureeExercice() {
        return DureeExercice;
    }

    public void setDureeExercice(String DureeExercice) {
        this.DureeExercice = DureeExercice;
    }

    @Override
    public String toString() {
        return "Exercice{" + "IDExercice=" + IDExercice + ", TypeExercice=" + TypeExercice + ", NomExercice=" + NomExercice + ", DescrExercice=" + DescrExercice + ", DiffExercice=" + DiffExercice + ", JusteSalleExercice=" + JusteSalleExercice + ", DureeExercice=" + DureeExercice + '}';
    }

}
