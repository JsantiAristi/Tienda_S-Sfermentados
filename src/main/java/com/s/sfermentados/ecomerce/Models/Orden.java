package com.s.sfermentados.ecomerce.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private int cantidadProductos;
    private double precioTotal;
    private int descuento;
    private boolean comprado;
    @OneToMany(mappedBy="orden", fetch= FetchType.EAGER)
    private Set<ProductoSeleccionado> productoSeleccionados = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId")
    private Cliente cliente;

    public Orden() {
    }

    public Orden(int cantidadProductos, double precioTotal, int descuento, boolean comprado) {
        this.cantidadProductos = cantidadProductos;
        this.precioTotal = precioTotal;
        this.descuento = descuento;
        this.comprado = comprado;
    }

    public void agregarProductoSeleccionado(ProductoSeleccionado productoSeleccionado) {
        productoSeleccionado.setOrden(this);
        productoSeleccionados.add(productoSeleccionado);
    }

    // Get
    public long getId() {return id;}
    public int getCantidadProductos() {return cantidadProductos;}
    public double getPrecioTotal() {return precioTotal;}
    public int getDescuento() {return descuento;}
    public Cliente getCliente() {return cliente;}
    public boolean isComprado() {return comprado;}
    public Set<ProductoSeleccionado> getProductoSeleccionados() {return productoSeleccionados;}

    // Set
    public void setCantidadProductos(int cantidadProductos) {this.cantidadProductos = cantidadProductos;}
    public void setPrecioTotal(double precioTotal) {this.precioTotal = precioTotal;}
    public void setDescuento(int descuento) {this.descuento = descuento;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}
    public void setComprado(boolean comprado) {this.comprado = comprado;}
    public void setProductoSeleccionados(Set<ProductoSeleccionado> productoSeleccionados) {this.productoSeleccionados = productoSeleccionados;}
}
