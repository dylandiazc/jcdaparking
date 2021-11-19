/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcdaparking.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;
import jcdaparking.modelos.Conductor;
import jcdaparking.modelos.ConsultasVehiculo;
import jcdaparking.modelos.Vehiculo;
import jcdaparking.vistas.VistaHome;
import jcdaparking.vistas.VistaIngreso;
import jcdaparking.vistas.VistaSalida;

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
        vistahome.botonBuscar.addActionListener(this);
        vistahome.botonSalida.addActionListener(this);
        vistahome.botonIngreso.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        VistaIngreso vistaingreso = new VistaIngreso();
        VistaSalida vistasalida = new VistaSalida();
        
        if(ae.getSource()==vistahome.botonSalida){    
            vistahome.setVisible(false);
            vistasalida.setVisible(true);
            
            ControladorSalida controladorSalida = new ControladorSalida(vistasalida, vehiculo, conductor);
            
        }
        
        if(ae.getSource()==vistahome.botonIngreso){
            vistahome.setVisible(false);
            vistaingreso.setVisible(true);
            
            ControladorIngreso controladorIngreso = new ControladorIngreso(vistaingreso, vehiculo, conductor);
        }
        
        if(ae.getSource()==vistahome.botonBuscar){
           ConsultasVehiculo consultasVehiculo = new ConsultasVehiculo();
            String placa=vistahome.cajaPlaca.getText();
        
            if(consultasVehiculo.buscarVehiculo(placa)!=null){
            
                vistahome.setVisible(false);
                vistasalida.setVisible(true);
            
            ControladorSalida controladorSalida = new ControladorSalida(vistasalida, vehiculo, conductor);
            }else{
            
            vistahome.setVisible(false);
            vistaingreso.setVisible(true);
            
            ControladorIngreso controladoringreso = new ControladorIngreso(vistaingreso, vehiculo, conductor);
        }    
        }
        
        
    }
}
