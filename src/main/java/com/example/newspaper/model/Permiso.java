package com.example.newspaper.model;

import java.util.Date;

public class Permiso {

    //Atributes
    private long IdPermiso;
    private String Nombre;
    private Date Fecha;


    //Getters & Setters
    public Date getFecha() {
        return Fecha;
    }
    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public long getIdPermiso() {
        return IdPermiso;
    }
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