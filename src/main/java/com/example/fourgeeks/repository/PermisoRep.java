package com.example.fourgeeks.repository;

import com.example.fourgeeks.model.Permiso;

import java.util.List;

public interface PermisoRep extends BaseRep<Permiso> {

    public List<Permiso> findByUser(String email);
}
