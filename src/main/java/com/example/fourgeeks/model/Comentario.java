package com.example.fourgeeks.model;

import java.util.Date;

public class Comentario {

    //Atributes

    private long IdComentario;
    private String Comentario;
    private long IdPost;
    private String Alias;
    private Date Fecha;


    //Getters & Setters

    public long getIdComentario() {
        return IdComentario;
    }
    public void setIdComentario(long idComentario) {
        IdComentario = idComentario;
    }

    public String getComentario() {
        return Comentario;
    }
    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public long getIdPost() {
        return IdPost;
    }
    public void setIdPost(long idPost) {
        IdPost = idPost;
    }

    public String getAlias() {
        return Alias;
    }
    public void setAlias(String alias) {
        Alias = alias;
    }

    public Date getFecha() {
        return Fecha;
    }
    public void setFecha(Date fecha) {
        Fecha = fecha;
    }
}
