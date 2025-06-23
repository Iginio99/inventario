package com.our.inventario.utils.algoritmos.algcategoria;

import com.our.inventario.utils.algoritmos.pilas.AbsPila;

public class PilaCategoria extends AbsPila<OperacionCategoria, NodoPilaCategoria>{

    @Override
    public NodoPilaCategoria getNuevoNodoCola(OperacionCategoria operacion) {
        return new NodoPilaCategoria(operacion);
    }
    
}
