
package autonoma.simuladorautomovil.models;

/**
 *
 * @author SalomeC
 */

import autonoma.simmuladorautonoma.exception.PatinajeException;
import autonoma.simuladorautomovil.exception.AccidenteException;
import autonoma.simuladorautomovil.exception.CapacidadMotorException;
import autonoma.simuladorautomovil.exception.EstadoInvalidoException;
import autonoma.simuladorautomovil.exception.VehiculoApagadoException;
import autonoma.simuladorautomovil.exception.VehiculoEncendidoException;


public class Vehiculo {

    private Motor motor;
    private Llantas llantas;
    private double velocidadActual;
    private boolean patinando;
    private boolean accidentado;

    public Vehiculo(Motor motor, Llantas llantas) {
        this.motor = motor;
        this.llantas = llantas;
        this.velocidadActual = 0;
        this.patinando = false;
        this.accidentado = false;
    }

    public void encender() throws VehiculoEncendidoException {
        if (motor.isEncendido()) {
            throw new VehiculoEncendidoException();
        }
        motor.encender();
    }

    public void apagar() throws VehiculoApagadoException, AccidenteException {
        if (!motor.isEncendido()) {
            throw new VehiculoApagadoException();
        }
        if (velocidadActual > 60) {
            motor.apagar();
            accidentado = true;
            velocidadActual = 0;
            throw new AccidenteException();
        }
        motor.apagar();
    }

    public void acelerar(double incremento) throws  CapacidadMotorException,EstadoInvalidoException {
        if (!motor.isEncendido()) {
            throw new EstadoInvalidoException();
        }
        if (accidentado) {
            throw new EstadoInvalidoException();
        }

        double nuevaVelocidad = velocidadActual + incremento;

        if (incremento > 30) {
            // Aceleración brusca -> riesgo motor
            motor.validarVelocidadMaxima(nuevaVelocidad);
        }

        if (nuevaVelocidad > motor.getVelocidadMaxima()) {
            accidentado = true;
            velocidadActual = 0;
            motor.apagar();
            throw new CapacidadMotorException();
        }

        velocidadActual = nuevaVelocidad;
    }

    public void frenar(double decremento) throws EstadoInvalidoException, PatinajeException {
        if (!motor.isEncendido()) {
            throw new EstadoInvalidoException();
        }
        if (velocidadActual == 0) {
            throw new EstadoInvalidoException();
        }

        if (decremento > velocidadActual) {
            patinando = true;
            throw new PatinajeException();
        }

        if (decremento > 30) {
            llantas.validarVelocidad(velocidadActual);
        }

        velocidadActual -= decremento;
        if (velocidadActual <= 0) {
            velocidadActual = 0;
            patinando = false;  // Se recupera del patinaje al detenerse
        }
    }

    // Métodos de acceso
    public Motor getMotor() {
        return motor;
    }

    public Llantas getLlantas() {
        return llantas;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public boolean isPatinando() {
        return patinando;
    }

    public boolean isAccidentado() {
        return accidentado;
    }
}
