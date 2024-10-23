package utp.pe.dw.finalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import utp.pe.dw.finalex.model.Usuario;
import utp.pe.dw.finalex.repository.IServicioPersona;
import utp.pe.dw.finalex.repository.IServicioUsuario;

import java.util.Optional;

@Controller
@RequestMapping("/usuario")
public class ControllerUsuario {

    @Autowired
    private IServicioUsuario servicioUsuario;

    @Autowired
    private IServicioPersona servicioPersona;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("usuarios", servicioUsuario.findAll());
        return "usuario";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        modelo.addAttribute("personas", servicioPersona.findAll());
        return "formUsuario";
    }

    @PostMapping("/guardar")
    public String graba(@Validated Usuario usuario, Model modelo) {
        servicioUsuario.save(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model modelo) {
        Optional<Usuario> usuario = servicioUsuario.findById(id);
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("personas", servicioPersona.findAll());
        return "formUsuario";
    }

    @GetMapping("/borra/{id}")
    public String borra(@PathVariable Long id, Model modelo) {
        servicioUsuario.deleteById(id);
        return "redirect:/usuario/listar";
    }

}
