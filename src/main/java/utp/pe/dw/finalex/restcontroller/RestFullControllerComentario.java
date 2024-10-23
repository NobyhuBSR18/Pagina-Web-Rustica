package utp.pe.dw.finalex.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utp.pe.dw.finalex.model.Comentario;
import utp.pe.dw.finalex.repository.IServicioComentario;
import utp.pe.dw.finalex.response.Mensaje;
import utp.pe.dw.finalex.util.ClockPE;

import java.util.List;

@RestController
@RequestMapping("/rest/api/comentario")
public class RestFullControllerComentario {

    @Autowired
    private IServicioComentario servicio;

    @GetMapping("/listar")
    @ResponseBody
    public List<Comentario> listar() {
        return (List<Comentario>) servicio.findAll();
    }

    @GetMapping("/listar/{id}")
    @ResponseBody
    public Comentario porId(@PathVariable Long id) {
        return servicio.findById(id).orElse(null);
    }

    @PostMapping("/guardar")
    @ResponseBody
    public Mensaje guardar(@Validated @RequestBody Comentario comentario) {

        comentario.setIdcomentario(0L);
        comentario.setFechacom(ClockPE.getClock());
        servicio.save(comentario);

        return new Mensaje("Se creo con exito comentario");

    }

    @PutMapping("/actualizar/{id}")
    @ResponseBody
    public Mensaje actualizar(@PathVariable Long id, @Validated @RequestBody Comentario comentario) {

        if (servicio.existsById(id)) {

            comentario.setIdcomentario(id);
            comentario.setFechacom(ClockPE.getClock());
            servicio.save(comentario);

            return new Mensaje("Comentario con id = " + id + " se actualizo con exito");

        } else {
            return new Mensaje("Comentario con id = " + id + " no existe");
        }

    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public Mensaje eliminar(@PathVariable Long id) {

        if (servicio.existsById(id)) {

            servicio.deleteById(id);

            return new Mensaje("Comentario con id = " + id + " se elimino con exito");

        } else {
            return new Mensaje("Comentario con id = " + id + " no existe");
        }

    }

}
