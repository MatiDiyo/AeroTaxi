package com.company;

import java.util.UUID;

public class AvionGold extends Avion implements ServicioCatering {

    private boolean wifi;
    private boolean servicioCatering; //por defecto en true

    public AvionGold(boolean wifi) {
        this.setUuid(UUID.randomUUID());
        this.setTarifaFija(6000);
        this.wifi = wifi;
        this.servicioCatering = true;
    }

    public AvionGold(int capacidadCombustible, double costoPorKm, int capacidadMaximaPasajeros, int velocidadMaxima, Propulsion propulsion, boolean wifi) {
        super(capacidadCombustible, costoPorKm, capacidadMaximaPasajeros, velocidadMaxima, propulsion);
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
