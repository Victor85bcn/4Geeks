package com.example.newspaper.components;

import com.example.newspaper.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

//@Configuration
public class TestDatabaseConfiguration {


    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/newspaper_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("vmartinez");
        dataSource.setPassword("root1234");
        return dataSource;
    }

    @Bean
    public CategoriaRepository categoriaRepository(){
        return new CategoriaRepository();
    }

    @Bean
    public UsuarioRepository usuarioRepository(){
        return new UsuarioRepository();
    }

    @Bean
    public PostRepository postRepository(){return new PostRepository();}

    @Bean
    public UsuarioMetadataRepository usuarioMetadataRepository(){
        return new UsuarioMetadataRepository();
    }

    @Bean
    public PostMetadataRepository postMetadataRepository(){
        return new PostMetadataRepository();
    }

    @Bean
    public PermisoRepository permisoRepository(){
        return new PermisoRepository();
    }

    @Bean
    public GrupoRepository grupoRepository(){
        return new GrupoRepository();
    }

    @Bean
    public ContenidoRepository contenidoRepository(){
        return new ContenidoRepository();
    }

    @Bean
    public ComentarioRepository comentarioRepository(){
        return new ComentarioRepository();
    }

    @Bean
    public GrupoPermisoRepository grupoPermisoRepository(){
        return new GrupoPermisoRepository();
    }

}
