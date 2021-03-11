package cl.dci.dbtienda.repositorio;

import cl.dci.dbtienda.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
}
