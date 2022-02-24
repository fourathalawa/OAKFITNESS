/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author mahdi
 */
public class Reservation {
    
    
private int IdReservation;
    private int IdUser;
    private Date DateReservation;
    private String NomSalle;
    private boolean AccCoach;
    private boolean AccResponsable;

    public Reservation() {
    }

    public Reservation(int IdReservation, int IdUser, Date DateReservation, String NomSalle, boolean AccCoach, boolean AccResponsable) {
        this.IdReservation = IdReservation;
        this.IdUser = IdUser;
        this.DateReservation = DateReservation;
        this.NomSalle = NomSalle;
        this.AccCoach = AccCoach;
        this.AccResponsable = AccResponsable;
    }

    public void setIdReservation(int IdReservation) {
        this.IdReservation = IdReservation;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public void setDateReservation(Date DateReservation) {
        this.DateReservation = DateReservation;
    }

    public void setNomSalle(String NomSalle) {
        this.NomSalle = NomSalle;
    }

    public void setAccCoach(boolean AccCoach) {
        this.AccCoach = AccCoach;
    }

    public void setAccResponsable(boolean AccResponsable) {
        this.AccResponsable = AccResponsable;
    }

    public int getIdReservation() {
        return IdReservation;
    }

    public int getIdUser() {
        return IdUser;
    }

    public Date getDateReservation() {
        return DateReservation;
    }

    public String getNomSalle() {
        return NomSalle;
    }

    public boolean isAccCoach() {
        return AccCoach;
    }

    public boolean isAccResponsable() {
        return AccResponsable;
    }

    @Override
    public String toString() {
        return "Reservation{" + "IdReservation=" + IdReservation + ", IdUser=" + IdUser + ", DateReservation=" + DateReservation + ", NomSalle=" + NomSalle + ", AccCoach=" + AccCoach + ", AccResponsable=" + AccResponsable + '}';
    }
    
    
    
    
}

