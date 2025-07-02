package com.our.inventario.data;

import com.our.inventario.model.Categoria;
import com.our.inventario.utils.algoritmos.listaenlazada.AbsListaTemp;

public class ListaCategoria extends AbsListaTemp<Categoria, NodoCategoria> {

    @Override
    public NodoCategoria getNuevoNodo(Categoria model) {
        return new NodoCategoria(model);
    }

    @Override
    public String getValueModel(Categoria model) {
        return model.getNombre();
    }
}