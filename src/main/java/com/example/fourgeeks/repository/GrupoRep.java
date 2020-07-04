package com.example.fourgeeks.repository;

import com.example.fourgeeks.model.Grupo;

public interface GrupoRep extends BaseRep<Grupo> {

    public Grupo findByUser(String email);
    public boolean deleteById(int id);

}
