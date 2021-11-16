/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcdaparking.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import jcdaparking.modelos.Conductor;
import jcdaparking.modelos.ConsultasConductores;
import jcdaparking.modelos.ConsultasVehiculo;
import jcdaparking.modelos.Vehiculo;
import jcdaparking.vistas.VistaHome;
import jcdaparking.vistas.VistaIngreso;

/**
 *
 * @author 57305
 */
public class ControladorIngreso implements ActionListener {
    
    VistaIngreso vistaingreso = new VistaIngreso();
    Vehiculo vehiculo = new Vehiculo();
    Conductor conductor= new Conductor();
    
    public ControladorIngreso(VistaIngreso vistaingreso, Vehiculo vehiculo, Conductor conductor) {
        
        this.vistaingreso=vistaingreso;
        this.vehiculo=vehiculo;
        this.conductor=conductor;
        vistaingreso.botonEntrar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ConsultasVehiculo consultasVehiculo = new ConsultasVehiculo();
        
        ConsultasConductores consultasConductores = new ConsultasConductores();
        
        vehiculo.setPlaca(vistaingreso.cajaPlaca.getText());
        conductor.setCedula(Integer.parseInt(vistaingreso.cajaCedula.getText()));
        conductor.setNombre(vistaingreso.cajaNombre.getText());
        conductor.setTelefono(Integer.parseInt(vistaingreso.cajaTelefono.getText()));
        conductor.setCelular(Integer.parseInt(vistaingreso.cajaCedula.getText()));
        
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada=formato.format(entrada);
        vehiculo.setFechaIngreso(fechaEntrada);
        
        vehiculo.setPlaca(vistaingreso.cajaPlaca.getText());
        
        if(consultasVehiculo.insertarVehiculo(vehiculo)&&consultasConductores.registrarConductor(conductor)){
            
            JOptionPane.showMessageDialog(null, "Éxito ingresando vehículo");
        
        }else{
            JOptionPane.showMessageDialog(null, "Error ingresando vehículo");
        }
        
    }
    
}
