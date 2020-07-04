package com.example.fourgeeks.components;

import com.example.fourgeeks.model.Post;
import com.example.fourgeeks.model.Seccion;
import com.example.fourgeeks.repository.impl.PostRepository;
import com.example.fourgeeks.repository.impl.SeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("sectionsComponent")
public class SectionsComponent {

    @Autowired
    PostRepository postRepository;

    @Autowired
    SeccionRepository seccionRepository;

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

    public List<Post> getReportajes() {
        ArrayList<Post> postsReportajes = new ArrayList<>();
        for(Post post : postRepository.getReportajes()) {
            postsReportajes.add(post);
        }
        return postsReportajes;
    }

    public List<Post> getOpinion() {
        ArrayList<Post> postsOpinion = new ArrayList<>();
        for(Post post : postRepository.getOpinion()) {
            postsOpinion.add(post);
        }
        return postsOpinion;
    }

    public List<Post> getNoTeLoPierdas() {
        ArrayList<Post> postsNoteLoPierdas = new ArrayList<>();
        for(Post post : postRepository.getNoTeLoPierdas()) {
            postsNoteLoPierdas.add(post);
        }
        return postsNoteLoPierdas;
    }

    public List<Seccion> getSecciones() {
        ArrayList<Seccion> seccionesList = new ArrayList<>();
        for(Seccion seccion : seccionRepository.findAll()) {
            seccionesList.add(seccion);
        }
        return seccionesList;
    }


}
