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
import utp.pe.dw.finalex.repository.IServicioCargo;

import java.util.Optional;

@Controller
@RequestMapping("/cargo")
public class ControllerCargo {

    @Autowired
    private IServicioCargo servicio;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("cargos", servicio.findAll());
        return "cargo";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model modelo) {
        modelo.addAttribute("cargo", new Cargo());
        return "formCargo";
    }

    @PostMapping("/guardar")
    public String graba(@Validated Cargo cargo, Model modelo) {
        servicio.save(cargo);
        return "redirect:/cargo/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model modelo) {
        Optional<Cargo> cargo = servicio.findById(id);
        modelo.addAttribute("cargo", cargo);
        return "formCargo";
    }

    @GetMapping("/borra/{id}")
    public String borra(@PathVariable Long id, Model modelo) {
        servicio.deleteById(id);
        return "redirect:/cargo/listar";
    }

}
