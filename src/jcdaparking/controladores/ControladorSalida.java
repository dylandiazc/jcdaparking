/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcdaparking.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import jcdaparking.modelos.Conductor;
import jcdaparking.modelos.ConsultasConductores;
import jcdaparking.modelos.ConsultasVehiculo;
import jcdaparking.modelos.Vehiculo;
import jcdaparking.vistas.VistaIngreso;
import jcdaparking.vistas.VistaSalida;
import jcdaparking.vistas.VistaHome;

/**
 *
 * @author USUARIO
 */
public class ControladorSalida implements ActionListener {
    VistaSalida vistasalida = new VistaSalida();
    Vehiculo vehiculo = new Vehiculo();
    Conductor conductor= new Conductor();
    
    public ControladorSalida( VistaSalida vistasalida, Vehiculo vehiculo, Conductor conductor){
        this.vistasalida=vistasalida;
        this.vehiculo=vehiculo;
        this.conductor=conductor;
        vistasalida.botonSalir.addActionListener(this);
        vistasalida.botonHome.addActionListener(this);
        vistasalida.botonIngreso.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        VistaIngreso vistaingreso = new VistaIngreso();
        VistaHome vistahome = new VistaHome();
        
        
        
        if(ae.getSource()==vistasalida.botonHome){    
            vistahome.setVisible(true);
            vistasalida.setVisible(false);
            
            ControladorHome controladorHome = new ControladorHome(vistahome, vehiculo, conductor);

        }
        
        if(ae.getSource()==vistasalida.botonIngreso){
            vistasalida.setVisible(false);
            vistaingreso.setVisible(true);
            
            ControladorIngreso controladorIngreso = new ControladorIngreso(vistaingreso, vehiculo, conductor);
        }
        
        if(ae.getSource()==vistasalida.botonSalir){
            
            ConsultasVehiculo consultasVehiculo = new ConsultasVehiculo();
        ConsultasConductores consultasConductores = new ConsultasConductores();
        
        vehiculo=consultasVehiculo.buscarVehiculo(vistasalida.cajaPlaca.getText());
        String fechaIn=vehiculo.getFechaIn();
        try{
            Date in = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaIn);
            Date out = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaOut = formato.format(out);
            
            long diferenciaTiempo=out.getTime()-in.getTime();
            TimeUnit unidadTiempo=TimeUnit.MINUTES;
            long tiempoParque=unidadTiempo.convert(diferenciaTiempo, TimeUnit.MILLISECONDS);
            vehiculo.setFechaOut(fechaOut);
            
            if(consultasVehiculo.actualizarVehiculo(vehiculo)){
                JOptionPane.showMessageDialog(null, "Vehiculo retirado");
            }else{
                JOptionPane.showMessageDialog(null, "Fallo retirando vehículo");
            }
            
        }catch(ParseException error){
            System.out.println("upsss..." +error);
        }
           
        }
       
    }
}


        
        
        
       