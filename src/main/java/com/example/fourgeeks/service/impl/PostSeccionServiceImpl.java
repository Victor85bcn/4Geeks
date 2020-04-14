package com.example.fourgeeks.service.impl;

import com.example.fourgeeks.model.Categoria;
import com.example.fourgeeks.model.Post;
import com.example.fourgeeks.model.PostSeccion;
import com.example.fourgeeks.model.Seccion;
import com.example.fourgeeks.repository.impl.CategoriaRepository;
import com.example.fourgeeks.repository.impl.PostSeccionRepository;
import com.example.fourgeeks.repository.impl.SeccionRepository;
import com.example.fourgeeks.service.CategoriaService;
import com.example.fourgeeks.service.PostSeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSeccionServiceImpl implements PostSeccionService {

    @Autowired
    private PostSeccionRepository postSeccionRepository;


    @Override
    public List<PostSeccion> findAll() {return postSeccionRepository.findAll();}

    @Override
    public boolean updatePostSeccion(Post post, Seccion seccion) {
        PostSeccion postSeccion = new PostSeccion();
        postSeccion.setIdPost(post.getIdPost());
        postSeccion.setIdSeccion(seccion.getIdSeccion());

        try {
            PostSeccion postSeccionToEvaluate = new PostSeccion();
            postSeccionToEvaluate = postSeccionRepository.findByPostId((int) post.getIdPost());

            if (postSeccionToEvaluate != null) {
                postSeccionRepository.deleteByPostId((int) post.getIdPost());
                postSeccionRepository.save(postSeccion);
                return true;
            }
            return false;
        } catch (Exception e) {
            postSeccionRepository.save(postSeccion);
            return true;
        }

    }

}
