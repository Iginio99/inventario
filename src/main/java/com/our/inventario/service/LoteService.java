package com.our.inventario.service;

import com.our.inventario.data.GlobalData;
import com.our.inventario.data.ListaLote;
import com.our.inventario.model.Lote;
import com.our.inventario.model.repository.LoteRepository;
import java.util.List;

public class LoteService {

  /*  private final LoteRepository repo;

    public LoteService(LoteRepository repo) {
        this.repo = repo;
    }

    public void listar() {
        List<Lote> lista = repo.listar();
        GlobalData.listaLote = new ListaLote();
        for (Lote lote : lista) {
            GlobalData.listaLote.agregar(lote);
        }
    }

    public Lote obtenerPorId(int id) {
        return repo.obtenerPorId(id);
    }

    public boolean insertar(Lote lote) {
        int insertarRepo = repo.insertar(lote);
        if (insertarRepo > 0) {
            lote.setIdLote(insertarRepo);
            GlobalData.listaLote.agregar(lote);
        }
        return insertarRepo > 0;
    }

    public boolean actualizar(Lote lote) {
        return repo.actualizar(lote);
    }

    public boolean eliminar(String nombre, int id) {
        boolean eliminarRepo = repo.eliminar(id);
        if (eliminarRepo) {
            return GlobalData.listaLote.eliminar(nombre);
        }
        return false;
    }*/
}
