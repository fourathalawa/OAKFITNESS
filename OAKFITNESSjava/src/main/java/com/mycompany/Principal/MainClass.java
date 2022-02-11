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
 * @author User
 */
public class MainClass {
    public static void main (String [] args){
//MyConnection mc =  MyConnection.getInstance();
UserCRUD userC = new UserCRUD();
ChallengeCRUD challengeC = new ChallengeCRUD();
//ch.ajouterChallengeD();
/*Challenge ch = new Challenge("21/5/2018","28/06/2018","fvgqf",54);
challengeC.ajouterChallenge(ch);
Challenge ch2 = new Challenge("30/12/2020","30/02/2021","update");
System.out.println(challengeC.afficherChallenge());*/
//ch.supprimerChallenge(4);
/*challengeC.ModifierChallenge(ch2, 5);
System.out.println(challengeC.afficherChallenge());*/

User admin = new User("fourat","halaoua","fourat.halaoua@esprit.tn",99626324,"21/02/2000",0);
User adherent = new User("assyl", "kriaa", "assyl.kriaa@esprit.tn",65847512,"21/02/2002",1,1,"10/02/2022");
User coach = new User("habib firas","hadroug","habibfiras.hadroug@esprit.tn", 00000000,"21/5/2000", 2, "aearr", "ouiyfcqglksb");
User responsable = new User("heni","nechi", "heni.nechi@esprit.tn",11111111,"10/01/1998", "mourouj",584712,3);
/*userC.ajouterAdmin(admin);
userC.ajouterAdhérent(adherent);
userC.ajouterCoach(coach);
userC.ajouterResponsable(responsable);*/
User adherent1 = new User("assylae", "kriaaaz", "assyl.kriaa@esprit.tn",65847512,"21/02/2002",1,1,"10/02/2022");
User coach1 = new User("habib firasds","hadrougsd","habibfiras.hadroug@esprit.tn", 00000000,"21/5/2000", 2, "aearr", "ouiyfcqglksb");
User responsable1 = new User("henivc","nechicv", "heni.nechi@esprit.tn",11111111,"10/01/1998", "mourouj",584712,3);

userC.ModifierAdhrent(adherent1, 3);
userC.ModifierCoach(coach1, 4);
userC.ModifierResponsable(responsable1, 5);
        System.out.println(userC.afficherAdhérent());
        System.out.println(userC.afficherCoach());
        System.out.println(userC.afficherResponsable());
        
        userC.supprimerUser(2);
                userC.supprimerUser(3);
        userC.supprimerUser(4);
        userC.supprimerUser(5);

    }
}
