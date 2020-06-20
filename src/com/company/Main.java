package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;

import java.io.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        boolean salirAdmin = false;
        boolean salirUsuario = false;
        int opcion; //Guardaremos la opcion del usuario
        int opcionAdmin;
        int opcionUsuario;

        Archivo funcionesDeArchivos = new Archivo();

        //archivoUsuarios.createArchivoUsuarios();

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        ArrayList listaAviones = new ArrayList();

        File fileUsuarios = new File("archivoUsuarios.json");
        listaUsuarios = funcionesDeArchivos.archivoToArrayUsuario(fileUsuarios);
        int sizeUsuariosList = listaUsuarios.size();

        while (!salir) {

            System.out.println("1. INICIAR SESION");
            System.out.println("2. REGISTRO");
            System.out.println("3. ADMIN");
            System.out.println("4. Salir");

            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        boolean comprobarDni = false;
                        int indexUsuario=0;
                        sn.nextLine();
                        while (!comprobarDni)
                        {
                            System.out.println("Ingrese su dni:");
                            String dniLogin = sn.nextLine();
                            // comprobar con archivos si el dni esta registrado
                            for (int i=0; i <sizeUsuariosList ; i++){
                                if ( dniLogin.equals(listaUsuarios.get(i).dni)) {
                                    comprobarDni=true;
                                    indexUsuario=i;
                                    System.out.println("Iniciando Sesion.");
                                    break;
                                }
                            }
                        }

                        while (!salirUsuario){
                            System.out.println("1. MOSTRAR DATOS");
                            System.out.println("2. NUEVO VUELO");
                            System.out.println("3. CANCELAR VUELO");
                            System.out.println("4. TODOS LOS VUELOS");
                            System.out.println("5. Salir");
                            try {
                                opcionUsuario = sn.nextInt();
                                switch (opcionUsuario){

                                    case 1:

                                        // mostrar todos los datos del usuario desde archivo o array de empresa
                                        String mostrarUsuario = listaUsuarios.get(indexUsuario).toString();
                                        System.out.println(mostrarUsuario);
                                        sn.nextLine();
                                        break;

                                    case 2:

                                        // ingresar al cuestionario de datos para el vuelo

                                        System.out.println("Datos para verificacion de vuelos");

                                        Vuelo vuelo = new Vuelo();

                                        System.out.println("Ingrese fecha del viaje:");



                                        break;

                                    case 3:

                                        // mostrar lista de vuelos cancelables con 24h de anticipacion

                                        break;

                                    case 4:
                                        // mostrar todos los vuelos del usuario
                                        break;

                                    case 5:
                                        salirUsuario = true;
                                        break;

                                    default:
                                        System.out.println("Debes ingresar un numero");
                                }

                            }
                            catch (InputMismatchException e){
                                System.out.println("Debes ingresar un numero.");
                                sn.next();
                            }

                        }salirUsuario = false;


                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");

                        System.out.println("Registro");

                        Usuario nuevoUsuario = new Usuario();
                        boolean flagDni=false;

                       do {
                            sn.nextLine();
                            System.out.println("Ingrese su dni");
                            nuevoUsuario.dni = sn.nextLine();
                            flagDni = false;
                            // comprobar con archivos si el dni esta registrado, si no lo esta seguir con el proceso
                            for (int i=0; i <sizeUsuariosList ; i++){
                                if ( nuevoUsuario.dni.equals(listaUsuarios.get(i).dni)) {
                                    flagDni = true;
                                    System.out.println("Ya existe.");
                                    break;
                                }
                            }
                        }while (flagDni);

                        System.out.println("Ingrese su nombre");
                        nuevoUsuario.nombre = sn.nextLine();

                        System.out.println("Ingrese su apellido");
                        nuevoUsuario.apellido = sn.nextLine();

                        System.out.println("Ingrese su edad");
                        nuevoUsuario.edad = sn.nextByte();

                        nuevoUsuario.dineroGastado = 0;

                        listaUsuarios.add(nuevoUsuario);

                        // guardar  nuevoUsuario en  el archivo con json
                        funcionesDeArchivos.guardarListaEnArchivoUsuarios(listaUsuarios);
                        System.out.println("usuario guardado...");
                        break;

                    case 3:
                        System.out.println("Has seleccionado la opcion 3");

                        System.out.println("Admin");


                        while (!salirAdmin){
                            System.out.println("1. LISTA AVIONES");
                            System.out.println("2. LISTA USUARIOS");
                            System.out.println("3. LISTA VUELOS");
                            System.out.println("4. AGREGAR AVION");
                            System.out.println("5. AGREGAR VUELO");
                            try {
                                opcionAdmin = sn.nextInt();
                                switch (opcionAdmin){

                                    case 1:

                                        // mostrar lista de avion desde archivos o array de empresa
                                        /*
                                        for(int i=0; i <sizeAvionesList ; i++){
                                            System.out.println(listaAviones.get(i).toString());
                                        }
                                        sn.nextLine();
                                        sn.nextLine();
                                        */
                                        break;

                                    case 2:

                                        // mostrar lista usuarios desde archivos o array de empresa
                                        for(int i=0; i <sizeUsuariosList ; i++){
                                            System.out.println(listaUsuarios.get(i).toString());
                                        }
                                        sn.nextLine();
                                        sn.nextLine();
                                        break;

                                    case 3:

                                        // mostrar lista de vuelos desde archivos o array de empresa

                                        break;

                                    case 4:
                                        // agregar aviones al array / archivo de aviones



                                        break;


                                    case 5:


                                        break;

                                    case 6:
                                        salirAdmin = true;
                                        break;

                                    default:
                                        System.out.println("Debes ingresar un numero");
                                }

                            }
                            catch (InputMismatchException e){
                                System.out.println("Debes ingresar un numero.");
                                sn.next();
                            }

                        }salirAdmin = false;
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }
}
