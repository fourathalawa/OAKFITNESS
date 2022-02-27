/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oakfitnessjavaservices;
import oakfitnessjavaEntities.panier;
import utils.myCnx;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oakfitnessjavaEntities.Commande;
/**
 *
 * @author touns
 */
public class commandeCRUD {
    Connection cnxx;
     Commande ex = new Commande();

    public commandeCRUD() {
        cnxx = myCnx.getInstance().getCnx();
    }

   
    public void ajoutercommande2(Commande c){
    String Request = "INSERT INTO commande (idA,dateC,totalC,etatC,facture,avisClient)"
                + " VALUES (?,?,?,?,?,?)";

    PreparedStatement  pst;
    try {
            pst = cnxx.prepareStatement(Request);
            pst.setInt(1, c.getIdC());
            pst.setDate(2, c.getDateC());
            pst.setFloat(3, c.getTotalC());
            pst.setString(4, c.getEtatC());
            pst.setString(4, c.getFacture());
            if (ex.getEtatC() == "livré") {
            pst.setString(4, c.getAvisClient());}
            pst.executeUpdate();
                        System.out.println("commande ajouté avec succés");
 } catch (SQLException ex) {
            System.err.println(ex.getMessage());    
        }

    }


    public List<Commande> affichercommande() {
         List<Commande> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM commande";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Commande ex = new Commande();
                ex.setDateC(rs.getDate(2));
                ex.setTotalC(rs.getFloat(3));
                ex.setEtatC(rs.getString(4));
                ex.setFacture(rs.getString(5));
                ex.setAvisClient(rs.getString(5));
                myList.add(ex);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            //   return null;
        }
        return myList;
    }

     


      public void Modifiercommande(Commande c, int idc)
      {
           String req = "UPDATE commande SET dateC ='"+c.getDateC()+"',totalC ='"+c.getTotalC()+"',etatC ='"+c.getFacture()+"',facture ='"+c.getFacture()+"' WHERE IdC= '"+idc+"'";
          PreparedStatement pst;

try {
            pst = cnxx.prepareStatement(req);
            pst.executeUpdate();
                        System.out.println("Commande modifié avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

      }
       public void annulerCommande(int idC) {
           
            String Request= "DELETE * FROM Commande wehre idc = (SELECT idC FROM Commande WHERE etatC='envoyé' or etatC='livré')";
            
          PreparedStatement pst;

        try {
            pst = cnxx.prepareStatement(Request);
            pst.executeUpdate();
            System.out.println("Commande supprimé avec succés");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
            
        }
    

    public void noterCommander(int idC) {
         String Request = "INSERT INTO commande (avisClient)"
                + " VALUES (?) WHERE idC=idc";
         PreparedStatement pst;
          try {
            pst = cnxx.prepareStatement(Request);
            pst.setString(1, ex.getAvisClient());
            
           
            pst.executeUpdate();
            System.out.println("avis ajouté avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
       
   

   

}
