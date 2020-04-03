package com.example.newspaper.repository;

import com.example.newspaper.mapper.PostSeccionMapper;
import com.example.newspaper.model.PostSeccion;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class PostSeccionRepository implements PostSeccionRep{

    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(PostSeccion object) {
        try {
            String sql = String.format("insert into post_seccion (IdPost, IdSeccion) values ('%d', '%d')", object.getIdPost(), object.getIdSeccion());
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(PostSeccion object) {
        if(object.getIdPost()>0) {
            String sql = String.format("update post_seccion set IdSeccion='%d' where IdPost='%d'",
                    object.getIdSeccion(), object.getIdPost());
            jdbcTemplate.execute(sql);
        }
        return false;
    }

    @Override
    public List<PostSeccion> findAll() {
        return jdbcTemplate.query("select * from post_seccion", new PostSeccionMapper());
    }

    @Override
    public PostSeccion findById(int id) {
        return null;
    }

    @Override
    public PostSeccion findByPostId(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from post_seccion where IdPost = ?",
                params, new PostSeccionMapper());
    }

    @Override
    public PostSeccion findBySeccionId(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from post_seccion where IdSeccion = ?",
                params, new PostSeccionMapper());
    }


    public void deleteAll(){
        jdbcTemplate.execute("delete from post_seccion");
    }

    public boolean deleteByPostId(int id){
        try{
            String sql = String.format("delete from post_seccion where IdPost='%d'", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            logger.error(e);
            return false;
        }
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
