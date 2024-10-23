package utp.pe.dw.finalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import utp.pe.dw.finalex.model.Comentario;
import utp.pe.dw.finalex.repository.IServicioComentario;
import utp.pe.dw.finalex.util.ClockPE;

@Controller
@RequestMapping("/")
public class ControllerPrincipio {

    @Autowired
    private IServicioComentario servicioComentario;

    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("comentario", new Comentario());
        return "principal";
    }

    @PostMapping("/comentario")
    public String realizarComentario(@ModelAttribute("comentario") Comentario comentario) {

        comentario.setIdcomentario(0L);
        comentario.setFechacom(ClockPE.getClock());

        servicioComentario.save(comentario);

        return "redirect:/";
    }

}
