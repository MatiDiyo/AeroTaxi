package com.company;

import org.omg.CORBA.ARG_IN;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

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
    private static void deseaVolverAlMenuPrincipal(ArrayList<Usuario> listaUsuario , ArrayList<Avion> listaAviones)
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
            cargarMenuPrincipal(listaUsuario,listaAviones); // continua
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
    private static void cargarMenuPrincipal(ArrayList<Usuario> listaUsuario , ArrayList<Avion> listaAviones)
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
                cargarMenuUsuario(listaUsuario , indexUsuario , listaAviones );
                break;

            case 2:
                System.out.print(mostrarMenuRegistracionUsuario());
                cargarRegistracionUsuario(listaUsuario);
                deseaVolverAlMenuPrincipal(listaUsuario, listaAviones);
                break;

            case 3:
                System.out.println(mostrarMenuAdmin());
                cargarMenuAdmin(listaUsuario , listaAviones);
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
    private static void cargarMenuUsuario(ArrayList<Usuario> listaUsuario , int indexDni , ArrayList<Avion> listaAviones)
    {
        byte opcion = ingresarOpcion((byte)1, (byte)5);

        switch (opcion)
        {
            case 1:
                System.out.println("\nMostrando los datos del usuario...");
                System.out.println(listaUsuario.get(indexDni).toString());
                deseaVolverAlMenuPrincipal(listaUsuario , listaAviones);
                break;

            case 2:
                System.out.println("\nIngresando nuevo vuelo...");
                deseaVolverAlMenuPrincipal(listaUsuario, listaAviones);
                break;

            case 3:
                System.out.println("\nCancelando vuelo...");
                deseaVolverAlMenuPrincipal(listaUsuario, listaAviones);
                break;

            case 4:
                System.out.println("\nMostrando todos los vuelos");
                deseaVolverAlMenuPrincipal(listaUsuario, listaAviones);
                break;

            case 5:
                System.out.print(mostrarMenuPrincipial());
                cargarMenuPrincipal(listaUsuario, listaAviones);
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
                "4. Volver al menú principal.\n" +
                "-------------------------------";
    }

    /**
     * Carga el menú de Admin o Empresa
     * @param listaUsuario
     */
    private static void cargarMenuAdmin(ArrayList<Usuario> listaUsuario , ArrayList<Avion> listaAviones)
    {
        byte opcion = ingresarOpcion((byte)1, (byte)4);

        switch (opcion)
        {
            case 1:
                System.out.println("\nMostrando lista de aviones");
                for( int i = 0; i < listaAviones.size() ; i++) {
                    System.out.println(listaAviones.get(i).toString());
                }
                deseaVolverAlMenuPrincipal(listaUsuario , listaAviones);
                break;

            case 2:
                System.out.println("\nMostrando lista de usuarios");
                for (int i = 0; i < listaUsuario.size() ; i++){
                    System.out.println(listaUsuario.get(i).toString());
                }
                deseaVolverAlMenuPrincipal(listaUsuario , listaAviones);
                break;

            case 3:
                System.out.println("\nMostrando lista de vuelos");
                deseaVolverAlMenuPrincipal(listaUsuario, listaAviones);
                break;

            case 4:
                System.out.println(mostrarMenuPrincipial());
                cargarMenuPrincipal(listaUsuario, listaAviones);
                break;

        }
    }

    // ------------------------------------------------------------------- //

    /**
     * Método principal de la clase, es el único público, este método se llamará desde el main.
     */
    public static void cargarSistema(ArrayList<Usuario> listaUsuarios , ArrayList<Avion> listaAviones)
    {
        System.out.print(mostrarMenuPrincipial());
        cargarMenuPrincipal(listaUsuarios,listaAviones);
    }
}
