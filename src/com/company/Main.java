package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;

import java.io.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {


        Archivo archivoUsuarios = new Archivo("archivoUsuarios.json");
        Archivo archivoAviones = new Archivo("archivoAviones.json");
        Archivo archivoVuelo = new Archivo("archivoVuelos.json");

        //Usuario user = new Usuario("Alberto", "Fernandez", "10344456",(byte)61, 0);

        //archivoUsuarios.agregarElemento(user, Usuario.class);

        //archivoUsuarios.createArchivoUsuarios();
        //archivoFunciones.createArchivoAviones();

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        ArrayList<Avion> listaAviones = new ArrayList<Avion>();
        ArrayList<Vuelo> listaVuelos = new ArrayList<>();

        listaUsuarios = archivoUsuarios.archivoToArrayUsuario();
        listaAviones = archivoAviones.archivoToArrayAvion();
        listaVuelos = archivoVuelo.archivoToArrayVuelos();

        Sistema.cargarSistema(listaUsuarios , listaAviones , listaVuelos);
    }
}
