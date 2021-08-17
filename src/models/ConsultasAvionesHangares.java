/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL_COREI5
 */
public class ConsultasAvionesHangares extends DataBase {

    private PreparedStatement sentenciaSQL;
    private ResultSet resultadoConsulta;

        public List<AvionesHangares> buscarAvionesHangares() {
        List<AvionesHangares> avionesHangares = new ArrayList<>();
        AvionesHangares avionHangar = new AvionesHangares();

        Connection conexion = conectarBD();

        String consulta = "SELECT * FROM tblaviones_hangares";

        try {
            sentenciaSQL = conexion.prepareStatement(consulta);

            resultadoConsulta = sentenciaSQL.executeQuery();
            while (resultadoConsulta.next()) {
                avionHangar = new AvionesHangares();
                avionHangar.setCodigo_hangar(resultadoConsulta.getInt("codigo_hangar"));
                avionHangar.setMatricula(resultadoConsulta.getString("matricula"));
                avionHangar.setFecha_ingreso(resultadoConsulta.getDate("fecha_ingreso"));
                avionHangar.setNumero_celda(resultadoConsulta.getInt("numero_celda"));
                avionesHangares.add(avionHangar);
                
            }return avionesHangares;
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
    
    public void insertarAvionHangar(String matricula) {
        ConsultasHangar consultasHangar = new ConsultasHangar();
        Hangar hangar = new Hangar();
        
        //Obtener fecha actual
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaActual = simpleDateFormat.format(date);
        
        //Rutina para generar el número de celda
        hangar = consultasHangar.buscarHangar();
        
        Connection conexion = conectarBD();

        String consulta = "INSERT INTO Tblaviones_hangares(codigo_hangar,matricula,fecha_ingreso,numero_celda)"
                + "VALUES(?,?,?,?)";

        try {
            sentenciaSQL = conexion.prepareStatement(consulta);
            
            sentenciaSQL.setInt(1,160);
            sentenciaSQL.setString(2,matricula);
            sentenciaSQL.setString(3,fechaActual);
            sentenciaSQL.setInt(4,hangar.getCupos_reservados()+1);

            int resultado = sentenciaSQL.executeUpdate();

            if (resultado > 0) {
                System.out.println("\nRegistro agregado correctamente");
            } else {
                System.out.println("\nProblemas agregando el registro");
            }
        } catch (Exception error) {
            System.out.println("\nError al insertar el registro " + error);
        } finally {
            try {
                conexion.close();
            } catch (Exception error) {
                System.out.println("\nError" + error);
            }

        }
    }
    
}
