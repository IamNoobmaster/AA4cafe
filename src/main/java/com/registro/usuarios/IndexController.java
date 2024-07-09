package com.registro.usuarios;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String verPaginaDeInicio(Model modelo) {
        return "index";
    }

    @GetMapping("/recetarios")
    public String verRecetario(Model modelo) {
        return "recetarios";
    }

    @GetMapping("/foro")
    public String verForo(Model modelo) {
        return "foro";
    }

    @GetMapping("/tienda")
    public String verTienda(Model modelo) {
        return "tienda";
    }

    @GetMapping("/carrito")
    public String verCarrito(Model modelo) {
        return "carrito";
    }


}
