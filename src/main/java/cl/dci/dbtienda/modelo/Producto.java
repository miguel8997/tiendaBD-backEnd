package cl.dci.dbtienda.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "producto",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "codigo")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @Size(max = 5)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigo;

    @NotBlank
    @Size(max = 30)
    private String nombre;

    private int precio;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    @JsonIgnoreProperties("productos")
    private Tienda tienda_id;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties("productos")
    private Categoria categoria_id;

}
