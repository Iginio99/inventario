package com.our.inventario.controller;

import com.our.inventario.model.Categoria;
import com.our.inventario.model.Producto;
import com.our.inventario.service.ProductoService;
import com.our.inventario.util.Sesion;
import com.our.inventario.view.ProductoView;
import java.time.LocalDate;
import java.util.List;

public class ProductoController {

    private final ProductoService service;
    private final ProductoView productView;

    public ProductoController(ProductoService service) {
        this.service = service;
        this.productView = new ProductoView();

        this.productView.setOnRegistroProducto(e -> registrar());
        this.productView.setOnOpenNuevoProducto(e -> openVistaNuevo());
        this.productView.setOnEditarProducto(e -> editar());
        this.productView.setOnEliminarProducto(e -> eliminar());
    }

    public void mostrarVista() {
        productView.mostrar(service.listar());
    }

    private void openVistaNuevo() {
        List<Categoria> categorias = Sesion.getCategorias(); // obtenemos categorías en sesión
        productView.mostrarRegistroProducto(categorias);
    }

    private void registrar() {
        Producto nuevo = crearProductoDesdeFormulario();
        if (nuevo == null) return;

        nuevo.setFechaRegistro(LocalDate.now());

        boolean creado = service.insertar(nuevo);
        if (creado) {
            productView.mostrarMensaje("Producto registrado correctamente.");
            mostrarVista();
        } else {
            productView.mostrarError("Error al registrar el producto.");
        }
    }

    private void editar() {
        Producto actualizado = crearProductoDesdeFormulario();
        if (actualizado == null) return;

        actualizado.setIdProducto(productView.getIdProducto()); // ID viene de formulario

        boolean modificado = service.actualizar(actualizado);
        if (modificado) {
            productView.mostrarMensaje("Producto actualizado correctamente.");
            mostrarVista();
        } else {
            productView.mostrarError("Error al actualizar el producto.");
        }
    }

    private void eliminar() {
        int id = productView.getIdProductoSeleccionado(); // de tabla o formulario
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

    // Helper para leer el formulario
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
