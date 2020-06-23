package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
    private File archivo;
    private String nombreArchivo;

    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.archivo = new File(nombreArchivo);
    }

    // MÉTODOS GÉNERICOS  //////////////////////////////////////////////////////////////////

    /**
     * Agrega un nuevo elemento a un archivo JSON
     * @param elemento el elemento génerico a agregar
     * @param clase la clase del elemento a agregar
     */

    public <T> void agregarElemento(T elemento, Class<T> clase) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<T> array = archivoToArray(clase);
            array.add(elemento);
            mapper.writeValue(archivo, array);

        } catch (IOException e) {
            System.out.println(" No se pudo leer/escribir el archivo: " + e.getMessage());
            e.printStackTrace();

        }
    }

    /**
     *
     * @return una lista del tipo de clase enviado por parametros
     * @param clase el tipo de clase de la lista a retornar
     */

    public <T> ArrayList<T> archivoToArray(Class<T> clase) {
        ArrayList<T> lista = new ArrayList<T>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            String jsonString;

            /// LECTURA JACKSON

            ArrayList<Usuario> arrayLectura;

            arrayLectura = mapper.readValue(archivo, ArrayList.class);

            int size = arrayLectura.size();

            T pLectura;

            jsonString = mapper.toString();

            for (int i = 0; i < size; i++) {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayLectura.get(i));
                pLectura = mapper.readValue(jsonString, clase);

                lista.add(pLectura);
            }

        } catch (IOException e) {
            System.out.println(" No se pudo leer/escribir el archivo: " + e.getMessage());
            e.printStackTrace();

        }

        return lista;
    }

    /**
     * @param lista la lista a guardar en el archivo
     *              Abre y Graba en el archivo JSON una lista de usuarios
     */
    public <T> void guardarListaEnArchivo(ArrayList<T> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            mapper.writeValue(archivo, lista);

        } catch (IOException e) {
            System.out.println(" No se pudo leer/escribir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * @return la lista de usuarios del JSON de usuarios
     */

    public ArrayList<Usuario> archivoToArrayUsuario() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            String jsonString;

            /// LECTURA JACKSON

            ArrayList<Usuario> arrayLectura;

            arrayLectura = mapper.readValue(archivo, ArrayList.class);

            int size = arrayLectura.size();

            Usuario pLectura = new Usuario();

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pLectura);

            for (int i = 0; i < size; i++) {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayLectura.get(i));
                pLectura = mapper.readValue(jsonString, Usuario.class);

                listaUsuarios.add(pLectura);
            }

        } catch (IOException e) {
            System.out.println(" No se pudo leer/escribir el archivo: " + e.getMessage());
            e.printStackTrace();

        }

        return listaUsuarios;
    }



    /**
     * @return la lista de aviones del JSON de aviones
     */
    public ArrayList<Avion> archivoToArrayAvion() {
        ArrayList<Avion> listaAviones = new ArrayList<Avion>();
        ArrayList<AvionBronze> listaBronze = new ArrayList<AvionBronze>();
        ArrayList<AvionSilver> listaSilver = new ArrayList<AvionSilver>();
        ArrayList<AvionGold> listaGold = new ArrayList<AvionGold>();

        listaBronze = ArchivoBronze();
        listaSilver = ArchivoSilver();
        listaGold = ArchivoGold();

        for(int i=0 ; i < listaBronze.size(); i++){
            listaAviones.add( listaBronze.get(i) );
        }
        for(int i=0 ; i < listaSilver.size(); i++){
            listaAviones.add( listaSilver.get(i) );
        }
        for(int i=0 ; i < listaGold.size(); i++){
            listaAviones.add( listaGold.get(i) );
        }

        return listaAviones;
    }

    public ArrayList<AvionBronze> ArchivoBronze() {
        ArrayList<AvionBronze> listaAviones = new ArrayList<AvionBronze>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            String jsonString;

            /// LECTURA JACKSON
            File archivoBronze = new File("archivoAvionesBronze.json");
            ArrayList<Avion> arrayLectura;
            arrayLectura = mapper.readValue( archivoBronze , ArrayList.class);
            AvionBronze avionBronze = new AvionBronze();

            AvionBronze lectura = new AvionBronze();

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lectura);

            for (int i = 0; i < arrayLectura.size() ; i++) {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayLectura.get(i));

                avionBronze = mapper.readValue(jsonString , AvionBronze.class );
                listaAviones.add(avionBronze);

            }

        } catch (IOException e) {
            System.out.println(" No se pudo leer/escribir el archivo: " + e.getMessage());
            e.printStackTrace();

        }

        return listaAviones;
    }

    public ArrayList<AvionSilver> ArchivoSilver() {
        ArrayList<AvionSilver> listaAviones = new ArrayList<AvionSilver>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            String jsonString;
            File archivoSilver = new File("archivoAvionesSilver.json");
            /// LECTURA JACKSON

            ArrayList<Avion> arrayLectura;
            arrayLectura = mapper.readValue( archivoSilver , ArrayList.class);
            AvionSilver avionSilver = new AvionSilver();

            AvionSilver lectura = new AvionSilver();

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lectura);

            for (int i = 0; i < arrayLectura.size() ; i++) {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayLectura.get(i));

                avionSilver = mapper.readValue(jsonString , AvionSilver.class );
                listaAviones.add(avionSilver);

            }

        } catch (IOException e) {
            System.out.println(" No se pudo leer/escribir el archivo: " + e.getMessage());
            e.printStackTrace();

        }

        return listaAviones;
    }

    public ArrayList<AvionGold> ArchivoGold() {
        ArrayList<AvionGold> listaAviones = new ArrayList<AvionGold>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            String jsonString;
            File archivoGold = new File("archivoAvionesGold.json");
            /// LECTURA JACKSON

            ArrayList<Avion> arrayLectura;
            arrayLectura = mapper.readValue( archivoGold , ArrayList.class);
            AvionGold avionGold = new AvionGold();

            AvionGold lectura = new AvionGold();

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(lectura);

            for (int i = 0; i < arrayLectura.size() ; i++) {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayLectura.get(i));

                avionGold = mapper.readValue(jsonString , AvionGold.class );
                listaAviones.add(avionGold);

            }

        } catch (IOException e) {
            System.out.println(" No se pudo leer/escribir el archivo: " + e.getMessage());
            e.printStackTrace();

        }

        return listaAviones;
    }



    /**
     * @paramaviones la lista a guardar en el archivo
     *                Graba en el archivo JSON una lista de aviones
     */
    /*public void guardarListaEnArchivoAviones( ArrayList<Avion> aviones)
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
    }*/


/////////////////// VUELOS /////////////////////////////////////////////////////
    public ArrayList<Vuelo> archivoToArrayVuelos() {
        ArrayList<Vuelo> listaVuelos = new ArrayList<Vuelo>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            String jsonString;
            /// LECTURA JACKSON

            ArrayList<Vuelo> arrayLectura;

            arrayLectura = mapper.readValue(archivo, ArrayList.class);

            int size = arrayLectura.size();

            Vuelo pLectura = new Vuelo();

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pLectura);

            for (int i = 0; i < size; i++) {
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayLectura.get(i));
                pLectura = mapper.readValue(jsonString, Vuelo.class);
                listaVuelos.add(pLectura);
            }

        } catch (IOException e) {
            System.out.println(" No se pudo leer/escribir el archivo: " + e.getMessage());
            e.printStackTrace();

        }

        return listaVuelos;
    }
}