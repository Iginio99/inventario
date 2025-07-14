package com.our.inventario.data;

import com.our.inventario.model.Almacen;
import com.our.inventario.utils.algoritmos.listaenlazada.AbsListaTemp;

public class ListaAlmacen extends AbsListaTemp<Almacen, NodoAlmacen> {

    @Override 
    public NodoAlmacen getNuevoNodo(Almacen model) {
        return new NodoAlmacen(model);
    }

    @Override
    public String getValueModel(Almacen model) {
        return model.getNombre();
    }
}
