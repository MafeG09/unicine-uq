package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
public class DistribucionSillas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Lob
    @Column(nullable = false)
    private String esquema ;

    @Positive
    @Column(nullable = false)
    private Integer total_sillas;

    @Positive
    @Column(nullable = false)
    private Integer filas;

    @Positive
    @Column(nullable = false)
    private Integer columnas;

    @OneToMany(mappedBy = "distribucionSillas")
    private List<Sala> salas;

   @Builder
    public DistribucionSillas(Integer total_sillas, Integer filas, Integer columnas) {
        this.total_sillas = total_sillas;
        this.filas = filas;
        this.columnas = columnas;
    }
}
