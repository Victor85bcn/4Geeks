package com.example.newspaper.repository;

import com.example.newspaper.mapper.ContenidoMapper;
import com.example.newspaper.model.Contenido;
import com.example.newspaper.repository.ContenidoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class ContenidoRepository implements ContenidoRep {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Contenido object) {
        try {
            String sql = String.format(
                    "insert into Contenido (Contenido,IdPost,Tipo) "
                            + "values('%s', '%d', '%s')",
                    object.getContenido(), object.getIdPost(), object.getTipo());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Contenido object) {
        if(object.getIdContenido()>0) {
            String sql = String.format("update Contenido set Contenido='%s', Tipo='%s' where IdContenido='%d'",
                    object.getContenido(), object.getTipo(), object.getIdContenido());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Contenido> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from contenido", new ContenidoMapper());
    }

    @Override
    public Contenido findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from contenido where IdContenido = ?",
                params, new ContenidoMapper());
    }
}
