package com.our.inventario.service;

import com.our.inventario.model.Producto;
import com.our.inventario.model.repository.ProductoRepository;
import java.util.List;

public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() {
        return repo.listar();
    }

    public Producto obtenerPorId(int id) {
        return repo.obtenerPorId(id);
    }

    public boolean insertar(Producto producto) {
        return repo.insertar(producto);
    }

    public boolean actualizar(Producto producto) {
        return repo.actualizar(producto);
    }

    public boolean eliminar(int id) {
        return repo.eliminar(id);
    }
}
