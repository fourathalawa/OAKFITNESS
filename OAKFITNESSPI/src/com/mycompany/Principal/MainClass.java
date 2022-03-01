/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Principal;

import com.mycompany.entities.Challenge;
import com.mycompany.entities.User;
import com.mycompany.services.ChallengeCRUD;
import com.mycompany.services.UserCRUD;
import com.mycompany.utils.MyConnection;

/**
 *
 * @author Fourat Halaoua
 */
public class MainClass {

    public static void main(String[] args) {
//MyConnection mc =  MyConnection.getInstance();
        UserCRUD userC = new UserCRUD();
        ChallengeCRUD challengeC = new ChallengeCRUD();
        //Challenge ch = new Challenge("21/5/2018","28/06/2018",86.2f,76.5f,1.75f,125);
        /* //ajouter Challenge
       challengeC.ajouterChallenge(ch);*/
 /*// modifier Challenge 
        
       Challenge ch2 = new Challenge("30/12/2020","30/02/2021",86.5f,72.5f,1.75f);
       System.out.println(challengeC.afficherChallenge());
        
       challengeC.ModifierChallenge(ch2,125);*/

 /* //supprimer Challenge 
       challengeC.supprimerChallenge(125);*/
 /* // afficher Challenge
        System.out.println(challengeC.afficherChallenge());*/
 
 /* //Ajouter ke nouveau poid  Challenge
        Challenge ch5 = new Challenge(78.6f);
        challengeC.NouveauPoid(ch5, 125);*/
  /* // Calcul IMC
 
        System.out.println("IMC initial | IMC Objectif | IMC courant ");   
        System.out.println(challengeC.CalculIMC(125));
 
 /* // taux de progression 
 System.out.print(challengeC.ProgressionChallenge(125));
        System.out.print("%");*/ 

  
  
  
  
  
  //User us = new User();
     //   System.out.println( us.decrypt("QJUBDIEY"));
  
         // ajouter des user
       // User admin = new User("kassem","benhenda","fourathalawa2000@gmail.com",54626952,"21-02-2000",0,"kassem00002");
        
        /*User adherent = new User("assyl", "kriaa", "assyl.kriaa@esprit.tn",65847512,"21/02/2002",1,1,"10/02/2022","assyl2000");
        User coach = new User("habib firas","hadroug","habibfiras.hadroug@esprit.tn", 00000000,"21/5/2000", 2, "aearr", "ouiyfcqglksb","habib9999");
        User responsable = new User("heni","nechi", "heni.nechi@esprit.tn",11111111,"10/01/1998", "mourouj",584712,3,"heni6666");
        
        userC.ajouterAdhérent(adherent);
        userC.ajouterCoach(coach);
        userC.ajouterResponsable(responsable);*/
//userC.ajouterAdmin(admin);
 //  userC.ResetPassword(admin);
 /* //modifier des user
        User adherent1 = new User("assylae", "kriaaaz", "assyl.kriaa@esprit.tn",65847512,"21/02/2002",1,1,"10/02/2022","assyl2000");
        User coach1 = new User("habib firasds","hadrougsd","habibfiras.hadroug@esprit.tn", 00000000,"21/5/2000", 2, "aearr", "ouiyfcqglksb","habib9999");
        User responsable1 = new User("henivc","nechicv", "heni.nechi@esprit.tn",11111111,"10/01/1998", "mourouj",584712,3,"heni6666");

        userC.ModifierAdhrent(adherent1, 28);
        userC.ModifierCoach(coach1, 29);
        userC.ModifierResponsable(responsable1,30);*/
 /* // afficher user
        System.out.println(userC.afficherAdhérent());
        System.out.println(userC.afficherCoach());
        System.out.println(userC.afficherResponsable());*/ 
         
  /*// supprimer des user
        userC.supprimerUser(27);
        userC.supprimerUser(28);
        userC.supprimerUser(29);
        userC.supprimerUser(30);*/
 /* // login in user
        User log = new User("assyl.kriaa@esprit.tn","assyl2000");
        System.out.println(userC.authentification(log));
       */  
    }

}
