/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.ConsultasPropietario;
import models.Propietario;

/**
 *
 * @author DELL_COREI5
 */
public class ControladorPropietario {

    private ConsultasPropietario consultasPropietario = new ConsultasPropietario();

    public List<Propietario> consultarPropietario() {
        List<Propietario> propietarios = consultasPropietario.buscarPropietario();
        return propietarios;
    }

    public void registrarPropietario(Propietario propietario) {
        //validaciones
        //??
        consultasPropietario.insertarPropietario(propietario);
    }
}
