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

        Archivo archivoUsuarios = new Archivo();

        //archivoUsuarios.createArchivoUsuarios();

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        File fileUsuarios = new File("archivoUsuarios.json");

        listaUsuarios = archivoUsuarios.archivoToArrayUsuario(fileUsuarios);

        int sizeUsuariosList = listaUsuarios.size();

        for (int i=0; i < sizeUsuariosList ; i++){
            System.out.println(listaUsuarios.get(i).nombre);
            System.out.println(listaUsuarios.get(i).dni);

        }

        /*
        try
        {
            File file = new File("mi_archivo.json");


            ObjectMapper mapper = new ObjectMapper();

            //Object to JSON in file
            Usuario p = new Usuario();
            Usuario p2 = new Usuario();
            Usuario p3 = new Usuario();
            String jsonString ;


            var arrayP = new ArrayList<Usuario>();


            p.setNombre("test1");
            p2.setNombre("test2");
            p3.setNombre("test3");
            p.setDni("12345");
            p2.setDni("12345");
            p3.setDni("12345");

            arrayP.add(p);
            arrayP.add(p2);
            arrayP.add(p3);

            mapper.writeValue(file , arrayP );


            int size = arrayP.size();
            /// LECTURA JACKSON

            ArrayList<Usuario> arrayLectura;


            arrayLectura = mapper.readValue( file , ArrayList.class );

            Usuario pLectura = new Usuario();

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pLectura);

            for (int i = 0; i < size; i++) {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayLectura.get(i));
                pLectura = mapper.readValue( jsonString , Usuario.class );
                System.out.println(pLectura.getNombre());
                System.out.println(pLectura.getDni());
            }

        }catch (IOException e){
            System.out.println(" No se pudo leer/escribir el archivo: " +e.getMessage());
            e.printStackTrace();

        }
        */

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

                        System.out.println("Ingrese su dni");
                        String dniLogin = sn.nextLine();
                        // comprobar con archivos si el dni esta registrado

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

                                        File archivo = new File ("files\\archivo.txt");


                                        try {
                                            // Apertura del fichero y creacion de BufferedReader para poder
                                            // hacer una lectura comoda (disponer del metodo readLine()).


                                            if(! archivo.exists()){
                                                System.out.println("el archivo no existe creando 1.");
                                                archivo.createNewFile();
                                                System.out.println("Archivo " +archivo.getName() + " creado con exito \n" );
                                            }

                                            // Escritura del fichero

                                            // Lectura del fichero

                                        }
                                        catch(IOException e){
                                            e.printStackTrace();
                                        }

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

                        System.out.println("Ingrese su dni");
                        nuevoUsuario.dni = sn.nextLine();
                        // comprobar con archivos si el dni esta registrado, si no lo esta seguir con el proceso

                        sn.nextLine();
                        System.out.println("Ingrese su nombre");
                        nuevoUsuario.nombre = sn.nextLine();

                        System.out.println("Ingrese su apellido");
                        nuevoUsuario.apellido = sn.nextLine();

                        System.out.println("Ingrese su edad");
                        nuevoUsuario.edad = sn.nextByte();

                        nuevoUsuario.dineroGastado = 0;

                        // guardar  nuevoUsuario en  el archivo con json

                        break;

                    case 3:
                        System.out.println("Has seleccionado la opcion 3");

                        System.out.println("Admin");


                        while (!salirAdmin){
                            System.out.println("1. LISTA AVIONES");
                            System.out.println("2. LISTA USUARIOS");
                            System.out.println("3. LISTA VUELOS");
                            System.out.println("4. Salir");
                            try {
                                opcionAdmin = sn.nextInt();
                                switch (opcionAdmin){

                                    case 1:

                                        // mostrar lista de avion desde archivos o array de empresa

                                        break;

                                    case 2:

                                        // mostrar lista usuarios desde archivos o array de empresa

                                        break;

                                    case 3:

                                        // mostrar lista de vuelos desde archivos o array de empresa

                                        break;

                                    case 4:
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
