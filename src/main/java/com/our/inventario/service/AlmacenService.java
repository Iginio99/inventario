package com.our.inventario.service;

import com.our.inventario.data.GlobalData;
import com.our.inventario.data.ListaAlmacen;
import com.our.inventario.model.Almacen;
import com.our.inventario.model.repository.AlmacenRepository;
import java.util.List;

public class AlmacenService {

    private final AlmacenRepository repo;

    public AlmacenService(AlmacenRepository repo) {
        this.repo = repo;
    }

    public void listar() {
        List<Almacen> lista = repo.listar();
        GlobalData.listaAlmacen = new ListaAlmacen();
        for (Almacen alm : lista) {
            GlobalData.listaAlmacen.agregar(alm);
        }
    }

    public Almacen obtenerPorId(int id) {
        return repo.obtenerPorId(id);
    }

    public boolean insertar(Almacen almacen) {
        int insertarRepo = repo.insertar(almacen);
        if (insertarRepo > 0) {
            almacen.setIdAlmacen(insertarRepo);
            GlobalData.listaAlmacen.agregar(almacen);
        }
        return insertarRepo > 0;
    }

    public boolean actualizar(Almacen almacen) {
        return repo.actualizar(almacen);
    }

    public boolean eliminar(String name, int id) {
        boolean eliminarRepo = repo.eliminar(id);
        if (eliminarRepo) {
            return GlobalData.listaAlmacen.eliminar(name);
        }
        return false;
    }
}
