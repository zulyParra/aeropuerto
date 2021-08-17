/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author DELL_COREI5
 */
public class ConsultasAvion extends DataBase {

    private PreparedStatement sentenciaSQL;

    public void insertarAvion(Avion avion) {

        Connection conexion = conectarBD();
        String consulta = "INSERT INTO Tblaviones(matricula,modelo,cedula,tipo_contrato)"
                + "VALUES(?,?,?,?)";

        try {

            sentenciaSQL = conexion.prepareStatement(consulta);

            sentenciaSQL.setString(1, avion.getMatricula());
            sentenciaSQL.setString(2, avion.getModelo());
            sentenciaSQL.setString(3, avion.getCedula());
            sentenciaSQL.setInt(4, avion.getTipo_contrato());

            int resultado = sentenciaSQL.executeUpdate();

            if (resultado > 0) {
                System.out.println("\nAvión agregado correctamente");
            } else {
                System.out.println("\nProblemas agregando el avión");
            }
        } catch (Exception error) {
            System.out.println("\nNo se pudo registrar el avión " + error);
        } finally {
            try {
                conexion.close();
            } catch (Exception error) {
                System.out.println("\nError" + error);
            }

        }
    }
}
