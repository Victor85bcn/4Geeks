package com.example.fourgeeks.repository;

import com.example.fourgeeks.configuration.TestDatabaseConfiguration;
import com.example.fourgeeks.model.Categoria;
import com.example.fourgeeks.model.Comentario;
import com.example.fourgeeks.repository.impl.ComentarioRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class ComentarioRepositoryTest {
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Test
    public void testInsertComentario(){
        Comentario comentario = new Comentario();
        comentario.setComentario("Test insert");
        comentario.setIdPost(1);
        comentario.setAlias("Test Alias");
        Assert.assertTrue(comentarioRepository.save(comentario));
        comentarioRepository.deleteById(((int) (comentarioRepository.findByComentario("Test insert")).getIdComentario()));
    }

    @Test
    public void testUpdateComentario(){
        Comentario comentario = comentarioRepository.findById(1);
        comentario.setComentario("Test comentario update");
        comentario.setAlias("Test Alias update");
        Assert.assertTrue(comentarioRepository.update(comentario));
        comentario.setComentario("Test inicial");
        comentario.setAlias("Test Alias");
        Assert.assertTrue(comentarioRepository.update(comentario));
    }

    @Test
    public void testFindAllComentario(){
        Assert.assertFalse(comentarioRepository.findAll().isEmpty());
    }

    @Test
    public void testFindByIdComentario(){
        Assert.assertTrue(comentarioRepository.findById(1).getComentario().equalsIgnoreCase("Test inicial"));
    }
}
