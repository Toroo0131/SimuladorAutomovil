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
    
   private Vehiculo vehiculo;

    public Simulador(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
