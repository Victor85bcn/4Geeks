package com.example.newspaper.mapper;

import com.example.newspaper.model.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario> {
    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setApellido(rs.getString("Apellido"));
        usuario.setPassword(rs.getString("Password"));
        usuario.setEmail(rs.getString("Email"));
        usuario.setIdGrupo(rs.getInt("IdGrupo"));
        usuario.setIdUsuario(rs.getInt("IdUsuario"));
        usuario.setNombre(rs.getString("Nombre"));
        return usuario;
    }
}
