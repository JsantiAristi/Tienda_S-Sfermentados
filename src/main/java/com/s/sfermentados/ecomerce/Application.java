package com.s.sfermentados.ecomerce;

import com.s.sfermentados.ecomerce.Models.Cliente;
import com.s.sfermentados.ecomerce.Models.Producto;
import com.s.sfermentados.ecomerce.Repositorios.ClienteRepositorio;
import com.s.sfermentados.ecomerce.Repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner IniciarDatos(ProductoRepositorio productoRepositorio, ClienteRepositorio clienteRepositorio){
		return (args) -> {
			Cliente cliente1 = new Cliente("Carlos","Ruiz","Suaha","carlosandresgoo@gmail.com","322-567-8909",passwordEncoder.encode("123"));
			clienteRepositorio.save(cliente1);

			Cliente cliente2 = new Cliente("Santiago","Aristizabal","Admin@","admin@gmail.com","311-890-2023",passwordEncoder.encode("123"));
			clienteRepositorio.save(cliente2);

			Producto vino_tinto_dulce = new Producto( 1, 20000, "https://res.cloudinary.com/dtis6pqyq/image/upload/v1686411712/kg7farm9plunaghqjraq.jpg" , 14, "Dulce", 750, "Vino de uva Isabela con característico olor frutal, tiene un toque seco y un brillante color Burdeos.", "Vino Tinto" );
			productoRepositorio.save(vino_tinto_dulce);
		};
	}
}
