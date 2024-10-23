package utp.pe.dw.finalex.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utp.pe.dw.finalex.model.Producto;
import utp.pe.dw.finalex.model.Producto;
import utp.pe.dw.finalex.repository.IServicioCategoria;
import utp.pe.dw.finalex.repository.IServicioProducto;
import utp.pe.dw.finalex.response.Mensaje;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/api/producto")
public class RestFullControllerProducto {

    @Autowired
    private IServicioProducto servicio;

    @GetMapping("/listar")
    @ResponseBody
    public List<Producto> listar() {
        return (List<Producto>) servicio.findAll();
    }

    @GetMapping("/listar/{id}")
    @ResponseBody
    public Producto porId(@PathVariable Long id) {
        return servicio.findById(id).orElse(null);
    }

    @PostMapping("/guardar")
    @ResponseBody
    public Mensaje guardar(@Validated @RequestBody Producto producto) {

        producto.setIdproducto(0L);

        servicio.crearProductoConSerie(
                producto.getNompro(),
                producto.getPrecpro(),
                producto.getCanpro(),
                producto.getUrlpro(),
                producto.getCategoria().getIdcategoria()
        );

        return new Mensaje("Se creo con exito producto");

    }

    @PutMapping("/actualizar/{id}")
    @ResponseBody
    public Mensaje actualizar(@PathVariable Long id, @Validated @RequestBody Producto producto) {

        if (servicio.existsById(id)) {

            producto.setIdproducto(id);
            servicio.save(producto);

            return new Mensaje("Producto con id = " + id + " se actualizo con exito");

        } else {
            return new Mensaje("Producto con id = " + id + " no existe");
        }

    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public Mensaje eliminar(@PathVariable Long id) {

        if (servicio.existsById(id)) {

            servicio.deleteById(id);

            return new Mensaje("Producto con id = " + id + " se elimino con exito");

        } else {
            return new Mensaje("Producto con id = " + id + " no existe");
        }

    }

}
