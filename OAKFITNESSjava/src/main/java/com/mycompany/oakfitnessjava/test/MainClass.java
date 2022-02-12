/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.test;

import com.mycompany.oakfitnessjava.entities.Evenement;
import com.mycompany.oakfitnessjava.entities.Repas;
import com.mycompany.oakfitnessjava.services.EvenementCRUD;
import com.mycompany.oakfitnessjava.services.RepasCRUD;

/**
 *
 * @author Heni Nechi
 */
public class MainClass {
    public static void main(String[] args) {
        /* MyConnection mc = new MyConnection();
        ExerciceCRUD ecrud = new ExerciceCRUD();
        Exercice ex = new Exercice("test3","test3","test3","test3","test3","test3");
         ecrud.ajouterExercice2(ex);
        System.out.println(ecrud.afficherExercice());
        Exercice ex2 = new Exercice("test4","test4","test4","test4","test4","test4");
        ecrud.ModifierExercice(ex2, 2);
        ecrud.supprimerExercice(1);
        System.out.println(ecrud.afficherExercice());
        
        EvenementCRUD ecrud = new EvenementCRUD();
        Evenement ev = new Evenement("test3","test3","test3","test3");
        ecrud.ajouterEvenement2(ev);
        System.out.println(ecrud.afficherEvenement());
        Evenement ev2 = new Evenement("test4","test4","test4","test4");
        ecrud.ModifierEvenement(ev2, 3);
        //ecrud.supprimerExercice(1);
        System.out.println(ecrud.afficherEvenement()); */
        RepasCRUD rcrud = new RepasCRUD();
        Repas r = new Repas("test3","test3","test3","test3");
        rcrud.ajouterRepas2(r);
        System.out.println(rcrud.afficherRepas());
        Repas r2 = new Repas("test4","test4","test4","test4");
        rcrud.ModifierRepas(r2, 3);
        //ecrud.supprimerExercice(1);
        System.out.println(rcrud.afficherRepas());
    }
}
