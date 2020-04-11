package com.example.newspaper.service.impl;

import com.example.newspaper.model.Post;
import com.example.newspaper.model.Usuario;
import com.example.newspaper.repository.PostRepository;
import com.example.newspaper.repository.UsuarioRepository;
import com.example.newspaper.service.PostService;
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
}
