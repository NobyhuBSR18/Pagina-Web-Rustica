package utp.pe.dw.finalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import utp.pe.dw.finalex.model.Persona;
import utp.pe.dw.finalex.repository.IServicioCargo;
import utp.pe.dw.finalex.repository.IServicioPersona;

import java.util.Optional;

@Controller
@RequestMapping("/persona")
public class ControllerPersona {

    @Autowired
    private IServicioPersona servicioPersona;

    @Autowired
    private IServicioCargo servicioCargo;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("personas", servicioPersona.findAll());
        return "persona";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model modelo) {
        modelo.addAttribute("persona", new Persona());
        modelo.addAttribute("cargos", servicioCargo.findAll());
        return "formPersona";
    }

    @PostMapping("/guardar")
    public String graba(@Validated Persona persona, Model modelo) {
        servicioPersona.save(persona);
        return "redirect:/persona/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model modelo) {
        Optional<Persona> persona = servicioPersona.findById(id);
        modelo.addAttribute("persona", persona);
        modelo.addAttribute("cargos", servicioCargo.findAll());
        return "formPersona";
    }

    @GetMapping("/borra/{id}")
    public String borra(@PathVariable Long id, Model modelo) {
        servicioPersona.deleteById(id);
        return "redirect:/persona/listar";
    }

}
