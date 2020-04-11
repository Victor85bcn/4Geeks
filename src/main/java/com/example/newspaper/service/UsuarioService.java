package com.example.newspaper.service;

import com.example.newspaper.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public boolean saveNewUsuario(Usuario usuario);

    public List<Usuario> findAll();
}
