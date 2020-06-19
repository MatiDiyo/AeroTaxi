package com.company;

public abstract class Avion {

    private short capacidadCombustible;
    private double costoPorKm; // entre 150 y 300
    private short capacidadMaximaPasajeros;
    private short velocidadMaxima;
    private Propulsion propulsion;
    //private boolean servicioCatering; usaremos una interface para el catering
    private int tarifaFija;

    public Avion(){}

    public Avion(short capacidadCombustible, double costoPorKm, short capacidadMaximaPasajeros, short velocidadMaxima, Propulsion propulsion, int tarifaFija) {
        this.capacidadCombustible = capacidadCombustible;
        this.costoPorKm = costoPorKm;
        this.capacidadMaximaPasajeros = capacidadMaximaPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.propulsion = propulsion;
        this.tarifaFija = tarifaFija;
    }

    public short getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(short capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public double getCostoPorKm() {
        return costoPorKm;
    }

    public void setCostoPorKm(double costoPorKm) {
        this.costoPorKm = costoPorKm;
    }

    public short getCapacidadMaximaPasajeros() {
        return capacidadMaximaPasajeros;
    }

    public void setCapacidadMaximaPasajeros(short capacidadMaximaPasajeros) {
        this.capacidadMaximaPasajeros = capacidadMaximaPasajeros;
    }

    public short getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(short velocidadMaxima) {
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
}
