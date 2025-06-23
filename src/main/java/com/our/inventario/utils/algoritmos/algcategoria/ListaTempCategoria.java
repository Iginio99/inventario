package com.our.inventario.utils.algoritmos.algcategoria;

import com.our.inventario.model.Categoria;
import com.our.inventario.utils.algoritmos.listaenlazada.AbsListaTemp;

public class ListaTempCategoria extends AbsListaTemp<Categoria, NodoTempCategoria>{

    @Override
    public NodoTempCategoria getNuevoNodo(Categoria model) {
        return new NodoTempCategoria(model);
    }

    @Override
    public String getValueModel(Categoria model) {
        return model.getNombre();
    }
    
}
