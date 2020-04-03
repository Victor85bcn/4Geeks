package com.example.newspaper.components;

import com.example.newspaper.model.Post;
import com.example.newspaper.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("sectionsComponent")
public class SectionsComponent {

    @Autowired
    PostRepository postRepository;

    public List<Post> getUltimasNoticias() {
        ArrayList<Post> postsUltimasNoticias = new ArrayList<>();
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
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
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        for(Post post : postRepository.getSubPortadaTop()) {
            postsSubPortada.add(post);
        }
        return postsSubPortada;
    }

    public List<Post> getSubPortadaBottom() {
        ArrayList<Post> postsSubPortada = new ArrayList<>();
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        for(Post post : postRepository.getSubPortadaBottom()) {
            postsSubPortada.add(post);
        }
        return postsSubPortada;
    }



}
