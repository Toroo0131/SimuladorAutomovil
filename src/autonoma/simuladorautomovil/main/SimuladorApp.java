
package autonoma.simuladorautomovil.main;

import autonoma.simuladorautomovil.models.ConfiguracionVehi;
import autonoma.simuladorautomovil.models.Simulador;
import autonoma.simuladorautomovil.models.Vehiculo;
import autonoma.simuladorautomovil.views.Ventana;
import autonoma.simuladorautomovil.views.config;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Salo
 */
public class SimuladorApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       config configDialog = new config(null, true);
        configDialog.setVisible(true);

        try {
            Vehiculo vehiculo = ConfiguracionVehi.cargarVehiculo("src/autonoma/simuladorAutomovil/txt/conf.txt");
            Simulador simulador = new Simulador(vehiculo);
            new Ventana(simulador).setVisible(true);
        } catch (IOException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el vehículo: " + ex.getMessage());
        }
    }
        
    }
  
