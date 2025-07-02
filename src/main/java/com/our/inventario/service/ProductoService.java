package com.our.inventario.service;

import com.our.inventario.data.ArbolProducto;
import com.our.inventario.data.GlobalData;
import com.our.inventario.model.Producto;
import com.our.inventario.model.repository.ProductoRepository;
import java.util.List;

public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public void listar() {
        List<Producto> productos = repo.listar();
        GlobalData.arbolProducto = new ArbolProducto();
        for (Producto p : productos) {
            GlobalData.arbolProducto.insertarSinDuplicados(p);
        }
    }

    public Producto obtenerPorId(int id) {
        return repo.obtenerPorId(id);
    }

    public boolean insertar(Producto producto) {
        int id = repo.insertar(producto);
        if (id > 0) {
            GlobalData.arbolProducto.insertarSinDuplicados(producto);
        }
        return id > 0;
    }

    public boolean actualizar(Producto producto) {
        return repo.actualizar(producto);
    }

    public boolean eliminar(int id) {
        return repo.eliminar(id);
    }
}
