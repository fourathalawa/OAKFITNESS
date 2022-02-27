/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oakfitnessjavaEntities;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;
import oakfitnessjavaservices.Produit;

/**
 *
 * @author touns
 */
public class panier {

   private int id;
    private int quantity;
    private double total;
    private int id_produit;
    private int id_client;


    public panier() {
    }

    public panier(int id, int quantity, double total, int id_plate, int id_client) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.id_produit = id_plate;
        this.id_client = id_client;
    }
     public panier( int quantity, double total, int id_produit, int id_client) {
        
        this.quantity = quantity;
        this.total = total;
        this.id_produit = id_produit;
        this.id_client = id_client;
    }
      public panier( int quantity, int id_produit, int id_client) {
        
        this.quantity = quantity;
        
        this.id_produit = id_produit;
        this.id_client = id_client;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "panier{" + "id=" + id + ", quantity=" + quantity + ", total=" + total + ", id_plate=" + id_produit + ", id_client=" + id_client + '}';
    }
     
}
