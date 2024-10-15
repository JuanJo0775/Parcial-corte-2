package org.example.domain;

import java.io.Serializable;

public class Facultad implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String direccion;

    public Facultad(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Facultad (){}

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Facultad [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
    }
}
