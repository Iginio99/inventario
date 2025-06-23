package com.our.inventario.utils.algoritmos.algcategoria;

import com.our.inventario.model.Categoria;
import com.our.inventario.utils.algoritmos.arbolbinario.AbsArbolGeneral;

public class ArbolCategoria extends AbsArbolGeneral<Categoria, NodoCategoria> {

    @Override
    public NodoCategoria nuevoNodo(Categoria model) {
        return new NodoCategoria(model);
    }

    @Override
    public String getValueModel(Categoria model) {
        return model.getNombre();
    }

}
