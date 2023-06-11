package com.s.sfermentados.ecomerce.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String nombre;
    private String apellido;
    private String nickName;
    private String correo;
    private String telefono;
    private String contraseña;
    @OneToMany(mappedBy="cliente", fetch= FetchType.EAGER)
    private Set<Orden> ordenes = new HashSet<>();

    public Cliente() {
    }
    public Cliente(String nombre, String apellido, String nickName, String correo, String telefono, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickName = nickName;
        this.correo = correo;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public void agregarOrden(Orden orden) {
        orden.setCliente(this);
        ordenes.add(orden);
    }

    // Get
    public long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public String getNickName() {return nickName;}
    public String getCorreo() {return correo;}
    public String getTelefono() {return telefono;}
    public String getContraseña() {return contraseña;}
    public Set<Orden> getOrdenes() {return ordenes;}

    // Set
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setNickName(String nickName) {this.nickName = nickName;}
    public void setCorreo(String correo) {this.correo = correo;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}
    public void setOrdenes(Set<Orden> ordenes) {this.ordenes = ordenes;}
}
