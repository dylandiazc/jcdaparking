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
public class Vehiculo {
    
    private String placa;
    public String fechaIn;
    public String fechaOut;
    private int valorPagar;
    private int idCedula;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String fechaIn, String fechaOut, int valorPagar, int idCedula) {
        this.placa = placa;
        this.fechaIn = fechaIn;
        this.fechaOut = fechaOut;
        this.valorPagar = valorPagar;
        this.idCedula = idCedula;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public int getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(int valorPagar) {
        this.valorPagar = valorPagar;
    }

    public int getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(int idCedula) {
        this.idCedula = idCedula;
    }
    
    
}
