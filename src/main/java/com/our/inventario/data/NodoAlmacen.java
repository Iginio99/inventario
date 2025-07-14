package com.our.inventario.data;

import com.our.inventario.model.Almacen;
import com.our.inventario.utils.algoritmos.listaenlazada.AbsNodoTemp;

public class NodoAlmacen extends AbsNodoTemp<Almacen, NodoAlmacen> {

    public NodoAlmacen(Almacen model) {
        super(model);
    }

    @Override
    public String getValueModel() {
        return model.getNombre();
    }
}
