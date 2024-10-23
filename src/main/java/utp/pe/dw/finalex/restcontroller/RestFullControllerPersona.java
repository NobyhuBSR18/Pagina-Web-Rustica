package utp.pe.dw.finalex.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utp.pe.dw.finalex.model.Categoria;
import utp.pe.dw.finalex.model.Persona;
import utp.pe.dw.finalex.repository.IServicioCargo;
import utp.pe.dw.finalex.repository.IServicioPersona;
import utp.pe.dw.finalex.response.Mensaje;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/api/persona")
public class RestFullControllerPersona {

    @Autowired
    private IServicioPersona servicio;

    @GetMapping("/listar")
    @ResponseBody
    public List<Persona> listar() {
        return (List<Persona>) servicio.findAll();
    }

    @GetMapping("/listar/{id}")
    @ResponseBody
    public Persona porId(@PathVariable Long id) {
        return servicio.findById(id).orElse(null);
    }

    @PostMapping("/guardar")
    @ResponseBody
    public Mensaje guardar(@Validated @RequestBody Persona persona) {

        persona.setIdpersona(0L);
        servicio.save(persona);

        return new Mensaje("Se creo con exito persona");

    }

    @PutMapping("/actualizar/{id}")
    @ResponseBody
    public Mensaje actualizar(@PathVariable Long id, @Validated @RequestBody Persona persona) {

        if (servicio.existsById(id)) {

            persona.setIdpersona(id);
            servicio.save(persona);

            return new Mensaje("Persona con id = " + id + " se actualizo con exito");

        } else {
            return new Mensaje("Persona con id = " + id + " no existe");
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
