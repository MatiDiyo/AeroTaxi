package com.company;

public enum Propulsion {
    MOTOR_A_REACCION("Motor a reaccion"),
    MOTOR_A_HELICE("Motor a helice"),
    MOTOR_A_PISTONES("Motor a pistones");

    private String tipo;

    private Propulsion(String tipo){
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
