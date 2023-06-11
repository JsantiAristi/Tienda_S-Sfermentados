package com.s.sfermentados.ecomerce.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private  int cantidadProductos;
    private double precioTotal;
    @OneToOne(targetEntity = Orden.class, fetch = FetchType.EAGER)
    private Orden orden;

    public Comprobante() {
    }

    public Comprobante(int cantidadProductos, double precioTotal, Orden orden) {
        this.cantidadProductos = cantidadProductos;
        this.precioTotal = precioTotal;
        this.orden = orden;
    }

    // Get
    public long getId() {return id;}
    public int getCantidadProductos() {return cantidadProductos;}
    public double getPrecioTotal() {return precioTotal;}
    public Orden getOrden() {return orden;}

    // Set
    public void setCantidadProductos(int cantidadProductos) {this.cantidadProductos = cantidadProductos;}
    public void setPrecioTotal(double precioTotal) {this.precioTotal = precioTotal;}
    public void setOrden(Orden orden) {this.orden = orden;}
}
