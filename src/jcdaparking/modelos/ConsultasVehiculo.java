/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcdaparking.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 57305
 */
public class ConsultasVehiculo extends ModeloBD {
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    Connection conexion=conectar();
    
    public boolean insertarVehiculo(Vehiculo vehiculo){
        
        String query="INSERT INTO vehiculos(placa,fecha_ingreso,fecha_salida,valor_pagar,id_cedula) "
                + "VALUES (?,?,?,?,?)";
        
        try{
            
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setString(1, vehiculo.getPlaca());
            consultaSQL.setString(2, vehiculo.getFechaIn());
            consultaSQL.setString(3, vehiculo.getFechaOut());
            consultaSQL.setInt(4, vehiculo.getValorPagar());
            consultaSQL.setInt(5, vehiculo.getIdCedula());
            int resultado=consultaSQL.executeUpdate();
            
            if(resultado>0){
                return true;
            }else{
                return false;
            }
        
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return false;  
        }
    }
    
    public Vehiculo buscarVehiculo(String placa){
        
        String query="SELECT * FROM vehiculos WHERE placa=?";
        
        try{
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setString(1, placa);
            
            resultadoSQL=consultaSQL.executeQuery();
            
            Vehiculo vehiculo = new Vehiculo();
            
            if(resultadoSQL.next()){
                vehiculo.setPlaca(resultadoSQL.getString("placa"));
                vehiculo.setFechaIn(resultadoSQL.getString("fecha_ingreso"));
                vehiculo.setFechaOut(resultadoSQL.getString("fecha_salida"));
                vehiculo.setValorPagar(resultadoSQL.getInt("valor_pagar"));
                vehiculo.setIdCedula(resultadoSQL.getInt("id_cedula"));
                return vehiculo;
                
            }else{
                return null;
            }
        
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return null;
        }
    }
    
    
    public boolean actualizarVehiculo(Vehiculo vehiculo){
        String query ="UPDATE vehiculos SET fecha_salida=? WHERE placa=?";
        
        try{
            consultaSQL=conexion.prepareStatement(query);
            consultaSQL.setString(1,vehiculo.getFechaOut());
            consultaSQL.setString(2,vehiculo.getPlaca());
            int resultado=consultaSQL.executeUpdate();
            
            if(resultado>0){
                return true;
            }else{
                return false;
            }
            
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return false;
        }
    }
}
