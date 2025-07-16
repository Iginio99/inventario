package com.our.inventario.model.repository;

import com.our.inventario.model.Lote;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoteRepository {

    private final Connection conn;

    public LoteRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Lote> listar() {
        List<Lote> lista = new ArrayList<>();
        String sql = "SELECT * FROM Lote";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Lote obtenerPorId(int id) {
        String sql = "SELECT * FROM Lote WHERE idLote = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertar(Lote lote) {
        String sql = "INSERT INTO Lote (nombre, idAlmacen) VALUES (?, ?)";
        try (PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, lote.getNombre());
            st.setInt(2, lote.getIdAlmacen());

            int rows = st.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = st.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean actualizar(Lote lote) {
        String sql = "UPDATE Lote SET nombre = ?, idAlmacen = ? WHERE idLote = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, lote.getNombre());
            st.setInt(2, lote.getIdAlmacen());
            st.setInt(3, lote.getIdLote());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(LoteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Lote WHERE idLote = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(LoteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private Lote map(ResultSet rs) throws SQLException {
        Lote lote = new Lote();
        lote.setIdLote(rs.getInt("idLote"));
        lote.setNombre(rs.getString("nombre"));
        lote.setIdAlmacen(rs.getInt("idAlmacen"));
        return lote;
    }
}
