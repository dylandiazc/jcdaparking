/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcdaparking.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import jcdaparking.modelos.Conductor;
import jcdaparking.modelos.ConsultasVehiculo;
import jcdaparking.modelos.Vehiculo;
import jcdaparking.vistas.VistaHome;
import jcdaparking.vistas.VistaIngreso;

/**
 *
 * @author 57305
 */
public class ControladorHome implements ActionListener {
    
    VistaHome vistahome = new VistaHome();
    Vehiculo vehiculo = new Vehiculo();
    Conductor conductor= new Conductor();

    public ControladorHome(VistaHome vistahome, Vehiculo vehiculo, Conductor conductor) {
        
        this.vistahome=vistahome;
        this.vehiculo=vehiculo;
        this.conductor=conductor;
        vistahome.botonIngresar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ConsultasVehiculo consultasVehiculo = new ConsultasVehiculo();
        String placa=vistahome.cajaPlaca.getText();
        
        if(consultasVehiculo.buscarVehiculo(placa)!=null){
            
        }else{
            VistaIngreso vistaingreso = new VistaIngreso();
            vistahome.setVisible(false);
            vistaingreso.setVisible(true);
            
            ControladorIngreso controladoringreso = new ControladorIngreso(vistaingreso, vehiculo, conductor);
        }
        
    }
    
    
    
}
