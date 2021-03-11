package cl.dci.dbtienda.controlador;

import cl.dci.dbtienda.modelo.Categoria;
import cl.dci.dbtienda.modelo.Producto;
import cl.dci.dbtienda.modelo.Tienda;
import cl.dci.dbtienda.modelo.Usuario;
import cl.dci.dbtienda.payload.ProductoRequest;
import cl.dci.dbtienda.repositorio.CategoriaRepositorio;
import cl.dci.dbtienda.repositorio.ProductoRepositorio;
import cl.dci.dbtienda.repositorio.TiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tienda")
public class ProductoControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private TiendaRepositorio tiendaRepositorio;

    @GetMapping("/productos/listar")
    public List<Producto> listarProductos(){
        return  productoRepositorio.findAll();
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long id){
        Producto p=productoRepositorio.findById(id).orElse(null);
        if (p==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @PutMapping("/productos/actualizar/{id}")
    public ResponseEntity<Producto> actulizarProducto(@PathVariable Long id,@RequestBody ProductoRequest producto){

        Producto p=productoRepositorio.findById(id).orElse(null);
        Categoria c=categoriaRepositorio.findById(producto.getCategoria()).orElse(null);
        if (p==null||c==null){
            return ResponseEntity.notFound().build();
        }

        p.setNombre(producto.getNombre());
        p.setCantidad(producto.getCantidad());
        p.setPrecio(producto.getPrecio());
        p.setCategoria(c);

        return ResponseEntity.ok(productoRepositorio.save(p));
    }

    @PostMapping("/productos/guardar")
    public ResponseEntity<Producto> guardarProducto(@RequestBody ProductoRequest producto){

        Producto p=new Producto();
        Tienda t=tiendaRepositorio.findById(producto.getTienda()).orElse(null);
        Categoria c=categoriaRepositorio.findById(producto.getCategoria()).orElse(null);
        if (t==null||c==null){
            return ResponseEntity.notFound().build();
        }

        p.setNombre(producto.getNombre());
        p.setCantidad(producto.getCantidad());
        p.setPrecio(producto.getPrecio());
        p.setTienda(t);
        p.setCategoria(c);

        return ResponseEntity.ok(productoRepositorio.save(p));
    }

    @DeleteMapping("/productos/eliminar/{id}")
    public Map deleteItem(@PathVariable Long id){
        Producto productoDB=productoRepositorio.findById(id).orElse(null);
        if (productoDB==null){
            return Collections.singletonMap("response", "Producto no encontrado");
        }
        productoRepositorio.delete(productoDB);
        return Collections.singletonMap("response", "Producto eliminado correctamente");
    }


}
