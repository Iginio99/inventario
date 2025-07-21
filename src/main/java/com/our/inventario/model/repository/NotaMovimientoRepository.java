package com.our.inventario.model.repository;

import com.our.inventario.model.NotaMovimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotaMovimientoRepository {
    private final Connection conn;

    public NotaMovimientoRepository(Connection conn) {
        this.conn = conn;
    }

    public List<NotaMovimiento> listar() {
        List<NotaMovimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM NotaMovimiento ORDER BY fecha DESC";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaMovimientoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public NotaMovimiento obtenerPorId(int id) {
        String sql = "SELECT * FROM NotaMovimiento WHERE idNotaMovimiento = " + id;
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return map(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaMovimientoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertar(NotaMovimiento nota) {
        String sql = """
            INSERT INTO NotaMovimiento (tipo, fecha, observaciones, idAlmacen, idUsuario)
            VALUES (?, ?, ?, ?, ?)
        """;
        try (PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setInt(1, nota.getTipo());
            st.setTimestamp(2, new Timestamp(nota.getFecha().getTime()));
            st.setString(3, nota.getObservaciones());
            st.setInt(4, nota.getIdAlmacen());
            st.setInt(5, nota.getIdUsuario());

            int rows = st.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = st.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaMovimientoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    private NotaMovimiento map(ResultSet rs) throws SQLException {
        NotaMovimiento nota = new NotaMovimiento();
        nota.setIdNotaMovimiento(rs.getInt("idNotaMovimiento"));
        nota.setTipo(rs.getInt("tipo"));
        nota.setFecha(rs.getTimestamp("fecha"));
        nota.setObservaciones(rs.getString("observaciones"));
        nota.setIdAlmacen(rs.getInt("idAlmacen"));
        nota.setIdUsuario(rs.getInt("idUsuario"));
        return nota;
    }
}
