package com.our.inventario.service;

import com.our.inventario.data.GlobalData;
import com.our.inventario.data.ListaCategoria;
import com.our.inventario.model.Categoria;
import com.our.inventario.model.repository.CategoriaRepository;
import java.util.List;

public class CategoriaService {

    private final CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    public void listar() {
        List<Categoria> lista = repo.listar();
        GlobalData.listaCategoria = new ListaCategoria();
        for (Categoria cat : lista) {
            GlobalData.listaCategoria.agregar(cat);
        }
    }

    public Categoria obtenerPorId(int id) {
        return repo.obtenerPorId(id);
    }

    public boolean insertar(Categoria categoria) {
        int insertarRepo = repo.insertar(categoria);
        if (insertarRepo > 0) {
            categoria.setId(insertarRepo);
            GlobalData.listaCategoria.agregar(categoria);
        }
        return insertarRepo > 0;
    }

    public boolean actualizar(Categoria categoria) {
        return repo.actualizar(categoria);
    }

    public boolean eliminar(String name, int id) {
        boolean eliminarRepo = repo.eliminar(id);
        if (eliminarRepo) {
            return GlobalData.listaCategoria.eliminar(name);
        }
        return false;
    }
}
