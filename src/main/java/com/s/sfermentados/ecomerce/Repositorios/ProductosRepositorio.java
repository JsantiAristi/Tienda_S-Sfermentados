package com.s.sfermentados.ecomerce.Repositorios;

import com.s.sfermentados.ecomerce.Models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductosRepositorio extends JpaRepository<Productos, Long> {
}
