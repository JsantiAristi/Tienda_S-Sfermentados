package com.s.sfermentados.ecomerce.Repositorios;


import com.s.sfermentados.ecomerce.Models.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrdenRepositorio extends JpaRepository<Orden, Long> {
}
