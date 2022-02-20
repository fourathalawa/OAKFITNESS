/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.entities;

/**
 *
 * @author user
 */
public class NoteCommentaire {

    private int idNote;
    private int userID;
    private int IDCommentaire;
    private int isLike;

    public NoteCommentaire() {
    }

    public int getIdNote() {
        return idNote;
    }

    public int getUserID() {
        return userID;
    }

    public int getIDCommentaire() {
        return IDCommentaire;
    }

    public int getIsLike() {
        return isLike;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setIDCommentaire(int IDCommentaire) {
        this.IDCommentaire = IDCommentaire;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }

    public NoteCommentaire(int idNote, int userID, int IDCommentaire, int isLike) {
        this.idNote = idNote;
        this.userID = userID;
        this.IDCommentaire = IDCommentaire;
        this.isLike = isLike;
    }

    public NoteCommentaire(int userID, int IDCommentaire, int isLike) {
        this.userID = userID;
        this.IDCommentaire = IDCommentaire;
        this.isLike = isLike;
    }

 

}
