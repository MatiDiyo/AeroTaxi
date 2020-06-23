package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.ARG_IN;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.exit;
import static java.lang.System.setOut;

/**
 * Clase estática, con un único método público: cargarSistema()
 */
public class Sistema
{
    private static Scanner sn = new Scanner(System.in);

    /**
     * Se le pregunta al usuario si quiere seguir con la ejecución del programa o no.
     * @return true = se continua con la ejecución del programa, false = se termina la ejecución del programa.
     */
    private static void deseaVolverAlMenuPrincipal(ArrayList<Usuario> listaUsuario , ArrayList<Avion> listaAviones, ArrayList<Vuelo> listaVuelos)
    {
        char opcion = 's';

        do {
            System.out.print("¿Desea volver al menú principal? (S/N): ");
            opcion = sn.next().charAt(0);
            opcion = Character.toUpperCase(opcion);
        } while (opcion == 'S' && opcion == 'N');

        if (opcion == 'S')
        {
            System.out.print(mostrarMenuPrincipial());
            cargarMenuPrincipal(listaUsuario,listaAviones , listaVuelos); // continua
        }
        else
            exit(0); // se sale
    }

    /**
     * @return un mensaje con la opción ingresada.
     */
    private static String mostrarOpcionIngresada(byte opcion)
    {
        return "Has seleccionado la opción "+ opcion + " ...";
    }

    // -------------------- MÉTODOS INGRESAR -------------------- //

    /**
     * @return el nombre ingresado
     */
    private static String ingresarNombre()
    {
        System.out.print("Ingrese su nombre: ");
        return sn.nextLine();
    }

    /**
     * @return el apellido ingresado
     */
    private static String ingresarApellido()
    {
        System.out.print("Ingrese su apelido: ");
        return sn.nextLine();
    }

    /**
     * @return el dni ingresado
     */
    private static String ingresarDNI()
    {
        System.out.print("Ingrese su dni: ");
        return sn.nextLine();
    }

    /**
     * @return la edad ingresada
     */
    private static byte ingresarEdad()
    {
        System.out.print("Ingrese su edad: ");
        return sn.nextByte();
    }


    /**
     * El método no se cortará hasta no obtener un número entre el rango deseado.
     * @return una opción entre n y m
     */
    private static byte ingresarOpcion(byte n, byte m)
    {
        byte opcion = 0;

        do {

            try
            {
                System.out.print("Ingrese una opción entre " + n + " y "+ m + ": ");
                opcion = sn.nextByte();
            }

            catch (InputMismatchException e) { sn.next(); }
            catch (Exception e) { sn.next(); }

            if (opcion >= n && opcion <= m)
                System.out.print(mostrarOpcionIngresada(opcion));
            else
                System.out.println("Opción inválida");

        } while (opcion < n || opcion > m);

        return opcion;
    }

    // ------------------------------------------------------------------- //

    // -------------------- MÉTODOS DE MENÚ PRINCIPAL -------------------- //

    /**
     * @return el menú a principal del sistema a imprimir
     */
    private static String mostrarMenuPrincipial()
    {
        return  "\n-------------------------------\n" +
                "        MENÚ PRINCIPAL\n" +
                "-------------------------------\n" +
                "1. INICIAR SESION DE USUARIO\n" +
                "2. REGISTRAR USUARIO\n" +
                "3. INICIAR SESION DE ADMIN\n" +
                "4. Salir.\n" +
                "-------------------------------\n";
    }

