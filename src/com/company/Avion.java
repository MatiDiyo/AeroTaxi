package com.company;

public class Avion {

    private short capacidadCombustible;
    private double costoPorKm;
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

    //hacer commit del contructor

}
