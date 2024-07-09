package com.registro.usuarios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.servicio.UsuarioServicio;

// Anotación que indica que esta clase es un controlador en Spring MVC
@Controller
// Anotación que mapea las solicitudes HTTP a nivel de clase para la URL "/registro"
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    // Declaración del servicio de usuarios
    private UsuarioServicio usuarioServicio;

    // Constructor para la inyección de dependencias del servicio de usuarios
    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }

    // Método que se ejecuta antes de cada solicitud del controlador para agregar un nuevo UsuarioRegistroDTO al modelo
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        // Retorna un nuevo objeto UsuarioRegistroDTO
        return new UsuarioRegistroDTO();
    }

    // Mapeo de solicitudes HTTP GET para la URL "/registro" a este método
    @GetMapping
    public String mostrarFormularioDeRegistro() {
        // Devuelve el nombre de la vista "registro" para mostrar el formulario de registro
        return "registro";
    }

    // Mapeo de solicitudes HTTP POST para la URL "/registro" a este método
    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        // Llama al servicio para guardar el nuevo usuario registrado
        usuarioServicio.guardar(registroDTO);
        // Redirige a "/registro?exito" después de un registro exitoso
        return "redirect:/registro?exito";
    }
}

