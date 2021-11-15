/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcdaparking;

import jcdaparking.controladores.Controlador;
import jcdaparking.modelos.ModeloBD;
import jcdaparking.vistas.Vista;

/**
 *
 * @author 57305
 */
public class Jcdaparking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModeloBD modelo = new ModeloBD();
        Vista vista = new Vista();
        vista.setVisible(true);
        
        Controlador controlador= new Controlador(modelo, vista);
        
    }
    
}
