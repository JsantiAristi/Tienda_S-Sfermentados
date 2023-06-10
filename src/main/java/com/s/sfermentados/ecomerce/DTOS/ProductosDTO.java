package com.s.sfermentados.ecomerce.DTOS;

import com.s.sfermentados.ecomerce.Models.Productos;

public class ProductosDTO {
    private long id;
    private int stock;
    private double precio;
    private String foto;
    private double abv;
    private String dulzor;
    private int contenido;
    private String descripcion;
    private String nombre;

    public ProductosDTO(Productos productos) {
        this.id = productos.getId();
        this.stock = productos.getStock();
        this.precio = productos.getPrecio();
        this.foto = productos.getFoto();
        this.abv = productos.getAbv();
        this.dulzor = productos.getDulzor();
        this.contenido = productos.getContenido();
        this.descripcion = productos.getDescripcion();
        this.nombre = productos.getNombre();
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
}
