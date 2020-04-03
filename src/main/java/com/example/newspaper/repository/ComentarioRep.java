package com.example.newspaper.repository;

import com.example.newspaper.model.Comentario;

import java.util.List;

public interface ComentarioRep extends BaseRep<Comentario> {

    public List<Comentario> findByPostId(int Id);

}
