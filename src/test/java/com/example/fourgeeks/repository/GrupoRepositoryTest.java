package com.example.fourgeeks.repository;

import com.example.fourgeeks.configuration.TestDatabaseConfiguration;
import com.example.fourgeeks.model.Grupo;
import com.example.fourgeeks.repository.impl.GrupoRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class GrupoRepositoryTest {

    @Autowired
    private GrupoRepository grupoRepository;

    @Test
    public void testA(){
        Grupo grupo = new Grupo();
        grupo.setIdgrupo(1);
        grupo.setNombre("Grupo1");

        Assert.assertTrue(grupoRepository.save(grupo));
    }

    @Test
    public void testB(){
        Grupo grupo = new Grupo();
        grupo.setIdgrupo(1);
        grupo.setNombre("Grupo2");

        Assert.assertTrue(grupoRepository.update(grupo));
    }

    @Test
    public void testC(){
        Assert.assertFalse(grupoRepository.findAll().isEmpty());
    }

    @Test
    public void testD(){
        Assert.assertTrue(grupoRepository.findById(1).getNombre().equalsIgnoreCase("Grupo2"));
    }

}
