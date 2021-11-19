/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcdaparking.modelos;

/**
 *
 * @author 57305
 */
public class Conductor {
    private int cedula;
    private String nombre;
    private int telefono;
    private int celular;
    public String fechaIn;
    public String fechaOut;

    public Conductor() {
    }

    public Conductor(int cedula, String nombre, int telefono, int celular, String fechaIn, String fechaOut) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.celular = celular;
        this.fechaIn = fechaIn;
        this.fechaOut = fechaOut;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }
    
     public String getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(String fechaIn) {
        this.fechaIn = fechaIn;
    }

    public String getFechaOut() {
        return fechaOut;
    }

    public void setFechaOut(String fechaOut) {
        this.fechaOut = fechaOut;
    }
    
    
}
