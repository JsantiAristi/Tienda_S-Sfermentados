package com.s.sfermentados.ecomerce.Controladores;

import com.s.sfermentados.ecomerce.DTOS.ProductosDTO;
import com.s.sfermentados.ecomerce.Repositorios.ProductosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
public class ProductosControlador {
    @Autowired
    ProductosRepositorio productosRepositorio;

    @GetMapping("api/productos")
    public List<ProductosDTO> obtenerProductos(){
        return productosRepositorio.findAll().stream().map( ProductosDTO::new ).collect(toList());
    }


}
