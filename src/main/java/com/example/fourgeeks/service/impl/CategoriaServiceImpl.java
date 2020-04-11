package com.example.fourgeeks.service.impl;

import com.example.fourgeeks.model.Categoria;
import com.example.fourgeeks.repository.impl.CategoriaRepository;
import com.example.fourgeeks.service.CategoriaService;
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
