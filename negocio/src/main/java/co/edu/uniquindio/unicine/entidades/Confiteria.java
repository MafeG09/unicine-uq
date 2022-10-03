package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Confiteria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Positive
    @Column(nullable = false)
    private Float precio;

    @Column(nullable = false, length = 200)
    private String url_imagen;

    @OneToMany(mappedBy = "confiteria")
    private List<CompraConfiteria> compraConfiterias;

    @Builder
    public Confiteria(String nombre, Float precio, String url_imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.url_imagen = url_imagen;
    }
}
