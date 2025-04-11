/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautonoma.utils;



import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerArchivo {
    private static final String RUTA = "C:\\Users\\Usuario\\Desktop\\POO3\\SimuladorAutomovil\\registro.txt";
    private static final String rutaArchivo = "C:\\Users\\Usuario\\Desktop\\POO3\\SimuladorAutomovil\\estadoVehiculo.txt";
    
    public static void guardar(String mensaje) {
        try (PrintWriter out = new PrintWriter(new FileWriter(RUTA, true))) {
            out.println(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
