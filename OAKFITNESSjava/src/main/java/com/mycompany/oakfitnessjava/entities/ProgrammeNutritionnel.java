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
    private int Calorie;
    private String TypeProgrammeNutritionel;

    public ProgrammeNutritionnel() {
    }

    public ProgrammeNutritionnel(int IDProgrammeNutritionnel, int IDCoach, int IDAdherent, int Calorie, String TypeProgrammeNutritionel) {
        this.IDProgrammeNutritionnel = IDProgrammeNutritionnel;
        this.IDCoach = IDCoach;
        this.IDAdherent = IDAdherent;
        this.Calorie = Calorie;
        this.TypeProgrammeNutritionel = TypeProgrammeNutritionel;
    }

    public ProgrammeNutritionnel(int IDCoach, int IDAdherent, int Calorie, String TypeProgrammeNutritionel) {
        this.IDCoach = IDCoach;
        this.IDAdherent = IDAdherent;
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
        return "ProgrammeNutritionnel{" + "IDProgrammeNutritionnel=" + IDProgrammeNutritionnel + ", IDCoach=" + IDCoach + ", IDAdherent=" + IDAdherent + ", Calorie=" + Calorie + ", TypeProgrammeNutritionel=" + TypeProgrammeNutritionel + '}';
    }

}
