/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.Avion;
import models.ConsultasAvion;

/**
 *
 * @author DELL_COREI5
 */
public class ControladorAvion {
    private ConsultasAvion consultasAvion = new ConsultasAvion();
    public void registrarAvion(Avion avion){
        consultasAvion.insertarAvion(avion);
    }
}
