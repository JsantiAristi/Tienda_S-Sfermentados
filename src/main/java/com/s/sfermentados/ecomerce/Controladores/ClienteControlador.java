package com.s.sfermentados.ecomerce.Controladores;

import com.s.sfermentados.ecomerce.DTOS.ClienteDTO;
import com.s.sfermentados.ecomerce.Models.Cliente;
import com.s.sfermentados.ecomerce.Repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

@RestController
public class ClienteControlador {
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/api/clientes")
    public List<ClienteDTO> obtenerClientes() {
        return clienteRepositorio.findAll().stream().map(ClienteDTO::new).collect(toList());
    }

    @PostMapping("/api/clientes")
    public ResponseEntity<Object> registrarCliente(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String nickName,
            @RequestParam String correo,
            @RequestParam String telefono,
            @RequestParam String contraseña) {


        if (!Pattern.matches("^[a-z A-Z]+$", nombre)) {
            return new ResponseEntity<>("El nombre solo puede contener letras.", HttpStatus.FORBIDDEN);
        }

        if (!Pattern.matches("^[a-z A-Z]+$", apellido)) {
            return new ResponseEntity<>("El apellido solo puede contener letras.", HttpStatus.FORBIDDEN);
        }

        if (correo.isBlank()) {
            return new ResponseEntity<>("El correo no puede estar en blanco.", HttpStatus.FORBIDDEN);
        } else if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return new ResponseEntity<>("Ingrese una dirección de correo electrónico válida.", HttpStatus.FORBIDDEN);
        }

        if (telefono.isBlank()) {
            return new ResponseEntity<>("El teléfono no puede estar en blanco.", HttpStatus.FORBIDDEN);
        } else if (!telefono.matches("\\d+")) {
            return new ResponseEntity<>("El teléfono debe contener solo números.", HttpStatus.FORBIDDEN);
        }

        if (contraseña.isBlank()) {
            return new ResponseEntity<>("La contraseña no puede estar en blanco.", HttpStatus.FORBIDDEN);
        }

        if (clienteRepositorio.findByNickName(nickName) != null) {
            return new ResponseEntity<>("El nickName ya está en uso.", HttpStatus.FORBIDDEN);
        }
        if (nickName.isBlank()) {
            return new ResponseEntity<>("El nickName no puede estar en blanco.", HttpStatus.FORBIDDEN);
        }
        if (clienteRepositorio.findByCorreo(correo) != null) {
            return new ResponseEntity<>("El correo electrónico ya está en uso.", HttpStatus.FORBIDDEN);
        }

        Cliente nuevoCliente = new Cliente(nombre, apellido, nickName, correo, telefono, passwordEncoder.encode(contraseña));
        clienteRepositorio.save(nuevoCliente);

        return new ResponseEntity<>("Se ha registrado exitosamente", HttpStatus.CREATED);
    }


}








