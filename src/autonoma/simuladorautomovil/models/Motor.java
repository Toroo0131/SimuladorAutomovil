/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import autonoma.simuladorautomovil.exception.CapacidadMotorException;



public class Motor {
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Atributos
    private boolean encendido;
    private double velocidadMaxima;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructor
    public Motor(double velocidadMaxima) {
        this.encendido = false;
        this.velocidadMaxima = velocidadMaxima;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Métodos de acceso

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Métodos
    
    public void encender(){
        this.encendido = true;
    }
    
    public void apagar(){
        this.encendido = false;
    }
    
    
    // Validar velocidad máxima
    public void validarVelocidadMaxima(double velocidad) throws CapacidadMotorException{
        if(velocidad>this.velocidadMaxima){
            System.out.println("Ouch soy el motor y sobrepasaron mi velocidad");
            throw new CapacidadMotorException();
        }
    }
}
