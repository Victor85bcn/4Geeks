package com.example.newspaper.repository;

import com.example.newspaper.mapper.PostMetadataMapper;
import com.example.newspaper.model.PostMetadata;
import com.example.newspaper.repository.PostMetadataRep;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.awt.print.Pageable;
import java.util.List;

@Repository
public class PostMetadataRepository implements PostMetadataRep {

    private Log logger = LogFactory.getLog(getClass());
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void postConstruct(){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(PostMetadata object) {
        try {
            String sql = String.format("insert into post_metadata (Clave, Valor, Tipo, IdPost) values ('%s', '%s', '%s', '%d')",
                    object.getClave(), object.getValor(), object.getTipo(), object.getIdPost());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(PostMetadata object) {
        if(object.getIdPost()>0) {
            String sql = String.format("update post_metadata set Clave='%s', Valor='%s', Tipo='%s', IdPost='%d' where IdPostMetadata='%d'",
                    object.getClave(), object.getValor(), object.getTipo(), object.getIdPost(), object.getIdPostMetadata());
            jdbcTemplate.execute(sql);
        }
        return false;
    }

    @Override
    public List<PostMetadata> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from post_metadata", new PostMetadataMapper());
    }

    @Override
    public PostMetadata findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from post_metadata where IdPostMetadata = ?",
                params, new PostMetadataMapper());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
