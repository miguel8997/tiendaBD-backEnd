package cl.dci.dbtienda.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(	name = "tienda",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nombre")
        })
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("tiendas")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda")
    @JsonIgnoreProperties("tienda")
    private Set<Producto> productos;

    public Tienda() {
    }

    public Tienda(@NotBlank @Size(max = 30) String nombre, Usuario usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
