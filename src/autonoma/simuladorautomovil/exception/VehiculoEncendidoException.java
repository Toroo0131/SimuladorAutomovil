/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exception;

/**
 *
 * @author Salo
 */
public class VehiculoEncendidoException extends Exception {
       public VehiculoEncendidoException() {
        super("El vehículo ya está encendido. No se puede encender nuevamente.");
    } 
}
