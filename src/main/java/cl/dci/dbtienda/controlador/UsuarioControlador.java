package cl.dci.dbtienda.controlador;

import cl.dci.dbtienda.modelo.Usuario;
import cl.dci.dbtienda.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tienda/")
public class UsuarioControlador {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/usuarios/listar")
    public List<Usuario> listar(){
        return  usuarioRepositorio.findAll();
    }

}
