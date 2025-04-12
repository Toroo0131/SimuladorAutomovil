/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import java.util.List;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;



/**
 *
 * @author Salo
 */
public class LecturaEscrituraConfiguracion {
        /**
     * Lee la configuración del archivo y crea un vehículo con motor y llantas adecuadas.
     */

    public static Vehiculo leerConfiguracion(String rutaArchivo) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        Path archivo = Paths.get(rutaArchivo);
        List<String> lineas = Files.readAllLines(archivo, charset); 

        String tipoLlantas = null;
        String tipoMotor = null;

        for (String linea : lineas) {
            String[] partes = linea.trim().split("\\s+");
            if (partes.length >= 2) {
                if (partes[0].equalsIgnoreCase("llantas")) {
                    tipoLlantas = partes[1];
                } else if (partes[0].equalsIgnoreCase("motor")) {
                    tipoMotor = partes[1];
                }
            }
        }

        if (tipoLlantas == null || tipoMotor == null) {
            throw new IllegalArgumentException("El archivo de configuración no contiene todos los datos necesarios.");
        }

        // ✅ Llamadas a métodos de la clase ConfiguracionVehi
        Llantas llantas = ConfiguracionVehi.crearLlantas(tipoLlantas);
        Motor motor = ConfiguracionVehi.crearMotor(Integer.parseInt(tipoMotor));
        return new Vehiculo(motor, llantas);
    }

    public static void escribirConfiguracion(String rutaArchivo, Vehiculo vehiculo) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        Path archivo = Paths.get(rutaArchivo);

        List<String> lineas = new ArrayList<>();

        // ✅ Llamadas correctas
        lineas.add("llantas " + ConfiguracionVehi.obtenerTipoLlantas(vehiculo.getLlantas().getLimiteVelocidad()));
        lineas.add("motor " + ConfiguracionVehi.obtenerCilindrajeDesdeVelocidad(vehiculo.getMotor().getVelocidadMaxima()));

        Files.write(archivo, lineas, charset);
    }
}
