package utp.pe.dw.finalex.repository;

import org.springframework.data.repository.CrudRepository;
import utp.pe.dw.finalex.model.Usuario;

public interface IServicioUsuario extends CrudRepository<Usuario, Long> {

    Usuario findByUsuario(String usuario);

}
