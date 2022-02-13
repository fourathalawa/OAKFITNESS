/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.entities;

/**
 *
 * @author Heni Nechi
 */
public class ProgrammeNutritionnel {

    private int IDProgrammeNutritionnel;
    private int IDCoach;
    private int IDAdherent;
    private int IDRepas;
    private int Calorie;
    private String TypeProgrammeNutritionel;

    public ProgrammeNutritionnel() {
    }
    

    public ProgrammeNutritionnel(int IDProgrammeNutritionnel, int IDCoach, int IDAdherent, int IDRepas, int Calorie, String TypeProgrammeNutritionel) {
        this.IDProgrammeNutritionnel = IDProgrammeNutritionnel;
        this.IDCoach = IDCoach;
        this.IDAdherent = IDAdherent;
        this.IDRepas = IDRepas;
        this.Calorie = Calorie;
        this.TypeProgrammeNutritionel = TypeProgrammeNutritionel;
    }

    public ProgrammeNutritionnel(int IDCoach, int IDAdherent, int IDRepas, int Calorie, String TypeProgrammeNutritionel) {
        this.IDCoach = IDCoach;
        this.IDAdherent = IDAdherent;
        this.IDRepas = IDRepas;
        this.Calorie = Calorie;
        this.TypeProgrammeNutritionel = TypeProgrammeNutritionel;
    }

    public int getIDProgrammeNutritionnel() {
        return IDProgrammeNutritionnel;
    }

    public void setIDProgrammeNutritionnel(int IDProgrammeNutritionnel) {
        this.IDProgrammeNutritionnel = IDProgrammeNutritionnel;
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

    public int getIDRepas() {
        return IDRepas;
    }

    public void setIDRepas(int IDRepas) {
        this.IDRepas = IDRepas;
    }

    public int getCalorie() {
        return Calorie;
    }

    public void setCalorie(int Calorie) {
        this.Calorie = Calorie;
    }

    public String getTypeProgrammeNutritionel() {
        return TypeProgrammeNutritionel;
    }

    public void setTypeProgrammeNutritionel(String TypeProgrammeNutritionel) {
        this.TypeProgrammeNutritionel = TypeProgrammeNutritionel;
    }

    @Override
    public String toString() {
        return "ProgrammeNutritionnel{" + "IDProgrammeNutritionnel=" + IDProgrammeNutritionnel + ", IDCoach=" + IDCoach + ", IDAdherent=" + IDAdherent + ", IDRepas=" + IDRepas + ", Calorie=" + Calorie + ", TypeProgrammeNutritionel=" + TypeProgrammeNutritionel + '}';
    }

}
