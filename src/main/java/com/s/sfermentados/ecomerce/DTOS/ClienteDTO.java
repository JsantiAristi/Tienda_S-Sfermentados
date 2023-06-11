package com.s.sfermentados.ecomerce.DTOS;

import com.s.sfermentados.ecomerce.Models.Cliente;
import java.util.Set;
import static java.util.stream.Collectors.toSet;

public class ClienteDTO {
    private long id;
    private String nombre;
    private String apellido;
    private String nickName;
    private String correo;
    private String telefono;
    private Set<OrdenDTO> ordenes ;

    public  ClienteDTO (Cliente cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.nickName = cliente.getNickName();
        this.correo = cliente.getCorreo();
        this.telefono = cliente.getTelefono();
        this.ordenes = cliente.getOrdenes().stream().map(orden -> new OrdenDTO(orden)).collect(toSet());
    }

    public long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public String getNickName() {return nickName;}
    public String getCorreo() {return correo;}
    public String getTelefono() {return telefono;}
    public Set<OrdenDTO> getOrdenes() {return ordenes;}
}
