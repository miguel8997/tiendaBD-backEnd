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
@Table(	name = "usuario",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "correo")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Size(max = 30)
        private String correo;

        @NotBlank
        @Size(max = 30)
        private String clave;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario_id")
        @JsonIgnoreProperties("usuario")
        private Set<Tienda> tiendas;

}
