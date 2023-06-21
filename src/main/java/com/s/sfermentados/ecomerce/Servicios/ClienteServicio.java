package com.s.sfermentados.ecomerce.Servicios;

import com.s.sfermentados.ecomerce.DTOS.ClienteDTO;
import com.s.sfermentados.ecomerce.Models.Cliente;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface ClienteServicio {
    List<ClienteDTO> obtenerTodosLosClientes();
    Cliente obtenerClientePorId(long id);
    Cliente obtenerClienteAutenticado(Authentication authentication);
    Cliente obtenerClientePorEmail(String email);
    boolean isAdmin(Authentication authentication);
    GrantedAuthority obtenerRolCliente(Authentication authentication);
    void guardarCliente(Cliente cliente);
}
