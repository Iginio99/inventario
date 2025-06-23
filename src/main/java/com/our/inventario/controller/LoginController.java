package com.our.inventario.controller;

import com.our.inventario.model.Usuario;
import com.our.inventario.service.UsuarioService;
import com.our.inventario.util.Either;
import com.our.inventario.util.Sesion;
import com.our.inventario.view.LoginView;

public class LoginController {

    private final UsuarioService usuarioService;
    private final LoginView loginView;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        this.loginView = new LoginView();
        this.loginView.setOnLogin(e -> login());
    }

    private void login() {
        String correo = loginView.getCorreo();
        String contrasena = loginView.getContraseña();

        Either<String, Usuario> resultado = usuarioService.login(correo, contrasena);

        if (resultado.isRight()) {
            Usuario usuario = resultado.getRight();
            Sesion.iniciarSesion(usuario);
            loginView.cerrar();
            MenuController menuController = new MenuController();
            menuController.mostrarVista();
        } else {
            loginView.mostrarError(resultado.getLeft());
        }
    }
    
    public void mostrarVista(){
        loginView.mostrar();
    }
}
