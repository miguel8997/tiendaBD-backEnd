package cl.dci.dbtienda.repositorio;

import cl.dci.dbtienda.modelo.Tienda;
import org.springframework.data.repository.CrudRepository;

public interface TiendaRepositorio extends CrudRepository<Tienda, Long> {
}
