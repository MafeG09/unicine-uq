package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Email
    @Column(nullable = false,unique = true, length = 200)
    private String correo;

    @ToString.Exclude
    @Column(nullable = false, length = 100)
    private String password;

    public Persona( String correo, String password) {
        this.correo = correo;
        this.password = password;
    }
}
