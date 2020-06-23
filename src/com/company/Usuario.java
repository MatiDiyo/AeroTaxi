package com.company;

import java.util.Objects;

public class Usuario {

    private String nombre;
    private String apellido;
    private String dni;
    private Byte edad;
    private double dineroGastado;

    public Usuario() {}

    public Usuario(String nombre, String apellido, String dni, Byte edad, double dineroGastado)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.dineroGastado = dineroGastado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Byte getEdad() {
        return edad;
    }

    public void setEdad(Byte edad) {
        this.edad = edad;
    }

    public double getDineroGastado() {
        return dineroGastado;
    }

    public void setDineroGastado(double dineroGastado) {
        this.dineroGastado = dineroGastado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Double.compare(usuario.dineroGastado, dineroGastado) == 0 &&
                Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(apellido, usuario.apellido) &&
                Objects.equals(dni, usuario.dni) &&
                Objects.equals(edad, usuario.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, dni, edad, dineroGastado);
    }

    @Override
    public String toString() {
        return  "\t-Nombre: " + nombre + "." +
                "\n\t-Apellido: " + apellido + "." +
                "\n\t-Dni: " + dni + "." +
                "\n\t-Edad: " + edad + "." +
                "\n\t-DineroGastado: $" + dineroGastado;
    }
}
