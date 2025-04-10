
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

    public String isRevisadas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setRevisadas(boolean parseBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String revisar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
