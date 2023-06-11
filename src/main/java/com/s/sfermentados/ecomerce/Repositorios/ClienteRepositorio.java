package com.s.sfermentados.ecomerce.Repositorios;

import com.s.sfermentados.ecomerce.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}
