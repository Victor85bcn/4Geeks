package com.example.newspaper.service;

import com.example.newspaper.model.Comentario;

import java.util.List;

public interface ComentarioService {

    public List<Comentario> findAll();
    public List<Comentario> findByPostId(int Id);
    public boolean save(Comentario comentario);
}
