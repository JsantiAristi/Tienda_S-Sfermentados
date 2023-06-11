package com.s.sfermentados.ecomerce.Controladores;

import com.s.sfermentados.ecomerce.DTOS.ClienteDTO;
import com.s.sfermentados.ecomerce.Models.Cliente;
import com.s.sfermentados.ecomerce.Repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ClienteControlador {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @GetMapping("api/clientes")
    public List<ClienteDTO> obtenerClientes() {
        return clienteRepositorio.findAll().stream().map(ClienteDTO::new).collect(toList());
    }

}







