package com.example.newspaper.model;

import java.util.Date;

public class UsuarioMetadata {

    //Atributes

    private long IdUsuarioMetadata;
    private long IdUsuario;
    private String Clave;
    private String Valor;
    private String Tipo;


    //Getters & Setters
    public long getIdUsuarioMetadata() {
        return IdUsuarioMetadata;
    }
    public void setIdUsuarioMetadata(long idUsuarioMetadata) {
        IdUsuarioMetadata = idUsuarioMetadata;
    }

    public long getIdUsuario() {
        return IdUsuario;
    }
    public void setIdUsuario(long idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getClave() {
        return Clave;
    }
    public void setClave(String clave) {
        Clave = clave;
    }

    public String getValor() {
        return Valor;
    }
    public void setValor(String valor) {
        Valor = valor;
    }

    public String getTipo() {
        return Tipo;
    }
    public void setTipo(String tipo) {
        Tipo = tipo;
    }

}
