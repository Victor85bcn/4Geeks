package com.example.newspaper.repository;

import com.example.newspaper.model.Grupo;

public interface GrupoRep extends BaseRep<Grupo> {

    public Grupo findByUser(String email);

}
