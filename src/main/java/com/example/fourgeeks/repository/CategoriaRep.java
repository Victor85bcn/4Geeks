package com.example.fourgeeks.repository;


import com.example.fourgeeks.model.Categoria;

import java.util.List;


public interface CategoriaRep  {

    public Categoria findByNombre(String nombre);
    public Categoria save(Categoria categoria);
    public List<Categoria> findAll();
    public Categoria findById(int Id);
    public Categoria update(Categoria categoria);

}
