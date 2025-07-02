package com.our.inventario.utils.algoritmos.listaenlazada;

import com.our.inventario.utils.algoritmos.arbolbinario.AbsArbolGeneral;

public abstract class AbsListaTemp<T, R extends AbsNodoTemp> {

    private R puntero;
    private R start;

    public AbsListaTemp() {
        puntero = null;
        start = null;
    }

    public abstract R getNuevoNodo(T model);

    public abstract String getValueModel(T model);

    public void agregar(T model) {
        R nuevo = getNuevoNodo(model);
        nuevo.setSiguiente(null);
        if (start == null) {
            puntero = nuevo;
            start = puntero;
        } else {
            puntero.setSiguiente(nuevo);
            puntero = nuevo;
        }
    }

    public boolean eliminar(String nombre) {
        R actual = start;
        R anterior = null;

        while (actual != null) {
            if (actual.getValueModel().equalsIgnoreCase(nombre)) {
                if (anterior == null) {
                    start = (R) actual.getSiguiente();
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                return true;
            } else {
                anterior = actual;
                actual = (R) actual.getSiguiente();
            }
        }
        return false;
    }

    public void mostrar() {
        R actual = puntero;
        while (actual != null) {
            T m = (T) actual.getModel();
            System.out.println("Categoria: " + getValueModel(m));
            actual = (R) actual.getSiguiente();
        }
    }

    public void confirmar(AbsArbolGeneral arbol) {
        R actual = puntero;
        while (actual != null) {
            arbol.insertar(actual.getModel());
            actual = (R) actual.getSiguiente();
        }
        puntero = null;
    }

    public R getStart() {
        return start;
    }

    public boolean estaVacia() {
        return puntero == null;
    }
}
