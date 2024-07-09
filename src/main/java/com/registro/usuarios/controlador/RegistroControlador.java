package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.servicio.UsuarioServicio;

// Anotación que indica que esta clase es un controlador en Spring MVC
@Controller
public class RegistroControlador {

    // Inyección de dependencias: Spring inyecta una instancia de UsuarioServicio
    @Autowired
    private UsuarioServicio servicio;

    // Mapeo de solicitudes HTTP GET para la URL "/login" a este método
    @GetMapping("/login")
    public String iniciarSesion() {
        // Devuelve el nombre de la vista "login" para mostrar la página de inicio de sesión
        return "login";
    }

    // Mapeo de solicitudes HTTP GET para la URL raíz ("/") a este método
    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        // Agrega una lista de usuarios al modelo para ser utilizada en la vista "index"
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        // Devuelve el nombre de la vista "index" para mostrar la página de inicio
        return "index";
    }
}