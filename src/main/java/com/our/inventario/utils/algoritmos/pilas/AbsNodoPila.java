package com.our.inventario.utils.algoritmos.pilas;

public abstract class AbsNodoPila<T> {

    private T operacion;
    private AbsNodoPila<T> siguiente;

    public AbsNodoPila(T operacion) {
        this.operacion = operacion;
    }

    public T getOperacion() {
        return operacion;
    }

    public void setOperacion(T operacion) {
        this.operacion = operacion;
    }

    public AbsNodoPila<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(AbsNodoPila<T> siguiente) {
        this.siguiente = siguiente;
    }

}
