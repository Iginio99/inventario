package com.our.inventario.controller;

import com.our.inventario.util.Servicios;
import com.our.inventario.view.MenuView;

public class MenuController {

    private final MenuView menuView;

    public MenuController() {
        this.menuView = new MenuView();
        this.menuView.setOnOpenProductos(e -> abrirGestionProductos());
        this.menuView.setOnOpenCategorias(e -> abrirGestionCategorias());
        this.menuView.setOnOpenAlmacen(e -> abrirGestionAlmacenes());
        this.menuView.setOnOpenMovmimientos(e -> abrirGestionMovmimientos());

    }

    private void abrirGestionProductos() {
        var controller = new ProductoController(Servicios.getProductoService(), Servicios.getCategoriaService());
        menuView.cerrar();
        controller.mostrarVista();
    }

    private void abrirGestionCategorias() {
        var controller = new CategoriaController(Servicios.getCategoriaService());
        menuView.cerrar();
        controller.mostrarVista();
    }

    private void abrirGestionAlmacenes() {
        var controller = new AlmacenController(Servicios.getAlmacenService());
        menuView.cerrar();
        controller.mostrarVista();
    }

    private void abrirGestionMovmimientos() {
        Servicios.getProductoService().listar();
        var controller = new MovimientoController(Servicios.getNotaMovimientoService());
        menuView.cerrar();
        controller.mostrarVista();
    }

    public void mostrarVista() {
        menuView.mostrar();
    }
}
