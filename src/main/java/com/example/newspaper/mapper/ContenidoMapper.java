package com.example.newspaper.mapper;

import com.example.newspaper.model.Categoria;
import com.example.newspaper.model.Contenido;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContenidoMapper implements RowMapper<Contenido> {
    @Override
    public Contenido mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contenido contenido = new Contenido();
        contenido.setContenido(rs.getString("Contenido"));
        contenido.setIdContenido(rs.getInt("IdContenido"));
        contenido.setIdPost(rs.getInt("IdPost"));
        contenido.setTipo(rs.getString("Tipo"));
        return contenido;
    }
}
