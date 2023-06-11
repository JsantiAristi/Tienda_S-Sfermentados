package com.s.sfermentados.ecomerce.DTOS;

import com.s.sfermentados.ecomerce.Models.ProductoSeleccionado;

public class ProductoSeleccionadoDTO {
    private long id;
    private int cantidad;
    private double precioTotal;
    private double precio;
    private int descuento;

    public ProductoSeleccionadoDTO (ProductoSeleccionado productoSeleccionado){
        this.id = productoSeleccionado.getId();
        this.cantidad = productoSeleccionado.getCantidad();
        this.precioTotal = productoSeleccionado.getPrecioTotal();
        this.precio = productoSeleccionado.getPrecio();
        this.descuento = productoSeleccionado.getDescuento();
    }

    public long getId() {return id;}
    public int getCantidad() {return cantidad;}
    public double getPrecioTotal() {return precioTotal;}
    public double getPrecio() {return precio;}
    public int getDescuento() {return descuento;}
}
