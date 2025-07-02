package com.our.inventario.data;

import com.our.inventario.model.Categoria;
import com.our.inventario.utils.algoritmos.listaenlazada.AbsNodoTemp;

public class NodoCategoria extends AbsNodoTemp<Categoria, NodoCategoria> {

    public NodoCategoria(Categoria model) {
        super(model);
    }

    @Override
    public String getValueModel() {
        return model.getNombre();
    }
}