/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorautomovil.models;

import autonoma.simmuladorautonoma.exception.ConfiguracionException;



public class Motor {
    private String cilindraje;
    private int velocidadMaxima;

    public Motor(String cilindraje) throws ConfiguracionException {
        this.cilindraje = cilindraje;
        switch (cilindraje) {
            case "1000 cc": velocidadMaxima = 100; break;
            case "2000 cc": velocidadMaxima = 160; break;
            case "3000 cc": velocidadMaxima = 220; break;
            default: throw new ConfiguracionException("Cilindraje no válido: " + cilindraje);
        }
    }

    public String getCilindraje() { return cilindraje; }
    public int getVelocidadMaxima() { return velocidadMaxima; }
}