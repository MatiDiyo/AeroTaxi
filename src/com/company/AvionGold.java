package com.company;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class AvionGold extends Avion implements ServicioCatering {

    private boolean wifi;
    private boolean servicioCatering; //por defecto en true

    public AvionGold() {
        this.setUuid(UUID.randomUUID());
        this.setTarifaFija(6000);
        this.wifi = true;
        this.servicioCatering = true;
    }

    public AvionGold(int capacidadCombustible, double costoPorKm, int capacidadMaximaPasajeros, int velocidadMaxima, Propulsion propulsion, Date fechaUltimoVuelo , boolean wifi ) {
        super(capacidadCombustible, costoPorKm, capacidadMaximaPasajeros, velocidadMaxima, propulsion , fechaUltimoVuelo);
        this.setUuid(UUID.randomUUID());
        this.setTarifaFija(6000);
        this.wifi = wifi;
        this.servicioCatering = true;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
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
        if (!(o instanceof AvionGold)) return false;
        if (!super.equals(o)) return false;
        AvionGold avionGold = (AvionGold) o;
        return isWifi() == avionGold.isWifi() &&
                isServicioCatering() == avionGold.isServicioCatering();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isWifi(), isServicioCatering());
    }

    @Override
    public String toString() {
        return "Avion - Gold" +
                "\n\t-Id: " + getUuid() + "." +
                "\n\t-Capacidad de combustible: " + getCapacidadCombustible() + "." +
                "\n\t-Costo /km: $" + getCostoPorKm() + "." +
                "\n\t-Capacidad maxima de pasajeros: " + getCapacidadMaximaPasajeros() + "." +
                "\n\t-Velocidad maxima: " + getVelocidadMaxima() + "km/h." +
                "\n\t-Tipo de propulsion: " + getPropulsion().getTipo() + "." +
                "\n\t-Tarifa fija: $" + getTarifaFija() + "." +
                "\n\t-Wifi: " + wifi + "." +
                "\n\t-Servicio de catering: " + servicioCatering + ".";
    }
}
