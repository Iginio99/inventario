package com.our.inventario.model.repository;

import com.our.inventario.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaRepository {

    private final Connection conn;

    public CategoriaRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM Categoria";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Categoria obtenerPorId(int id) {
        String sql = "SELECT * FROM Categoria WHERE idCategoria = " + id;
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return map(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertar(Categoria categoria) {
        String sql = """
            INSERT INTO Categoria (nombre, descripcion)
            VALUES (?, ?)
        """;

        try (PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, categoria.getNombre());
            st.setString(2, categoria.getDescripcion());

            int rows = st.executeUpdate();

            if (rows > 0) {
                try (ResultSet rs = st.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean actualizar(Categoria categoria) {
        String sql = String.format("""
            UPDATE Categoria
            SET nombre = '%s',
                descripcion = '%s'
            WHERE idCategoria = %d
        """, categoria.getNombre(), categoria.getDescripcion(), categoria.getId());

        try (Statement st = conn.createStatement()) {
            return st.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Categoria WHERE idCategoria = " + id;
        try (Statement st = conn.createStatement()) {
            return st.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private Categoria map(ResultSet rs) throws SQLException {
        return new Categoria(
                rs.getInt("idCategoria"),
                rs.getString("nombre"),
                rs.getString("descripcion")
        );
    }
}
