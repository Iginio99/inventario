package com.our.inventario.controller;

import com.our.inventario.model.repository.ProductoRepository;
import com.our.inventario.model.repository.UsuarioRepository;
import com.our.inventario.service.ProductoService;
import com.our.inventario.service.UsuarioService;
import com.our.inventario.util.DbConnection;
import com.our.inventario.util.Servicios;
import com.our.inventario.util.Sesion;
import com.our.inventario.view.MenuView;

public class MenuController {

    private final MenuView menuView;

    public MenuController() {
        this.menuView = new MenuView();
        this.menuView.setOnOpenProductos(e -> abrirGestionProductos());
        this.menuView.setOnOpenCategorias(e-> abrirGestionCategorias());
        this.menuView.setOnOpenCategorias(e-> abrirGestionAlmacenes());        
        this.menuView.setOnOpenCategorias(e-> abrirGestionStock());

    }

    private void abrirGestionProductos() {
        var categorias = Servicios.getCategoriaService().listar();
        Sesion.setCategorias(categorias);
        var controller = new ProductoController(Servicios.getProductoService());
        menuView.cerrar();
        controller.mostrarVista();
    }
    
    private void abrirGestionCategorias(){
        var controller = new CategoriaController(Servicios.getCategoriaService());
        menuView.cerrar();
        controller.mostrarVista();
    }
    
    private void abrirGestionAlmacenes(){
        var controller = new AlmacenController(/*Servicios.getCategoriaService()*/);
        menuView.cerrar();
        controller.mostrarVista();
    }
    
    private void abrirGestionStock(){
        var controller = new StockController(/*Servicios.getCategoriaService()*/);
        menuView.cerrar();
        controller.mostrarVista();
    }

    public void mostrarVista() {
        menuView.mostrar();
    }
}
