package com.our.inventario.controller;

import com.our.inventario.model.DetalleMovimiento;
import com.our.inventario.model.NotaMovimiento;
import com.our.inventario.service.AlmacenService;
import com.our.inventario.service.NotaMovimientoService;
import com.our.inventario.service.ProductoService;
import com.our.inventario.view.MovimientosForm;

import java.util.List;

public class MovimientoController {

    private final NotaMovimientoService movimientoService;
    private final MovimientosForm view;
    private int tipoMovimiento; // 1 entrada, 2 salida

    public MovimientoController(
            NotaMovimientoService movimientoService
    ) {
        this.movimientoService = movimientoService;
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
        tipoMovimiento = 1;
        view.limpiarFormulario();
        view.cerrarDialog();
        view.mostrarFormularioMovimiento("Nota de Entrada");
    }

    private void openNotaDeSalida() {
        tipoMovimiento = 2;
        view.limpiarFormulario();
        view.mostrarFormularioMovimiento("Nota de Salida");
    }

    private void regresarMenu() {
        view.cerrar();
        MenuController menu = new MenuController();
        menu.mostrarVista();
    }

    private void retrocederEleccion() {
        view.mostrarElegirTipo();
    }

    private void guardarMovimiento() {
        NotaMovimiento nota = new NotaMovimiento();
        nota.setTipo(tipoMovimiento);
        nota.setIdAlmacen(view.getAlmacenSeleccionado());
        // nota.setIdUsuario(GlobalData.usuarioActual.getIdUsuario());
        nota.setObservaciones(view.getObservaciones());

        List<DetalleMovimiento> detalles = view.getProductosConCantidad(tipoMovimiento);

        if (detalles.isEmpty()) {
            view.mostrarError("Debe agregar al menos un producto.");
            return;
        }

        boolean exito = movimientoService.insertar(nota, detalles);
        if (exito) {
            view.mostrarMensaje("Movimiento guardado exitosamente.");
            view.limpiarFormulario();
            view.mostrarElegirTipo();
        } else {
            view.mostrarError("Error al guardar el movimiento.");
        }
    }

    private void eliminarProducto() {
        view.eliminarProductoSeleccionado();
    }

    private void agregarProducto() {
        view.agregarProductoATabla();
    }

    private void limpiarTabla() {
        view.limpiarTablaProductos();
    }
}
