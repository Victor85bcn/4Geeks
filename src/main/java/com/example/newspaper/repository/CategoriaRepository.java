package com.example.newspaper.repository;

import com.example.newspaper.mapper.CategoriaMapper;
import com.example.newspaper.model.Categoria;
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
public class CategoriaRepository implements CategoriaRep {

    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Categoria categoria) {
        try {
            String sql = String.format("insert into Categoria (Nombre, Descripcion) " +
                    "values ('%s', '%s')", categoria.getNombre(), categoria.getDescripcion());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Categoria categoria) {
        if (categoria.getIdCategoria() != 0) {
            String sql = String.format("update Categoria set Nombre = '%s', Descripcion = '%s' "
                    + "where IdCategoria = '%d'",
            categoria.getNombre(), categoria.getDescripcion(), categoria.getIdCategoria());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Categoria> findAll(SpringDataWebProperties.Pageable pageable) {
        return jdbcTemplate.query("select * from Categoria ", new CategoriaMapper());
    }

    @Override
    public Categoria findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from Categoria where IdCategoria = ?", params, new CategoriaMapper());
    }

    public void deleteAll(){
        jdbcTemplate.execute("delete from Categoria");
    }

    public boolean deleteById(int id){
        try{
            String sql = String.format("delete from Categoria where IdCategoria='%d'", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            logger.error(e);
            return false;
        }
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
