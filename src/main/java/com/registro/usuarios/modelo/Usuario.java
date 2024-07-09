package com.registro.usuarios.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

// Anotación que indica que esta clase es una entidad JPA
@Entity
// Anotación que especifica la tabla de la base de datos con la que se mapea esta entidad
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    // Anotación que indica que este campo es la clave primaria de la entidad
    @Id
    // Anotación que indica que el valor de la clave primaria será generado automáticamente por la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Especifica el mapeo del campo 'nombre' en la base de datos
    @Column(name = "nombre")
    private String nombre;

    // Especifica el mapeo del campo 'apellido' en la base de datos
    @Column(name = "apellido")
    private String apellido;

    // Campo de la entidad sin una anotación de columna específica, por lo que se mapea automáticamente
    @Column(unique = true)
    private String email;
    //hemos agregado la columna clave 
    @Column(name = "clave")
    private String password;

    // Anotación que define una relación de muchos a muchos entre 'Usuario' y 'Rol'
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // Anotación que especifica la tabla de unión para la relación muchos a muchos
    @JoinTable(
        name = "usuarios_roles",
        joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Collection<Rol> roles;

    // Métodos getter y setter para los campos de la entidad

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    // Constructor que inicializa todos los campos de la entidad
    public Usuario(Long id, String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    // Constructor que inicializa todos los campos excepto 'id'
    public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    // Constructor sin argumentos necesario para JPA
    public Usuario() {
    }
}

