package com.registro.usuarios.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.UsuarioRepositorio;

// Anotación que indica que esta clase es un servicio de Spring
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    // Inyección del repositorio de usuarios
    private UsuarioRepositorio usuarioRepositorio;

    // Inyección del codificador de contraseñas BCrypt
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Constructor que inyecta el repositorio de usuarios
    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        super();
        this.usuarioRepositorio = usuarioRepositorio;
    }

    // Método para guardar un nuevo usuario a partir de un DTO de registro de usuario
    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        // Crear un nuevo usuario utilizando los datos del DTO y codificando la contraseña
        Usuario usuario = new Usuario(registroDTO.getNombre(), 
                registroDTO.getApellido(), registroDTO.getEmail(),
                passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
        // Guardar el usuario en el repositorio y devolver la entidad guardada
        return usuarioRepositorio.save(usuario);
    }

    // Método para cargar un usuario por nombre de usuario (email en este caso)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario por email
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        // Lanzar una excepción si el usuario no se encuentra
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        // Devolver un objeto UserDetails con el email, contraseña y roles del usuario
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    // Método privado para mapear los roles del usuario a objetos GrantedAuthority
    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        // Convertir cada rol en un objeto SimpleGrantedAuthority y recogerlos en una lista
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    // Método para listar todos los usuarios
    @Override
    public List<Usuario> listarUsuarios() {
        // Devolver todos los usuarios del repositorio
        return usuarioRepositorio.findAll();
    }
}

