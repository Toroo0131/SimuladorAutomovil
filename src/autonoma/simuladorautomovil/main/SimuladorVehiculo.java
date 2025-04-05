
package autonoma.simuladorautomovil.main;

/**
 *
 * @author SaloméC
 */
package simulador;

import javax.swing.*;

public class SimuladorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Mostrar diálogo de configuración primero
            ConfigDialog configDialog = new ConfigDialog(null);
            configDialog.setVisible(true);
            
            if (configDialog.isConfigurado()) {
                MainFrame mainFrame = new MainFrame(configDialog.getVehiculo());
                mainFrame.setVisible(true);
            } else {
                System.exit(0);
            }
        });
    }
}