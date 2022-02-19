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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author Heni Nechi
 */
public class MainClass {

    public static void main(String[] args) throws ParseException, MessagingException {
        // Execute this everyday at 00:00
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                EvenementCRUD ecrud = new EvenementCRUD();
                //Get events that's due in 1 day
                List<Evenement> J1 = ecrud.isJ1();
                if (!J1.isEmpty()) {
                    try {
                        //Send Emails to user about the J-1 events
                        ecrud.EnvoyeEmailJ1(J1, "heni.m.nechi@gmail.com, heni.nechi@esprit.tn");
                        System.out.println("Message sent!");
                    } catch (MessagingException ex) {
                        Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_MONTH, 20);
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);

        System.out.println(date.getTime());
        timer.scheduleAtFixedRate(task, date.getTime(), 86400000);

        //Evenement (CRUD) Evenement Instance
        EvenementCRUD ecrud = new EvenementCRUD();
        //Date to be inserted into Instance
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Evenement ev = new Evenement(4, sdf.parse("2022-02-22"), "test5", "test5", "test5", "test5");
        //Add an event
        // ecrud.ajouterEvenement2(ev);
        //Delete an event 
        //ecrud.supprimerEvenement(4);
        //Edit an event 
        //ecrud.ModifierEvenement(ev, 27);
        //Show events 
        //System.out.println(ecrud.afficherEvenement());
        //Get event created by user
        //ecrud.EvenementCreatedby(2);
        //Get Events between 2 dates
        //ecrud.BetweenDatesEvenement(sdf.parse("2022-01-01"), sdf.parse("2022-12-31"));

        //Exercice (CRUD) Exercice Instance
        ExerciceCRUD excrud = new ExerciceCRUD();
        Exercice ex = new Exercice("test3", "test3", "test3", "test3", "test3", "test3");
        //Add an exercice 
        //excrud.ajouterExercice2(ex);
        //Delete an exercice
        //excrud.supprimerExercice(2);
        //Edit an exercice 
        //excrud.ModifierExercice(ex, 3);
        //Show exercices
        //System.out.println(excrud.afficherExercice());
        //Add an exercice to a Fitness Plan
        //excrud.AjouterExerciceAProgramme(1, 5);
        //Delete an exercice from a Fitness Plan 
        //excrud.supprimerExerciceDeProgramme(2, 2);
        
        //Fitness Plan (CRUD) Fitness Instance
        ProgrammeSportifCRUD pscrud = new ProgrammeSportifCRUD();
        ProgrammeSportif ps = new ProgrammeSportif(1, 1, 1, "test");
        //Add a Fitness Plan 
        //pscrud.ajouterProgrammeSportif2(ps);
        //Delete a Fitness Plan 
        //pscrud.supprimerProgrammeSportif(2);
        //Edit a Fitness Plan
        //pscrud.ModifierProgrammeSportif(ps, 3);
        //Show Fitness Plans
        //System.out.println(pscrud.afficherProgrammeSportif());
        //Show Exercices of a Fitness Plan
        //pscrud.AfficherExercicesDeProgramme(2);

        //Meals (CRUD) Meal Instance       
        RepasCRUD rcrud = new RepasCRUD();
        Repas r = new Repas("test3", "test3", "test3", 250, "test3");
        //Add a Meal
        //rcrud.ajouterRepas2(r);
        //Delete a Meal 
        //rcrud.supprimerRepas(2);
        //Edit a Meal 
        //rcrud.ModifierRepas(r, 3);
        //Show Meals 
        //System.out.println(rcrud.afficherRepas());
        //Add a Meal to a Nutrional Plan
        //rcrud.AjouterRepasAProgramme(2, 3);
        //Delete a Meal from a Nutrional Plan
        //rcrud.supprimerRepasDeProgramme(2, 4);
        
        //Fitness Plan (CRUD) Fitness Instance
        ProgrammeNutritionnelCRUD pncrud = new ProgrammeNutritionnelCRUD();
        ProgrammeNutritionnel pn = new ProgrammeNutritionnel(1, 1, 100, "test2");
        //Add a Nutrional Plan 
        //pncrud.ajouterProgrammeNutritionnel2(pn);
        //Delete a Fitness Plan 
        //pncrud.supprimerProgrammeNutritionnel(2);
        //Edit a Fitness Plan
        //pncrud.ModifierProgrammeNutritionnel(pn, 3);
        //Show Fitness Plans
        //System.out.println(pncrud.afficherProgrammeNutritionnel());
        //Show Exercices of a Fitness Plan
        //pncrud.AfficherRepasDeProgramme(2);  

    }
}
