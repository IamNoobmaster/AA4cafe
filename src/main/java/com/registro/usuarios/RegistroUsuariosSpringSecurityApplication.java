package com.registro.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotación que indica que esta clase es la clase principal de la aplicación Spring Boot
@SpringBootApplication
public class RegistroUsuariosSpringSecurityApplication {

    // Método principal que inicia la aplicación Spring Boot
    public static void main(String[] args) {
        // Método estático de SpringApplication para iniciar la aplicación con esta clase como configuración principal
        SpringApplication.run(RegistroUsuariosSpringSecurityApplication.class, args);
    }

}

