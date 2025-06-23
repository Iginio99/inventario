package com.our.inventario.utils.algoritmos.arbolbinario;

public abstract class AbsArbolGeneral<T, R extends AbsNodo<T, R>> {

    private R raiz;

    protected abstract R nuevoNodo(T model);

    protected abstract String getValueModel(T model);

    public void insertar(T model) {
        raiz = insertarRec(raiz, model);
    }
    
    public void insertarSinDuplicados(T model) {
        raiz = insertarSinDuplicadosRec(raiz, model);
    }

    private R insertarRec(R nodo, T model) {
        if (nodo == null) {
            return nuevoNodo(model);
        }
        if (getValueModel(model).compareToIgnoreCase(nodo.getValueModel()) < 0) {
            nodo.setIzquierda(insertarRec(nodo.getIzquierda(), model));
        } else {
            nodo.setDerecha(insertarRec(nodo.getDerecha(), model));
        }
        return nodo;
    }

    private R insertarSinDuplicadosRec(R nodo, T model) {
        if (nodo == null) {
            return nuevoNodo(model);
        }

        int cmp = getValueModel(model).compareToIgnoreCase(nodo.getValueModel());

        if (cmp < 0) {
            nodo.setIzquierda(insertarRec(nodo.getIzquierda(), model));
        } else if (cmp > 0) {
            nodo.setDerecha(insertarRec(nodo.getDerecha(), model));
        } else {
            // Ya existe un nodo con el mismo nombre
            System.out.println("Elemento duplicado no insertado: " + getValueModel(model));
            // Opcionalmente podrías lanzar una excepción o ignorarlo
        }

        return nodo;
    }

    public boolean buscar(String value) {
        return buscarRec(raiz, value);
    }

    private boolean buscarRec(R nodo, String nombre) {
        if (nodo == null) {
            return false;
        }
        int cmp = nombre.compareToIgnoreCase(nodo.getValueModel());
        if (cmp == 0) {
            return true;
        }
        if (cmp < 0) {
            return buscarRec(nodo.getIzquierda(), nombre);
        } else {
            return buscarRec(nodo.getDerecha(), nombre);
        }
    }

    public void inOrdenAsc() {
        inOrdenAscRec(raiz);
    }

    private void inOrdenAscRec(R nodo) {
        if (nodo != null) {
            inOrdenAscRec(nodo.getIzquierda());
            System.out.println(nodo.getModel());
            inOrdenAscRec(nodo.getDerecha());
        }
    }

    public void inOrdenDesc() {
        inOrdenDescRec(raiz);
    }

    private void inOrdenDescRec(R nodo) {
        if (nodo != null) {
            inOrdenDescRec(nodo.getDerecha());
            System.out.println(nodo.getModel());
            inOrdenDescRec(nodo.getIzquierda());
        }
    }

    public void eliminar(String nombre) {
        raiz = eliminarRec(raiz, nombre);
    }

    private R eliminarRec(R nodo, String nombre) {
        if (nodo == null) {
            return null;
        }

        int cmp = nombre.compareToIgnoreCase(nodo.getValueModel());

        if (cmp < 0) {
            nodo.setIzquierda(eliminarRec(nodo.getIzquierda(), nombre));
        } else if (cmp > 0) {
            nodo.setDerecha(eliminarRec(nodo.getDerecha(), nombre));
        } else {
            // Caso 1: sin hijos
            if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {
                return null;
            }

            // Caso 2: un hijo
            if (nodo.getIzquierda() == null) {
                return nodo.getDerecha();
            }
            if (nodo.getDerecha() == null) {
                return nodo.getIzquierda();
            }

            // Caso 3: dos hijos
            R sucesor = obtenerMinimo(nodo.getDerecha());
            nodo.setModel(sucesor.getModel());
            nodo.setDerecha(eliminarRec(nodo.getDerecha(), sucesor.getValueModel()));
        }
        return nodo;
    }

    private R obtenerMinimo(R nodo) {
        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda();
        }
        return nodo;
    }
}
