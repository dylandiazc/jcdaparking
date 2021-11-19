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
import jcdaparking.vistas.VistaSalida;

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
        vistaingreso.botonRegistrar.addActionListener(this);
        vistaingreso.botonHome.addActionListener(this);
        vistaingreso.botonSalida.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        VistaHome vistahome = new VistaHome();
        VistaSalida vistasalida = new VistaSalida();
        
        if(ae.getSource()==vistaingreso.botonSalida){    
            vistaingreso.setVisible(false);
            vistasalida.setVisible(true);
            
            ControladorSalida controladorSalida = new ControladorSalida(vistasalida, vehiculo, conductor);
            
        }
        
        if(ae.getSource()==vistaingreso.botonHome){    
            vistaingreso.setVisible(false);
            vistahome.setVisible(true);
            
            ControladorHome controladorHome = new ControladorHome(vistahome, vehiculo, conductor);
            
        }
        
        if(ae.getSource()==vistaingreso.botonRegistrar){    
            
                ConsultasVehiculo consultasVehiculo = new ConsultasVehiculo();
                ConsultasConductores consultasConductores = new ConsultasConductores();


                conductor.setCedula(Integer.parseInt(vistaingreso.cajaCedula.getText()));
                conductor.setNombre(vistaingreso.cajaNombre.getText());
                conductor.setTelefono(Integer.parseInt(vistaingreso.cajaFijo.getText()));
                conductor.setCelular(Integer.parseInt(vistaingreso.cajaCelular.getText()));

                Date entrada = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaEntrada=formato.format(entrada);
                vehiculo.setFechaIn(fechaEntrada);

                vehiculo.setPlaca(vistaingreso.cajaPlaca.getText());
                vehiculo.setValorPagar(0);
                vehiculo.setIdCedula(Integer.parseInt(vistaingreso.cajaCedula.getText()));

                if(consultasConductores.registrarConductor(conductor)&&consultasVehiculo.insertarVehiculo(vehiculo)){

                    JOptionPane.showMessageDialog(null, "Éxito ingresando vehículo");

                }else{
                    JOptionPane.showMessageDialog(null, "Error ingresando vehículo");
                }
            
        }
        
        
        
    }
    
}
