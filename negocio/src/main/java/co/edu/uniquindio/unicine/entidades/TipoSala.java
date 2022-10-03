package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoSala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer codigo;

    private String nombre;

    @OneToMany(mappedBy = "tipoSala")
    private List<Sala> salas;

    public TipoSala(List<Sala> salas, String nombre) {
        this.salas = salas;
        this.nombre = nombre;
    }
}
