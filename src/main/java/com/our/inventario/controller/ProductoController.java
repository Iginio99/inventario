package com.our.inventario.controller;

import com.our.inventario.data.GlobalData;
import com.our.inventario.model.Categoria;
import com.our.inventario.model.Producto;
import com.our.inventario.service.CategoriaService;
import com.our.inventario.service.ProductoService;
import com.our.inventario.view.ProductoView;
import java.time.LocalDate;

public class ProductoController {

    private final ProductoService service;
    private final CategoriaService catService;
    private final ProductoView productView;
    private boolean isEdit;

    public ProductoController(ProductoService service, CategoriaService catService) {
        this.service = service;
        this.catService = catService;
        this.productView = new ProductoView();

        this.productView.setOnRegistroProducto(e -> accion());
        this.productView.setOnOpenNuevoProducto(e -> openVistaNuevo());
        this.productView.setOnOpenEditarProducto(e -> openVistaEditar());
        this.productView.setOnEliminarProducto(e -> eliminar());
        this.productView.setOnRegresarMenu(e -> regresar());
        this.productView.setOnCloseNuevoProducto(e -> cerrarVistaNuevo());
    }

    public void mostrarVista() {
        service.listar();
        productView.mostrar(GlobalData.arbolProducto);
    }

    public void actualizarVista() {
        productView.mostrar(GlobalData.arbolProducto);
    }

    private void openVistaNuevo() {
        isEdit = false;
        productView.limpiarDatos();
        catService.listar();
        productView.mostrarRegistroProducto(GlobalData.listaCategoria);
    }

    private void openVistaEditar() {
        isEdit = true;
        /*List<Categoria> categorias = catService.listar();
        Producto p = service.obtenerPorId(productView.getIdProductoSeleccionado());
        productView.mostrarEditarProducto(categorias, p);*/
    }

    private void cerrarVistaNuevo() {
        productView.cerrarVistaNuevoProducto();
    }

    private void accion() {
        if (isEdit) {
            editar();
        } else {
            registrar();
        }
        productView.cerrarVistaNuevoProducto();
    }

    private void registrar() {
        Producto nuevo = crearProductoDesdeFormulario();
        if (nuevo == null) {
            return;
        }

        nuevo.setFechaRegistro(LocalDate.now());

        boolean creado = service.insertar(nuevo);
        if (creado) {
            productView.mostrarMensaje("Producto registrado correctamente.");
            actualizarVista();
        } else {
            productView.mostrarError("Error al registrar el producto.");
        }
    }

    private void editar() {
        Producto actualizado = crearProductoDesdeFormulario();
        if (actualizado == null) {
            return;
        }

        actualizado.setIdProducto(productView.getIdProductoSeleccionado());

        boolean modificado = service.actualizar(actualizado);
        if (modificado) {
            productView.mostrarMensaje("Producto actualizado correctamente.");
            mostrarVista();
        } else {
            productView.mostrarError("Error al actualizar el producto.");
        }
    }

    private void eliminar() {
        int id = productView.getIdProductoSeleccionado();
        if (id <= 0) {
            productView.mostrarError("Seleccione un producto válido para eliminar.");
            return;
        }

        boolean eliminado = service.eliminar(id);
        if (eliminado) {
            productView.mostrarMensaje("Producto eliminado correctamente.");
            mostrarVista();
        } else {
            productView.mostrarError("Error al eliminar el producto.");
        }
    }

    private void regresar() {
        productView.cerrar();
        MenuController menuController = new MenuController();
        menuController.mostrarVista();
    }

    private Producto crearProductoDesdeFormulario() {
        try {
            String sku = productView.getSku();
            String nombre = productView.getNombre();
            String descripcion = productView.getDescripcion();
            Categoria categoria = productView.getCategoriaSeleccionada();
            String marca = productView.getMarca();
            double precio = productView.getPrecio();

            Producto p = new Producto(nombre, descripcion, categoria, marca, precio);
            p.setSku(sku);
            return p;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            productView.mostrarError("Datos inválidos: " + e.getMessage());
            return null;
        }
    }
}
