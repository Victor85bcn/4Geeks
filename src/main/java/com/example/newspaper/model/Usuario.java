package com.example.newspaper.model;

import java.util.Date;

public class Usuario {

    //Atributes

    private long IdUsuario;
    private String Nombre;
    private String Apellido;
    private String Password;
    private String Email;
    private long IdGrupo;


    //Getters & Setters
    public long getIdUsuario() {
        return IdUsuario;
    }
    public void setIdUsuario(long idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getContrasena() {
        return Password;
    }
    public void setContrasena(String contrasena) {
        Password = contrasena;
    }

    public String getCorreo() {
        return Email;
    }
    public void setCorreo(String correo) {
        Email = correo;
    }

    public long getIdGrupo() {
        return IdGrupo;
    }
    public void setIdGrupo(long idGrupo) {
        IdGrupo = idGrupo;
    }

}
