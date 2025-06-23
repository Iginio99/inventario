package com.our.inventario.util;

import com.our.inventario.model.Categoria;
import com.our.inventario.model.Usuario;
import java.util.List;

public class Sesion {

    private static Usuario usuarioActual;
    private static List<Categoria> categorias;

    public static void iniciarSesion(Usuario usuario) {
        usuarioActual = usuario;
    }
    
    public static void setCategorias(List<Categoria> categoriasBd){
        categorias = categoriasBd;
    }
    
    public static List<Categoria> getCategorias(){
        return categorias;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }

    public static boolean estaLogueado() {
        return usuarioActual != null;
    }
}
