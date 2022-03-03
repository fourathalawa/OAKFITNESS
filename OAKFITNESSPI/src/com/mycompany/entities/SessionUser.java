/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

/**
 *
 * @author User
 */
public class SessionUser {
    private int id;
    private int role;

    public SessionUser(int id, int role) {
        this.id = id;
        this.role = role;
    }

    public SessionUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Session{" + "id=" + id + ", role=" + role + '}';
    }
    
}
