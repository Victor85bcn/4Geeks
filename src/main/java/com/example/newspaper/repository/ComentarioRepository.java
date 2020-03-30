package com.example.newspaper.repository;

import com.example.newspaper.mapper.ComentarioMapper;
import com.example.newspaper.model.Comentario;
import com.example.newspaper.repository.ComentarioRep;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.awt.print.Pageable;
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
                    "insert into Comentario (Comentario,IdPost,IdUsuario,Respuesta) "
                            + "values('%s', '%d', '%d', '%d')",
                    comentario.getComentario(), comentario.getIdPost(), comentario.getIdUsuario(), comentario.getRespuesta());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Comentario comentario) {
        if(comentario.getIdComentario()>0) {
            String sql = String.format("update Comentario set Comentario='%s', IdPost='%d', IdUsuario='%d', Respuesta='%s' where IdComentario='%d'",
                    comentario.getComentario(), comentario.getIdPost(), comentario.getIdUsuario(), comentario.getRespuesta(), comentario.getIdComentario());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Comentario> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from comentario", new ComentarioMapper());
    }

    @Override
    public Comentario findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from comentario where IdComentario = ?",
                params, new ComentarioMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
