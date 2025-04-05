
package autonoma.simuladorautomovil.main;

/**
 *
 * @author SaloméC
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimuladorVehiculo {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java SimuladorVehiculo <archivo_configuracion>");
            return;
        }

        try {
            Vehiculo vehiculo = configurarVehiculo(args[0]);
            // Aquí iría el menú/interfaz para controlar el vehículo
            System.out.println("Vehículo configurado correctamente:");
            System.out.println(vehiculo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de configuración: " + e.getMessage());
        } catch (ConfiguracionException e) {
            System.out.println("Error en la configuración: " + e.getMessage());
        }
    }

    private static Vehiculo configurarVehiculo(String archivo) throws IOException, ConfiguracionException {
        String tipoLlantas = null;
        String cilindrajeMotor = null;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.trim().split("\\s+", 2);
                if (partes.length == 2) {
                    if (partes[0].equalsIgnoreCase("llantas")) {
                        tipoLlantas = partes[1].trim();
                    } else if (partes[0].equalsIgnoreCase("motor")) {
                        cilindrajeMotor = partes[1].trim();
                    }
                }
            }
        }

        if (tipoLlantas == null || cilindrajeMotor == null) {
            throw new ConfiguracionException("Archivo de configuración incompleto");
        }

        Llantas llantas = new Llantas(tipoLlantas);
        Motor motor = new Motor(cilindrajeMotor);
        return new Vehiculo(motor, llantas);
    }
}