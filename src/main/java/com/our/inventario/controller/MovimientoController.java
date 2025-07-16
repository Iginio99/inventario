package com.our.inventario.controller;

import com.our.inventario.view.MovimientosForm;

public class MovimientoController {

    private final MovimientosForm view;

    public MovimientoController() {
        this.view = new MovimientosForm();

        view.setOnOpenNotaDeEntrada(e -> openNotaDeEntrada());
        view.setOnOpenNotaDeSalida(e -> openNotaDeSalida());
        view.setOnRegresarMenu(e -> regresarMenu());
        view.setOnRegresarEleccion(e -> retrocederEleccion());
        view.setOnGuardarMovimiento(e -> guardarMovimiento());
        view.setOnEliminarProducto(e -> eliminarProducto());
        view.setOnAgregarProducto(e -> agregarProducto());
        view.setOnLimpiar(e -> limpiarTabla());
    }

    public void mostrarVista() {
        view.mostrarElegirTipo();
    }
    
    private void openNotaDeEntrada() {
        // Mostrar formulario de registro de entrada
    }

    private void openNotaDeSalida() {
        // Mostrar formulario de registro de salida
    }

    private void regresarMenu() {
        // Cerrar todo y volver al menú principal
    }

    private void retrocederEleccion() {
        // Ocultar dialog de tipo movimiento
    }

    private void guardarMovimiento() {
        // Guardar nota de movimiento (entrada o salida)
    }

    private void eliminarProducto() {
        // Eliminar producto de la tabla
    }

    private void agregarProducto() {
        // Agregar producto y cantidad a la tabla
    }

    private void limpiarTabla() {
        // Vaciar la tabla de productos del movimiento
    }
}
