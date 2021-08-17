/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Scanner;
import models.Avion;

/**
 *
 * @author DELL_COREI5
 */
public class VistaAvion {
    public Avion activarVista(){
        Scanner objScanner =new Scanner(System.in);
        Avion objAvion = new Avion();
        
        System.out.println("-----------------------------------------");
        System.out.println("A continuación digite los datos del avión");
        System.out.println("-----------------------------------------");
        
        System.out.print("Digite la matrícula del avión: ");
        objAvion.setMatricula(objScanner.next());
        
        System.out.print("Digite el modelo del avión: ");
        objAvion.setModelo(objScanner.next()); 
        
        System.out.print("Digite la cédula del propietario: ");
        objAvion.setCedula(objScanner.next()); 
        
        System.out.print("Digite el tipo de contrato 1/anual, 2/mensual: ");
        objAvion.setTipo_contrato(objScanner.nextInt());
        
        return objAvion;
    }
}
