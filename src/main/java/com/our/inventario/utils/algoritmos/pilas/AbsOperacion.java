package com.our.inventario.utils.algoritmos.pilas;

public abstract class AbsOperacion<T> {

    private TipoOperacion tipo;
    private T datoAnterior;
    private T datoActual;

    public AbsOperacion(TipoOperacion tipo, T datoAnterior, T datoActual) {
        this.tipo = tipo;
        this.datoAnterior = datoAnterior;
        this.datoActual = datoActual;
    }

    public TipoOperacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoOperacion tipo) {
        this.tipo = tipo;
    }

    public T getDatoAnterior() {
        return datoAnterior;
    }

    public void setDatoAnterior(T datoAnterior) {
        this.datoAnterior = datoAnterior;
    }

    public T getDatoActual() {
        return datoActual;
    }

    public void setDatoActual(T datoActual) {
        this.datoActual = datoActual;
    }

}
