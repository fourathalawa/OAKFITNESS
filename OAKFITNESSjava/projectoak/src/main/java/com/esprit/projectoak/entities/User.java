/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.entities;

/**
 *
 * @author user
 */
public class User {
    private int userID;
    private int userName;
    private String userMail;

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getUserID() {
        return userID;
    }

    public int getUserName() {
        return userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public User() {
    }

}
