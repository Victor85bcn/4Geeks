package com.example.fourgeeks.repository.impl;

import com.example.fourgeeks.mapper.SeccionMapper;
import com.example.fourgeeks.model.Seccion;
import com.example.fourgeeks.repository.SeccionRep;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class SeccionRepository implements SeccionRep {


    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Seccion seccion) {
        try {
            String sql = String.format("insert into Seccion (Nombre) values ('%s')", seccion.getNombre());
            jdbcTemplate.execute(sql);
            logger.info("Sección " + seccion.getNombre() + " creada.");
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Seccion seccion) {
        if (seccion.getIdSeccion() != 0) {
            String sql = String.format("update Seccion set Nombre = '%s' where IdSeccion = '%d'", seccion.getNombre(), seccion.getIdSeccion());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Seccion> findAll() {
        return jdbcTemplate.query("select * from Seccion ", new SeccionMapper());
    }

    @Override
    public Seccion findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from Seccion where IdSeccion = ?", params, new SeccionMapper());
    }

    public void deleteAll(){
        jdbcTemplate.execute("delete from Seccion");
    }

    public boolean deleteById(int id){
        try{
            String sql = String.format("delete from Seccion where IdSeccion='%d'", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

}
