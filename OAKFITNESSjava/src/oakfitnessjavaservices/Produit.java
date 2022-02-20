/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oakfitnessjavaservices;

/**
 *
 * @author touns
 */
public class Produit {
   private int idProduit;
    private String nomProduit;
    private float prix;

    public Produit() {
    }

    public Produit(int idProduit, String nomProduit) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + idProduit + ", nomProduit=" + nomProduit + '}';
    }
    
}
