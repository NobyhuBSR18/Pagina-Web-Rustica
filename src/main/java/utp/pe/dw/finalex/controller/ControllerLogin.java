package utp.pe.dw.finalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import utp.pe.dw.finalex.model.Usuario;
import utp.pe.dw.finalex.repository.IServicioUsuario;

@Controller
@RequestMapping("/login")
public class ControllerLogin {

    @Autowired
    private IServicioUsuario servicio;

    @GetMapping
    public String login(Model model) {
        model.addAttribute("user", new Usuario());
        return "login";
    }

    @PostMapping
    public String cruds(@ModelAttribute("user") Usuario usuario) {

        Usuario user = servicio.findByUsuario(usuario.getUsuario());

        if(user != null &&
                user.getUsuario().equals(usuario.getUsuario()) &&
                user.getContrasena().equals(usuario.getContrasena())
        ) {
            System.out.println("entre");
            return "redirect:/cargo/listar";
        } else {
            System.out.println("no entre");
            return "redirect:/login";
        }

    }

}
