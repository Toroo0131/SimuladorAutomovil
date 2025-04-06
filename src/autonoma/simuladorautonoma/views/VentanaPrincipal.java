
package autonoma.simuladorautonoma.views;

import autonoma.simmuladorautonoma.exception.VehiculoException;
import autonoma.simuladorautomovil.models.Vehiculo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

    private void mostrarEstado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
/**
 *
 * @author Estudiante
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private Vehiculo vehiculo;
    private JTextArea areaEstado;

    public VentanaPrincipal(Vehiculo vehiculo) {
        vehiculo = new Vehiculo();
        inicializarComponentes();
        mostrarEstado();
    }
    private void inicializarComponentes() {
        setTitle("Simulador de Automóvil");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        areaEstado = new JTextArea();
        areaEstado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaEstado);

        JPanel panelBotones = new JPanel(new GridLayout(3, 2, 10, 10));

        JButton btnEncender = new JButton("Encender");
        btnEncender.addActionListener(this::encenderVehiculo);

        JButton btnApagar = new JButton("Apagar");
        btnApagar.addActionListener(this::apagarVehiculo);

        JButton btnAcelerar = new JButton("Acelerar");
        btnAcelerar.addActionListener(this::acelerarVehiculo);

        JButton btnFrenar = new JButton("Frenar");
        btnFrenar.addActionListener(this::frenarVehiculo);

        JButton btnMotor = new JButton("Estado del Motor");
        btnMotor.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, vehiculo.getMotor().toString());
        });

        JButton btnLlantas = new JButton("Estado de Llantas");
        btnLlantas.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, vehiculo.getLlantas().toString());
        });

        panelBotones.add(btnEncender);
        panelBotones.add(btnApagar);
        panelBotones.add(btnAcelerar);
        panelBotones.add(btnFrenar);
        panelBotones.add(btnMotor);
        panelBotones.add(btnLlantas);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbEncender = new javax.swing.JButton();
        jbApagar = new javax.swing.JButton();
        jbAcelerar = new javax.swing.JButton();
        jbFrenar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbLlantas = new javax.swing.JButton();
        jbMotor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jbEncender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autonoma/simuladorautomovil/images/encender.png"))); // NOI18N
        jbEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEncenderActionPerformed(evt);
            }
        });

        jbApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autonoma/simuladorautomovil/images/apagar.png"))); // NOI18N
        jbApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbApagarActionPerformed(evt);
            }
        });

        jbAcelerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autonoma/simuladorautomovil/images/acelerador.png"))); // NOI18N
        jbAcelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAcelerarActionPerformed(evt);
            }
        });

        jbFrenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autonoma/simuladorautomovil/images/pedal-de-freno.png"))); // NOI18N
        jbFrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFrenarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autonoma/simuladorautomovil/images/car.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbFrenar)
                .addGap(48, 48, 48)
                .addComponent(jbAcelerar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jbEncender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbApagar)
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbFrenar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jbApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jbEncender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAcelerar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jbLlantas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autonoma/simuladorautomovil/images/tires.jpg"))); // NOI18N
        jbLlantas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLlantasActionPerformed(evt);
            }
        });

        jbMotor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autonoma/simuladorautomovil/images/engine.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbLlantas)
                    .addComponent(jbMotor))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jbLlantas)
                .addGap(18, 18, 18)
                .addComponent(jbMotor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Simulador Automovil");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         mostrarEstado();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEncenderActionPerformed
   try {
        vehiculo.encender();
        vehiculo.getMotor().arrancar();
    } catch (VehiculoException ex) {
        mostrarError(ex.getMessage());
    }
    mostrarEstado();
}

        private void mostrarError(String message) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }//GEN-LAST:event_jbEncenderActionPerformed

    private void jbFrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFrenarActionPerformed
    try {
        String input = JOptionPane.showInputDialog(this, "¿Cuánto deseas frenar?");
        int reduccion = Integer.parseInt(input);
        vehiculo.frenar(reduccion);
    } catch (NumberFormatException ex) {
        mostrarError("Debes ingresar un número válido.");
    } catch (VehiculoException ex) {
        mostrarError(ex.getMessage());
    }
    mostrarEstado();

    }//GEN-LAST:event_jbFrenarActionPerformed

    private void jbLlantasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLlantasActionPerformed
      JOptionPane.showMessageDialog(this, vehiculo.getLlantas().toString(), "Estado de Llantas", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbLlantasActionPerformed

    private void jbApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbApagarActionPerformed
    try {
        vehiculo.apagar();
        vehiculo.getMotor().detener();
    } catch (VehiculoException ex) {
        mostrarError(ex.getMessage());
    }
    mostrarEstado();
}

    }//GEN-LAST:event_jbApagarActionPerformed

    private void jbAcelerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcelerarActionPerformed
    try {
        String input = JOptionPane.showInputDialog(this, "¿Cuánto acelerar?");
        int valor = Integer.parseInt(input);
        vehiculo.acelerar(valor);
    } catch (NumberFormatException ex) {
        mostrarError("Ingresa un número válido.");
    } catch (VehiculoException ex) {
        mostrarError(ex.getMessage());
    }
    mostrarEstado();
});
   
    }//GEN-LAST:event_jbAcelerarActionPerformed

    private void mostrarEstado() {
        String estado = "Vehículo " + (vehiculo.isEncendido() ? "encendido" : "apagado") + "\n"
                + "Velocidad actual: " + vehiculo.getVelocidad() + " km/h\n"
                + vehiculo.getMotor().toString() + "\n"
                + vehiculo.getLlantas().toString();
        areaEstado.setText(estado);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaPrincipal::new);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbAcelerar;
    private javax.swing.JButton jbApagar;
    private javax.swing.JButton jbEncender;
    private javax.swing.JButton jbFrenar;
    private javax.swing.JButton jbLlantas;
    private javax.swing.JButton jbMotor;
    // End of variables declaration//GEN-END:variables
}
