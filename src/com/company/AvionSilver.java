package com.company;

import java.util.Objects;
import java.util.UUID;

public class AvionSilver extends Avion implements ServicioCatering{

    private boolean servicioCatering; //por defecto en true

    public AvionSilver(){
        this.setUuid(UUID.randomUUID());
        this.setTarifaFija(4000);
        this.servicioCatering = true;
    }

    public AvionSilver(int capacidadCombustible, double costoPorKm, int capacidadMaximaPasajeros, int velocidadMaxima, Propulsion propulsion){
        super(capacidadCombustible, costoPorKm, capacidadMaximaPasajeros, velocidadMaxima, propulsion);
        this.setUuid(UUID.randomUUID());
        this.setTarifaFija(4000);
        this.servicioCatering = true;
    }

    public boolean isServicioCatering() {
        return servicioCatering;
    }

    public void setServicioCatering(boolean servicioCatering) {
        this.servicioCatering = servicioCatering;
    }

    @Override
    public void catering(boolean cambiar) {
        servicioCatering = cambiar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvionSilver)) return false;
        if (!super.equals(o)) return false;
        AvionSilver that = (AvionSilver) o;
        return isServicioCatering() == that.isServicioCatering();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isServicioCatering());
    }

    @Override
    public String toString() {
        return "Avion - Silver" +
                "\n\t-Id: " + getUuid() + "." +
                "\n\t-Capacidad de combustible: " + getCapacidadCombustible() + "." +
                "\n\t-Costo /km: $" + getCostoPorKm() + "." +
                "\n\t-Capacidad maxima de pasajeros: " + getCapacidadMaximaPasajeros() + "." +
                "\n\t-Velocidad maxima: " + getVelocidadMaxima() + "km/h." +
                "\n\t-Tipo de propulsion: " + getPropulsion().getTipo() + "." +
                "\n\t-Tarifa fija: $" + getTarifaFija() + "." +
                "\n\t-Wifi: No."  +
                "\n\t-Servicio de catering: " + servicioCatering + ".";
    }
}
