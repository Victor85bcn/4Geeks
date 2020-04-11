package com.example.newspaper.service.impl;

import com.example.newspaper.model.Categoria;
import com.example.newspaper.repository.impl.CategoriaRepository;
import com.example.newspaper.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public List<Categoria> findAll() {return categoriaRepository.findAll();}


}
