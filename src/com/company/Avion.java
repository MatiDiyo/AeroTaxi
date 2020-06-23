package com.company;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Avion {

    private UUID uuid;
    private int capacidadCombustible;
    private double costoPorKm; // entre 150 y 300
    private int capacidadMaximaPasajeros;
    private int velocidadMaxima;
    private Propulsion propulsion;
    //private boolean servicioCatering; usaremos una interface para el catering
    private int tarifaFija;
    private Date fechaUltimoVuelo;

    private static final int COSTO_MINIMO_POR_KM = 150;
    private static final int COSTO_MAXIMO_POR_KM = 300;

    public Avion(){}

    //constructor con tarifa por defecto para las herencias
    public Avion(int capacidadCombustible, double costoPorKm, int capacidadMaximaPasajeros, int velocidadMaxima, Propulsion propulsion , Date fechaUltimoVuelo) {
        this.uuid = UUID.randomUUID();
        this.capacidadCombustible = capacidadCombustible;
        this.costoPorKm = costoPorKm;
        this.capacidadMaximaPasajeros = capacidadMaximaPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.propulsion = propulsion;
        this.fechaUltimoVuelo = fechaUltimoVuelo;
    }

    //contructor con tarifa modificable
    public Avion(int capacidadCombustible, double costoPorKm, int capacidadMaximaPasajeros, int velocidadMaxima, Propulsion propulsion, int tarifaFija) {
        this.uuid = UUID.randomUUID();
        this.capacidadCombustible = capacidadCombustible;
        this.costoPorKm = costoPorKm;
        this.capacidadMaximaPasajeros = capacidadMaximaPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.propulsion = propulsion;
        this.tarifaFija = tarifaFija;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(int capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public double getCostoPorKm() {
        return costoPorKm;
    }

    public void setCostoPorKm(double costoPorKm) {
        this.costoPorKm = costoPorKm;
    }

    public int getCapacidadMaximaPasajeros() {
        return capacidadMaximaPasajeros;
    }

    public void setCapacidadMaximaPasajeros(int capacidadMaximaPasajeros) {
        this.capacidadMaximaPasajeros = capacidadMaximaPasajeros;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public Propulsion getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(Propulsion propulsion) {
        this.propulsion = propulsion;
    }

    public int getTarifaFija() {
        return tarifaFija;
    }

    public void setTarifaFija(int tarifaFija) {
        this.tarifaFija = tarifaFija;
    }

    public Date getFechaUltimoVuelo() {
        return fechaUltimoVuelo;
    }

    public void setFechaUltimoVuelo(Date fechaUltimoVuelo) {
        this.fechaUltimoVuelo = fechaUltimoVuelo;
    }

    public static int getCostoMinimoPorKm() { return COSTO_MINIMO_POR_KM; }

    public static int getCostoMaximoPorKmPorKm() { return COSTO_MAXIMO_POR_KM; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avion)) return false;
        Avion avion = (Avion) o;
        return getCapacidadCombustible() == avion.getCapacidadCombustible() &&
                Double.compare(avion.getCostoPorKm(), getCostoPorKm()) == 0 &&
                getCapacidadMaximaPasajeros() == avion.getCapacidadMaximaPasajeros() &&
                getVelocidadMaxima() == avion.getVelocidadMaxima() &&
                getTarifaFija() == avion.getTarifaFija() &&
                getUuid().equals(avion.getUuid()) &&
                getPropulsion() == avion.getPropulsion();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getCapacidadCombustible(), getCostoPorKm(), getCapacidadMaximaPasajeros(), getVelocidadMaxima(), getPropulsion(), getTarifaFija());
    }

    @Override
    public String toString() {
        return "Avion{" +
                "capacidadCombustible=" + capacidadCombustible +
                ", costoPorKm=" + costoPorKm +
                ", capacidadMaximaPasajeros=" + capacidadMaximaPasajeros +
                ", velocidadMaxima=" + velocidadMaxima +
                ", propulsion=" + propulsion.getTipo() +
                ", tarifaFija=" + tarifaFija +
                ", fechaUltimoVuelo=" +fechaUltimoVuelo+
                '}';
    }
}
