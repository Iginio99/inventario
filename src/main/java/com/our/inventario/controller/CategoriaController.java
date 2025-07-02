package com.our.inventario.controller;

import com.our.inventario.data.GlobalData;
import com.our.inventario.model.Categoria;
import com.our.inventario.service.CategoriaService;
import com.our.inventario.view.CategoriaForm;

public class CategoriaController {

    private final CategoriaService service;
    private final CategoriaForm view;
    private boolean isEdit;

    public CategoriaController(CategoriaService service) {
        this.service = service;
        this.view = new CategoriaForm();

        view.setOnRegistroCategoria(e -> accion());
        view.setOnOpenNuevoCategoria(e -> openVistaNuevo());
        view.setOnOpenEditarCategoria(e -> openVistaEditar());
        view.setOnEliminarCategoria(e -> eliminar());
        view.setOnRegresarMenu(e -> regresar());
        view.setOnCloseNuevoCategoria(e -> cerrarVistaNuevo());
    }

    public void mostrarVista() {
        service.listar();
        view.mostrar(GlobalData.listaCategoria);
    }
    
    public void actualizarVista(){
        view.mostrar(GlobalData.listaCategoria);
    }

    private void openVistaNuevo() {
        isEdit = false;
        view.limpiarDatosRegistro();
        view.mostrarRegistroCategoria();
    }
    
    private void openVistaEditar() {
        isEdit = true;
        Categoria c = service.obtenerPorId(view.getIdCategoriaSeleccionada());
        view.mostrarEditarCategoria(c);
    }

    private void cerrarVistaNuevo() {
        view.cerrarVistaNuevoCategoria();
    }
    
    private void accion(){
        if (isEdit) {
            editar();
        } else {
            registrar();
        }
    }

    private void registrar() {
        Categoria nueva = crearCategoriaDesdeFormulario();
        if (nueva == null) return;

        boolean creado = service.insertar(nueva);
        if (creado) {
            view.mostrarMensaje("Categoría registrada correctamente.");
            actualizarVista();
        } else {
            view.mostrarError("Error al registrar la categoría.");
        }
    }

    private void editar() {
        Categoria actualizada = crearCategoriaDesdeFormulario();
        if (actualizada == null) return;

        actualizada.setId(view.getIdCategoriaSeleccionada());

        boolean modificado = service.actualizar(actualizada);
        if (modificado) {
            view.mostrarMensaje("Categoría actualizada correctamente.");
            mostrarVista();
        } else {
            view.mostrarError("Error al actualizar la categoría.");
        }
    }

    private void eliminar() {
        int id = view.getIdCategoriaSeleccionada();
        String name = view.getNameCategoriaSeleccionada();
        if (id <= 0 || name ==  null) {
            view.mostrarError("Seleccione una categoría válida para eliminar.");
            return;
        }

        boolean eliminado = service.eliminar(name, id);
        if (eliminado) {
            view.mostrarMensaje("Categoría eliminada correctamente.");
            actualizarVista();
        } else {
            view.mostrarError("Error al eliminar la categoría.");
        }
    }

    private void regresar() {
        view.cerrar();
        MenuController menu = new MenuController();
        menu.mostrarVista();
    }

    private Categoria crearCategoriaDesdeFormulario() {
        try {
            String nombre = view.getNombre();
            String descripcion = view.getDescripcion();

            if (nombre == null || nombre.isBlank()) {
                view.mostrarError("El nombre de la categoría es obligatorio.");
                return null;
            }

            return new Categoria(0, nombre, descripcion);

        } catch (Exception e) {
            view.mostrarError("Error al leer los datos: " + e.getMessage());
            return null;
        }
    }
}
