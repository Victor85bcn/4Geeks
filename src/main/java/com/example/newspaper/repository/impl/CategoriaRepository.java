package com.example.newspaper.repository.impl;

import com.example.newspaper.mapper.CategoriaMapper;
import com.example.newspaper.model.Categoria;
import com.example.newspaper.repository.CategoriaRep;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoriaRepository implements CategoriaRep {

    private Log logger = LogFactory.getLog(getClass());
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Categoria save(Categoria categoria) {
        try {
            String sql = String.format("insert into Categoria (Nombre, Descripcion) " +
                    "values ('%s', '%s')", categoria.getNombre(), categoria.getDescripcion());
            jdbcTemplate.execute(sql);
            logger.info("Categoria " + categoria.getNombre() + " creada.");
            return findByNombre(categoria.getNombre());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Categoria update(Categoria categoria) {
        if (categoria.getIdCategoria() != 0) {
            try {
                String sql = String.format("update Categoria set Nombre = '%s', Descripcion = '%s' "
                                + "where IdCategoria = '%d'",
                        categoria.getNombre(), categoria.getDescripcion(), categoria.getIdCategoria());
                jdbcTemplate.execute(sql);
                logger.info("Categoria " + categoria.getNombre() + " modificada.");
                return findByNombre(categoria.getNombre());
            } catch (Exception e){
                logger.error(e.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override
    public List<Categoria> findAll() {
        return jdbcTemplate.query("select * from Categoria ", new CategoriaMapper());
    }

    @Override
    public Categoria findById(int Id) {
        try {
            Object[] params = new Object[] {Id};
            return jdbcTemplate.queryForObject("select * from Categoria where IdCategoria = ?", params, new CategoriaMapper());
        } catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Categoria findByNombre(String nombre) {
        Object[] params = new Object[] {nombre};
        return jdbcTemplate.queryForObject("select * from Categoria where Nombre = '" + nombre + "'", new CategoriaMapper());
    }

    public void deleteAll(){
        jdbcTemplate.execute("delete from Categoria");
    }

    public boolean deleteById(int id){
        try{
            String sql = String.format("delete from Categoria where IdCategoria='%d'", id);
            logger.info("Categoria " + id + " eliminada.");
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

}
