package com.example.fourgeeks.model;

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

    public String getPassword() {
        return Password;
    }
    public void setPassword(String contrasena) {
        Password = contrasena;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String correo) {
        Email = correo;
    }

    public long getIdGrupo() {
        return IdGrupo;
    }
    public void setIdGrupo(long idGrupo) {
        IdGrupo = idGrupo;
    }

}
