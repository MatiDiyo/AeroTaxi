package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Vuelo{

    Scanner sn = new Scanner(System.in);

    private Date fecha;
    private Ciudad origen;
    private Ciudad destino;
    private int cantidadAcompanantes;
    private Avion avion;
    private int distancia;
    private double costoTotal;

    public Vuelo() {
    }

    public Vuelo(Ciudad origen, Ciudad destino, int distancia)
    {
        fecha = null;
        this.origen = origen;
        this.destino = destino;
        cantidadAcompanantes = 0;
        avion = null;
        this.distancia = distancia;
        costoTotal = 0;
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

    //retornar Vuelo? o en void?
    public void contratarVuelo(){
        //pedir fecha de vuelo
        System.out.println("-Elija su origen.\n");
        elegirOrigen();
        System.out.println("\n-Elija su destino.\n");
        elegirDestino();
        this.distancia = calcularDistancia();
        System.out.println("\n-Ingrese la cantidad de acompañantes: ");
        this.cantidadAcompanantes = sn.nextInt() + 1; //mas uno pq hay que contar el que hace la compra
        //seleccionar un avion (mostrar los aviones de ese dia)
        System.out.println("\n-El costo del vuelo es de:" + distancia);
        //confirmar para generar vuelo

       // return Vuelo;
    }

    public void elegirOrigen(){
        int i = 0;

        System.out.println("1 - " + Ciudad.BUENOS_AIRES.getLugar());
        System.out.println("2 - " + Ciudad.CORDOBA.getLugar());
        System.out.println("3 - " + Ciudad.SANTIAGO.getLugar());
        System.out.println("4 - " + Ciudad.MONTEVIDEO.getLugar());
        System.out.println("");
        System.out.println("-Ingrese un origen: ");
        i = sn.nextInt();

        if (i == 1){
            origen = Ciudad.BUENOS_AIRES;
        }else if(i == 2){
            origen = Ciudad.CORDOBA;
        }else if(i == 3){
            origen = Ciudad.SANTIAGO;
        }else if (i == 4){
            origen = Ciudad.MONTEVIDEO;
        }
    }

    public void elegirDestino(){
        int i = 0;

        System.out.println("1 - " + Ciudad.BUENOS_AIRES.getLugar());
        System.out.println("2 - " + Ciudad.CORDOBA.getLugar());
        System.out.println("3 - " + Ciudad.SANTIAGO.getLugar());
        System.out.println("4 - " + Ciudad.MONTEVIDEO.getLugar());
        System.out.println("");
        System.out.println("-Ingrese un destino: ");
        i = sn.nextInt();

        if (i == 1){
            if(Ciudad.BUENOS_AIRES.getLugar().equals(origen)){
                System.out.println("    -No se puede elegir el mismo origen y destino.\n");
                elegirDestino();
            }else{
                destino = Ciudad.BUENOS_AIRES;
            }
        }else if (i == 2){
            if(Ciudad.CORDOBA.getLugar().equals(origen)){
                System.out.println("    -No se puede elegir el mismo origen y destino.\n");
                elegirDestino();
            }else{
                destino = Ciudad.CORDOBA;
            }
        }else if (i == 3){
            if(Ciudad.SANTIAGO.getLugar().equals(origen)){
                System.out.println("    -No se puede elegir el mismo origen y destino.\n");
                elegirDestino();
            }else{
                destino = Ciudad.SANTIAGO;
            }
        }else if (i == 4){
            if(Ciudad.MONTEVIDEO.getLugar().equals(origen)){
                  System.out.println("    -No se puede elegir el mismo origen y destino.\n");
                  elegirDestino();
            }else{
                    destino = Ciudad.MONTEVIDEO;
            }
        }
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

    public void setCantidadAcompanantes(short cantidadAcompanantes) {
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
        return "Vuelo{" +
                "fecha=" + fecha +
                ", origen=" + origen +
                ", destino=" + destino +
                ", cantidadAcompanantes=" + cantidadAcompanantes +
                ", avion=" + avion +
                ", distancia=" + distancia +
                ", costoTotal=" + costoTotal +
                '}';
    }
}
