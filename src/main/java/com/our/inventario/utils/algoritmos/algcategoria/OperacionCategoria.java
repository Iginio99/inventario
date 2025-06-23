package com.our.inventario.utils.algoritmos.algcategoria;

import com.our.inventario.model.Categoria;
import com.our.inventario.utils.algoritmos.pilas.AbsOperacion;
import com.our.inventario.utils.algoritmos.pilas.TipoOperacion;

public class OperacionCategoria extends AbsOperacion<Categoria>{
    
    public OperacionCategoria(TipoOperacion tipo, Categoria datoAnterior, Categoria datoActual) {
        super(tipo, datoAnterior, datoActual);
    }
    
}
