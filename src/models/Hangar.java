/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author DELL_COREI5
 */
public class Hangar {
    private int codigo_angar;
    private int cupo_total;
    private int cupos_disponibles;
    private int cupos_reservados;

    public int getCodigo_angar() {
        return codigo_angar;
    }

    public void setCodigo_angar(int codigo_angar) {
        this.codigo_angar = codigo_angar;
    }

    public int getCupo_total() {
        return cupo_total;
    }

    public void setCupo_total(int cupo_total) {
        this.cupo_total = cupo_total;
    }

    public int getCupos_disponibles() {
        return cupos_disponibles;
    }

    public void setCupos_disponibles(int cupos_disponibles) {
        this.cupos_disponibles = cupos_disponibles;
    }

    public int getCupos_reservados() {
        return cupos_reservados;
    }

    public void setCupos_reservados(int cupos_reservados) {
        this.cupos_reservados = cupos_reservados;
    }
    
    
}
