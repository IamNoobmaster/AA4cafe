package com.registro.usuarios.controlador.dto;

// Clase DTO (Data Transfer Object) para el registro de usuarios
public class UsuarioRegistroDTO {

    // Atributos privados de la clase
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    // Método getter para el campo id
    public Long getId() {
        return id;
    }

    // Método setter para el campo id
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para el campo nombre
    public String getNombre() {
        return nombre;
    }

    // Método setter para el campo nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para el campo apellido
    public String getApellido() {
        return apellido;
    }

    // Método setter para el campo apellido
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Método getter para el campo email
    public String getEmail() {
        return email;
    }

    // Método setter para el campo email
    public void setEmail(String email) {
        this.email = email;
    }

    // Método getter para el campo password
    public String getPassword() {
        return password;
    }

    // Método setter para el campo password
    public void setPassword(String password) {
        this.password = password;
    }

    // Constructor que inicializa todos los campos excepto id
    public UsuarioRegistroDTO(String nombre, String apellido, String email, String password) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    // Constructor sin argumentos necesario para la creación de instancias vacías
    public UsuarioRegistroDTO() {
    }
}

