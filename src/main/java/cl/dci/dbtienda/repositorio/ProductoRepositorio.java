package cl.dci.dbtienda.repositorio;

import cl.dci.dbtienda.modelo.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepositorio extends CrudRepository<Producto, Long> {
}
