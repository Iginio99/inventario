package com.our.inventario.data;

import com.our.inventario.model.Producto;
import com.our.inventario.utils.algoritmos.arbolbinario.AbsNodo;

public class NodoProducto extends AbsNodo<Producto, NodoProducto> {

    public NodoProducto(Producto model) {
        super(model);
    }

    @Override
    public String getValueModel() {
        return model.getNombre();
    }
}
