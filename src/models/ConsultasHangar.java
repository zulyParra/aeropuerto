/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

/**
 *
 * @author DELL_COREI5
 */
public class ConsultasHangar extends DataBase {

    private PreparedStatement sentenciaSQL;
    private ResultSet resultadoConsulta;

    public Hangar buscarHangar() {
        Hangar objHangar = new Hangar();

        Connection conexion = conectarBD();

        String consulta = "SELECT * FROM Tblhangares";

        try {
            sentenciaSQL = conexion.prepareStatement(consulta);

            resultadoConsulta = sentenciaSQL.executeQuery();

            if (resultadoConsulta.next()) {
                objHangar.setCodigo_angar(resultadoConsulta.getInt("codigo_hangar"));
                objHangar.setCupo_total(resultadoConsulta.getInt("cupo_total"));
                objHangar.setCupos_disponibles(resultadoConsulta.getInt("cupos_disponibles"));
                objHangar.setCupos_reservados(resultadoConsulta.getInt("cupos_reservados"));

                return objHangar;
            } else {
                return null;
            }
        } catch (Exception error) {
            System.out.println("Error consultando registro " + error);
            return null;
        } finally {
            try {
                conexion.close();
            } catch (Exception error) {
                System.out.println("Error" + error);
            }
        }
    }
    
        public void actualizarhangar(Hangar hangar){
        Connection conexion = conectarBD();
        String consulta = "UPDATE Tblhangares SET cupos_disponibles = ?,cupos_reservados=? WHERE codigo_hangar=160";
        
        try {
            sentenciaSQL = conexion.prepareStatement(consulta);
            
            sentenciaSQL.setInt(1, hangar.getCupos_disponibles());
            sentenciaSQL.setInt(2, hangar.getCupos_reservados());
            
            int resultado = sentenciaSQL.executeUpdate();

            if (resultado > 0) {
                System.out.println("\nHangar actualizado correctamente");
            } else {
                System.out.println("\nProblemas actualizando el hangar");
            }
        } catch (Exception error) {
            System.out.println("\nError al insertar el registro " + error);
        }finally {
            try {
                conexion.close();
            } catch (Exception error) {
                System.out.println("\nError" + error);
            }

        }
    }
}
