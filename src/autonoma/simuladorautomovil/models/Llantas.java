/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import autonoma.simmuladorautonoma.exception.ConfiguracionException;



public class Llantas {
    private String tipo;
    private int limitePermitido;

    public Llantas(String tipo) throws ConfiguracionException {
        this.tipo = tipo;
        switch (tipo) {
            case "Buenas": limitePermitido = 110; break;
            case "Bonitas": limitePermitido = 70; break;
            case "Baratas": limitePermitido = 50; break;
            default: throw new ConfiguracionException("Tipo de llantas no válido: " + tipo);
        }
    }

    public String getTipo() { return tipo; }
    public int getLimitePermitido() { return limitePermitido; }
}