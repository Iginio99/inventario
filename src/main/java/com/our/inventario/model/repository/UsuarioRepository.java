package com.our.inventario.model.repository;

import com.our.inventario.model.Rol;
import com.our.inventario.model.Usuario;
import com.our.inventario.util.Either;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioRepository {

    private final Connection conn;

    public UsuarioRepository(Connection conn) {
        this.conn = conn;
    }

    public Either<String, Usuario> login(String correo, String contraseña) {
        String sql = getConsultaLogin();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = map(rs);
                return Either.right(usuario);
            } else {
                return Either.left("Credenciales incorrectas");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
            return Either.left("Error de base de datos: " + ex.getMessage());
        }
    }

    private Usuario map(ResultSet rs) throws SQLException {
        return new Usuario(
                rs.getInt("idUsuario"),
                rs.getString("nombreUsuario"),
                rs.getString("correo"),
                rs.getString("contrasena"),
                new Rol(
                        rs.getInt("idRol"),
                        rs.getString("nombreRol"))
        );

    }

    private String getConsultaLogin() {
        String sql = """
            SELECT 
                u.idUsuario,
                u.nombre AS nombreUsuario,
                u.correo,
                u.contrasena,
                r.idRol,
                r.nombre AS nombreRol
            FROM 
                Usuario u
            JOIN 
                Rol r ON u.idRol = r.idRol
            WHERE 
                u.correo = ? AND u.contrasena = ?
        """;
        return sql;
    }
}
