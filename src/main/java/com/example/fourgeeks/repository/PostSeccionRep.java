package com.example.fourgeeks.repository;

import com.example.fourgeeks.model.PostSeccion;

import java.util.List;

public interface PostSeccionRep extends BaseRep<PostSeccion> {

    public PostSeccion findByPostId(int Id);
    public List<PostSeccion> findBySeccionId(int Id);

}
