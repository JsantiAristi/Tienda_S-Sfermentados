package com.s.sfermentados.ecomerce.DTOS;

import com.s.sfermentados.ecomerce.Models.Comprobante;
import com.s.sfermentados.ecomerce.Models.Orden;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class ComprobanteDTO {
    private long id;
    private  int cantidadProductos;
    private double precioTotal;
    private Orden orden;

    public ComprobanteDTO(Comprobante comprobante) {
        this.id = comprobante.getId();
        this.cantidadProductos = comprobante.getCantidadProductos();
        this.precioTotal = comprobante.getPrecioTotal();
        this.orden = comprobante.getOrden();
    }

    public long getId() {return id;}
    public int getCantidadProductos() {return cantidadProductos;}
    public double getPrecioTotal() {return precioTotal;}
    public Orden getOrden() {return orden;}
}
