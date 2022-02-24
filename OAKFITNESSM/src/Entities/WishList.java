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
public class WishList {
    
 private int IdWishList;
    private int IdProduit;
    private int IdUser;
    private String Note;
    private Date date;

    public WishList() {
    }

    public WishList(int IdWishList, int IdProduit, int IdUser,String Note,Date date) {
        this.IdWishList = IdWishList;
        this.IdProduit = IdProduit;
        this.IdUser = IdUser;
        this.Note=Note;
        this.date=date;   }

    
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public void setIdWishList(int IdWishList) {
        this.IdWishList = IdWishList;
    }

    public void setIdProduit(int IdProduit) {
        this.IdProduit = IdProduit;
    }


    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public int getIdWishList() {
        return IdWishList;
    }

    public int getIdProduit() {
        return IdProduit;
    }

    public int getIdUser() {
        return IdUser;
    }

   
@Override
    public String toString() {
        return "WishList{" + "IdWishList=" + IdWishList + ", IdProduit=" + IdProduit + ", IdUser=" + IdUser + ", Note=" + Note + ", date=" + date + '}';
    }

   
    
}
