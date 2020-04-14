package com.example.fourgeeks.service;

import com.example.fourgeeks.model.Categoria;
import com.example.fourgeeks.model.Post;
import com.example.fourgeeks.model.PostSeccion;
import com.example.fourgeeks.model.Seccion;

import java.util.List;

public interface PostSeccionService {

    public List<PostSeccion> findAll();
    public boolean updatePostSeccion(Post post, Seccion seccion);
}
