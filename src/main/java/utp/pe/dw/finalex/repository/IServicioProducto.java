package utp.pe.dw.finalex.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import utp.pe.dw.finalex.model.Producto;

public interface IServicioProducto extends CrudRepository<Producto, Long> {

    @Modifying
    @Transactional
    @Query(value = "{ call sp_productoCrearConSerie(:_nompro, :_precpro, :_canpro, :_urlpro, :_codcat) }", nativeQuery = true)
    void crearProductoConSerie(@Param("_nompro") String _nompro,
                               @Param("_precpro") Double _precpro,
                               @Param("_canpro") Integer _canpro,
                               @Param("_urlpro") String _urlpro,
                               @Param("_codcat") Long _codcat
    );

}
