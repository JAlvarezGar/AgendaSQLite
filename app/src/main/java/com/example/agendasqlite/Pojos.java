package com.example.agendasqlite;

public class Pojos {

    private int dni;
    private String nombre;
    private String calle;
    private String telefono;

    public Pojos(int dni, String nombre, String calle, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.calle = calle;
        this.telefono = telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
