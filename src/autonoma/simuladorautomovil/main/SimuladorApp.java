
package autonoma.simuladorautomovil.main;

/**
 *
 * @author SaloméC
 */


import autonoma.simmuladorautonoma.exception.ConfiguracionException;
import autonoma.simuladorautomovil.models.Llantas;
import autonoma.simuladorautomovil.models.Motor;
import autonoma.simuladorautomovil.models.Vehiculo;
import autonoma.simuladorautonoma.views.VentanaPrincipal;
import javax.swing.*;

public class SimuladorApp {
    public static void main(String[] args) {
        try {
            // Configurar vehículo (ejemplo)
            Motor motor = new Motor("2000 cc");
            Llantas llantas = new Llantas("Bonitas");
            Vehiculo vehiculo = new Vehiculo(motor, llantas);
            
            // Crear y mostrar ventana
            SwingUtilities.invokeLater(() -> {
                VentanaPrincipal ventana = new VentanaPrincipal(vehiculo);
                ventana.setVisible(true);
            });
            
        } catch (ConfiguracionException e) {
            JOptionPane.showMessageDialog(null, "Error de configuración: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}