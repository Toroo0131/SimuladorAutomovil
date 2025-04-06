
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

    public void encender() throws VehiculoException {
        if (encendido) {
            throw new VehiculoException("El vehículo ya está encendido.");
        }
        encendido = true;
    }

    public void apagar() throws VehiculoException {
        if (!encendido) {
            throw new VehiculoException("El vehículo ya está apagado.");
        }
        if (velocidad > 0) {
            throw new VehiculoException("No se puede apagar el vehículo en movimiento.");
        }
        encendido = false;
    }

    public void acelerar(int incremento) throws VehiculoException {
        if (!encendido) {
            throw new VehiculoException("Debe encender el vehículo primero.");
        }
        if (incremento <= 0) {
            throw new VehiculoException("El incremento debe ser positivo.");
        }
        velocidad += incremento;
    }

    public void frenar(int decremento) throws VehiculoException {
        if (!encendido) {
            throw new VehiculoException("Debe encender el vehículo primero.");
        }
        if (decremento <= 0) {
            throw new VehiculoException("El decremento debe ser positivo.");
        }
        if (decremento > velocidad) {
            throw new VehiculoException("No puede frenar más de la velocidad actual.");
        }
        velocidad -= decremento;
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
}
