package com.company;

import java.util.UUID;

public class AvionBronze extends Avion {

    public AvionBronze(){
        this.setUuid(UUID.randomUUID());
        this.setTarifaFija(3000);
    }

    public AvionBronze(int capacidadCombustible, double costoPorKm, int capacidadMaximaPasajeros, int velocidadMaxima, Propulsion propulsion){
        super(capacidadCombustible, costoPorKm, capacidadMaximaPasajeros, velocidadMaxima,propulsion);
        this.setUuid(UUID.randomUUID());
        this.setTarifaFija(3000);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Avion - Bronze" +
                "\n\t-Id: " + getUuid() + "." +
                "\n\t-Capacidad de combustible: " + getCapacidadCombustible() + "." +
                "\n\t-Costo /km: $" + getCostoPorKm() + "." +
                "\n\t-Capacidad maxima de pasajeros: " + getCapacidadMaximaPasajeros() + "." +
                "\n\t-Velocidad maxima: " + getVelocidadMaxima() + "km/h." +
                "\n\t-Tipo de propulsion: " + getPropulsion().getTipo() + "." +
                "\n\t-Tarifa fija: $" + getTarifaFija() + "." +
                "\n\t-Wifi: No."  +
                "\n\t-Servicio de catering: No.";
    }
}
