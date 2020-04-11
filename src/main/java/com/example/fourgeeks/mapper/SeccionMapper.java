package com.example.fourgeeks.mapper;

import com.example.fourgeeks.model.Seccion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeccionMapper implements RowMapper<Seccion> {
    @Override
    public Seccion mapRow(ResultSet rs, int i) throws SQLException {
        Seccion seccion = new Seccion();
        seccion.setIdSeccion(rs.getInt("IdSeccion"));
        seccion.setNombre(rs.getString("Nombre"));
        return seccion;
    }
}