    /**
     * Carga el menú principal del programa se podrá volver a este, en cualquier punto del programa.
     */
    private static void cargarMenuPrincipal(ArrayList<Usuario> listaUsuario , ArrayList<Avion> listaAviones , ArrayList<Vuelo> listaVuelos)
    {
        byte opcion = ingresarOpcion((byte)1, (byte)4);

        switch (opcion)
        {
            case 1:
                boolean comprobarDni = false;
                int indexUsuario=0;
                sn.nextLine();
                sn.nextLine();
                while (!comprobarDni)
                {
                    String dniLogin = ingresarDNI();
                    // comprobar con archivos si el dni esta registrado
                    for (int i=0; i < listaUsuario.size() ; i++){
                        if ( dniLogin.equals(listaUsuario.get(i).dni)) {
                            comprobarDni=true;
                            indexUsuario=i;
                            System.out.println("Iniciando Sesion.");
                            break;
                        }
                    }
                }
                System.out.println(mostrarMenuUsuario());
                cargarMenuUsuario(listaUsuario , indexUsuario , listaAviones , listaVuelos);
                break;

            case 2:
                System.out.print(mostrarMenuRegistracionUsuario());
                cargarRegistracionUsuario(listaUsuario);
                deseaVolverAlMenuPrincipal(listaUsuario, listaAviones , listaVuelos);
                break;

            case 3:
                System.out.println(mostrarMenuAdmin());
                cargarMenuAdmin(listaUsuario , listaAviones , listaVuelos);
                break;

            case 4:
                exit(0);
        }
    }

    // ------------------------------------------------------------------- //

    // -------------------- MÉTODOS DE MENÚ DE USUARIO Y VUELOS -------------------- //

    // TODO: EL USUARIO TIENE QUE CREAR VUELOS, CANCELAR Y LISTAR TODOS SUS VUELOS.

    /**
     * @return el menú de usuario del sistema a imprimir
     */
    private static String mostrarMenuUsuario()
    {
        return  "\n\n-------------------------------\n" +
                "        MENÚ DE USUARIO\n" +
                "-------------------------------\n" +
                "1. MOSTRAR DATOS\n" +
                "2. NUEVO VUELO\n" +
                "3. CANCELAR VUELO\n" +
                "4. MOSTRAR TODOS LOS VUELOS\n" +
                "5. Volver al menú principal\n" +
                "-------------------------------";
    }

    /**
     * @return muestra los datos de un usuario en particular.
     */

    private static void mostrarDatosUsuario()
    {
        // TODO: DEBE MOSTRAR LOS DATOS DE UN USUARIO, TIENE QUE BUSCARLO MEDIANTE DNI
    }

    /**
     * Carga el menú del usuario del programa.
     */
    private static void cargarMenuUsuario(ArrayList<Usuario> listaUsuario , int indexDni , ArrayList<Avion> listaAviones , ArrayList<Vuelo> listaVuelos)
    {
        byte opcion = ingresarOpcion((byte)1, (byte)5);

        switch (opcion)
        {
            case 1:
                System.out.println("\nMostrando los datos del usuario...");
                System.out.println(listaUsuario.get(indexDni).toString());
                deseaVolverAlMenuPrincipal(listaUsuario , listaAviones , listaVuelos );
                break;

            case 2:
                System.out.println("\nIngresando nuevo vuelo...");
                deseaVolverAlMenuPrincipal(listaUsuario, listaAviones , listaVuelos);
                break;

            case 3:
                System.out.println("\nCancelando vuelo...");
                deseaVolverAlMenuPrincipal(listaUsuario, listaAviones , listaVuelos);
                break;

            case 4:
                System.out.println("\nMostrando todos los vuelos");
                deseaVolverAlMenuPrincipal(listaUsuario, listaAviones , listaVuelos);
                break;

            case 5:
                System.out.print(mostrarMenuPrincipial());
                cargarMenuPrincipal(listaUsuario, listaAviones , listaVuelos);
                break;
        }
    }

    // ------------------------------------------------------------------- //

    // -------------------- MÉTODOS DE REGISTRACIÓN DE USUARIO -------------------- //

    /**
     * @return el menú de registración de usuario del sistema a imprimir
     */
    private static String mostrarMenuRegistracionUsuario()
    {
        return "\n\n-------------------------------\n" +
                "     MENÚ DE REGISTRACION DE USUARIO\n" +
                "-------------------------------\n";
    }

