package com.company;

public enum Distancia {
    //Ciudades - Distancias en Km
    BsAs_Cordoba("Buenos aires - Cordoba", 695),
    BsAs_Santiago("Buenos aires - Santiago", 1400),
    BsAs_Montevideo("Buenos aires - Montevideo", 950),
    Cordoba_Montevideo("Cordoba - Montevideo", 1190),
    Cordoba_Santiago("Cordoba - Santiago", 1050),
    Montevideo_Santiago("Montevideo - Santiago", 2100);

    private String recorrido; //primero lugar de salida y despues el destino, ej "Buenos Aires - Cordoba"
    private int km; //la distancia de recorrido

    private Distancia(String recorrido, int km){
        this.recorrido = recorrido;
        this.km = km;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
