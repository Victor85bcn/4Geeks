package com.example.fourgeeks.model;

import java.util.Date;

public class Post {

    //Atributes
    private long IdPost;
    private String Titulo;
    private String Extracto;
    private String Contenido;
    private long  IdUsuario;
    private String Imagen;
    private long IdCategoria;
    private Date Fecha;
    private String Tipo = "POST";


    //Getters & Setters
    public long getIdPost() {
        return IdPost;
    }
    public void setIdPost(long idPost) {
        IdPost = idPost;
    }

    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getExtracto() {
        return Extracto;
    }
    public void setExtracto(String extracto) {
        Extracto = extracto;
    }

    public long getIdUsuario() {
        return IdUsuario;
    }
    public void setIdUsuario(long idUsuario) {
        IdUsuario = idUsuario;
    }

    public long getIdCategoria() {return IdCategoria;}
    public void setIdCategoria(long idCategoria) {IdCategoria = idCategoria;}

    public String getImagen() {
        return Imagen;
    }
    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public String getTipo() {
        return Tipo;
    }
    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getContenido() {return Contenido;}
    public void setContenido(String contenido) {Contenido = contenido;}

    public Date getFecha() {return Fecha;}
    public void setFecha(Date fecha) {Fecha = fecha;}
}
