package com.our.inventario.controller;

import com.our.inventario.model.Categoria;
import com.our.inventario.service.CategoriaService;
import java.util.List;

public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    public boolean crear(String nombre, String descripcion){
        return service.crearCategoria(nombre, descripcion);
    }

    public List<Categoria> listar() {
        return service.listar();
    }
}
