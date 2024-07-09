package com.registro.usuarios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.modelo.Producto;
import com.registro.usuarios.repositorio.ProductoRepositorio;

@Controller
@RequestMapping("/productos")
public class VistaProductoControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @GetMapping
    public String mostrarProductos(Model model) {
        List<Producto> productos = productoRepositorio.findAll();
        model.addAttribute("productos", productos);
        return "productos";
    }
}