    /**
     * Carga un usuario por pantalla y lo guarda en un archivo JSON.
     */
    private static void cargarRegistracionUsuario(ArrayList<Usuario> listaUsuarios)
    {

        Usuario nuevoUsuario = new Usuario();
        boolean flagDni = false;

        do {
            sn.nextLine();

            nuevoUsuario.dni = ingresarDNI();
            int sizeUsuariosList = listaUsuarios.size();
            flagDni = false;

            // Comprobar con archivos si el dni esta registrado, si no lo esta seguir con el proceso

            for (int i=0; i <sizeUsuariosList ; i++){
                if ( nuevoUsuario.dni.equals(listaUsuarios.get(i).dni)) {
                    flagDni = true;
                    System.out.println("EL DNI "+ nuevoUsuario.dni + " ya existe.");
                    break;
                }
            }
        } while (flagDni);

        // Ingresando los datos restantes del usuario
        nuevoUsuario.nombre = ingresarNombre();
        nuevoUsuario.apellido = ingresarApellido();
        nuevoUsuario.edad = ingresarEdad();
        nuevoUsuario.dineroGastado = 0;

        listaUsuarios.add(nuevoUsuario);

        // Guardar  nuevoUsuario en el archivo con json
        Archivo archivoUsuarios = new Archivo("archivoUsuarios.json");
        archivoUsuarios.guardarListaEnArchivo(listaUsuarios);

        System.out.println("Usuario guardado...");
    }

    // ------------------------------------------------------------------- //

    // -------------------- MÉTODOS DE ADMIN O EMPRESA -------------------- //

    // TODO: CREAR LOS MÉTODOS DE LISTAR AVIONES, USUARIO, VUELOS (ES RESPONSABILIDAD DE EL ADMIN O EMPRESA)

    /**
     * @return el menú de Admin o Empresa a imprimir.
     */
    private static String mostrarMenuAdmin()
    {
        return "\n\n-------------------------------\n" +
                "        MENÚ DE ADMIN\n" +
                "-------------------------------\n" +
                "1. MOSTRAR LISTA DE AVIONES\n" +
                "2. MOSTRAR LISTA DE USUARIOS\n" +
                "3. MOSTRAR LISTA DE VUELOS\n" +
                "4. MENU CARGAR DE AVIONES\n"  +
                "5. MENU CARGAR DE VUELOS\n"  +
                "6. Volver al menú principal.\n" +
                "-------------------------------";
    }

    /**
     * Carga el menú de Admin o Empresa
     * @param listaUsuario
     */
    private static void cargarMenuAdmin(ArrayList<Usuario> listaUsuario , ArrayList<Avion> listaAviones , ArrayList<Vuelo> listaVuelos)
    {
        byte opcion = ingresarOpcion((byte)1, (byte)6);
        switch (opcion)
        {
            case 1:
                System.out.println("\nMostrando lista de aviones");
                for( int i = 0; i < listaAviones.size() ; i++) {
                    System.out.println(listaAviones.get(i).toString());
                }
                deseaVolverAlMenuPrincipal(listaUsuario , listaAviones ,listaVuelos);
                break;

            case 2:
                System.out.println("\nMostrando lista de usuarios");
                for (int i = 0; i < listaUsuario.size() ; i++){
                    System.out.println(listaUsuario.get(i).toString());
                }
                deseaVolverAlMenuPrincipal(listaUsuario , listaAviones , listaVuelos);
                break;

            case 3:
                System.out.println("\nMostrando lista de vuelos");
                for (int i = 0; i < listaVuelos.size() ; i++) {
                    System.out.println(listaVuelos.get(i).toString());
                }
                deseaVolverAlMenuPrincipal(listaUsuario, listaAviones,listaVuelos);
                break;

            case 4:
                System.out.println("\nMostrando menu carga aviones");
                System.out.println("1_Avion tipo bronze");
                System.out.println("2_Avion tipo silver");
                System.out.println("3_Avion tipo Gold");
                byte opcion2 = ingresarOpcion((byte)1,(byte)3);

                switch (opcion2){
                    case 1:
                        menuCargaAvionBronze(listaUsuario , listaAviones );
                        break;
                    case 2:
                        menuCargaAvionSilver(listaAviones);
                        break;
                    case 3:
                        menuCargaAvionGold(listaAviones);
                        break;
                }
                deseaVolverAlMenuPrincipal(listaUsuario, listaAviones , listaVuelos);

            case 5:
                System.out.println("\nMostrando menu nuevo vuelo.");
                menuNuevoVuelo( listaAviones , listaVuelos);
                deseaVolverAlMenuPrincipal(listaUsuario , listaAviones , listaVuelos);

            case 6:
                System.out.println(mostrarMenuPrincipial());
                cargarMenuPrincipal(listaUsuario, listaAviones ,listaVuelos);
                break;

        }
    }



