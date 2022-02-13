/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import entities.Produit;
import entities.Transformation;
import services.ProduitCRUD;
import services.TransformationCRUD;
import utils.MyConnection;

/**
 *
 * @author kriaa
 */
public class MainClass {

    public static void main(String[] args) {

        ProduitCRUD ps = new ProduitCRUD();
        Produit p = new Produit(31, "GoldStandard", "Whey", "premium Whey", 17, 1, "GoldStandard.png");
        Produit p2 = new Produit("Gtest", "Wtest", "premium test", 026, 0, "Gold.png");
        //ps.ajouterProduit(p2);
        //ps.supprimerProduit(31);
        //ps.modifierProduit(p2, 28);
        System.out.println(ps.afficherProduit());
        System.out.println("------------LIST Trier Par Nom------------");
        System.out.println(ps.afficherProduitTrier1());
       

        TransformationCRUD ts = new TransformationCRUD();
        Transformation t = new Transformation(26, "incridible ", " best Transs", "avant.png", "apres.png", 36);
        Transformation t2 = new Transformation("test ", " best Test", "test.png", "test.png", 34);
        //ts.ajouterTransformation(t2);
        //ts.supprimerTransformation(3);
        //ts.modifierTransformation(t2, 6);
        System.out.println(ts.afficherTransformation());
        System.out.println("------------LIST Trier Par Titre------------");
        System.out.println(ts.afficherTransformationTrier1());
        
        

    }
}
