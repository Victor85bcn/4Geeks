package com.example.fourgeeks.repository;

import com.example.fourgeeks.model.Post;

import java.util.List;

public interface PostRep extends BaseRep<Post> {

    public List<Post> getUltimasNoticias();
    public Post getPortadaPrincipal();
    public List<Post> getSubPortadaTop();
    public List<Post> getSubPortadaBottom();
    public List<Post> getLoMasPopular();
    public List<Post> getReportajes();
    public List<Post> getOpinion();
    public boolean deleteByPostId(int id);
    public List<Post> getNoTeLoPierdas();
    public List<Post> getPostsByCategoria(String categoria);
    public List<Post> postsSinSeccion();
}
