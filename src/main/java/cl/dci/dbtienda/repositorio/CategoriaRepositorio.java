package cl.dci.dbtienda.repositorio;

import cl.dci.dbtienda.modelo.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepositorio extends CrudRepository<Categoria, Long> {
}
