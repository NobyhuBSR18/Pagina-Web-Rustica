package utp.pe.dw.finalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import utp.pe.dw.finalex.model.Cargo;
import utp.pe.dw.finalex.model.Categoria;
import utp.pe.dw.finalex.repository.IServicioCategoria;

import java.util.Optional;

@Controller
@RequestMapping("/categoria")
public class ControllerCategoria {

    @Autowired
    private IServicioCategoria servicio;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("categorias", servicio.findAll());
        return "categoria";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model modelo) {
        modelo.addAttribute("categoria", new Categoria());
        return "formCategoria";
    }

    @PostMapping("/guardar")
    public String graba(@Validated Categoria categoria, Model modelo) {
        servicio.save(categoria);
        return "redirect:/categoria/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model modelo) {
        Optional<Categoria> categoria = servicio.findById(id);
        modelo.addAttribute("categoria", categoria);
        return "formCategoria";
    }

    @GetMapping("/borra/{id}")
    public String borra(@PathVariable Long id, Model modelo) {
        servicio.deleteById(id);
        return "redirect:/categoria/listar";
    }

}
