package com.registro.usuarios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro.usuarios.modelo.Producto;
import com.registro.usuarios.repositorio.ProductoRepositorio;

@RestController
@RequestMapping("/api/productos")
public class ProductoControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @GetMapping
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepositorio.findAll();
    }



    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = productoRepositorio.findById(id).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepositorio.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto) {
        Producto producto = productoRepositorio.findById(id).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        producto.setNombreProducto(detallesProducto.getNombreProducto());
        producto.setPrecio(detallesProducto.getPrecio());
        Producto productoActualizado = productoRepositorio.save(producto);
        return ResponseEntity.ok(productoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        Producto producto = productoRepositorio.findById(id).orElse(null);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        productoRepositorio.delete(producto);
        return ResponseEntity.noContent().build();
    }
}


    

