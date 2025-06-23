package com.our.inventario.utils.algoritmos.algcategoria;

import com.our.inventario.model.Categoria;
import com.our.inventario.utils.algoritmos.arbolbinario.AbsNodo;

public class NodoCategoria extends AbsNodo<Categoria, NodoCategoria> {

    public NodoCategoria(Categoria model) {
        super(model);
    }

    @Override
    public String getValueModel() {
        return model.getNombre();
    }
}
