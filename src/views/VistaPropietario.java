/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.List;
import java.util.Scanner;
import models.Propietario;

/**
 *
 * @author DELL_COREI5
 */
public class VistaPropietario {

    public Propietario activarVista() {
        Scanner objScanner = new Scanner(System.in);
        Propietario objPropietario = new Propietario();

        System.out.println("\n");
        System.out.println("----------------------------------------------");
        System.out.println("Acontinuación digite los datos del propietario");
        System.out.println("----------------------------------------------");
        
        System.out.print("Digite la cédula del porpietario: ");
        objPropietario.setCedula(objScanner.next());

        System.out.print("Digite el nombre del porpietario: ");
        objPropietario.setNombre(objScanner.next());

        System.out.print("Digite el metodo de pago 1/credito, 2/contado): ");
        objPropietario.setTipo_pago(objScanner.nextInt());

        return objPropietario;
    }

    public void activarVista2(List<Propietario> propietarios) {

        for (int i = 0; i < propietarios.size(); i++) {
            Propietario propietario = propietarios.get(i);
            System.out.println("\n");
            System.out.println("--------------------------------------");
            System.out.println("---DATOS DEL PROPIETARIO NÚMERO: " + (i+1) + " ---");
            System.out.println("--------------------------------------");
            System.out.println("");
            System.out.print("Cédula: " + propietario.getCedula());
            System.out.println("");
            System.out.print("Nombre: " + propietario.getNombre());
            System.out.println("");
            System.out.print("Tipo de pago: " + propietario.getTipo_pago());
            System.out.println("");
        }

    }
}
