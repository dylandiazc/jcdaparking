/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcdaparking;

import jcdaparking.controladores.ControladorHome;
import jcdaparking.modelos.Conductor;
import jcdaparking.modelos.Vehiculo;
import jcdaparking.vistas.VistaHome;

/**
 *
 * @author 57305
 */
public class Jcdaparking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        VistaHome vistahome = new VistaHome();
        vistahome.setVisible(true);
        
        Vehiculo vehiculo = new Vehiculo();
        Conductor conductor= new Conductor();
        
        
        ControladorHome controladorhome = new ControladorHome(vistahome,vehiculo,conductor);
    }
    
}
