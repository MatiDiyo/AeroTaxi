package com.company;

import java.util.Date;
import java.util.Objects;

public class Vuelo {

    private Date fecha;
    private Ciudad origen;
    private Ciudad destino;
    private int cantidadAcompanantes;
    private Avion avion;
    private int distancia;
    private double costoTotal;

    public Vuelo() {
    }

    //utilizar Distancia.getKm() para la distancia
    public Vuelo(Date fecha, Ciudad origen, Ciudad destino, int cantidadAcompanantes, Avion avion, int distancia, double costoTotal) {
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.cantidadAcompanantes = cantidadAcompanantes;
        this.avion = avion;
        this.distancia = distancia;
        this.costoTotal = costoTotal;
    }

    public int calcularDistancia(){
        int distancia = 0;
        if(origen.getLugar().equals(Distancia.BsAs_Cordoba.getOrigen()) && destino.getLugar().equals(Distancia.BsAs_Cordoba.getDestino())){
            distancia = Distancia.BsAs_Cordoba.getKm();
        }else if (origen.getLugar().equals(Distancia.BsAs_Santiago.getOrigen()) && destino.getLugar().equals(Distancia.BsAs_Santiago.getDestino())){
            distancia = Distancia.BsAs_Santiago.getKm();
        }else if (origen.getLugar().equals(Distancia.BsAs_Montevideo.getOrigen()) && destino.getLugar().equals(Distancia.BsAs_Montevideo.getDestino())){
            distancia = Distancia.BsAs_Montevideo.getKm();
        }else if (origen.getLugar().equals(Distancia.Cordoba_Montevideo.getOrigen()) && destino.getLugar().equals(Distancia.Cordoba_Montevideo.getDestino())){
            distancia = Distancia.Cordoba_Montevideo.getKm();
        }else if (origen.getLugar().equals(Distancia.Cordoba_Santiago.getOrigen()) && destino.getLugar().equals(Distancia.Cordoba_Santiago.getDestino())){
            distancia = Distancia.Cordoba_Santiago.getKm();
        }else if (origen.getLugar().equals(Distancia.Montevideo_Santiago.getOrigen()) && destino.getLugar().equals(Distancia.Montevideo_Santiago.getDestino())){
            distancia = Distancia.Montevideo_Santiago.getKm();
        }
        return distancia;
    }

    public double costoVuelo(){
        return (distancia * avion.getCostoPorKm()) + (cantidadAcompanantes * 3500) + (avion.getTarifaFija());
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public int getCantidadAcompanantes() {
        return cantidadAcompanantes;
    }

    public void setCantidadAcompanantes(int cantidadAcompanantes) {
        this.cantidadAcompanantes = cantidadAcompanantes;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return cantidadAcompanantes == vuelo.cantidadAcompanantes &&
                distancia == vuelo.distancia &&
                Double.compare(vuelo.costoTotal, costoTotal) == 0 &&
                Objects.equals(fecha, vuelo.fecha) &&
                origen == vuelo.origen &&
                destino == vuelo.destino &&
                Objects.equals(avion, vuelo.avion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, origen, destino, cantidadAcompanantes, avion, distancia, costoTotal);
    }

    @Override
    public String toString() {
        return  "\t-Fecha: " + fecha + "." +
                "\n\t-Origen: " + origen.getLugar() + "." +
                "\n\t-Destino: " + destino.getLugar() + "." +
                "\n\t-Cantidad de Acompanantes: " + cantidadAcompanantes + "." +
                "\n\t-Avion: " + avion.getUuid() + "." +
                "\n\t-Distancia: " + distancia + "." +
                "\n\t-Costo total: $" + costoTotal + ".";
    }
}
