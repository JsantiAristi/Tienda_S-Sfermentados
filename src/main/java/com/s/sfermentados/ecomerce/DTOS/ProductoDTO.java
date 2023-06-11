package com.s.sfermentados.ecomerce.DTOS;

import com.s.sfermentados.ecomerce.Models.Producto;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ProductoDTO {
    private long id;
    private int stock;
    private double precio;
    private String foto;
    private double abv;
    private String dulzor;
    private int contenido;
    private String descripcion;
    private String nombre;
    private Set<ProductoSeleccionadoDTO> productoSeleccionados;

    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.stock = producto.getStock();
        this.precio = producto.getPrecio();
        this.foto = producto.getFoto();
        this.abv = producto.getAbv();
        this.dulzor = producto.getDulzor();
        this.contenido = producto.getContenido();
        this.descripcion = producto.getDescripcion();
        this.nombre = producto.getNombre();
        this.productoSeleccionados = producto.getProductoSeleccionados().stream().map(ProductoSeleccionadoDTO::new).collect(toSet());
    }

    public long getId() {return id;}
    public int getStock() {return stock;}
    public double getPrecio() {return precio;}
    public String getFoto() {return foto;}
    public double getAbv() {return abv;}
    public String getDulzor() {return dulzor;}
    public int getContenido() {return contenido;}
    public String getDescripcion() {return descripcion;}
    public String getNombre() {return nombre;}
    public Set<ProductoSeleccionadoDTO> getProductoSeleccionados() {return productoSeleccionados;}
}
