package com.example.fourgeeks.model;

public class Permiso {

    //Atributes
    private long IdPermiso;
    private String Nombre;


    //Getters & Setters
    public long getIdPermiso() {return IdPermiso;}
    public void setIdPermiso(long idPermiso) {
        IdPermiso = idPermiso;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
