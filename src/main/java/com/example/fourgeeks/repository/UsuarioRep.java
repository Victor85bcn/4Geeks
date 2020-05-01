package com.example.fourgeeks.repository;

import com.example.fourgeeks.model.Usuario;

import java.util.List;

public interface UsuarioRep {

    public Usuario save(Usuario object);
    public boolean update(Usuario object);
    public List<Usuario> findAll();
    public Usuario findById(int Id);
    public Usuario findByEmail(String email);
    public boolean deleteByUsuarioId(int id);
}
