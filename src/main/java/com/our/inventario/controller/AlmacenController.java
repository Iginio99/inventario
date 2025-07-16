package com.our.inventario.controller;

import com.our.inventario.data.GlobalData;
import com.our.inventario.model.Almacen;
import com.our.inventario.service.AlmacenService;
import com.our.inventario.view.AlmacenForm;

public class AlmacenController {

    private final AlmacenService service;
    private final AlmacenForm view;
    private boolean isEdit;

    public AlmacenController(AlmacenService service) {
        this.service = service;
        this.view = new AlmacenForm();

        view.setOnRegistroAlmacen(e -> accion());
        view.setOnOpenNuevoAlmacen(e -> openVistaNuevo());
        view.setOnOpenEditarAlmacen(e -> openVistaEditar());
        view.setOnAddLote(e -> openVistaLote());
        view.setOnAddStock(e -> openVistaStock());
        view.setOnEliminarAlmacen(e -> eliminar());
        view.setOnRegresarMenu(e -> regresar());
        view.setOnCloseNuevoAlmacen(e -> cerrarVistaNuevo());
    }

    public void mostrarVista() {
        service.listar();
        view.mostrar(GlobalData.listaAlmacen);
    }

    public void actualizarVista() {
        view.mostrar(GlobalData.listaAlmacen);
    }

    private void openVistaNuevo() {
        isEdit = false;
        view.limpiarDatosRegistro();
        view.mostrarRegistroAlmacen();
    }

    private void openVistaEditar() {
        isEdit = true;
        Almacen a = service.obtenerPorId(view.getIdAlmacenSeleccionado());
        view.mostrarEditarAlmacen(a);
    }
    
    private void openVistaLote() {
        Almacen a = service.obtenerPorId(view.getIdAlmacenSeleccionado());
        view.mostrarLotes(a);
    }
    
    private void openVistaStock() {
        Almacen a = service.obtenerPorId(view.getIdAlmacenSeleccionado());
        view.mostrarEditarAlmacen(a);
    }

    private void cerrarVistaNuevo() {
        view.cerrarVistaNuevoAlmacen();
    }

    private void accion() {
        if (isEdit) {
            editar();
        } else {
            registrar();
        }
    }

    private void registrar() {
        Almacen nuevo = crearAlmacenDesdeFormulario();
        if (nuevo == null) return;

        boolean creado = service.insertar(nuevo);
        if (creado) {
            view.mostrarMensaje("Almacén registrado correctamente.");
            actualizarVista();
        } else {
            view.mostrarError("Error al registrar el almacén.");
        }
    }

    private void editar() {
        Almacen actualizado = crearAlmacenDesdeFormulario();
        if (actualizado == null) return;

        actualizado.setIdAlmacen(view.getIdAlmacenSeleccionado());

        boolean modificado = service.actualizar(actualizado);
        if (modificado) {
            view.mostrarMensaje("Almacén actualizado correctamente.");
            mostrarVista();
        } else {
            view.mostrarError("Error al actualizar el almacén.");
        }
    }

    private void eliminar() {
        int id = view.getIdAlmacenSeleccionado();
        String name = view.getNameAlmacenSeleccionado();
        if (id <= 0 || name == null) {
            view.mostrarError("Seleccione un almacén válido para eliminar.");
            return;
        }

        boolean eliminado = service.eliminar(name, id);
        if (eliminado) {
            view.mostrarMensaje("Almacén eliminado correctamente.");
            actualizarVista();
        } else {
            view.mostrarError("Error al eliminar el almacén.");
        }
    }

    private void regresar() {
        view.cerrar();
        MenuController menu = new MenuController();
        menu.mostrarVista();
    }

    private Almacen crearAlmacenDesdeFormulario() {
        try {
            String nombre = view.getNombre();

            if (nombre == null || nombre.isBlank()) {
                view.mostrarError("El nombre del almacén es obligatorio.");
                return null;
            }

            Almacen a = new Almacen();
            a.setNombre(nombre);
            return a;

        } catch (Exception e) {
            view.mostrarError("Error al leer los datos: " + e.getMessage());
            return null;
        }
    }
}
