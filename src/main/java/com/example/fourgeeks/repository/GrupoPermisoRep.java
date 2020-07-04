package com.example.fourgeeks.repository;

import com.example.fourgeeks.model.GrupoPermiso;

public interface GrupoPermisoRep extends BaseRep<GrupoPermiso> {

    public boolean deleteById(int permiso);
}
