package com.example.newspaper.repository;

import com.example.newspaper.mapper.GrupoMapper;
import com.example.newspaper.model.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class GrupoRepository implements GrupoRep {

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
    public List<Grupo> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from grupo", new GrupoMapper());
    }

    @Override
    public Grupo findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from grupo where IdGrupo = ?",
                params, new GrupoMapper());
    }
}
