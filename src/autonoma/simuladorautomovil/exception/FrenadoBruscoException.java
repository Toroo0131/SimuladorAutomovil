/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.exception;

/**
 *
 * @author Salo
 */
public class FrenadoBruscoException extends Exception {
        public FrenadoBruscoException() {
        super("¡Frenado brusco detectado! La intensidad de frenado supera los 60 Km/h.");
    }
}
