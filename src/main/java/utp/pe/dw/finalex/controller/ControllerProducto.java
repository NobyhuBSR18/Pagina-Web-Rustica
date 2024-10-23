package utp.pe.dw.finalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utp.pe.dw.finalex.model.Categoria;
import utp.pe.dw.finalex.model.Producto;
import utp.pe.dw.finalex.repository.IServicioCategoria;
import utp.pe.dw.finalex.repository.IServicioProducto;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/producto")
public class ControllerProducto {

    @Autowired
    private IServicioProducto servicioProducto;

    @Autowired
    private IServicioCategoria servicioCategoria;

    @GetMapping("/carta")
    public String carta(Model model) {
        model.addAttribute("productos", servicioProducto.findAll());
        return "carta";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("productos", servicioProducto.findAll());
        return "producto";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model modelo) {
        modelo.addAttribute("producto", new Producto());
        modelo.addAttribute("categorias", servicioCategoria.findAll());
        return "formProducto";
    }

    @PostMapping("/guardar")
    public String graba(@Validated Producto producto, Model modelo) {
        servicioProducto.save(producto);
        return "redirect:/producto/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model modelo) {
        Optional<Producto> producto = servicioProducto.findById(id);
        modelo.addAttribute("producto", producto);
        modelo.addAttribute("categorias", servicioCategoria.findAll());
        return "formProducto";
    }

    @GetMapping("/borra/{id}")
    public String borra(@PathVariable Long id, Model modelo) {
        servicioProducto.deleteById(id);
        return "redirect:/producto/listar";
    }

}
