package com.example.newspaper.repository;

import com.example.newspaper.mapper.UsuarioMetadataMapper;
import com.example.newspaper.model.UsuarioMetadata;
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
public class UsuarioMetadataRepository implements UsuarioMetadataRep {

    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(UsuarioMetadata object) {
        try {
            String sql = String.format("insert into usuario_metadata (IdUsuario, Clave, Valor, Tipo) values ('%d', '%s', '%s', '%s')",
                    object.getIdUsuario(), object.getClave(), object.getValor(), object.getTipo());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(UsuarioMetadata object) {
        if(object.getIdUsuarioMetadata()>0) {
            String sql = String.format("update usuario_metadata set IdUsuario='%d', Clave='%s', Valor='%s', Tipo='%s' where IdUsuarioMetadata='%d'",
                    object.getIdUsuario(), object.getClave(), object.getValor(), object.getTipo(), object.getIdUsuarioMetadata());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<UsuarioMetadata> findAll(SpringDataWebProperties.Pageable pageable) {
        return jdbcTemplate.query("select * from usuario_metadata", new UsuarioMetadataMapper());
    }

    @Override
    public UsuarioMetadata findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from usuario_metadata where IdUsuarioMetadata = ?",
                params, new UsuarioMetadataMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
