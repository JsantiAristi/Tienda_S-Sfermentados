package com.s.sfermentados.ecomerce.Servicios.Implementacion;

import com.s.sfermentados.ecomerce.DTOS.ClienteDTO;
import com.s.sfermentados.ecomerce.Models.Cliente;
import com.s.sfermentados.ecomerce.Repositorios.ClienteRepositorio;
import com.s.sfermentados.ecomerce.Servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteImplementacion implements ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<ClienteDTO> obtenerTodosLosClientes() {
        return clienteRepositorio.findAll()
                .stream()
                .map(cliente -> new ClienteDTO(cliente))
                .collect(Collectors.toList());
    }

    @Override
    public Cliente obtenerClientePorId(long id) {
        return clienteRepositorio.findById(id);
    }

    @Override
    public Cliente obtenerClienteAutenticado(Authentication authentication) {
        return clienteRepositorio.findByNickName(authentication.getName());
    }
    @Override
    public Cliente obtenerClientePorEmail(String email) {
        return clienteRepositorio.findByCorreo(email);
    }
    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }
}
