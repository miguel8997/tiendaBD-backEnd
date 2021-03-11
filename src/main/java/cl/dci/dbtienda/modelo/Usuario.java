package cl.dci.dbtienda.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(	name = "usuario",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "correo")
        })
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

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
        @JsonIgnoreProperties("usuario")
        private Set<Tienda> tiendas;

        public Usuario() {
        }

        public Usuario(@NotBlank @Size(max = 30) String correo, @NotBlank @Size(max = 30) String clave) {
                this.correo = correo;
                this.clave = clave;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getCorreo() {
                return correo;
        }

        public void setCorreo(String correo) {
                this.correo = correo;
        }

        public String getClave() {
                return clave;
        }

        public void setClave(String clave) {
                this.clave = clave;
        }

        public Set<Tienda> getTiendas() {
                return tiendas;
        }

        public void setTiendas(Set<Tienda> tiendas) {
                this.tiendas = tiendas;
        }

        @Override
        public String toString() {
                return "Usuario{" +
                        "id=" + id +
                        ", correo='" + correo + '\'' +
                        ", clave='" + clave + '\'' +
                        ", tiendas=" + tiendas +
                        '}';
        }
}
