package com.example.fourgeeks.service.impl;

import com.example.fourgeeks.model.Usuario;
import com.example.fourgeeks.repository.impl.UsuarioRepository;
import com.example.fourgeeks.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveNewUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {return usuarioRepository.findAll();}
}
