package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;

import java.io.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Archivo archivoUsuarios = new Archivo("archivoUsuarios.json");
        Archivo archivoAviones = new Archivo("archivoAviones.json");
        Archivo archivoVuelo = new Archivo("archivoVuelos.json");

        //archivoUsuarios.createArchivoUsuarios();
        //archivoFunciones.createArchivoAviones();

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        ArrayList<Avion> listaAviones = new ArrayList<Avion>();
        ArrayList<Vuelo> listaVuelos = new ArrayList<>();

        listaUsuarios = archivoUsuarios.archivoToArrayUsuario();
        listaAviones = archivoAviones.archivoToArrayAvion();

        Sistema.cargarSistema(listaUsuarios , listaAviones , listaVuelos);
    }
}
