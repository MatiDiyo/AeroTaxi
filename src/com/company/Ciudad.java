package com.company;

public enum Ciudad { //ciudades prolijas
    BUENOS_AIRES("Buenos Aires"),
    CORDOBA("Cordoba"),
    SANTIAGO("Santiago"),
    MONTEVIDEO("Montevideo");

    private String lugar;

    private Ciudad(String lugar){
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
