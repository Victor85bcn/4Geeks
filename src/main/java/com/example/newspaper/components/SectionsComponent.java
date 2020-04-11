package com.example.newspaper.components;

import com.example.newspaper.model.Post;
import com.example.newspaper.repository.impl.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("sectionsComponent")
public class SectionsComponent {

    @Autowired
    PostRepository postRepository;

    public List<Post> getUltimasNoticias() {
        ArrayList<Post> postsUltimasNoticias = new ArrayList<>();
        for(Post post : postRepository.getUltimasNoticias()) {
            postsUltimasNoticias.add(post);
        }
        return postsUltimasNoticias;
    }

    public Post getPortadaPrincipal() {
        Post postPortadaPrincipal = postRepository.getPortadaPrincipal(); // TODO Cambiar por un metodo dentro del repo que traiga un unico post principal.
        return postPortadaPrincipal;
    }

    public List<Post> getSubPortadaTop() {
        ArrayList<Post> postsSubPortada = new ArrayList<>();
        for(Post post : postRepository.getSubPortadaTop()) {
            postsSubPortada.add(post);
        }
        return postsSubPortada;
    }

    public List<Post> getSubPortadaBottom() {
        ArrayList<Post> postsSubPortada = new ArrayList<>();
        for(Post post : postRepository.getSubPortadaBottom()) {
            postsSubPortada.add(post);
        }
        return postsSubPortada;
    }

    public List<Post> getLoMasPopular() {
        ArrayList<Post> postsLoMasPopular = new ArrayList<>();
        for(Post post : postRepository.getLoMasPopular()) {
            postsLoMasPopular.add(post);
        }
        return postsLoMasPopular;
    }

    public List<Post> getNoTeLoPierdas() {
        ArrayList<Post> postsNoteLoPierdas = new ArrayList<>();
        for(Post post : postRepository.getNoTeLoPierdas()) {
            postsNoteLoPierdas.add(post);
        }
        return postsNoteLoPierdas;
    }



}
