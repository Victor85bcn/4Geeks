package com.example.fourgeeks.repository;

import com.example.fourgeeks.configuration.TestDatabaseConfiguration;
import com.example.fourgeeks.model.Usuario;
import com.example.fourgeeks.repository.impl.UsuarioRepository;
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
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void testA(){
        Usuario usuario = new Usuario();
        usuario.setApellido("Apellido Original");
        usuario.setPassword("1234");
        usuario.setEmail("testemail@gmail.com");
        usuario.setIdGrupo(1);
        usuario.setNombre("Original");
        Assert.assertNotNull(usuarioRepository.save(usuario));
    }

    @Test
    public void testB(){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);
        usuario.setApellido("Apellido Modificado");
        usuario.setPassword("1234");
        usuario.setEmail("emailupdated@gmail.com");
        usuario.setIdGrupo(1);
        usuario.setNombre("Modificado");

        Assert.assertTrue(usuarioRepository.update(usuario));
    }

    @Test
    public void testC(){
        Assert.assertFalse(usuarioRepository.findAll().isEmpty());
    }

    @Test
    public void testD(){
        Assert.assertTrue(usuarioRepository.findById(1).getNombre().equalsIgnoreCase("DavidBB"));
    }
}
