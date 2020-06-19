package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {

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
}
