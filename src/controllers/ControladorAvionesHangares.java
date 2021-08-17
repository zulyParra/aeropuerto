/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.AvionesHangares;
import models.ConsultasAvionesHangares;

/**
 *
 * @author DELL_COREI5
 */
public class ControladorAvionesHangares {
    ConsultasAvionesHangares consultasAvionesHangares = new ConsultasAvionesHangares();
    
    public List<AvionesHangares> consultarAvionesHangares() {
        List<AvionesHangares> avionesHangares = consultasAvionesHangares.buscarAvionesHangares();
        return avionesHangares;
    }
    
    public void matricularAvionHangar(String matricula){
        
        consultasAvionesHangares.insertarAvionHangar(matricula);
    }
}
