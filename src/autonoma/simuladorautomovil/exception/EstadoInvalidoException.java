/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exception;

/**
 *
 * @author Salo
 */
public class EstadoInvalidoException extends Exception{
    public EstadoInvalidoException() {
        super("La acción solicitada no es válida en el estado actual del vehículo.");
    }

    
}
