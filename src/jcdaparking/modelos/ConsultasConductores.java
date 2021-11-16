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
public class ConsultasConductores extends ModeloBD {
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    Connection conexion=conectar();
    public boolean registrarConductor(Conductor conductor){
        
        String query="INSERT INTO conductores(cedula,nombre,telefono,celular) "
                + "VALUES (?,?,?,?)";
        
        try{
            consultaSQL=conexion.prepareStatement(query);
            
            consultaSQL.setInt(1, conductor.getCedula());
            consultaSQL.setString(2, conductor.getNombre());
            consultaSQL.setInt(3, conductor.getTelefono());
            consultaSQL.setInt(4, conductor.getCelular());
            
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
    
    public Conductor buscarConductor(int cedula){
       
        String query="SELECT * FROM conductores WHERE cedula=?";
        
        try{
            consultaSQL=conexion.prepareStatement(query);
            consultaSQL.setInt(1, cedula);
            resultadoSQL=consultaSQL.executeQuery();
            Conductor conductor=new Conductor();
            
            if(resultadoSQL.next()){
                conductor.setCedula(resultadoSQL.getInt("cedula"));
                conductor.setNombre(resultadoSQL.getString("nombre"));
                conductor.setCelular(resultadoSQL.getInt("celular"));
                conductor.setTelefono(resultadoSQL.getInt("telefono"));
                return conductor;
            
            }else{
                return null;
            }
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return null;
        }
    }
}


