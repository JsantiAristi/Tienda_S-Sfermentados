package com.s.sfermentados.ecomerce.Controladores;

import com.s.sfermentados.ecomerce.DTOS.ProductoDTO;
import com.s.sfermentados.ecomerce.Repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ProductoControlador {
    @Autowired
    ProductoRepositorio productoRepositorio;

    @GetMapping("/api/producto")
    public List<ProductoDTO> obtenerProductos(){
        return productoRepositorio.findAll().stream().map( ProductoDTO::new ).collect(toList());
    }


}
