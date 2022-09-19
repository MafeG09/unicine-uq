package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Libro implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String ibsn;

    @Column(nullable = false)
    private String nombre;

    @PositiveOrZero
    private int unidades;

    @PositiveOrZero
    private int anio;

   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private Genero genero;

   @ManyToMany (mappedBy = "libros")
   private List<Prestamo> prestamos;

   @ManyToMany
   private List<Autor> autores;


}
