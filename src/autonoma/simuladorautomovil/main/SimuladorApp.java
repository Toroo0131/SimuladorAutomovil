
package autonoma.simuladorautomovil.main;

/**
 *
 * @author SaloméC
 */


import autonoma.simuladorautomovil.models.Vehiculo;

import javax.swing.*;
import java.awt.*;

import autonoma.simmuladorautonoma.exception.VehiculoException;


import javax.swing.JOptionPane;


import javax.swing.JButton;

import javax.swing.JTextArea;

import javax.swing.JFrame;

public class SimuladorApp {
    private final Vehiculo vehiculo;
    private JTextArea estadoArea;

    public SimuladorApp() {
        vehiculo = new Vehiculo();
        crearInterfaz();
    }

    private void crearInterfaz() {
        JFrame ventana = new JFrame("Simulador de Vehículo");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);
        ventana.setLayout(new BorderLayout());

        // Área de estado
        estadoArea = new JTextArea();
        estadoArea.setEditable(false);
        actualizarEstado();

        JScrollPane scroll = new JScrollPane(estadoArea);
        ventana.add(scroll, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 2, 10, 10));

        JButton btnEncender = new JButton("Encender");
        btnEncender.addActionListener(e -> {
            try {
                vehiculo.encender();
                vehiculo.getMotor().arrancar();
            } catch (VehiculoException ex) {
                mostrarError(ex.getMessage());
            }
            actualizarEstado();
        });

        JButton btnApagar = new JButton("Apagar");
        btnApagar.addActionListener(e -> {
            try {
                vehiculo.apagar();
                vehiculo.getMotor().detener();
            } catch (VehiculoException ex) {
                mostrarError(ex.getMessage());
            }
            actualizarEstado();
        });

        JButton btnAcelerar = new JButton("Acelerar");
        btnAcelerar.addActionListener(e -> {
            try {
                String input = JOptionPane.showInputDialog("¿Cuánto deseas acelerar?");
                int valor = Integer.parseInt(input);
                vehiculo.acelerar(valor);
            } catch (NumberFormatException ex) {
                mostrarError(ex.getMessage());
            }
            actualizarEstado();
        });

        JButton btnFrenar = new JButton("Frenar");
        btnFrenar.addActionListener(e -> {
            try {
                String input = JOptionPane.showInputDialog("¿Cuánto deseas frenar?");
                int valor = Integer.parseInt(input);
                vehiculo.frenar(valor);
            } catch (NumberFormatException ex) {
                mostrarError(ex.getMessage());
            }
            actualizarEstado();
        });

        JButton btnRevisarMotor = new JButton("Estado del Motor");
        btnRevisarMotor.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, vehiculo.getMotor().toString());
        });

        JButton btnRevisarLlantas = new JButton("Presión Llantas");
        btnRevisarLlantas.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, vehiculo.getLlantas().toString());
        });

        // Añadir botones al panel
        panelBotones.add(btnEncender);
        panelBotones.add(btnApagar);
        panelBotones.add(btnAcelerar);
        panelBotones.add(btnFrenar);
        panelBotones.add(btnRevisarMotor);
        panelBotones.add(btnRevisarLlantas);

        ventana.add(panelBotones, BorderLayout.SOUTH);
        ventana.setVisible(true);
    }

    private void actualizarEstado() {
        StringBuilder estado = new StringBuilder();
        estado.append("Vehículo ").append(vehiculo.isEncendido() ? "encendido" : "apagado").append("\n");
        estado.append("Velocidad actual: ").append(vehiculo.getVelocidad()).append(" km/h\n");
        estado.append(vehiculo.getMotor().toString()).append("\n");
        estado.append(vehiculo.getLlantas().toString());
        estadoArea.setText(estado.toString());
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimuladorApp::new);
    }
}
