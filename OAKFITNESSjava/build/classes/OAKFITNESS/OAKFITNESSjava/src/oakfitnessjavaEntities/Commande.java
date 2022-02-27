/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oakfitnessjavaEntities;

import java.sql.Date;

/**
 *
 * @author touns
 */
public class Commande {
    private int idA;
    private int idC;
    private Date dateC;
    private float totalC;
    private String etatC;
    private String facture;
    private String avisClient;
public Commande(){};
    public Commande(Date dateC, float totalC, String etatC, String facture) {
        
        this.dateC = dateC;
        this.totalC = totalC;
        this.etatC = etatC;
        this.facture = facture;
    }

    public int getIdC() {
        return idC;
    }

    public Date getDateC() {
        return dateC;
    }

    public float getTotalC() {
        return totalC;
    }

    public String getEtatC() {
        return etatC;
    }

    public String getFacture() {
        return facture;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public void setDateC(Date dateC) {
        this.dateC = dateC;
    }

    public void setTotalC(float totalC) {
        this.totalC = totalC;
    }

    public void setEtatC(String etatC) {
        this.etatC = etatC;
    }

    public void setFacture(String facture) {
        this.facture = facture;
    }

    public void setAvisClient(String avisClient) {
        this.avisClient = avisClient;
    }

    public String getAvisClient() {
        return avisClient;
    }
    

    @Override
    public String toString() {
        return "Commande{" + "idC=" + idC + ", dateC=" + dateC + ", totalC=" + totalC + ", etatC=" + etatC + ", facture=" + facture + '}';
    }

    
}
