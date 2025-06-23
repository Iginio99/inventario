package com.our.inventario.service;

import com.our.inventario.model.Producto;
import com.our.inventario.model.repository.ProductoRepository;
import java.util.List;

public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }
    
    public List<Producto> listar(){
        return repo.listar();
    }
}
