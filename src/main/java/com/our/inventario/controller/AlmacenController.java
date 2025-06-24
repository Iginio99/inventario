/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.our.inventario.controller;

import com.our.inventario.view.AlmacenForm;

/**
 *
 * @author Acer
 */
public class AlmacenController {
    private final AlmacenForm almacenView;
    
    public AlmacenController(){
        this.almacenView = new AlmacenForm();
    }
    
    public void mostrarVista() {
        //almacenView.mostrar(service.listar());
    }
}
