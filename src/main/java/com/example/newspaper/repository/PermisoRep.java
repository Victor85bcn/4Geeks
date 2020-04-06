package com.example.newspaper.repository;

import com.example.newspaper.model.Permiso;

import java.util.List;

public interface PermisoRep extends BaseRep<Permiso> {

    public List<Permiso> findByUser(String email);
}
