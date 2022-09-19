package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private Integer coodigo;

    @Column (nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;
}
