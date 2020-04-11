package com.example.fourgeeks.repository;

import com.example.fourgeeks.model.PostSeccion;

public interface PostSeccionRep extends BaseRep<PostSeccion> {

    public PostSeccion findByPostId(int Id);
    public PostSeccion findBySeccionId(int Id);

}
