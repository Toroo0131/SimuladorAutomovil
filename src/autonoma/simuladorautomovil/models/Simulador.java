/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import autonoma.simuladorautomovil.exception.AccidenteException;
import autonoma.simuladorautomovil.exception.CapacidadMotorException;
import autonoma.simuladorautomovil.exception.EstadoInvalidoException;
import autonoma.simuladorautomovil.exception.VehiculoApagadoException;
import autonoma.simuladorautomovil.exception.VehiculoEncendidoException;


/**
 *
 * @author Salo
 */
public class Simulador {
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Atributos
    private Vehiculo vehiculo;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructor

    public Simulador(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Métodos
    public void encenderVehiculo() throws VehiculoEncendidoException{
        vehiculo.encender();
    }
    
    public void apagarVehiculo() throws VehiculoApagadoException, AccidenteException{
        vehiculo.apagar();
    }
    
    public void acelerarVehiculo(double velocidad)throws CapacidadMotorException, VehiculoApagadoException, EstadoInvalidoException{
       vehiculo.acelerar(velocidad);
       
    }  
}
