package com.example.fourgeeks.repository.impl;

import com.example.fourgeeks.mapper.PermisoMapper;
import com.example.fourgeeks.model.Permiso;
import com.example.fourgeeks.repository.PermisoRep;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class PermisoRepository implements PermisoRep {

    private Log logger = LogFactory.getLog(getClass());
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

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
            logger.info("Permiso " + object.getNombre() + " creado.");
            return true;
        }catch(Exception e) {
            logger.error(e.getMessage());
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
    public List<Permiso> findAll() {
        return jdbcTemplate.query("select * from permiso", new PermisoMapper());
    }

    @Override
    public Permiso findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from permiso where IdPermiso = ?",
                params, new PermisoMapper());
    }

    @Override
    public List<Permiso> findByUser(String email) {
            return jdbcTemplate.query("select p.* from permiso p\n" +
                    "    inner join grupo_permiso gp on p.IdPermiso = gp.idPermiso\n" +
                    "    inner join usuario u on gp.IdGrupo = u.IdGrupo\n" +
                    "where u.Email = '" + email + "';", new PermisoMapper());
        }

    @Override
    public boolean deleteById(int id){
        try{
            String sql = String.format("delete from permiso where IdPermiso='%d'", id);
            logger.info("Permiso " + id + " eliminado.");
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

}
