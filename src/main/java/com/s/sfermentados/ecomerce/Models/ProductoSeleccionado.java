package com.s.sfermentados.ecomerce.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ProductoSeleccionado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private int cantidad;
    private double precioTotal;
    private double precio;
    private int descuento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ordenId")
    private Orden orden;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productosId")
    private Productos productos;

    public ProductoSeleccionado() {
    }

    public ProductoSeleccionado(int cantidad, double precioTotal, double precio, int descuento) {
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.precio = precio;
        this.descuento = descuento;
    }

    // get
    public long getId() {return id;}
    public int getCantidad() {return cantidad;}
    public double getPrecioTotal() {return precioTotal;}
    public double getPrecio() {return precio;}
    public int getDescuento() {return descuento;}
    public Orden getOrden() {return orden;}
    public Productos getProductos() {return productos;}

    // Set
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    public void setPrecioTotal(double precioTotal) {this.precioTotal = precioTotal;}
    public void setPrecio(double precio) {this.precio = precio;}
    public void setDescuento(int descuento) {this.descuento = descuento;}
    public void setOrden(Orden orden) {this.orden = orden;}
    public void setProductos(Productos productos) {this.productos = productos;}
}
