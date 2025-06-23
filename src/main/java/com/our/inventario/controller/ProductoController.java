package com.our.inventario.controller;

import com.our.inventario.service.ProductoService;
import com.our.inventario.util.Sesion;
import com.our.inventario.view.ProductoView;

public class ProductoController {

    private final ProductoService service;
    private final ProductoView productView;

    public ProductoController(ProductoService service) {
        this.service = service;
        this.productView = new ProductoView();
        this.productView.setOnRegistroProducto(e -> registrar());
        this.productView.setOnOpenNuevoProducto(e -> openVistaNuevo());
    }

    public void mostrarVista() {
        productView.mostrar(service.listar());
    }

    private void openVistaNuevo() {
        productView.mostrarRegistroProducto(Sesion.getCategorias());
    }

    private void registrar() {
        /*String correo = loginView.getCorreo();
        String contrasena = loginView.getContraseña();

        Either<String, Usuario> resultado = service.login(correo, contrasena);

        if (resultado.isRight()) {
            Usuario usuario = resultado.getRight();
            Sesion.iniciarSesion(usuario);
            loginView.cerrar();
            MenuView menu = new MenuView();
            menu.mostrar();
        } else {
            loginView.mostrarError(resultado.getLeft());
        }*/
    }
}
