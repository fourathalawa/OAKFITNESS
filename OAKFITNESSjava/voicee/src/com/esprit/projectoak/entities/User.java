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
    private String userName;
    private String userMail;

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public User() {
    }

    public User(String userName, String userMail) {
        this.userName = userName;
        this.userMail = userMail;
    }

    public User(int userID, String userName, String userMail ) {
        this.userID = userID;
        this.userName = userName;
        this.userMail = userMail;
    }

}
