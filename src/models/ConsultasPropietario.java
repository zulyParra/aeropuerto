/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL_COREI5
 */
public class ConsultasPropietario extends DataBase {

    private PreparedStatement sentenciaSQL;
    private ResultSet resultadoConsulta;
    
        public List<Propietario> buscarPropietario() {
        List<Propietario> propietarios = new ArrayList<>();
        Propietario objPropietario = new Propietario();

        Connection conexion = conectarBD();

        String consulta = "SELECT * FROM tblpropietarios";

        try {
            sentenciaSQL = conexion.prepareStatement(consulta);

            resultadoConsulta = sentenciaSQL.executeQuery();
            while (resultadoConsulta.next()) {
                objPropietario = new Propietario();
                objPropietario.setCedula(resultadoConsulta.getString("cedula"));
                objPropietario.setNombre(resultadoConsulta.getString("nombre"));
                objPropietario.setTipo_pago(resultadoConsulta.getInt("tipo_pago"));
                propietarios.add(objPropietario);
                
                
            }return propietarios;
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

    public void insertarPropietario(Propietario propietario) {
        //1. Establecer conexion
        Connection conexion = conectarBD();
        String consulta = "INSERT INTO Tblpropietarios(cedula,nombre,tipo_pago)"
                + "VALUES(?,?,?)";
        //2. Intento llevar datos
        try {
            //3. Asociar el PS a la conexión
            sentenciaSQL = conexion.prepareStatement(consulta);
            //4. Diferenciar la consulta (Personalizar)
            sentenciaSQL.setString(1, propietario.getCedula());
            sentenciaSQL.setString(2, propietario.getNombre());
            sentenciaSQL.setInt(3, propietario.getTipo_pago());
            //5. ejecutar y actualizar
            int resultado = sentenciaSQL.executeUpdate();
            //6. Validar el resultado
            if (resultado > 0) {
                System.out.println("\nPropietario agregado correctamente");
            } else {
                System.out.println("\nProblemas agregado el propietario");
            }
        } catch (Exception error) {
            System.out.println("\nNo se pudo registrar el usuario " + error);
        } finally {
            try {
                conexion.close();
            } catch (Exception error) {
                System.out.println("\nError" + error);
            }

        }
    }
}
