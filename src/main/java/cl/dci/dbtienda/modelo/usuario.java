package cl.dci.dbtienda.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "usuario",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "correo")
        })

public class usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Size(max = 30)
        private String correo;

        @NotBlank
        @Size(max = 30)
        private String clave;

}
