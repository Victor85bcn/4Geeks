package com.example.fourgeeks.repository.impl;

import com.example.fourgeeks.mapper.ComentarioMapper;
import com.example.fourgeeks.model.Comentario;
import com.example.fourgeeks.repository.ComentarioRep;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class ComentarioRepository implements ComentarioRep {

    private Log logger = LogFactory.getLog(getClass());
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

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
            logger.info("Comentario de " + comentario.getAlias() + " creado.");
            return true;
        }catch(Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Comentario comentario) {
        if(comentario.getIdComentario()>0) {
            String sql = String.format("update Comentario set Comentario='%s', IdPost='%d', Alias='%s', Respuesta='%s' where IdComentario='%d'",
                    comentario.getComentario(), comentario.getIdPost(), comentario.getAlias(), comentario.getRespuesta(), comentario.getIdComentario());
            jdbcTemplate.execute(sql);
            logger.info("Comentario de " + comentario.getAlias() + " modificado.");
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
        try {
            return jdbcTemplate.queryForObject("select * from comentario where IdComentario = ?",
                    params, new ComentarioMapper());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }

    }
    @Override
    public List<Comentario> findByPostId(int Id) {
        List<Comentario> comentarios = jdbcTemplate.query("select * from comentario where IdPost = " + Id, new ComentarioMapper());
        if(!comentarios.isEmpty()){
            return comentarios;
        } else {
            return comentarios;
        }

    }

    public boolean deleteById(int id){
        try{
            String sql = String.format("delete from comentario where IdComentario='%d'", id);
            jdbcTemplate.execute(sql);
            logger.info("Comentario " + id + " eliminado.");
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

}
