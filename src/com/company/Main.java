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
        Archivo archivoUsuarios = new Archivo();
        Archivo archivoFunciones = new Archivo();

        //archivoUsuarios.createArchivoUsuarios();
        //archivoFunciones.createArchivoAviones();

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        ArrayList<Avion> listaAviones = new ArrayList<Avion>();

        File fileUsuarios = new File("archivoUsuarios.json");
        listaUsuarios = archivoUsuarios.archivoToArrayUsuario(fileUsuarios);
        int sizeUsuariosList = listaUsuarios.size();

        listaUsuarios = archivoFunciones.archivoToArrayUsuario(fileUsuarios);
        File fileAviones = new File("archivoAviones.json");
        listaAviones = archivoFunciones.archivoToArrayAvion(fileAviones);

        Sistema.cargarSistema(listaUsuarios , listaAviones );
    }
}
