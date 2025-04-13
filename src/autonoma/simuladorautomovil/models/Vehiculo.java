
package autonoma.simuladorautomovil.models;

/**
 *
 * @author SalomeC
 */


import autonoma.simuladorautomovil.exception.EstadoInvalidoException;
import autonoma.simuladorautomovil.exception.VehiculoApagadoException;



public class Vehiculo {
private boolean encendido;
    private double velocidad;
    private Motor motor;
    private Llantas llantas;

    public Vehiculo(Motor motor, Llantas llantas) {
        this.motor = motor;
        this.llantas = llantas;
        this.encendido = false;
        this.velocidad = 0;
    }

    public void encender() throws EstadoInvalidoException {
        if (encendido) {
            throw new EstadoInvalidoException();
        }
        encendido = true;
    }

    public void apagar() throws EstadoInvalidoException {
        if (!encendido) {
            throw new EstadoInvalidoException();
        }
        if (velocidad > 0) {
            throw new EstadoInvalidoException();
        }
        encendido = false;
    }

    public void acelerar(double incremento) throws VehiculoApagadoException {
        if (!encendido) throw new VehiculoApagadoException();

        double nuevaVelocidad = velocidad + incremento;
        double maxPermitida = Math.min(motor.getVelocidadMaxima(), llantas.getVelocidadLimite());

        if (nuevaVelocidad > maxPermitida) {
            velocidad = maxPermitida;
        } else {
            velocidad = nuevaVelocidad;
        }
    }

    public void frenar(double decremento) throws VehiculoApagadoException {
        if (!encendido) throw new VehiculoApagadoException();

        velocidad -= decremento;
        if (velocidad < 0) velocidad = 0;
    }

    public void frenarBruscamente() throws VehiculoApagadoException {
        if (!encendido) throw new VehiculoApagadoException();
        velocidad = 0;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public Motor getMotor() {
        return motor;
    }

    public Llantas getLlantas() {
        return llantas;
    }
}