    private static void menuCargaAvionBronze(ArrayList<Usuario> listaUsuario , ArrayList<Avion> listaAviones)
    {
        Calendar fechaAvion = Calendar.getInstance();
        AvionBronze nuevoAvion = new AvionBronze();

        fechaAvion.after(1);
        System.out.println( fechaAvion.getTime());
        try
        {
            File file = new File("archivoAvionesBronze.json");
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            System.out.println("Registro Avion bronze");

            sn.nextLine();
            System.out.println("capacidad Combustible:");
            nuevoAvion.setCapacidadCombustible(sn.nextInt());
            sn.nextLine();
            System.out.println("Cantidad maxima de pasajeros:");
            nuevoAvion.setCapacidadMaximaPasajeros(sn.nextInt());
            sn.nextLine();
            System.out.println("Costo por km:");
            nuevoAvion.setCostoPorKm(sn.nextDouble());
            sn.nextLine();
            System.out.println("Velocidad maxima:");
            nuevoAvion.setVelocidadMaxima(500);

            sn.nextLine();

            System.out.println("Tipo de propulsion:");
            int controlMotor=0;
            System.out.println("1_Motor a reaccion.");
            System.out.println("2_Motor a helice.");
            System.out.println("3_Motor a pistones.");

            controlMotor = sn.nextInt();
            switch (controlMotor){
                case 1:
                    nuevoAvion.setPropulsion(Propulsion.MOTOR_A_REACCION);
                    break;

                case 2:
                    nuevoAvion.setPropulsion(Propulsion.MOTOR_A_HELICE);
                    break;
                case 3:
                    nuevoAvion.setPropulsion(Propulsion.MOTOR_A_PISTONES);
                    break;
            }

            nuevoAvion.setFechaUltimoVuelo( fechaAvion.getTime() );
            listaAviones.add(nuevoAvion);
            mapper.writeValue(file , listaAviones );

        }catch (IOException e){
            System.out.println(" No se pudo leer/escribir el archivo: " +e.getMessage());
            e.printStackTrace();

        }
    }

