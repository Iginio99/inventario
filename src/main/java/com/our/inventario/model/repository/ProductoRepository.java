package com.our.inventario.model.repository;

import com.our.inventario.model.Categoria;
import com.our.inventario.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                        rs.getInt("idCategoria"),
                        rs.getString("nombreCategoria"),
                        rs.getString("descripcionCategoria")),
                rs.getString("marca"),
                rs.getDouble("precioUnitario"),
                rs.getDate("fechaRegistro").toLocalDate());
    }

    public Producto obtenerPorId(int id) {
        String sql = getConsultaProductosConCategoria() + " WHERE p.idProducto = " + id;
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return map(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertar(Producto producto) {
        String sql = """
            INSERT INTO Producto (sku, nombre, descripcion, idCategoria, marca, precioUnitario, fechaRegistro)
            VALUES (?, ?, ?, ?, ?, ?, NOW())
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, producto.getSku());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getCategoria().getId());
            ps.setString(5, producto.getMarca());
            ps.setDouble(6, producto.getPrecioUnitario());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1); // Devuelve el ID generado
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean actualizar(Producto producto) {
        String sql = String.format("""
            UPDATE Producto
            SET sku = '%s',
                nombre = '%s',
                descripcion = '%s',
                idCategoria = %d,
                marca = '%s',
                precioUnitario = %f
            WHERE idProducto = %d
        """,
                producto.getSku(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getCategoria().getId(),
                producto.getMarca(),
                producto.getPrecioUnitario(),
                producto.getIdProducto()
        );

        try (Statement st = conn.createStatement()) {
            return st.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Producto WHERE idProducto = " + id;

        try (Statement st = conn.createStatement()) {
            return st.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
