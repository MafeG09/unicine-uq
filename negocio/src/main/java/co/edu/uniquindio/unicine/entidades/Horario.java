package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Horario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private String dia;

    @Column(nullable = false)
    private String hora;

    @Column(nullable = false)
    private LocalDateTime fechaInicio;

    @Column(nullable = false)
    private LocalDateTime fechaFin;

    @ToString.Exclude
    @OneToMany(mappedBy = "horario")
    private List<Funcion> funciones;

    @Builder
    public Horario(String dia, String hora, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.dia = dia;
        this.hora = hora;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
