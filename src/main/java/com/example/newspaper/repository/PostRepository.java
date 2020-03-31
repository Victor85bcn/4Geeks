package com.example.newspaper.repository;

import com.example.newspaper.mapper.PostMapper;
import com.example.newspaper.model.Post;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class PostRepository implements PostRep {

    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Post object) {
        try {
            String sql = String.format("insert into Post (Titulo, Extracto, Contenido, IdUsuario, IdCategoria, Imagen, Tipo) values ('%s', '%s', '%s', %d, %d, '%s', '%s')",
                    object.getTitulo(), object.getExtracto(), object.getContenido(), object.getIdUsuario(), object.getIdCategoria(), object.getImagen(), object.getTipo());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Post object) {
        if(object.getIdPost()>0) {
            String sql = String.format("update Post set Titulo='%s', Contenido='%s', Extracto='%s', IdUsuario=%d, IdCategoria=%d, Imagen='%s', Tipo='%s' where IdPost=%d",
                    object.getTitulo(), object.getContenido(), object.getExtracto(), object.getIdUsuario(), object.getIdCategoria(), object.getImagen(), object.getTipo(), object.getIdPost());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Post> findAll(SpringDataWebProperties.Pageable pageable) {
        return jdbcTemplate.query("select * from post", new PostMapper());
    }

    @Override
    public Post findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from post where IdPost = ?",
                params, new PostMapper());
    }

    @Override
    public List<Post> getUltimasNoticias() {
        return jdbcTemplate.query("select * from post order by IdPost desc limit 4", new PostMapper());
    }

    @Override
    public Post getPortadaPrincipal() {
        return jdbcTemplate.queryForObject("select * from post order by 1 desc limit 1", new PostMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}