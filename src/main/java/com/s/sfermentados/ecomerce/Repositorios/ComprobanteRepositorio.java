package com.s.sfermentados.ecomerce.Repositorios;

import com.s.sfermentados.ecomerce.Models.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ComprobanteRepositorio extends JpaRepository<Comprobante, Long> {
}
