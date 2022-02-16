/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.test;

import com.mycompany.oakfitnessjava.entities.Evenement;
import com.mycompany.oakfitnessjava.entities.Repas;
import com.mycompany.oakfitnessjava.services.EvenementCRUD;
import com.mycompany.oakfitnessjava.services.RepasCRUD;
import com.mycompany.oakfitnessjava.entities.Exercice;
import com.mycompany.oakfitnessjava.entities.ProgrammeNutritionnel;
import com.mycompany.oakfitnessjava.entities.ProgrammeSportif;
import com.mycompany.oakfitnessjava.services.ExerciceCRUD;
import com.mycompany.oakfitnessjava.services.ProgrammeNutritionnelCRUD;
import com.mycompany.oakfitnessjava.services.ProgrammeSportifCRUD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Heni Nechi
 */
public class MainClass {

    public static void main(String[] args) throws ParseException {
        //MyConnection mc = new MyConnection();
        
       // ExerciceCRUD ecrud = new ExerciceCRUD();
        //ProgrammeSportifCRUD pscrud = new ProgrammeSportifCRUD();
        //ProgrammeSportif ps = new ProgrammeSportif(1,1,1,"test");
       // pscrud.ajouterProgrammeSportif2(ps); 
        //Exercice ex = new Exercice("test3","test3","test3","test3","test3","test3");
        //Exercice ex2 = new Exercice("test3","test3","test3","test3","test3","test3");
        //ecrud.ajouterExercice2(ex2);
        //System.out.println(ex.getIDExercice());
        /*ecrud.ajouterExercice2(ex2);*/
        //ecrud.AjouterExerciceAProgramme(10,27); 
        //System.out.println(pscrud.AfficherExercicesDeProgramme(10));
       //ecrud.supprimerExerciceDeProgramme(2);
        /*System.out.println(ecrud.afficherExercice());
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
        System.out.println(ecrud.afficherEvenement()); 
        
        RepasCRUD rcrud = new RepasCRUD();
        Repas r = new Repas("test3","test3","test3","test3");
        rcrud.ajouterRepas2(r);
        System.out.println(rcrud.afficherRepas());
        Repas r2 = new Repas("test4","test4","test4","test4");
        rcrud.ModifierRepas(r2, 3);
        //ecrud.supprimerExercice(1);
        System.out.println(rcrud.afficherRepas()); 

        ProgrammeSportifCRUD pscrud = new ProgrammeSportifCRUD();
        ProgrammeSportif ps = new ProgrammeSportif(1, 1,1, 1,"test");
        pscrud.ajouterProgrammeSportif2(ps,ex);
        System.out.println(pscrud.afficherProgrammeSportif());
        ProgrammeSportif ps2 = new ProgrammeSportif(2, 2, ex2.getIDExercice(), 2,"test2");
        pscrud.ModifierProgrammeSportif(ps2,ex,2);
        //ecrud.supprimerExercice(1);
        System.out.println(pscrud.afficherProgrammeSportif());*/
        /*RepasCRUD rcrud = new RepasCRUD();
        ExerciceCRUD ecrud = new ExerciceCRUD();
        ProgrammeNutritionnelCRUD pncrud = new ProgrammeNutritionnelCRUD();
        ProgrammeSportifCRUD pscrud = new ProgrammeSportifCRUD();
        
        
        /*ProgrammeNutritionnel pn = new ProgrammeNutritionnel(1,1,100,"test2");
        Repas r = new Repas("test3","test3","test3","test3");
        ProgrammeSportif ps = new ProgrammeSportif(1, 1,1, 1,"test");
        Exercice ex = new Exercice("test28","test28","test28","test28","test28","test28");
        ecrud.ajouterExercice2(ex);
        ecrud.AjouterExerciceAProgramme(10, 28);
        //pncrud.ajouterProgrammeNutritionnel2(pn);
        //rcrud.AjouterRepasAProgramme(1, 2);
       System.out.println(pncrud.AfficherRepasDeProgramme(1));
       System.out.println(pscrud.AfficherExercicesDeProgramme(10));
       //System.out.println(rcrud.afficherRepas());*/
        /*SimpleDateFormat sdf = new SimpleDateFormat(
    "yyyy-MM-dd");*/
        EvenementCRUD ecrud = new EvenementCRUD();
        //Evenement ev = new Evenement(1,sdf.parse("2022-09-12"),"test3","test3","test3","test3");
       // ecrud.ajouterEvenement2(ev)
        System.out.println(ecrud.afficherEvenement());
       // Evenement ev2 = new Evenement(2,sdf.parse("2022-09-28"),"test4","test4","test4","test4");
    }
}
