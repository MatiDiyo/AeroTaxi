package com.company;

public enum Distancia { //distancias prolijas
    //Ciudades - Distancias en Km
    BsAs_Cordoba("Buenos Aires","Cordoba", 695),
    BsAs_Santiago("Buenos Aires", "Santiago", 1400),
    BsAs_Montevideo("Buenos Aires" ,"Montevideo", 950),
    Cordoba_Montevideo("Cordoba",  "Montevideo", 1190),
    Cordoba_Santiago("Cordoba", "Santiago", 1050),
    Montevideo_Santiago("Montevideo", "Santiago", 2100);

    private String origen; //primero lugar de salida y despues el destino, ej "Buenos Aires - Cordoba"
    private String destino; //primero lugar de salida y despues el destino, ej "Buenos Aires - Cordoba"
    private int km; //la distancia de recorrido

    private Distancia(String recorrido, String destino, int km){
        this.origen = origen;
        this.destino = destino;
        this.km = km;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
