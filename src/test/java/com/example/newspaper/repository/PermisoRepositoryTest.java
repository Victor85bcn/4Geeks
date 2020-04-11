package com.example.newspaper.repository;

import com.example.newspaper.configuration.TestDatabaseConfiguration;
import com.example.newspaper.model.Permiso;
import com.example.newspaper.repository.impl.PermisoRepository;
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
public class PermisoRepositoryTest {
    @Autowired
    private PermisoRepository repository;

    @Test
    public void testA(){
        Permiso permiso = new Permiso();
        permiso.setIdPermiso(1);
        permiso.setNombre("Nuevo Permismo");

        Assert.assertTrue(repository.save(permiso));
    }

    @Test
    public void testB(){
        Permiso permiso = new Permiso();
        permiso.setIdPermiso(1);
        permiso.setNombre("Nuevo Permismo2");

        Assert.assertTrue(repository.update(permiso));
    }

    @Test
    public void testC(){
        Assert.assertFalse(repository.findAll().isEmpty());
    }

    @Test
    public void testD(){
        Assert.assertTrue(repository.findById(1).getNombre().equalsIgnoreCase("Nuevo Permismo2"));
    }
}
