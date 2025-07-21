package com.our.inventario.service;

import com.our.inventario.model.DetalleMovimiento;
import com.our.inventario.model.NotaMovimiento;
import com.our.inventario.model.repository.DetalleMovimientoRepository;
import com.our.inventario.model.repository.NotaMovimientoRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotaMovimientoService {

    private final NotaMovimientoRepository notaRepo;
    private final DetalleMovimientoRepository detalleRepo;
    private final Connection conn;

    public NotaMovimientoService(Connection conn) {
        this.conn = conn;
        this.notaRepo = new NotaMovimientoRepository(conn);
        this.detalleRepo = new DetalleMovimientoRepository(conn);
    }

    public List<NotaMovimiento> listar() {
        return notaRepo.listar();
    }

    public NotaMovimiento obtenerPorId(int id) {
        return notaRepo.obtenerPorId(id);
    }

    public boolean insertar(NotaMovimiento nota, List<DetalleMovimiento> detalles) {
        try {
            conn.setAutoCommit(false);

            int idNota = notaRepo.insertar(nota);
            if (idNota <= 0) {
                conn.rollback();
                return false;
            }
            nota.setIdNotaMovimiento(idNota);

            for (DetalleMovimiento det : detalles) {
                det.setIdNotaMovimiento(idNota);
                if (!detalleRepo.insertar(det)) {
                    conn.rollback();
                    return false;
                }
            }

            conn.commit();
            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                Logger.getLogger(NotaMovimientoService.class.getName()).log(Level.SEVERE, null, e);
            }
            Logger.getLogger(NotaMovimientoService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                Logger.getLogger(NotaMovimientoService.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
