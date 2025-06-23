package com.our.inventario.model;

import java.time.LocalDate;

public class Producto {

    private int idProducto;
    private String sku;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private String marca;
    private double precioUnitario;
    private LocalDate fechaRegistro;

    public Producto(String nombre, String descripcion, Categoria categoria, String marca, double precioUnitario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.marca = marca;
        this.precioUnitario = precioUnitario;
    }

    public Producto(int idProducto, String sku, String nombre, String descripcion, Categoria categoria, String marca, double precioUnitario, LocalDate fechaRegistro) {
        this.idProducto = idProducto;
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.marca = marca;
        this.precioUnitario = precioUnitario;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