    private static void menuCargaAvionSilver( ArrayList<Avion> listaAviones)
    {
        Calendar fechaAvion = Calendar.getInstance();
        AvionSilver nuevoAvion = new AvionSilver();

        fechaAvion.after(1);
        System.out.println( fechaAvion.getTime());
        try
        {
            File file = new File("archivoAvionesSilver.json");
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            System.out.println("Registro Avion bronze");

            sn.nextLine();
            System.out.println("capacidad Combustible:");
            nuevoAvion.setCapacidadCombustible(sn.nextInt());
            sn.nextLine();
            System.out.println("Cantidad maxima de pasajeros:");
            nuevoAvion.setCapacidadMaximaPasajeros(sn.nextInt());
            sn.nextLine();
            System.out.println("Costo por km:");
            nuevoAvion.setCostoPorKm(sn.nextDouble());
            sn.nextLine();
            System.out.println("Velocidad maxima:");
            nuevoAvion.setVelocidadMaxima(500);

            sn.nextLine();

            System.out.println("Tipo de propulsion:");
            int controlMotor=0;
            System.out.println("1_Motor a reaccion.");
            System.out.println("2_Motor a helice.");
            System.out.println("3_Motor a pistones.");

            controlMotor = sn.nextInt();
            switch (controlMotor){
                case 1:
                    nuevoAvion.setPropulsion(Propulsion.MOTOR_A_REACCION);
                    break;

                case 2:
                    nuevoAvion.setPropulsion(Propulsion.MOTOR_A_HELICE);
                    break;
                case 3:
                    nuevoAvion.setPropulsion(Propulsion.MOTOR_A_PISTONES);
                    break;
            }

            nuevoAvion.setFechaUltimoVuelo( fechaAvion.getTime() );
            listaAviones.add(nuevoAvion);
            mapper.writeValue(file , listaAviones );

        }catch (IOException e){
            System.out.println(" No se pudo leer/escribir el archivo: " +e.getMessage());
            e.printStackTrace();

        }
    }
    private static void menuCargaAvionGold( ArrayList<Avion> listaAviones)
    {
        Calendar fechaAvion = Calendar.getInstance();
        AvionGold nuevoAvion = new AvionGold();

        fechaAvion.after(1);
        System.out.println( fechaAvion.getTime());
        try
        {
            File file = new File("archivoAvionesGold.json");
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            System.out.println("Registro Avion bronze");

            sn.nextLine();
            System.out.println("capacidad Combustible:");
            nuevoAvion.setCapacidadCombustible(sn.nextInt());
            sn.nextLine();
            System.out.println("Cantidad maxima de pasajeros:");
            nuevoAvion.setCapacidadMaximaPasajeros(sn.nextInt());
            sn.nextLine();
            System.out.println("Costo por km:");
            nuevoAvion.setCostoPorKm(sn.nextDouble());
            sn.nextLine();
            System.out.println("Velocidad maxima:");
            nuevoAvion.setVelocidadMaxima(500);

            sn.nextLine();

            System.out.println("Tipo de propulsion:");
            int controlMotor=0;
            System.out.println("1_Motor a reaccion.");
            System.out.println("2_Motor a helice.");
            System.out.println("3_Motor a pistones.");

            controlMotor = sn.nextInt();
            switch (controlMotor){
                case 1:
                    nuevoAvion.setPropulsion(Propulsion.MOTOR_A_REACCION);
                    break;

                case 2:
                    nuevoAvion.setPropulsion(Propulsion.MOTOR_A_HELICE);
                    break;
                case 3:
                    nuevoAvion.setPropulsion(Propulsion.MOTOR_A_PISTONES);
                    break;
            }

            nuevoAvion.setFechaUltimoVuelo( fechaAvion.getTime() );
            listaAviones.add(nuevoAvion);
            mapper.writeValue(file , listaAviones );

        }catch (IOException e){
            System.out.println(" No se pudo leer/escribir el archivo: " +e.getMessage());
            e.printStackTrace();

        }
    }



