/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.entities;

/**
 *
 * @author Heni Nechi
 */
public class ProgrammeSportif {

    private int IDProgrammeSportif;
    private int IDCoach;
    private int IDAdherent;
    private int IDExercice;
    private String DureeMois;
    private String TypeProgrammeSportif;

    public ProgrammeSportif(int IDProgrammeSportif, int IDCoach, int IDAdherent, int IDExercice, String DureeMois, String TypeProgrammeSportif) {
        this.IDProgrammeSportif = IDProgrammeSportif;
        this.IDCoach = IDCoach;
        this.IDAdherent = IDAdherent;
        this.IDExercice = IDExercice;
        this.DureeMois = DureeMois;
        this.TypeProgrammeSportif = TypeProgrammeSportif;
    }

    public int getIDProgrammeSportif() {
        return IDProgrammeSportif;
    }

    public void setIDProgrammeSportif(int IDProgrammeSportif) {
        this.IDProgrammeSportif = IDProgrammeSportif;
    }

    public int getIDCoach() {
        return IDCoach;
    }

    public void setIDCoach(int IDCoach) {
        this.IDCoach = IDCoach;
    }

    public int getIDAdherent() {
        return IDAdherent;
    }

    public void setIDAdherent(int IDAdherent) {
        this.IDAdherent = IDAdherent;
    }

    public int getIDExercice() {
        return IDExercice;
    }

    public void setIDExercice(int IDExercice) {
        this.IDExercice = IDExercice;
    }

    public String getDureeMois() {
        return DureeMois;
    }

    public void setDureeMois(String DureeMois) {
        this.DureeMois = DureeMois;
    }

    public String getTypeProgrammeSportif() {
        return TypeProgrammeSportif;
    }

    public void setTypeProgrammeSportif(String TypeProgrammeSportif) {
        this.TypeProgrammeSportif = TypeProgrammeSportif;
    }

    @Override
    public String toString() {
        return "ProgrammeSportif{" + "IDProgrammeSportif=" + IDProgrammeSportif + ", IDCoach=" + IDCoach + ", IDAdherent=" + IDAdherent + ", IDExercice=" + IDExercice + ", DureeMois=" + DureeMois + ", TypeProgrammeSportif=" + TypeProgrammeSportif + '}';
    }

}
