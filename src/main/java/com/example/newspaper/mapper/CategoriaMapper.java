package com.example.newspaper.mapper;

import com.example.newspaper.model.Categoria;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaMapper implements RowMapper<Categoria> {
    @Override
    public Categoria mapRow(ResultSet rs, int i) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(rs.getInt("IdCategoria"));
        categoria.setNombre(rs.getString("Nombre"));
        categoria.setDescripcion(rs.getString("Descripcion"));
        categoria.setFecha(rs.getTimestamp("Fecha"));
        return categoria;
    }
}
