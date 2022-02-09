/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

/**
 *
 * @author User
 */
public class Challenge {
    private int IdChallenge;
    private String DateDebut;
    private String DateFin;
    private String Objectif;
    private int IdUser;

    public Challenge() {
    }

    public Challenge(int IdChallenge, String DateDebut, String DateFin, String Objectif, int IdUser) {
        this.IdChallenge = IdChallenge;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Objectif = Objectif;
        this.IdUser = IdUser;
    }

    public Challenge(String DateDebut, String DateFin, String Objectif, int IdUser) {
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.Objectif = Objectif;
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

    public String getObjectif() {
        return Objectif;
    }

    public void setObjectif(String Objectif) {
        this.Objectif = Objectif;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    @Override
    public String toString() {
        return "Challenge{" + "IdChallenge=" + IdChallenge + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", Objectif=" + Objectif + ", IdUser=" + IdUser + '}';
    }
    
}
