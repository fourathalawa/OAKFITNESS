/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oakfitnessm;

import Services.ReservationCRUD;
import Utilities.MyConnection;

/**
 *
 * @author mahdi
 */
public class OAKFITNESSM {

   public static void main (String [] args){
    ReservationCRUD r=new ReservationCRUD();
       System.out.println(r.afficherReservation());
    }
}
