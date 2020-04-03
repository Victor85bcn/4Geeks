package com.example.newspaper.repository;

import com.example.newspaper.model.PostSeccion;

public interface PostSeccionRep extends BaseRep<PostSeccion> {

    public PostSeccion findByPostId(int Id);
    public PostSeccion findBySeccionId(int Id);

}
