/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

/**
 *
 * @author SalomeC
 */

import autonoma.simmuladorautonoma.exception.VehiculoException;

public class Vehiculo {
    private Motor motor;
    private Llantas llantas;
    private boolean encendido;
    private int velocidad;
    private boolean patinando;
    private boolean accidentado;

    public Vehiculo(Motor motor, Llantas llantas) {
        this.motor = motor;
        this.llantas = llantas;
        this.encendido = false;
        this.velocidad = 0;
        this.patinando = false;
        this.accidentado = false;
    }

    public void encender() throws VehiculoException {
        if (accidentado) throw new VehiculoException("El vehículo está accidentado");
        if (encendido) throw new VehiculoException("El vehículo ya está encendido");
        encendido = true;
    }

    public void apagar() throws VehiculoException {
        if (!encendido) throw new VehiculoException("El vehículo ya está apagado");
        if (velocidad > 60) {
            accidentar("Apagado a alta velocidad");
            throw new VehiculoException("¡Accidente! No se puede apagar a más de 60 km/h");
        }
        encendido = false;
        velocidad = 0;
    }

    public void acelerar(int incremento) throws VehiculoException {
        if (!encendido) throw new VehiculoException("El vehículo está apagado");
        if (accidentado) throw new VehiculoException("El vehículo está accidentado");
        if (patinando) throw new VehiculoException("El vehículo está patinando");

        int nuevaVelocidad = velocidad + incremento;
        if (nuevaVelocidad > motor.getVelocidadMaxima()) {
            accidentar("Exceso de velocidad del motor");
            throw new VehiculoException("¡Accidente! Velocidad máxima excedida");
        }
        velocidad = nuevaVelocidad;
    }

    public void frenar(int decremento) throws VehiculoException {
        if (!encendido) throw new VehiculoException("El vehículo está apagado");
        if (accidentado) throw new VehiculoException("El vehículo está accidentado");
        if (patinando) throw new VehiculoException("El vehículo está patinando");
        if (velocidad == 0) return;

        boolean frenadoBrusco = decremento > 30;
        if (frenadoBrusco && velocidad > llantas.getLimitePermitido()) {
            patinar();
            throw new VehiculoException("¡Patinando! Frenado brusco a alta velocidad");
        }

        if (decremento > velocidad) {
            patinar();
            throw new VehiculoException("¡Patinando! Frenado demasiado fuerte");
        }

        velocidad = Math.max(0, velocidad - decremento);
        if (velocidad == 0) patinando = false;
    }

    private void accidentar(String razon) {
        velocidad = 0;
        encendido = false;
        accidentado = true;
    }

    private void patinar() {
        patinando = true;
    }

    // Getters
    public boolean isEncendido() { return encendido; }
    public int getVelocidad() { return velocidad; }
    public boolean isPatinando() { return patinando; }
    public boolean isAccidentado() { return accidentado; }
    public Motor getMotor() { return motor; }
    public Llantas getLlantas() { return llantas; }

    @Override
    public String toString() {
        return String.format("Estado: %s | Velocidad: %d km/h | %s | %s",
            encendido ? "ENCENDIDO" : "APAGADO",
            velocidad,
            patinando ? "PATINANDO" : "Control normal",
            accidentado ? "¡ACCIDENTADO!" : "Operativo");
    }
}