    private static void menuNuevoVuelo( ArrayList<Avion> listaAviones , ArrayList<Vuelo> listaVuelos){

        Vuelo nuevoVuelo = new Vuelo();
        Calendar fechaIngresada = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        int fechateclado;
        try
        {
            File file = new File("archivoVuelos.json");
            ObjectMapper mapper = new ObjectMapper();
            //Object to JSON in file
            System.out.println("Registro nuevo vuelo.");

            sn.nextLine();
            System.out.println("Ingrese la fecha del vuelo:");
            System.out.println("Ingrese anio ej:2020");
            fechateclado = sn.nextInt();
            fechaIngresada.set( Calendar.YEAR , fechateclado );
            System.out.println("Ingrese mes en formado de 2 digitos:");
            fechateclado = sn.nextInt();
            fechaIngresada.set( Calendar.MONTH , fechateclado - 1 );
            System.out.println("Ingrese el dia del vuelo:");
            fechateclado = sn.nextInt();
            fechaIngresada.set( Calendar.DATE , fechateclado );
            System.out.println("Ingrese hora del vuelo formato 24h");
            fechateclado = sn.nextInt();
            fechaIngresada.set( Calendar.HOUR , fechateclado - 12);
            fechaIngresada.set( Calendar.MINUTE , 00 );
            fechaIngresada.set( Calendar.SECOND , 00);
            System.out.println("Fecha ingresada: "+fechaIngresada.getTime());
            nuevoVuelo.setFecha( fechaIngresada.getTime() );
            sn.nextLine();
            System.out.println("Ciudad de origen:");
            System.out.println("1_Buenos Aires.");
            System.out.println("2_Cordoba");
            System.out.println("3_Santiago");
            System.out.println("4_Montevideo");
            byte opcion = ingresarOpcion((byte)1, (byte)4);
            switch (opcion){
                case 1:
                    nuevoVuelo.setOrigen( Ciudad.BUENOS_AIRES);
                    break;
                case 2:
                    nuevoVuelo.setOrigen( Ciudad.CORDOBA);
                    break;
                case 3:
                    nuevoVuelo.setOrigen( Ciudad.SANTIAGO );
                    break;
                case 4:
                    nuevoVuelo.setOrigen( Ciudad.MONTEVIDEO);
            }

            sn.nextLine();
            System.out.println("Ciudad de destino:");
            byte opcionDestino;

            switch (opcion){
                case 1:
                    System.out.println("1_Cordoba");
                    System.out.println("2_Santiago");
                    System.out.println("3_Montevideo");
                    opcionDestino = ingresarOpcion((byte)1 , (byte)3);
                    switch (opcionDestino){
                        case 1:
                            nuevoVuelo.setDestino( Ciudad.CORDOBA );
                            break;
                        case 2:
                            nuevoVuelo.setDestino( Ciudad.SANTIAGO );
                            break;
                        case 3:
                            nuevoVuelo.setDestino( Ciudad.MONTEVIDEO );
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1_Bueno Aires");
                    System.out.println("2_Santiago");
                    System.out.println("3_Montevideo");
                    opcionDestino = ingresarOpcion((byte)1 , (byte)3);
                    switch (opcionDestino){
                        case 1:
                            nuevoVuelo.setDestino( Ciudad.BUENOS_AIRES );
                            break;
                        case 2:
                            nuevoVuelo.setDestino( Ciudad.SANTIAGO );
                            break;
                        case 3:
                            nuevoVuelo.setDestino( Ciudad.MONTEVIDEO );
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1_Bueno Aires");
                    System.out.println("2_Cordoba");
                    System.out.println("3_Montevideo");
                    opcionDestino = ingresarOpcion((byte)1 , (byte)3);
                    switch (opcionDestino){
                        case 1:
                            nuevoVuelo.setDestino( Ciudad.BUENOS_AIRES );
                            break;
                        case 2:
                            nuevoVuelo.setDestino( Ciudad.CORDOBA );
                            break;
                        case 3:
                            nuevoVuelo.setDestino( Ciudad.MONTEVIDEO );
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1_Bueno Aires");
                    System.out.println("2_Cordoba");
                    System.out.println("3_Santiago");
                    opcionDestino = ingresarOpcion((byte)1 , (byte)3);
                    switch (opcionDestino){
                        case 1:
                            nuevoVuelo.setDestino( Ciudad.BUENOS_AIRES );
                            break;
                        case 2:
                            nuevoVuelo.setDestino( Ciudad.CORDOBA );
                            break;
                        case 3:
                            nuevoVuelo.setDestino( Ciudad.SANTIAGO );
                            break;
                    }
                    break;

            }

            sn.nextLine();
            nuevoVuelo.setCantidadAcompanantes(0);

            System.out.println("Seleccione un avion");
            Byte opcionAvion;

            for (int i=0; i < listaAviones.size() ; i++) {
                System.out.print(i + 1);
                System.out.println("_" + listaAviones.get(i).toString());
                System.out.println("--------------------------------------------------------------");
            }
            opcionAvion = ingresarOpcion( (byte)1 , (byte)listaAviones.size() );

            nuevoVuelo.setAvion(listaAviones.get(opcionAvion.intValue()-1) );// agregar una lista de aviones y un selecionador

            nuevoVuelo.getAvion().setFechaUltimoVuelo( nuevoVuelo.getFecha() );
            nuevoVuelo.setDistancia(  nuevoVuelo.calcularDistancia() );
            nuevoVuelo.setCostoTotal( nuevoVuelo.costoVuelo() );

            listaVuelos.add(nuevoVuelo);
            mapper.writeValue(file , listaVuelos );

        }catch (IOException e){
            System.out.println(" No se pudo leer/escribir el archivo: " +e.getMessage());
            e.printStackTrace();

        }

    }

    // ------------------------------------------------------------------- //

    /**
     * Método principal de la clase, es el único público, este método se llamará desde el main.
     */
    public static void cargarSistema(ArrayList<Usuario> listaUsuarios , ArrayList<Avion> listaAviones , ArrayList<Vuelo> listaVuelos)
    {
        System.out.print(mostrarMenuPrincipial());
        cargarMenuPrincipal(listaUsuarios,listaAviones,listaVuelos);
    }
}
