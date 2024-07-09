package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Usuario;

// Anotación que indica que esta interfaz es un repositorio Spring
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    // Método personalizado para encontrar un usuario por su email
    public Usuario findByEmail(String email);
}

