/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.List;
import models.AvionesHangares;

/**
 *
 * @author DELL_COREI5
 */
public class VistaAvionesHangar {

    public void activarVista(List<AvionesHangares> avionesHangares) {

        for (int i = 0; i < avionesHangares.size(); i++) {
            AvionesHangares avionHangar = avionesHangares.get(i);
            System.out.println("\n");
            System.out.println("--------------------------------------");
            System.out.println("-----DATOS DEL INGRESO NÚMERO: " + (i + 1) + " -----");
            System.out.println("--------------------------------------");
            System.out.println("");
            System.out.print("Código del hangar: " + avionHangar.getCodigo_hangar());
            System.out.println("");
            System.out.print("Matrícula del avión: " + avionHangar.getMatricula());
            System.out.println("");
            System.out.print("Fecha de ingreso: " + avionHangar.getFecha_ingreso());
            System.out.println("");
            System.out.print("Número de celda: " + avionHangar.getNumero_celda());
            System.out.println("");
        }

    }
}
