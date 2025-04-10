
import autonoma.simmuladorautonoma.exception.VehiculoException;
import autonoma.simuladorautomovil.models.Vehiculo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Simulador {
    private final Vehiculo vehiculo;

    public Simulador(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void encender() throws VehiculoException {
        vehiculo.encender();
    }

    public void apagar() throws VehiculoException {
        vehiculo.apagar();
    }

    public void acelerar(double incremento) throws VehiculoException {
        vehiculo.acelerar((int) incremento);
    }

    public void frenar(double decremento) throws VehiculoException {
        vehiculo.frenar((int) decremento);
    }

    public String revisarMotor() throws VehiculoException {
        return vehiculo.getMotor().revisar();
    }

    public String revisarLlantas() throws VehiculoException {
        return vehiculo.getLlantas().revisar();
    }

    public String obtenerEstado() {
        return vehiculo.toString();
    }

   public void guardarEstado() throws IOException {
    String rutaArchivo = "C:\\Users\\Usuario\\Desktop\\POO3\\SimuladorAutomovil\\estadoVehiculo.txt";
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
        writer.write(obtenerEstado());
    }
    }

}
