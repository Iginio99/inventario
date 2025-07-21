package com.our.inventario.model;

import java.util.Date;

public class NotaMovimiento {

    private int idNotaMovimiento;
    private int tipo; // 1 = entrada, 2 = salida
    private Date fecha;
    private String observaciones;
    private int idAlmacen;
    private int idUsuario;

    public int getIdNotaMovimiento() {
        return idNotaMovimiento;
    }

    public void setIdNotaMovimiento(int idNotaMovimiento) {
        this.idNotaMovimiento = idNotaMovimiento;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
