package com.example.fourgeeks.repository;

import com.example.fourgeeks.configuration.TestDatabaseConfiguration;
import com.example.fourgeeks.model.Categoria;
import com.example.fourgeeks.repository.impl.CategoriaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void testInsertCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Test insert");
        categoria.setDescripcion("Este es un insert de categoria");
        Categoria categoriaTest = categoriaRepository.save(categoria);
        Assert.assertNotNull(categoriaTest);
        categoriaRepository.deleteById(((int) categoriaTest.getIdCategoria()));
    }

    @Test
    public void testUpdateCategoria() {
        Categoria categoria = categoriaRepository.findById(1);
        categoria.setNombre("Test update");
        categoria.setDescripcion("Este es un update de categoria");
        categoriaRepository.update(categoria);
        Assert.assertNotNull(categoriaRepository.findByNombre("Test update"));
        categoria.setNombre("Test inicial");
        categoria.setDescripcion("Esta es la categoria inicial");
        categoriaRepository.update(categoria);
        Assert.assertNotNull(categoriaRepository.findByNombre("Test inicial"));
    }

    @Test
    public void testFindByIdCategoria() {
        Categoria categoria = categoriaRepository.findById(1);
        Assert.assertTrue(categoria.getIdCategoria() == 1);
        Assert.assertTrue("Test inicial".equals(categoria.getNombre()));
    }

    @Test
    public void testFindAllCategoria() {
        Assert.assertFalse(categoriaRepository.findAll().isEmpty());
    }

    @Test
    public void testDeleteByIdCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNombre("Test delete");
        categoria.setDescripcion("Esta es la categoria a eliminar");
        categoriaRepository.save(categoria);
        Assert.assertTrue(categoriaRepository.deleteById(((int) categoriaRepository.findByNombre("Test delete").getIdCategoria())));
    }
}
