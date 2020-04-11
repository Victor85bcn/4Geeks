package com.example.fourgeeks.repository;

import com.example.fourgeeks.model.Usuario;

public interface UsuarioRep extends BaseRep<Usuario> {

    public Usuario findByEmail(String email);
}
