package com.example.newspaper.service.impl;

import com.example.newspaper.model.Comentario;
import com.example.newspaper.repository.impl.ComentarioRepository;
import com.example.newspaper.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;


    @Override
    public List<Comentario> findAll() {return comentarioRepository.findAll();}

    @Override
    public List<Comentario> findByPostId(int Id) {return comentarioRepository.findByPostId(Id);}

    @Override
    public boolean save(Comentario comentario) {return comentarioRepository.save(comentario);}


}
