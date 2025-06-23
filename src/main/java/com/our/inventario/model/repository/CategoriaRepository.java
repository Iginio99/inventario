package com.our.inventario.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.our.inventario.model.Categoria;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaRepository {

    private final Connection conn;

    public CategoriaRepository(Connection conn) {
        this.conn = conn;
    }

    public boolean save(Categoria c) {
        String sql = "INSERT INTO Categoria(nombre, descripcion) VALUES(?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepository.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Optional<Categoria> findById(long id) {
        String sql = "SELECT * FROM Categoria WHERE idCategoria = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(map(rs));
            }
            return Optional.empty();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.empty();
    }

    public List<Categoria> findAll() {
        List<Categoria> list = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private Categoria map(ResultSet rs) throws SQLException {
        return new Categoria(
                rs.getLong("idCategoria"),
                rs.getString("nombre"),
                rs.getString("descripcion"));
    }
}
