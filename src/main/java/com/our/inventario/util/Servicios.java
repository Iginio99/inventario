package com.our.inventario.util;

import com.our.inventario.model.repository.AlmacenRepository;
import com.our.inventario.model.repository.CategoriaRepository;
import com.our.inventario.model.repository.ProductoRepository;
import com.our.inventario.service.AlmacenService;
import com.our.inventario.service.CategoriaService;
import com.our.inventario.service.NotaMovimientoService;
import com.our.inventario.service.ProductoService;

public class Servicios {

    public static CategoriaService getCategoriaService() {
        var conn = DbConnection.getInstance();
        var repo = new CategoriaRepository(conn);
        var service = new CategoriaService(repo);
        return service;
    }

    public static ProductoService getProductoService() {
        var conn = DbConnection.getInstance();
        var repo = new ProductoRepository(conn);
        var service = new ProductoService(repo);
        return service;
    }

    public static AlmacenService getAlmacenService() {
        var conn = DbConnection.getInstance();
        var repo = new AlmacenRepository(conn);
        var service = new AlmacenService(repo);
        return service;
    }

    public static NotaMovimientoService getNotaMovimientoService() {
        var conn = DbConnection.getInstance();
        var service = new NotaMovimientoService(conn);
        return service;
    }
}
