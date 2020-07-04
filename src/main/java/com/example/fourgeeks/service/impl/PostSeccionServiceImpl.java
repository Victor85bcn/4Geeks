package com.example.fourgeeks.service.impl;

import com.example.fourgeeks.model.Post;
import com.example.fourgeeks.model.PostSeccion;
import com.example.fourgeeks.model.Seccion;
import com.example.fourgeeks.repository.impl.PostRepository;
import com.example.fourgeeks.repository.impl.PostSeccionRepository;
import com.example.fourgeeks.repository.impl.SeccionRepository;
import com.example.fourgeeks.service.PostSeccionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSeccionServiceImpl implements PostSeccionService {

    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private PostSeccionRepository postSeccionRepository;

    @Autowired
    private SeccionRepository seccionRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostSeccion> findAll() {return postSeccionRepository.findAll();}

    @Override
    public boolean updatePostSeccion(Post post, Seccion seccion) {
        PostSeccion postSeccion = new PostSeccion();
        postSeccion.setIdPost(post.getIdPost());
        postSeccion.setIdSeccion(seccion.getIdSeccion());

        try {
            PostSeccion postseccionToEvaluate = postSeccionRepository.findByPostId((int) postSeccion.getIdPost());
            Seccion seccionToEvaluate = seccionRepository.findById((int) postSeccion.getIdSeccion());
            Post postToEvaluate = postRepository.findById((int) postSeccion.getIdPost());

            if (postseccionToEvaluate != null && seccionToEvaluate != null && postToEvaluate != null) {
                postSeccionRepository.deleteByPostId((int) postSeccion.getIdPost());
                postSeccionRepository.save(postSeccion);
                return true;
            } else if (seccionToEvaluate == null) {
                logger.error("No se ha podido añadir el post " + postSeccion.getIdPost() + " a la sección " + postSeccion.getIdSeccion() + ", la sección no existe.");
                return false;
            } else if (postToEvaluate == null) {
                logger.error("No se ha podido añadir el post " + postSeccion.getIdPost() + " a la sección " + postSeccion.getIdSeccion() + ", el post no existe.");
                return false;
            } else {
                postSeccionRepository.save(postSeccion);
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean updatePostSeccion(PostSeccion postSeccion) {

        try {
            PostSeccion postseccionToEvaluate = postSeccionRepository.findByPostId((int) postSeccion.getIdPost());
            Seccion seccionToEvaluate = seccionRepository.findById((int) postSeccion.getIdSeccion());
            Post postToEvaluate = postRepository.findById((int) postSeccion.getIdPost());

            if (postseccionToEvaluate != null && seccionToEvaluate != null && postToEvaluate != null) {
                postSeccionRepository.deleteByPostId((int) postSeccion.getIdPost());
                postSeccionRepository.save(postSeccion);
                return true;
            } else if (seccionToEvaluate == null) {
                logger.error("No se ha podido añadir el post " + postSeccion.getIdPost() + " a la sección " + postSeccion.getIdSeccion() + ", la sección no existe.");
                return false;
            } else if (postToEvaluate == null) {
                logger.error("No se ha podido añadir el post " + postSeccion.getIdPost() + " a la sección " + postSeccion.getIdSeccion() + ", el post no existe.");
                return false;
            } else {
                postSeccionRepository.save(postSeccion);
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }

    }

}
