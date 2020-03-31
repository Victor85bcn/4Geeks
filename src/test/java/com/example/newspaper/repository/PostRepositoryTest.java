package com.example.newspaper.repository;

import com.example.newspaper.components.TestDatabaseConfiguration;
import com.example.newspaper.model.Post;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;


    @Test
    public void insert() throws IOException {
        Post post = new Post();
        post.setIdPost(1);
        post.setImagen("image.jpg");
        post.setIdCategoria(1);
        post.setExtracto("Extracto de ejemplo");
        post.setContenido("nuevo-post");
        post.setTitulo("Nuevo Post");
        post.setIdUsuario(1);

        boolean result = postRepository.save(post);

        Assert.assertTrue(result);
    }

    @Test
    public void update() throws IOException {
        Post post = new Post();
        post.setIdPost(1);
        post.setImagen("image.jpg");
        post.setIdCategoria(1);
        post.setExtracto("Extracto de ejemplo");
        post.setContenido("nuevo-post-xd");
        post.setTitulo("Nuevo Post XD");
        post.setIdUsuario(1);

        boolean result = postRepository.update(post);

        Assert.assertTrue(result);
    }

    @Test
    public void findById(){
        Post post = postRepository.findById(3);
        Assert.assertNotNull(post);
    }

    @Test
    public void findAll(){
        SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
        Assert.assertFalse(postRepository.findAll(pageable).isEmpty());
    }
}
