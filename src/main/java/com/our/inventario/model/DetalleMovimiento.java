package com.our.inventario.model;

import java.math.BigDecimal;

public class DetalleMovimiento {

    private int idDetalleMovimiento;
    private int idNotaMovimiento;
    private int idProducto;
    private BigDecimal cantidad;
    private Integer idLote;

    public int getIdDetalleMovimiento() {
        return idDetalleMovimiento;
    }

    public void setIdDetalleMovimiento(int idDetalleMovimiento) {
        this.idDetalleMovimiento = idDetalleMovimiento;
    }

    public int getIdNotaMovimiento() {
        return idNotaMovimiento;
    }

    public void setIdNotaMovimiento(int idNotaMovimiento) {
        this.idNotaMovimiento = idNotaMovimiento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

}
