package com.example.fourgeeks.service;

import com.example.fourgeeks.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario saveNewUsuario(Usuario usuario);

    public List<Usuario> findAll();
}
