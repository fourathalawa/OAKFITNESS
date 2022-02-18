/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author kriaa
 */
public class Produit {
    private int IdProduit;
    private String NomProduit;
    private String CategProduit;
    private String DescrProduit;
    private float PrixProduit;
    private int IsAvailable;
    private String ImageProduit;
    private int StockProduit;

//stock

    public Produit(int IdProduit, String NomProduit, String CategProduit, String DescrProduit, float PrixProduit, int IsAvailable, String ImageProduit, int StockProduit) {
        this.IdProduit = IdProduit;
        this.NomProduit = NomProduit;
        this.CategProduit = CategProduit;
        this.DescrProduit = DescrProduit;
        this.PrixProduit = PrixProduit;
        this.IsAvailable = IsAvailable;
        this.ImageProduit = ImageProduit;
        this.StockProduit = StockProduit
    }

    public Produit() {
    }

    public Produit(String NomProduit, String CategProduit, String DescrProduit, float PrixProduit, int IsAvailable, String ImageProduit, int StockProduit ) {
        this.NomProduit = NomProduit;
        this.CategProduit = CategProduit;
        this.DescrProduit = DescrProduit;
        this.PrixProduit = PrixProduit;
        this.IsAvailable = IsAvailable;
        this.ImageProduit = ImageProduit;
        this.StockProduit = StockProduit;
    }

   public int getStockProduit(){
  return StockProduit;
}
   public void setStockProduit(int StockProduit) {
        this.StockProduit = StockProduit;
    }

    public int getIdProduit() {
        return IdProduit;
    }

    public String getNomProduit() {
        return NomProduit;
    }

    public String getCategProduit() {
        return CategProduit;
    }

    public String getDescrProduit() {
        return DescrProduit;
    }

    public float getPrixProduit() {
        return PrixProduit;
    }

    public int getIsAvailable() {
        return IsAvailable;
    }

    public String getImageProduit() {
        return ImageProduit;
    }

    public void setIdProduit(int IdProduit) {
        this.IdProduit = IdProduit;
    }

    public void setNomProduit(String NomProduit) {
        this.NomProduit = NomProduit;
    }

    public void setCategProduit(String CategProduit) {
        this.CategProduit = CategProduit;
    }

    public void setDescrProduit(String DescrProduit) {
        this.DescrProduit = DescrProduit;
    }

    public void setPrixProduit(float PrixProduit) {
        this.PrixProduit = PrixProduit;
    }

    public void setIsAvailable(int IsAvailable) {
        this.IsAvailable = IsAvailable;
    }

    public void setImageProduit(String ImageProduit) {
        this.ImageProduit = ImageProduit;
    }

    @Override
    public String toString() {
        return "Produit{" + "IdProduit=" + IdProduit + ", NomProduit=" + NomProduit + ", CategProduit=" + CategProduit + ", DescrProduit=" + DescrProduit + ", PrixProduit=" + PrixProduit + ", IsAvailable=" + IsAvailable + ", ImageProduit=" + ImageProduit +", StockProduit =" + StockProduit + '}';
    }
    
    
    
}

