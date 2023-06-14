package com.s.sfermentados.ecomerce.Repositorios;

import com.s.sfermentados.ecomerce.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.core.Authentication;

@RepositoryRestResource
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    Cliente findByNickName (String nickName);
    Cliente findById(long id);
    Cliente findByCorreo(String correo);


}
