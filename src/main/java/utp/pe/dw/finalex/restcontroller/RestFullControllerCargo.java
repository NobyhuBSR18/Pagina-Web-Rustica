package utp.pe.dw.finalex.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utp.pe.dw.finalex.model.Cargo;
import utp.pe.dw.finalex.repository.IServicioCargo;
import utp.pe.dw.finalex.response.Mensaje;

import java.util.List;

@RestController
@RequestMapping("/rest/api/cargo")
public class RestFullControllerCargo {

    @Autowired
    private IServicioCargo servicio;

    @GetMapping("/listar")
    @ResponseBody
    public List<Cargo> listar() {
        return (List<Cargo>) servicio.findAll();
    }

    @GetMapping("/listar/{id}")
    @ResponseBody
    public Cargo porId(@PathVariable Long id) {
        return servicio.findById(id).orElse(null);
    }

    @PostMapping("/guardar")
    @ResponseBody
    public Mensaje guardar(@Validated @RequestBody Cargo cargo) {

        cargo.setIdcargo(0L);
        servicio.save(cargo);

        return new Mensaje("Se creo con exito cargo");

    }

    @PutMapping("/actualizar/{id}")
    @ResponseBody
    public Mensaje actualizar(@PathVariable Long id, @Validated @RequestBody Cargo cargo) {

        if (servicio.existsById(id)) {

            cargo.setIdcargo(id);
            servicio.save(cargo);

            return new Mensaje("Cargo con id = " + id + " se actualizo con exito");

        } else {
            return new Mensaje("Cargo con id = " + id + " no existe");
        }

    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public Mensaje eliminar(@PathVariable Long id) {

        if (servicio.existsById(id)) {

            servicio.deleteById(id);

            return new Mensaje("Cargo con id = " + id + " se elimino con exito");

        } else {
            return new Mensaje("Cargo con id = " + id + " no existe");
        }

    }

}
