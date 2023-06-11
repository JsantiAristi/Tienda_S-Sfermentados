package com.s.sfermentados.ecomerce.DTOS;

import com.s.sfermentados.ecomerce.Models.Orden;
import java.util.Set;
import static java.util.stream.Collectors.toSet;

public class OrdenDTO {
    private long id;
    private int cantidadProductos;
    private double precioTotal;
    private int descuento;
    private boolean comprado;
    private Set<ProductoSeleccionadoDTO> productoSeleccionados;
    public OrdenDTO(Orden orden) {
        this.id = orden.getId();
        this.cantidadProductos = orden.getCantidadProductos();
        this.precioTotal = orden.getPrecioTotal();
        this.descuento = orden.getDescuento();
        this.comprado = orden.isComprado();
        this.productoSeleccionados = orden.getProductoSeleccionados().stream().map(ProductoSeleccionadoDTO::new).collect(toSet());
    }

    public long getId() {return id;}
    public int getCantidadProductos() {return cantidadProductos;}
    public double getPrecioTotal() {return precioTotal;}
    public int getDescuento() {return descuento;}
    public boolean isComprado() {return comprado;}
    public Set<ProductoSeleccionadoDTO> getProductoSeleccionados() {return productoSeleccionados;}
}
