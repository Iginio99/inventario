package com.our.inventario.data;

import com.our.inventario.model.Producto;
import com.our.inventario.utils.algoritmos.arbolbinario.AbsArbolGeneral;

public class ArbolProducto extends AbsArbolGeneral<Producto, NodoProducto>{

    @Override
    protected NodoProducto nuevoNodo(Producto model) {
        return new NodoProducto(model);
    }

    @Override
    protected String getValueModel(Producto model) {
        return model.getNombre();
    }
}
