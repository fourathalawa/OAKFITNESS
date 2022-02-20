/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.princnipal;

import com.esprit.projectoak.entities.Commentaire;
import com.esprit.projectoak.entities.NoteCommentaire;
import com.esprit.projectoak.entities.Publication;
import com.esprit.projectoak.entities.Reclamation;
import com.esprit.projectoak.entities.User;
import com.esprit.projectoak.services.CommentaireCRUD;
import com.esprit.projectoak.services.NoteCommentaireCRUD;
import com.esprit.projectoak.services.PublicationCRUD;
import com.esprit.projectoak.services.ReclamationCRUD;
import com.esprit.projectoak.services.userCRUD;

/**
 *
 * @author user
 */
public class MainClass {
//jerjerj

    public static void main(String[] args) {
////MyConnection mc =  MyConnection.getInstance();
        ReclamationCRUD ps = new ReclamationCRUD();
//ps.ajouterReclamation();
        Reclamation p = new Reclamation(1, 2, "cest une reclamation", "22/22/2022");
        // ps.ajouterReclamation2(p);
//        // System.out.println(p.getIDReclamation());
//        //ps.supprimerReclamation(26);
//        ps.modifierReclamation(25, p);
        System.out.println("**************affichage reclamation************************************");
        System.out.println(ps.afficherReclamation());
        PublicationCRUD pb = new PublicationCRUD();
        System.out.println("**************affichage statistique************************************");

        ps.pourcentageCategorie();
        // pb.ajouterPulication();
        Publication pu = new Publication(1, "h", "j", "k");
        //  Publication puu = new Publication("update2","update2");
        //   pb.ajouterPulication2(pu);
//        pb.supprimerPublication(2);
//        pb.modifierPulication(1, puu);
        // CommentaireCRUD c = new CommentaireCRUD();
        System.out.println("**************forum****************************************************");

        System.out.println("\n" + pb.afficherPulication());
//c.ajouterCommentaire();
        Commentaire cc = new Commentaire(3, 44, "ff", "ii");
//Commentaire cc2 = new Commentaire("ljerje erle er,ler, elr,erl");
//c.ajouterCommentaire2(cc);
        //c.supprimerCommentaire(5);
        //c.modifierPulication(1, cc2);
        // System.out.println(f.afficherPulication());
        System.out.println("**************rechercher************************************************");
        pb.chercherPublication("mise");
        System.out.println("**************tri*******************************************************");
        pb.triPulication(3);

        pb.extractNom(1);
        userCRUD c = new userCRUD();
        User u = new User("mazen", "mazen@gmail.Com");
        c.ajoutUser(u);
        NoteCommentaireCRUD ncn = new NoteCommentaireCRUD();
        NoteCommentaire no = new NoteCommentaire();
        ncn.Like(7, 2);
       // System.out.println(ncn.note(7));
      // ncn.undo(7, 1);
      // ncn.check(7,1);

    }
}
