/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

/**
 *
 * @author Salo
 */
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
        if (accidentado) {
            throw new VehiculoException("El vehículo está accidentado y no puede encenderse");
        }
        if (encendido) {
            throw new VehiculoException("El vehículo ya está encendido");
        }
        encendido = true;
        System.out.println("Vehículo encendido");
    }

    public void apagar() throws VehiculoException {
        if (!encendido) {
            throw new VehiculoException("El vehículo ya está apagado");
        }
        if (velocidad > 60) {
            accidentar("El vehículo se apagó a alta velocidad");
            throw new VehiculoException("El vehículo se accidentó al apagarse a alta velocidad");
        }
        encendido = false;
        velocidad = 0;
        System.out.println("Vehículo apagado");
    }

    public void acelerar(int incremento) throws VehiculoException {
        if (!encendido) {
            throw new VehiculoException("El vehículo está apagado y no puede acelerar");
        }
        if (accidentado) {
            throw new VehiculoException("El vehículo está accidentado");
        }
        if (patinando) {
            throw new VehiculoException("El vehículo está patinando, no se puede acelerar hasta detenerse");
        }

        int nuevaVelocidad = velocidad + incremento;
        if (nuevaVelocidad > motor.getVelocidadMaxima()) {
            accidentar("El vehículo excedió la velocidad máxima del motor");
            throw new VehiculoException("El motor no soporta esa velocidad");
        }

        velocidad = nuevaVelocidad;
        System.out.println("Acelerando. Velocidad actual: " + velocidad + " km/h");
    }

    public void frenar(int decremento) throws VehiculoException {
        if (!encendido) {
            throw new VehiculoException("El vehículo está apagado y no puede frenar");
        }
        if (accidentado) {
            throw new VehiculoException("El vehículo está accidentado");
        }
        if (patinando) {
            throw new VehiculoException("El vehículo está patinando, no se puede frenar más hasta detenerse");
        }
        if (velocidad == 0) {
            System.out.println("El vehículo ya está detenido");
            return;
        }

        boolean frenadoBrusco = decremento > 30;
        
        if (frenadoBrusco && velocidad > llantas.getLimitePermitido()) {
            patinar("Frenado brusco a alta velocidad");
            throw new VehiculoException("El vehículo patinó por frenado brusco a alta velocidad");
        }
        
        if (decremento > velocidad) {
            patinar("Frenado con intensidad mayor a la velocidad actual");
            throw new VehiculoException("El vehículo patinó por exceso de frenado");
        }

        velocidad = Math.max(0, velocidad - decremento);
        if (velocidad == 0) {
            patinando = false; // Se recupera el control al detenerse
        }
        System.out.println("Frenando. Velocidad actual: " + velocidad + " km/h");
    }

    private void accidentar(String razon) {
        velocidad = 0;
        encendido = false;
        accidentado = true;
        System.out.println("¡ACCIDENTE! Razón: " + razon);
    }

    private void patinar(String razon) {
        patinando = true;
        System.out.println("¡PATINANDO! Razón: " + razon);
    }

    @Override
    public String toString() {
        return String.format("Estado del vehículo:%n" +
                           "- Motor: %s (Vel. máx: %d km/h)%n" +
                           "- Llantas: %s (Límite: %d km/h)%n" +
                           "- Encendido: %b%n" +
                           "- Velocidad: %d km/h%n" +
                           "- Patinando: %b%n" +
                           "- Accidentado: %b",
                           motor.getCilindraje(), motor.getVelocidadMaxima(),
                           llantas.getTipo(), llantas.getLimitePermitido(),
                           encendido, velocidad, patinando, accidentado);
    }
}