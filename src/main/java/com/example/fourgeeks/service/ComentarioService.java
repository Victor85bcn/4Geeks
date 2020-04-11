package com.example.fourgeeks.service;

import com.example.fourgeeks.model.Comentario;

import java.util.List;

public interface ComentarioService {

    public List<Comentario> findAll();
    public List<Comentario> findByPostId(int Id);
    public boolean save(Comentario comentario);
}
