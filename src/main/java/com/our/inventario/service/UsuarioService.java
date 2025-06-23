package com.our.inventario.service;

import com.our.inventario.model.Usuario;
import com.our.inventario.model.repository.UsuarioRepository;
import com.our.inventario.util.Either;

public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Either<String, Usuario> login(String correo, String contraseña) {
        return repo.login(correo, contraseña);
    }
}
