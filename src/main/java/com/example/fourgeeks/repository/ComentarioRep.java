package com.example.fourgeeks.repository;

import com.example.fourgeeks.model.Comentario;

import java.util.List;

public interface ComentarioRep extends BaseRep<Comentario> {

    public List<Comentario> findByPostId(int Id);

}
