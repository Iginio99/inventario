package com.our.inventario.model.repository;

import com.our.inventario.model.Categoria;
import com.our.inventario.model.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoRepository {

    private final Connection conn;

    public ProductoRepository(Connection conn) {
        this.conn = conn;
    }

    public List<Producto> listar() {
        List<Producto> list = new ArrayList<>();
        String sql = getConsultaProductosConCategoria();
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private Producto map(ResultSet rs) throws SQLException {
        return new Producto(
                rs.getInt("idProducto"),
                rs.getString("sku"),
                rs.getString("nombreProducto"),
                rs.getString("descripcionProducto"),
                new Categoria(
                        Long.valueOf(rs.getInt("idCategoria")),
                        rs.getString("nombreCategoria"),
                        rs.getString("descripcionCategoria")),
                rs.getString("marca"),
                rs.getDouble("precioUnitario"),
                rs.getDate("fechaRegistro").toLocalDate());
    }

    private String getConsultaProductosConCategoria() {
        return """
            SELECT 
                p.idProducto,
                p.sku,
                p.nombre AS nombreProducto,
                p.descripcion AS descripcionProducto,
                p.marca,
                p.precioUnitario,
                p.fechaRegistro,
                c.idCategoria,
                c.nombre AS nombreCategoria,
                c.nombre AS descripcionCategoria
            FROM 
                Producto p
            JOIN 
                Categoria c ON p.idCategoria = c.idCategoria
        """;
    }

}
