/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exception;

/**
 *
 * @author Salo
 */
public class VehiculoApagadoException extends Exception {
        public VehiculoApagadoException() {
        super("El vehículo ya está apagado. No se puede apagar nuevamente.");
    }
}
