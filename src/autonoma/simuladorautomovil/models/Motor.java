/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;



public class Motor {
    private boolean enFuncionamiento;

    public Motor() {
        this.enFuncionamiento = false;
    }

    public boolean isEnFuncionamiento() {
        return enFuncionamiento;
    }

    public void arrancar() {
        this.enFuncionamiento = true;
    }

    public void detener() {
        this.enFuncionamiento = false;
    }

    @Override
    public String toString() {
        return enFuncionamiento ? "Motor en funcionamiento" : "Motor detenido";
    }

    public String isRevisado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setRevisado(boolean parseBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String revisar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
