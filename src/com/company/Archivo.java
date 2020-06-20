package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
// FUNCIONES DE USUARIOS  //////////////////////////////////////////////////////////////////

    public void createArchivoUsuarios(){
        Scanner sn = new Scanner(System.in);
        Usuario nuevoUsuario = new Usuario();

        try
        {
            File file = new File("archivoUsuarios.json");

            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Usuario> arrayUsuarios = new ArrayList<Usuario>();
            ArrayList<Usuario> arrayUsuarios2 = new ArrayList<Usuario>();
            //Object to JSON in file
            System.out.println("Registro");


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

            arrayUsuarios.add(nuevoUsuario);


            mapper.writeValue(file , arrayUsuarios );



        }catch (IOException e){
            System.out.println(" No se pudo leer/escribir el archivo: " +e.getMessage());
            e.printStackTrace();

        }
    }

    public ArrayList<Usuario> archivoToArrayUsuario( File archivo ) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            String jsonString ;

            /// LECTURA JACKSON

            ArrayList<Usuario> arrayLectura;

            arrayLectura = mapper.readValue( archivo , ArrayList.class );

            int size = arrayLectura.size();

            Usuario pLectura = new Usuario();

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pLectura);

            for (int i = 0; i < size; i++) {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayLectura.get(i));
                pLectura = mapper.readValue( jsonString , Usuario.class );
                listaUsuarios.add(pLectura);
            }

        }catch (IOException e){
            System.out.println(" No se pudo leer/escribir el archivo: " +e.getMessage());
            e.printStackTrace();

        }

        return listaUsuarios;
    }

    public void guardarListaEnArchivoUsuarios( ArrayList<Usuario> usuarios)
    {
        try
        {
            File file = new File("archivoUsuarios.json");

            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            mapper.writeValue(file , usuarios );

        }catch (IOException e){
            System.out.println(" No se pudo leer/escribir el archivo: " +e.getMessage());
            e.printStackTrace();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////

    // FUNCIONES DE AVIONES //////////////////////////////////////////////////////////////////////////

/*
    public void createArchivoAviones(){
        Scanner sn = new Scanner(System.in);
        Avion nuevoAvion = new Avion();

        try
        {
            File file = new File("archivoAviones.json");

            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Avion> arrayAvion = new ArrayList<Avion>();
            ArrayList<Avion> arrayUsuarios2 = new ArrayList<Avion>();
            //Object to JSON in file
            System.out.println("Registro");



            arrayAvion.add(nuevoAvion);


            mapper.writeValue(file , arrayAvion );



        }catch (IOException e){
            System.out.println(" No se pudo leer/escribir el archivo: " +e.getMessage());
            e.printStackTrace();

        }
    }

    public ArrayList<Avion> archivoToArrayAvion( File archivo ) {
        ArrayList<Avion> listaAviones = new ArrayList<Avion>();

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            String jsonString ;

            /// LECTURA JACKSON

            ArrayList<Avion> arrayLectura;

            arrayLectura = mapper.readValue( archivo , ArrayList.class );

            int size = arrayLectura.size();

            Avion pLectura = new Avion();

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pLectura);

            for (int i = 0; i < size; i++) {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayLectura.get(i));
                pLectura = mapper.readValue( jsonString , Avion.class );
                listaAviones.add(pLectura);
            }

        }catch (IOException e){
            System.out.println(" No se pudo leer/escribir el archivo: " +e.getMessage());
            e.printStackTrace();

        }

        return listaAviones;
    }

    public void guardarListaEnArchivoAviones( ArrayList<Avion> aviones)
    {
        try
        {
            File file = new File("archivoAvion.json");

            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            mapper.writeValue(file , aviones );

        }catch (IOException e){
            System.out.println(" No se pudo leer/escribir el archivo: " +e.getMessage());
            e.printStackTrace();
        }
    }

 */
}
