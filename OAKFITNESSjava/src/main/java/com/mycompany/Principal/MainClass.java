/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Principal;

import com.mycompany.entities.Challenge;
import com.mycompany.services.ChallengeCRUD;
import com.mycompany.utils.MyConnection;
/**
 *
 * @author User
 */
public class MainClass {
    public static void main (String [] args){
//MyConnection mc =  MyConnection.getInstance();

ChallengeCRUD ch = new ChallengeCRUD();
//ch.ajouterChallenge();
Challenge ch1 = new Challenge("21/5/2018","28/06/2018","fvgqf",54);
ch.ajouterPersonne2(ch1);
Challenge ch2 = new Challenge("30/12/2020","30/02/2021","update");
System.out.println(ch.afficherChallenge());
//ch.supprimerChallenge(4);
ch.ModifierChallenge(ch2, 5);
System.out.println(ch.afficherChallenge());

    }
}
