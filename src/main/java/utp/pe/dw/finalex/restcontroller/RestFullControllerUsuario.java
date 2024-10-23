package utp.pe.dw.finalex.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utp.pe.dw.finalex.model.Usuario;
import utp.pe.dw.finalex.repository.IServicioPersona;
import utp.pe.dw.finalex.repository.IServicioUsuario;
import utp.pe.dw.finalex.response.Mensaje;

import java.util.List;

@RestController
@RequestMapping("/rest/api/usuario")
public class RestFullControllerUsuario {

    @Autowired
    private IServicioUsuario servicio;

    @GetMapping("/listar")
    @ResponseBody
    public List<Usuario> listar() {
        return (List<Usuario>) servicio.findAll();
    }

    @GetMapping("/listar/{id}")
    @ResponseBody
    public Usuario porId(@PathVariable Long id) {
        return servicio.findById(id).orElse(null);
    }

    @PostMapping("/guardar")
    @ResponseBody
    public Mensaje guardar(@Validated @RequestBody Usuario usuario) {

        usuario.setIdusuario(0L);
        servicio.save(usuario);

        return new Mensaje("Se creo con exito usuario");

    }

    @PutMapping("/actualizar/{id}")
    @ResponseBody
    public Mensaje actualizar(@PathVariable Long id, @Validated @RequestBody Usuario usuario) {

        if (servicio.existsById(id)) {

            usuario.setIdusuario(id);
            servicio.save(usuario);

            return new Mensaje("Usuario con id = " + id + " se actualizo con exito");

        } else {
            return new Mensaje("Usuario con id = " + id + " no existe");
        }

    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public Mensaje eliminar(@PathVariable Long id) {

        if (servicio.existsById(id)) {

            servicio.deleteById(id);

            return new Mensaje("Persona con id = " + id + " se elimino con exito");

        } else {
            return new Mensaje("Persona con id = " + id + " no existe");
        }

    }

}
