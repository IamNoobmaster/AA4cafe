package com.registro.usuarios.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Anotación que indica que esta clase es una entidad JPA
@Entity
// Anotación que especifica la tabla de la base de datos con la que se mapea esta entidad
@Table(name = "rol")
public class Rol {

    // Anotación que indica que este campo es la clave primaria de la entidad
    @Id
    // Anotación que indica que el valor de la clave primaria será generado automáticamente por la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campo que almacena el nombre del rol
    private String nombre;

    // Constructor que recibe todos los campos
    public Rol(Long id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    // Constructor sin argumentos necesario para JPA
    public Rol() {
    }

    // Constructor que recibe solo el nombre del rol
    public Rol(String nombre) {
        super();
        this.nombre = nombre;
    }

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
}

