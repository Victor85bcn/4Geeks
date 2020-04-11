package com.example.newspaper.repository;

import com.example.newspaper.mapper.ComentarioMapper;
import com.example.newspaper.model.Comentario;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ComentarioRepository implements ComentarioRep {

    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Comentario comentario) {
        try {
            String sql = String.format(
                    "insert into Comentario (Comentario,IdPost,Alias) "
                            + "values('%s', '%d', '%s')",
                    comentario.getComentario(), comentario.getIdPost(), comentario.getAlias(), comentario.getRespuesta());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            System.out.println("ERROR!!!!!" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Comentario comentario) {
        if(comentario.getIdComentario()>0) {
            String sql = String.format("update Comentario set Comentario='%s', IdPost='%d', Alias='%s', Respuesta='%s' where IdComentario='%d'",
                    comentario.getComentario(), comentario.getIdPost(), comentario.getAlias(), comentario.getRespuesta(), comentario.getIdComentario());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Comentario> findAll() {
        return jdbcTemplate.query("select * from comentario", new ComentarioMapper());
    }

    @Override
    public Comentario findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from comentario where IdComentario = ?",
                params, new ComentarioMapper());
    }
    @Override
    public List<Comentario> findByPostId(int Id) {
        List<Comentario> comentarios = jdbcTemplate.query("select * from comentario where IdPost = " + Id, new ComentarioMapper());
        return comentarios;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
