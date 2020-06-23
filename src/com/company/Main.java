package com.company;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Archivo archivoUsuarios = new Archivo("archivoUsuarios.json");
        Archivo archivoAviones = new Archivo("archivoAviones.json");
        Archivo archivoVuelo = new Archivo("archivoVuelos.json");

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        ArrayList<Avion> listaAviones = new ArrayList<Avion>();
        ArrayList<Vuelo> listaVuelos = new ArrayList<>();

        listaUsuarios = archivoUsuarios.archivoToArrayUsuario();
        listaAviones = archivoAviones.archivoToArrayAvion();
        listaVuelos = archivoVuelo.archivoToArrayVuelos();

        Sistema.cargarSistema(listaUsuarios , listaAviones , listaVuelos);
    }
}
