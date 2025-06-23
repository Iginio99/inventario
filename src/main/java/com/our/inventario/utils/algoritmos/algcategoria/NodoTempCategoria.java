package com.our.inventario.utils.algoritmos.algcategoria;

import com.our.inventario.model.Categoria;
import com.our.inventario.utils.algoritmos.listaenlazada.AbsNodoTemp;

public class NodoTempCategoria extends AbsNodoTemp<Categoria, NodoTempCategoria>{

    public NodoTempCategoria(Categoria model) {
        super(model);
    }

    @Override
    public String getValueModel() {
        return model.getNombre();
    }
}
