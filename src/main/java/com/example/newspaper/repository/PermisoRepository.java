package com.example.newspaper.repository;

import com.example.newspaper.mapper.PermisoMapper;
import com.example.newspaper.model.Permiso;
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
public class PermisoRepository implements PermisoRep {

    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

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
    public List<Permiso> findAll(SpringDataWebProperties.Pageable pageable) {
        return jdbcTemplate.query("select * from permiso", new PermisoMapper());
    }

    @Override
    public Permiso findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from permiso where IdPermiso = ?",
                params, new PermisoMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
