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
    private Usuario usuario_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda_id")
    @JsonIgnoreProperties("producto")
    private Set<Producto> productos;

}
