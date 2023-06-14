package com.s.sfermentados.ecomerce.Configuraciones;

import com.s.sfermentados.ecomerce.Models.Cliente;
import com.s.sfermentados.ecomerce.Repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAutenticacion extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override

    public void init(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(inputName -> {

            Cliente cliente = clienteRepositorio.findByNickName(inputName);

            if (cliente != null) {

                return new User(cliente.getNickName(), cliente.getContraseña(),

                        AuthorityUtils.createAuthorityList("CLIENTE"));

            } else {

                throw new UsernameNotFoundException("NickName desconocido: " + inputName);

            }

        });

    }

    @Bean

    public PasswordEncoder passwordEncoder() {

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }

}
