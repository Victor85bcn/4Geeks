package com.example.newspaper.repository;

import com.example.newspaper.mapper.UsuarioMapper;
import com.example.newspaper.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class UsuarioRepository implements UsuarioRep {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Usuario object) {
        try {
            String sql = String.format("insert into Usuario (Nombre, Apellido, Password, Email, IdGrupo) values ('%s', '%s', '%s', '%s', '%d')",
                    object.getNombre(), object.getApellido(), object.getPassword(), object.getEmail(), object.getIdGrupo());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Usuario object) {
        if(object.getIdUsuario()>0) {
            String sql = String.format("update Usuario set Nombre='%s', Apellido='%s', Password='%s', Email='%s', IdGrupo='%d' where IdUsuario='%d'",
                    object.getNombre(), object.getApellido(), object.getPassword(), object.getEmail(), object.getIdGrupo(), object.getIdUsuario());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Usuario> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from Usuario", new UsuarioMapper());
    }

    @Override
    public Usuario findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from Usuario where IdUsuario = ?",
                params, new UsuarioMapper());
    }
}
