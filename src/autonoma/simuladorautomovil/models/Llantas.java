
package autonoma.simuladorautomovil.models;

import autonoma.simmuladorautonoma.exception.PatinajeException;

public class Llantas {
    private double limiteVelocidad;

    public Llantas(double limiteVelocidad) {
        this.limiteVelocidad = limiteVelocidad;
    }

    public double getLimiteVelocidad() {
        return limiteVelocidad;
    }

    public void setLimiteVelocidad(double limiteVelocidad) {
        this.limiteVelocidad = limiteVelocidad;
    }

    public void validarVelocidad(double velocidad) throws PatinajeException {
        if (velocidad > this.limiteVelocidad) {
            throw new PatinajeException();
        }
    }
}
