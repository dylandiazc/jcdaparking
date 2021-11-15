/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcdaparking.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 57305
 */
public class ModeloBD {
    
    private String servidorBD="jdbc:mysql://localhost/jcdaparking";
    private String usuarioBD="root";
    private String passwordBD="";

    public ModeloBD() {
        
    }
    
    public Connection conectar(){
        
        Connection conexion=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection(servidorBD,usuarioBD,passwordBD);
            System.out.println("Éxito en la conexión");
            return conexion;
            
        }catch(Exception error){
            System.out.println("ups... no hay conexión "+error);
            return null;
        }
        
    }
    
}
