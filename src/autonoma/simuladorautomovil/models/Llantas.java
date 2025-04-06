
package autonoma.simuladorautomovil.models;



public class Llantas {
    private int presion;

    public Llantas() {
        this.presion = 32; // Valor por defecto en psi
    }

    public int getPresion() {
        return presion;
    }

    public void inflar(int cantidad) {
        this.presion += cantidad;
    }

    public void desinflar(int cantidad) {
        this.presion = Math.max(0, this.presion - cantidad);
    }

    @Override
    public String toString() {
        return "Presión actual de las llantas: " + presion + " psi";
    }
}
