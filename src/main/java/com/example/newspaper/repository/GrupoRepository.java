package com.example.newspaper.repository;

import com.example.newspaper.mapper.GrupoMapper;
import com.example.newspaper.model.Grupo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class GrupoRepository implements GrupoRep {

    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Grupo object) {
        try {
            String sql = String.format("insert into Grupo (Nombre) values ('%s')", object.getNombre());
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Grupo object) {
        if(object.getIdgrupo()>0) {
            String sql = String.format("update Grupo set Nombre='%s' where IdGrupo='%d'", object.getNombre(), object.getIdgrupo());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Grupo> findAll() {
        return jdbcTemplate.query("select * from grupo", new GrupoMapper());
    }

    @Override
    public Grupo findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from grupo where IdGrupo = ?",
                params, new GrupoMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
