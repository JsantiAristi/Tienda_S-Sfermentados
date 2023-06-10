package com.s.sfermentados.ecomerce;

import com.s.sfermentados.ecomerce.Models.Productos;
import com.s.sfermentados.ecomerce.Repositorios.ProductosRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner IniciarDatos(ProductosRepositorio productosRepositorio){
		return (args) -> {
			Productos vino_tinto_dulce = new Productos( 1, 20000, "https://res.cloudinary.com/dtis6pqyq/image/upload/v1686411712/kg7farm9plunaghqjraq.jpg" , 14, "Dulce", 750, "Vino de uva Isabela con característico olor frutal, tiene un toque seco y un brillante color Burdeos.", "Vino Tinto" );
			productosRepositorio.save(vino_tinto_dulce);
		};
	}
}
