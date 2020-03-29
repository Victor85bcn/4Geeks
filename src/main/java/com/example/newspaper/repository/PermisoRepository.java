package com.example.newspaper.repository;

import com.example.newspaper.mapper.PermisoMapper;
import com.example.newspaper.model.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class PermisoRepository implements PermisoRep {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Permiso object) {
        try {
            String sql = String.format("insert into Permiso (Nombre) values ('%s')",
                    object.getNombre());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Permiso object) {
        if(object.getIdPermiso()>0) {
            String sql = String.format("update Permiso set Nombre='%s' where IdPermiso='%d'",
                    object.getNombre(), object.getIdPermiso());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Permiso> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from permiso", new PermisoMapper());
    }

    @Override
    public Permiso findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from permiso where IdPermiso = ?",
                params, new PermisoMapper());
    }
}
