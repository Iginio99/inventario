package com.our.inventario.controller;

import com.our.inventario.view.StockForm;

public class StockController {
    private final StockForm stockView;
    
    public StockController(){
        this.stockView = new StockForm();
    }
    
    public void mostrarVista() {
        //almacenView.mostrar(service.listar());
    }
}
