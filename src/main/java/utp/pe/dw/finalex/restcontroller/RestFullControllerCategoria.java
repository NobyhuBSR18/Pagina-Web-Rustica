package utp.pe.dw.finalex.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utp.pe.dw.finalex.model.Cargo;
import utp.pe.dw.finalex.model.Categoria;
import utp.pe.dw.finalex.repository.IServicioCategoria;
import utp.pe.dw.finalex.response.Mensaje;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/api/categoria")
public class RestFullControllerCategoria {

    @Autowired
    private IServicioCategoria servicio;

    @GetMapping("/listar")
    @ResponseBody
    public List<Categoria> listar() {
        return (List<Categoria>) servicio.findAll();
    }

    @GetMapping("/listar/{id}")
    @ResponseBody
    public Categoria porId(@PathVariable Long id) {
        return servicio.findById(id).orElse(null);
    }

    @PostMapping("/guardar")
    @ResponseBody
    public Mensaje guardar(@Validated @RequestBody Categoria categoria) {

        categoria.setIdcategoria(0L);
        servicio.save(categoria);

        return new Mensaje("Se creo con exito categoria");

    }

    @PutMapping("/actualizar/{id}")
    @ResponseBody
    public Mensaje actualizar(@PathVariable Long id, @Validated @RequestBody Categoria categoria) {

        if (servicio.existsById(id)) {

            categoria.setIdcategoria(id);
            servicio.save(categoria);

            return new Mensaje("Categoria con id = " + id + " se actualizo con exito");

        } else {
            return new Mensaje("Categoria con id = " + id + " no existe");
        }

    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public Mensaje eliminar(@PathVariable Long id) {

        if (servicio.existsById(id)) {

            servicio.deleteById(id);

            return new Mensaje("Categoria con id = " + id + " se elimino con exito");

        } else {
            return new Mensaje("Categoria con id = " + id + " no existe");
        }

    }

}
