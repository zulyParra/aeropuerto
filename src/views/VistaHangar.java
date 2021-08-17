/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Scanner;
import models.Hangar;

/**
 *
 * @author DELL_COREI5
 */
public class VistaHangar {
    public void activarVista(Hangar hangar){
        System.out.println("\n");
        System.out.println("-----------------------------------------");
        System.out.println("-----------DATOS DEL HANGAR--------------");
        System.out.println("-----------------------------------------");
        System.out.println("");
        System.out.print("Cupos totales del hangar: "+ hangar.getCupo_total());
        System.out.println("");
        System.out.print("Cupos disponibles del hangar: "+ hangar.getCupos_disponibles());
        System.out.println("");
        System.out.print("Cupos reservados del hangar: "+ hangar.getCupos_reservados());
        System.out.println("");
    }
}
