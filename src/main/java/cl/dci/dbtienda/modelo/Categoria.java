package cl.dci.dbtienda.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(	name = "categoria",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nombre")
        })
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    @JsonIgnoreProperties("categoria")
    private Set<Producto> productos;

    public Categoria() {
    }

    public Categoria(@NotBlank @Size(max = 30) String nombre) {
        this.nombre = nombre;
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

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
