package com.example.newspaper.repository;


import com.example.newspaper.model.Categoria;

import java.util.List;


public interface CategoriaRep  {

    public Categoria findByNombre(String nombre);
    public Categoria save(Categoria categoria);
    public List<Categoria> findAll();
    public Categoria findById(int Id);
    public Categoria update(Categoria categoria);

}
