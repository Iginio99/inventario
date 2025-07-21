package com.our.inventario.model.repository;

import com.our.inventario.model.DetalleMovimiento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleMovimientoRepository {

    private final Connection conn;

    public DetalleMovimientoRepository(Connection conn) {
        this.conn = conn;
    }

    public List<DetalleMovimiento> listarPorNota(int idNotaMovimiento) {
        List<DetalleMovimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM DetalleMovimiento WHERE idNotaMovimiento = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, idNotaMovimiento);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    lista.add(map(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleMovimientoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean insertar(DetalleMovimiento detalle) {
        String sql = """
            INSERT INTO DetalleMovimiento (idNotaMovimiento, idProducto, cantidad, idLote)
            VALUES (?, ?, ?, ?)
        """;
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, detalle.getIdNotaMovimiento());
            st.setInt(2, detalle.getIdProducto());
            st.setBigDecimal(3, detalle.getCantidad());
            if (detalle.getIdLote() != null) {
                st.setInt(4, detalle.getIdLote());
            } else {
                st.setNull(4, Types.INTEGER);
            }
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleMovimientoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private DetalleMovimiento map(ResultSet rs) throws SQLException {
        DetalleMovimiento detalle = new DetalleMovimiento();
        detalle.setIdDetalleMovimiento(rs.getInt("idDetalleMovimiento"));
        detalle.setIdNotaMovimiento(rs.getInt("idNotaMovimiento"));
        detalle.setIdProducto(rs.getInt("idProducto"));
        detalle.setCantidad(rs.getBigDecimal("cantidad"));
        int idLote = rs.getInt("idLote");
        detalle.setIdLote(rs.wasNull() ? null : idLote);
        return detalle;
    }
}
