package cl.dci.dbtienda;

import cl.dci.dbtienda.modelo.Categoria;
import cl.dci.dbtienda.modelo.Producto;
import cl.dci.dbtienda.modelo.Tienda;
import cl.dci.dbtienda.modelo.Usuario;
import cl.dci.dbtienda.repositorio.CategoriaRepositorio;
import cl.dci.dbtienda.repositorio.ProductoRepositorio;
import cl.dci.dbtienda.repositorio.TiendaRepositorio;
import cl.dci.dbtienda.repositorio.UsuarioRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Precarga {

    @Bean(name = "usuario")
    CommandLineRunner cargaUsuario(UsuarioRepositorio usuarioRepositorio){
        return(args->{
            usuarioRepositorio.save(new Usuario("pa@gmail.com","123123"));
            usuarioRepositorio.save(new Usuario("la@gmail.com","123123"));
        });
    }

    @Bean(name = "tienda")
    CommandLineRunner cargaUsuario(TiendaRepositorio tiendaRepositorio,UsuarioRepositorio usuarioRepositorio){
        return(args->{
            tiendaRepositorio.save(new Tienda("La herradura",usuarioRepositorio.findById(1L).orElse(null)));
            tiendaRepositorio.save(new Tienda("Los andes",usuarioRepositorio.findById(2L).orElse(null)));
        });
    }

    @Bean(name = "categoria")
    CommandLineRunner cargaCategoria(CategoriaRepositorio categoriaRepositorio){
        return(args->{
            categoriaRepositorio.save(new Categoria("Frutas"));
            categoriaRepositorio.save(new Categoria("Aseo"));
        });
    }

    @Bean(name = "productos")
    CommandLineRunner cargaProducto(ProductoRepositorio productoRepositorio,CategoriaRepositorio categoriaRepositorio,TiendaRepositorio tiendaRepositorio){
        return(args->{
            productoRepositorio.save(new Producto("Pera",500,12,tiendaRepositorio.findById(1L).orElse(null),categoriaRepositorio.findById(1L).orElse(null)));
            productoRepositorio.save(new Producto("Manzana",600,12,tiendaRepositorio.findById(1L).orElse(null),categoriaRepositorio.findById(1L).orElse(null)));
            productoRepositorio.save(new Producto("Esponja",700,12,tiendaRepositorio.findById(1L).orElse(null),categoriaRepositorio.findById(2L).orElse(null)));
            productoRepositorio.save(new Producto("Cloro",800,12,tiendaRepositorio.findById(1L).orElse(null),categoriaRepositorio.findById(2L).orElse(null)));
            productoRepositorio.save(new Producto("Pera",500,12,tiendaRepositorio.findById(2L).orElse(null),categoriaRepositorio.findById(1L).orElse(null)));
            productoRepositorio.save(new Producto("Manzana",600,12,tiendaRepositorio.findById(2L).orElse(null),categoriaRepositorio.findById(1L).orElse(null)));
            productoRepositorio.save(new Producto("Esponja",700,12,tiendaRepositorio.findById(2L).orElse(null),categoriaRepositorio.findById(2L).orElse(null)));
            productoRepositorio.save(new Producto("Cloro",800,12,tiendaRepositorio.findById(2L).orElse(null),categoriaRepositorio.findById(2L).orElse(null)));
        });
    }

}
