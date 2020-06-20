package com.company;

public class Main
{
    public static void main(String[] args)
    {
        Archivo archivoUsuarios = new Archivo();

        //archivoUsuarios.createArchivoUsuarios();
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        File fileUsuarios = new File("archivoUsuarios.json");
        listaUsuarios = archivoUsuarios.archivoToArrayUsuario(fileUsuarios);
        int sizeUsuariosList = listaUsuarios.size();

        Menu.cargarSistema(listaUsuarios);

    }
}
