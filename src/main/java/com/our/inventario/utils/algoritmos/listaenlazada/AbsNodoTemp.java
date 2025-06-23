package com.our.inventario.utils.algoritmos.listaenlazada;

public abstract class AbsNodoTemp<T, R extends AbsNodoTemp> {

    protected T model;
    private R siguiente;

    public AbsNodoTemp(T model) {
        this.model = model;
        this.siguiente = null;
    }
    
    public abstract String getValueModel();

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public R getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(R siguiente) {
        this.siguiente = siguiente;
    }

}
