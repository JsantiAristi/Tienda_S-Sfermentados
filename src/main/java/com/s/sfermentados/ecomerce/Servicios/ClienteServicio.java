package com.s.sfermentados.ecomerce.Servicios;

import com.s.sfermentados.ecomerce.DTOS.ClienteDTO;
import com.s.sfermentados.ecomerce.Models.Cliente;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ClienteServicio {
    List<ClienteDTO> obtenerTodosLosClientes();
    Cliente obtenerClientePorId(long id);
    Cliente obtenerClienteAutenticado(Authentication authentication);
    Cliente obtenerClientePorEmail(String email);
    void guardarCliente(Cliente cliente);
}
