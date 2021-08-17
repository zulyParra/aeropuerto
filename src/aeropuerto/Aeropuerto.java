/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import controllers.ControladorAvion;
import controllers.ControladorAvionesHangares;
import controllers.ControladorHangar;
import controllers.ControladorPropietario;
import java.util.List;
import java.util.Scanner;
import models.Avion;
import models.AvionesHangares;
import models.Hangar;
import models.Propietario;
import views.VistaAvion;
import views.VistaAvionesHangar;
import views.VistaHangar;
import views.VistaPropietario;

/**
 *
 * @author DELL_COREI5
 */
public class Aeropuerto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner objLeer = new Scanner(System.in);
        ControladorHangar controladorHangar = new ControladorHangar();
        Hangar hangar = controladorHangar.consultarHangar();
        ControladorPropietario controladorPropietario = new ControladorPropietario();
        List<Propietario> propietarios = controladorPropietario.consultarPropietario();
        VistaPropietario vistaPropietario = new VistaPropietario();
        ControladorAvionesHangares controladorAvionesHangares = new ControladorAvionesHangares();
        List<AvionesHangares> avionesHangares = controladorAvionesHangares.consultarAvionesHangares();
        VistaAvionesHangar vistaAvionesHangar = new VistaAvionesHangar();
        VistaHangar vistaHangar = new VistaHangar();

        int opcion;
        do {
            System.out.println("\nBienvenido al sistema administrador del Hangar Número 160");
            System.out.println("-----------------------------------------------------------");
            System.out.println("");
            System.out.println("-----------1.  Consultar datos del hangar------------------");
            System.out.println("-----------2.  Consultar datos de los propietarios---------");
            System.out.println("-----------3.  Consultar últimos aviones registrados-------");
            System.out.println("-----------4.  Registrar propietario-----------------------");
            System.out.println("-----------5.  Registrar nuevo avión dentro del hangar-----");
            System.out.println("-----------0.  Salir---------------------------------------");

            System.out.print("\nDigite una opción: ");
            opcion = objLeer.nextInt();

            switch (opcion) {
                case 1:
                    vistaHangar.activarVista(hangar);
                    break;
                case 2:
                    vistaPropietario.activarVista2(propietarios);
                    break;
                case 3:
                    vistaAvionesHangar.activarVista(avionesHangares);
                    break;
                case 4:
                    Propietario propietario = vistaPropietario.activarVista();
                    controladorPropietario.registrarPropietario(propietario);
                    break;
                case 5:

                    if (hangar.getCupos_disponibles() > 0 && hangar.getCupos_disponibles() < 16) {

                        VistaAvion vistaAvion = new VistaAvion();
                        Avion avion = vistaAvion.activarVista();
                        ControladorAvion controladorAvion = new ControladorAvion();
                        controladorAvion.registrarAvion(avion);

//                        ControladorAvionesHangares controladorAvionesHangares = new ControladorAvionesHangares();
                        controladorAvionesHangares.matricularAvionHangar(avion.getMatricula());

                        controladorHangar.actualizarHangar(hangar);
                    } else {
                        System.out.println("No tenemos cupos disponibles");
                    }
                    break;
                default:
                    System.out.println("Digite una opción válida");
                    break;
            }

        } while (opcion != 0);

    }

}
