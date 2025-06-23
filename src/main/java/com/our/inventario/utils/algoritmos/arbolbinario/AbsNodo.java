package com.our.inventario.utils.algoritmos.arbolbinario;

public abstract class AbsNodo<T, R extends AbsNodo> {

    protected T model;
    private R izquierda;
    private R derecha;
    
    public abstract String getValueModel();

    public AbsNodo(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public R getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(R izquierda) {
        this.izquierda = izquierda;
    }

    public R getDerecha() {
        return derecha;
    }

    public void setDerecha(R derecha) {
        this.derecha = derecha;
    }

}
