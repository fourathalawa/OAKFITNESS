/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oakfitnessjava;
import oakfitnessjavaEntities.panier;
import oakfitnessjavaEntities.Commande;
import oakfitnessjavaservices.commandeCRUD;
import oakfitnessjavaservices.panierCRUD;
import utils.myCnx;
/**
 *
 * @author touns
 */
public class OAKFITNESSjava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          // MyConnection mc = new MyConnection();
        panierCRUD pcrud = new panierCRUD();
        panier p = new panier(2,1,1);
        //pcrud.ajouterpanier(p);
     //System.out.println(pcrud.afficherpanier(1));
//        panier p2 = new panier("test2","test2","test2","test2","test2","test2");
      pcrud.ModifierQteProduit(3,2);
//        pcrud.supprimerproduit(p2);
//        System.out.println(pcrud.afficherpanier());
//        
//        commandeCRUD ccrud = new commandeCRUD();
//        commande c = new commande("test1","test1","test1","test1","test1","test1");
//        ccrud.ajoutercommande2(c);
//        System.out.println(ccrud.affichercommande());
//        commande c2 = new commande("test4","test4","test4","test4","test4","test4");
//        ccrud.Modifiercommande(c2, 2);
//        ccrud.supprimercommande(c2);
//        System.out.println(pcrud.affichercommande());

    }
}
        