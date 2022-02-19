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
    private int DureeMois;
    private String TypeProgrammeSportif;

    public ProgrammeSportif() {
    }

    public ProgrammeSportif(int IDProgrammeSportif, int IDCoach, int IDAdherent, int DureeMois, String TypeProgrammeSportif) {
        this.IDProgrammeSportif = IDProgrammeSportif;
        this.IDCoach = IDCoach;
        this.IDAdherent = IDAdherent;
        this.DureeMois = DureeMois;
        this.TypeProgrammeSportif = TypeProgrammeSportif;
    }

    public ProgrammeSportif(int IDCoach, int IDAdherent, int DureeMois, String TypeProgrammeSportif) {
        this.IDCoach = IDCoach;
        this.IDAdherent = IDAdherent;
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

    public int getDureeMois() {
        return DureeMois;
    }

    public void setDureeMois(int DureeMois) {
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
        return "ProgrammeSportif{" + "IDProgrammeSportif=" + IDProgrammeSportif + ", IDCoach=" + IDCoach + ", IDAdherent=" + IDAdherent + ", DureeMois=" + DureeMois + ", TypeProgrammeSportif=" + TypeProgrammeSportif + '}';
    }

}
