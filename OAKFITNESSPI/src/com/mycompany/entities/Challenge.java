/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

/**
 *
 * @author Fourat Halaoua
 */
public class Challenge {

    private int IdChallenge;
    private String DateDebut;
    private String DateFin;
    private float poidInt;
    private float poidOb;
    private float taille;
    private float poidNv;
    private int IdUser;

    public Challenge() {
    }

    public Challenge(float poidNv) {
        this.poidNv = poidNv;
    }

    public Challenge(String DateDebut, String DateFin, float poidInt, float poidOb, float taille) {
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.poidInt = poidInt;
        this.poidOb = poidOb;
        this.taille=taille;
    }

    public Challenge(String DateDebut, String DateFin, float poidInt, float poidOb, float taille, int IdUser) {
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
          this.poidInt = poidInt;
        this.poidOb = poidOb;
        this.taille=taille;
        this.IdUser = IdUser;
    }

    public int getIdChallenge() {
        return IdChallenge;
    }

    public void setIdChallenge(int IdChallenge) {
        this.IdChallenge = IdChallenge;
    }

    public String getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(String DateDebut) {
        this.DateDebut = DateDebut;
    }

    public String getDateFin() {
        return DateFin;
    }

    public void setDateFin(String DateFin) {
        this.DateFin = DateFin;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public float getPoidInt() {
        return poidInt;
    }

    public void setPoidInt(float poidInt) {
        this.poidInt = poidInt;
    }

    public float getPoidOb() {
        return poidOb;
    }

    public void setPoidOb(float poidOb) {
        this.poidOb = poidOb;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getPoidNv() {
        return poidNv;
    }

    public void setPoidNv(float poidNv) {
        this.poidNv = poidNv;
    }

    @Override
    public String toString() {
        return "Challenge{" + "IdChallenge=" + IdChallenge + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", poidInt=" + poidInt + ", poidOb=" + poidOb + ", taille=" + taille + ", poidNv=" + poidNv + ", IdUser=" + IdUser + '}';
    }

    
}
