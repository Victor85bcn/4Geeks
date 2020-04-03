package com.example.newspaper.mapper;

import com.example.newspaper.model.PostSeccion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostSeccionMapper implements RowMapper<PostSeccion> {
    @Override
    public PostSeccion mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostSeccion postSeccion = new PostSeccion();
        postSeccion.setIdPost(rs.getInt("IdPost"));
        postSeccion.setIdSeccion(rs.getInt("IdSeccion"));
        return postSeccion;
    }
}
