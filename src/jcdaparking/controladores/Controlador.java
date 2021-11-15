/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcdaparking.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jcdaparking.modelos.ModeloBD;
import jcdaparking.vistas.Vista;

/**
 *
 * @author 57305
 */
public class Controlador implements ActionListener{
    
    ModeloBD modelo = new ModeloBD();
    Vista vista = new Vista();

    public Controlador(ModeloBD modelo, Vista vista) {
        this.modelo=modelo;
        this.vista=vista;
        vista.boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        modelo.conectar();
    }
    
    
}
