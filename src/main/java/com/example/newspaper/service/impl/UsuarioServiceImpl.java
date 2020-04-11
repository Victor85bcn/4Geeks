package com.example.newspaper.service.impl;

import com.example.newspaper.model.Usuario;
import com.example.newspaper.repository.impl.UsuarioRepository;
import com.example.newspaper.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean saveNewUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {return usuarioRepository.findAll();}
}
