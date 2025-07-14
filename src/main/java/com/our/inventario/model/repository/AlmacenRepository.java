package com.our.inventario.model.repository;

import com.our.inventario.model.Almacen;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlmacenRepository {

    private final Connection conn;

    public AlmacenRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Almacen> listar() {
        List<Almacen> lista = new ArrayList<>();
        String sql = "SELECT * FROM Almacen";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlmacenRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Almacen obtenerPorId(int id) {
        String sql = "SELECT * FROM Almacen WHERE idAlmacen = " + id;
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return map(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlmacenRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertar(Almacen almacen) {
        String sql = """
            INSERT INTO Almacen (nombre)
            VALUES (?)
        """;

        try (PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, almacen.getNombre());

            int rows = st.executeUpdate();

            if (rows > 0) {
                try (ResultSet rs = st.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlmacenRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean actualizar(Almacen almacen) {
        String sql = String.format("""
            UPDATE Almacen
            SET nombre = '%s'
            WHERE idAlmacen = %d
        """, almacen.getNombre(), almacen.getIdAlmacen());

        try (Statement st = conn.createStatement()) {
            return st.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AlmacenRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Almacen WHERE idAlmacen = " + id;
        try (Statement st = conn.createStatement()) {
            return st.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AlmacenRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private Almacen map(ResultSet rs) throws SQLException {
        Almacen almacen = new Almacen();
        almacen.setIdAlmacen(rs.getInt("idAlmacen"));
        almacen.setNombre(rs.getString("nombre"));
        return almacen;
    }
}
