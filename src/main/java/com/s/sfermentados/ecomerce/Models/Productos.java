package com.s.sfermentados.ecomerce.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private int stock;
    private double precio;
    private String foto;
    private double abv;
    private String dulzor;
    private int contenido;
    private String descripcion;
    private String nombre;
    @OneToMany(mappedBy="productos", fetch= FetchType.EAGER)
    private Set<ProductoSeleccionado> productoSeleccionados = new HashSet<>();

    public Productos() {
    }

    public Productos(int stock, double precio, String foto, double abv, String dulzor, int contenido, String descripcion, String nombre) {
        this.stock = stock;
        this.precio = precio;
        this.foto = foto;
        this.abv = abv;
        this.dulzor = dulzor;
        this.contenido = contenido;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }


    // Get
    public long getId() {return id;}
    public int getStock() {return stock;}
    public double getPrecio() {return precio;}
    public String getFoto() {return foto;}
    public double getAbv() {return abv;}
    public String getDulzor() {return dulzor;}
    public int getContenido() {return contenido;}
    public String getDescripcion() {return descripcion;}
    public String getNombre() {return nombre;}
    public Set<ProductoSeleccionado> getProductoSeleccionados() {return productoSeleccionados;}

    // Set
    public void setStock(int stock) {this.stock = stock;}
    public void setPrecio(double precio) {this.precio = precio;}
    public void setFoto(String foto) {this.foto = foto;}
    public void setAbv(double abv) {this.abv = abv;}
    public void setDulzor(String dulzor) {this.dulzor = dulzor;}
    public void setContenido(int contenido) {this.contenido = contenido;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setProductoSeleccionados(Set<ProductoSeleccionado> productoSeleccionados) {this.productoSeleccionados = productoSeleccionados;}
}
