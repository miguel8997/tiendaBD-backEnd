package cl.dci.dbtienda.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(	name = "categoria",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nombre")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria_id")
    @JsonIgnoreProperties("producto")
    private Set<Producto> productos;

}
