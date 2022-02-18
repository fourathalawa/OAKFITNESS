/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        Produit p = new Produit(31, "GoldStandard", "Whey", "premium Whey", 17, 1, "GoldStandard.png",10);
        Produit p2 = new Produit("Gtest", "Wtest", "premium test", 026, 0, "Gold.png",20);
        //ps.ajouterProduit(p);
        //ps.supprimerProduit(31);
        //ps.modifierProduit(p2, 28);
        System.out.println(ps.afficherProduit());
        System.out.println("------------LIST Trier Par Nom------------");
        System.out.println(ps.afficherProduitTrier1());
        System.out.println("------------Chiffre Affaire Des Produit Valable---------------------");
        System.out.println(ps.calculerChiffreAffaire());



       

        TransformationCRUD ts = new TransformationCRUD();
        Transformation t = new Transformation(26, "incridible ", " best Transs", "avant.png", "apres.png",80,70,180,180, 36);
        Transformation t2 = new Transformation("test ", " best Test", "test.png", "test.png",80,100,180,187, 34);
        //ts.ajouterTransformation(t);
        //ts.supprimerTransformation(3);
        //ts.LikeTransformation(23);
        //ts.unLikeTransformation(22);
        System.out.println("------------LIST Transformation------------");
        System.out.println(ts.afficherTransformation());
        System.out.println("------------LIST Trier Par Titre------------");
        System.out.println(ts.afficherTransformationTrier1());
       System.out.println("------------Calculer IMC Avant ------------");
        //System.out.println(ts.calculerAvantIMC(17) );
     // System.out.println("------------Calculer IMC Apres ------------");
        //System.out.println(ts.calculerApresIMC(17) );
        System.out.println("---------------Image Plus Like----------------");
        System.out.println(ts.afficherTransformationLike());
}
}