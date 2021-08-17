/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ConsultasHangar;
import models.Hangar;
import views.VistaHangar;
        

/**
 *
 * @author DELL_COREI5
 */
public class ControladorHangar {
    private ConsultasHangar consultasHangar= new ConsultasHangar();
    private VistaHangar vistaHangar= new VistaHangar();
    
    public Hangar consultarHangar(){
        Hangar hangar = consultasHangar.buscarHangar();
        return hangar;
    }
    
    public void actualizarHangar(Hangar hangar){
        int cuposDisponiblesAntesMatricula = hangar.getCupos_disponibles();
        int cuposDisponibleDespuesMatricula = cuposDisponiblesAntesMatricula - 1;
        
        int cuposReservadosAntesMatricula = hangar.getCupos_reservados();
        int cuposReservadosDespuesMatricula = cuposReservadosAntesMatricula + 1;
        
        hangar.setCupos_disponibles(cuposDisponibleDespuesMatricula);
        hangar.setCupos_reservados(cuposReservadosDespuesMatricula);
        
        consultasHangar.actualizarhangar(hangar);
    }

}
