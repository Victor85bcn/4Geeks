package com.example.newspaper.repository;

import com.example.newspaper.model.Post;

import java.util.List;

public interface PostRep extends BaseRep<Post> {

    public List<Post> getUltimasNoticias();
    public Post getPortadaPrincipal();
    public List<Post> getSubPortadaTop();
    public List<Post> getSubPortadaBottom();
}
