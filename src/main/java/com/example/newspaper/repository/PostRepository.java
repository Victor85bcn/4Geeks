package com.example.newspaper.repository;

import com.example.newspaper.mapper.PostMapper;
import com.example.newspaper.model.Post;
import com.example.newspaper.repository.PostRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class PostRepository implements PostRep {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Post object) {
        try {
            String sql = String.format("insert into Post (Titulo, Slug, Extracto, IdUsuario, IdCategoria, ImagenDestacada, Tipo) values ('%s','%s', '%s', '%d', '%d', '%s', '%s')",
                    object.getTitulo(), object.getSlug(), object.getExtracto(), object.getIdUsuario(), object.getCategoria(), object.getImagenDestacada(), object.getTipo());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Post object) {
        if(object.getIdPost()>0) {
            String sql = String.format("update Post set Titulo='%s', Slug='%s', Extracto='%s', IdUsuario='%d', IdCategoria='%d', ImagenDestacada='%s', Tipo='%s' where IdPost=%d",
                    object.getTitulo(), object.getSlug(), object.getExtracto(), object.getIdUsuario(), object.getCategoria(), object.getImagenDestacada(), object.getTipo(), object.getIdPost());

            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Post> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from post order by Fecha desc ", new PostMapper());
    }

    @Override
    public Post findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from post where IdPost = ?",
                params, new PostMapper());
    }
}
