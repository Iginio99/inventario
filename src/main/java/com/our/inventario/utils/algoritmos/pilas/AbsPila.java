package com.our.inventario.utils.algoritmos.pilas;

public abstract class AbsPila<T, R extends AbsNodoPila> {

    protected AbsNodoPila<T> cima;

    public abstract R getNuevoNodoCola(T operacion);

    public void apilar(T operacion) {
        AbsNodoPila<T> nuevo = getNuevoNodoCola(operacion);
        nuevo.setSiguiente(nuevo);
        cima = nuevo;
    }

    public T verCima() {
        return estaVacia() ? null : cima.getOperacion();
    }

    public T desapilar() {
        if (estaVacia()) {
            return null;
        }
        T operacion = cima.getOperacion();
        cima = cima.getSiguiente();
        return operacion;
    }

    public boolean estaVacia() {
        return cima == null;
    }
}
