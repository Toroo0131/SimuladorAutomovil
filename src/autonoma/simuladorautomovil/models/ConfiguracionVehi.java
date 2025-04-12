/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Salo
 */
public class ConfiguracionVehi {
     public static Vehiculo cargarVehiculo(String archivoConfiguracion) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivoConfiguracion));
        String linea;
        Llantas llantas = null;
        Motor motor = null;

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(";");
            if (partes.length < 2) continue;

            switch (partes[0].toLowerCase()) {
                case "llantas":
                    llantas = crearLlantas(partes[1]);
                    break;
                case "motor":
                    motor = crearMotor(Integer.parseInt(partes[1]));
                    break;
            }
        }
        br.close();

        if (motor == null || llantas == null) {
            throw new IllegalArgumentException("Falta configuración de motor o llantas.");
        }

        return new Vehiculo(motor, llantas);
    }

    /**
     * Crea un objeto Llantas según el tipo textual recibido.
     */
    public static Llantas crearLlantas(String tipo) {
        switch (tipo.toLowerCase()) {
            case "buenas":
                return new Llantas(110);
            case "bonitas":
                return new Llantas(70);
            case "baratas":
                return new Llantas(50);
            default:
                throw new IllegalArgumentException("Tipo de llantas no válido: " + tipo);
        }
    }

    /**
     * Crea un objeto Motor según el cilindraje recibido.
     */
    public static Motor crearMotor(int cilindraje) {
        switch (cilindraje) {
            case 1000:
                return new Motor(100);
            case 2000:
                return new Motor(160);
            case 3000:
                return new Motor(220);
            default:
                throw new IllegalArgumentException("Cilindraje no válido: " + cilindraje);
        }
    }
     public static int obtenerCilindrajeDesdeVelocidad(double velocidadMaxima) {
        if (velocidadMaxima == 100) {
            return 1000;
        } else if (velocidadMaxima == 160) {
            return 2000;
        } else if (velocidadMaxima == 220) {
            return 3000;
        } else {
            throw new IllegalArgumentException("Velocidad máxima no válida: " + velocidadMaxima);
        }
    }

    // 🔥 MÉTODO NUEVO: lo pegas aquí
    public static String obtenerTipoLlantas(double limiteVelocidad) {
        if (limiteVelocidad == 110) {
            return "buenas";
        } else if (limiteVelocidad == 70) {
            return "bonitas";
        } else if (limiteVelocidad == 50) {
            return "baratas";
        } else {
            throw new IllegalArgumentException("Límite de velocidad no reconocido: " + limiteVelocidad);
        }
    }
}