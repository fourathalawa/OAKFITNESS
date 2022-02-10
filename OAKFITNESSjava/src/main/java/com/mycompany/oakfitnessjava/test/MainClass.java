/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.test;

import com.mycompany.oakfitnessjava.entities.Exercice;
import com.mycompany.oakfitnessjava.services.ExerciceCRUD;
import com.mycompany.oakfitnessjava.utils.MyConnection;

/**
 *
 * @author Heni Nechi
 */
public class MainClass {
    public static void main(String[] args) {
        // MyConnection mc = new MyConnection();
        ExerciceCRUD ecrud = new ExerciceCRUD();
        Exercice ex = new Exercice("test3","test3","test3","test3","test3","test3");
        ecrud.ajouterExercice2(ex);
        System.out.println(ecrud.afficherExercice());
        Exercice ex2 = new Exercice("test4","test4","test4","test4","test4","test4");
        ecrud.ModifierExercice(ex2, 2);
        //ecrud.supprimerExercice(1);
        System.out.println(ecrud.afficherExercice());
        
    }
}
