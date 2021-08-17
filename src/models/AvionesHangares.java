/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author DELL_COREI5
 */
public class AvionesHangares {
    private int codigo_hangar;
    private String matricula;
    private Date fecha_ingreso;
    private int numero_celda;

    public int getCodigo_hangar() {
        return codigo_hangar;
    }

    public void setCodigo_hangar(int codigo_hangar) {
        this.codigo_hangar = codigo_hangar;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getNumero_celda() {
        return numero_celda;
    }

    public void setNumero_celda(int numero_celda) {
        this.numero_celda = numero_celda;
    }
    
    
}
