
package autonoma.simuladorautomovil.models;

/**
 *
 * @author SalomeC
 */

import autonoma.simmuladorautonoma.exception.VehiculoException;


public class Vehiculo {
    private boolean encendido;
    private int velocidad;
    private Motor motor;
    private Llantas llantas;

    public Vehiculo() {
        this.encendido = false;
        this.velocidad = 0;
        this.motor = new Motor();
        this.llantas = new Llantas();
    }

    public boolean isEncendido() {
        return encendido;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public Motor getMotor() {
        return motor;
    }

    public Llantas getLlantas() {
        return llantas;
    }

    public void encender() throws VehiculoException {
        if (encendido) {
            throw new VehiculoException("El vehículo ya esta encendido.");
        }
        encendido = true;
    }

    public void apagar() throws VehiculoException {
        if (!encendido) {
            throw new VehiculoException("El vehículo ya esta apagado.");
        }
        if (velocidad > 0) {
            throw new VehiculoException("No se puede apagar el vehículo en movimiento.");
        }
        encendido = false;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void acelerar(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void frenar(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
