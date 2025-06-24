package com.our.inventario.controller;

import com.our.inventario.model.Categoria;
import com.our.inventario.service.CategoriaService;
import com.our.inventario.view.CategoriaForm;
import java.util.List;

public class CategoriaController {
    private final CategoriaService service;
    private final CategoriaForm categoryView;

    public CategoriaController(CategoriaService service) {
        this.service = service;
        this.categoryView = new CategoriaForm();
        this.categoryView.setOnRegistroCategoria(e -> registrar());
        this.categoryView.setOnOpenNuevoCategoria(e -> openVistaNuevo());
    }

    public boolean crear(String nombre, String descripcion){
        return service.crearCategoria(nombre, descripcion);
    }
    
    private void registrar(){
        
    }

    public List<Categoria> listar() {
        return service.listar();
    }
    
     public void mostrarVista() {
        categoryView.mostrar(service.listar());
    }

    private void openVistaNuevo() {
        categoryView.mostrarRegistroCategoria();
    }
}
