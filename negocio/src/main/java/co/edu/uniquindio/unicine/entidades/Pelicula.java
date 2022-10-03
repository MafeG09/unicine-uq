package co.edu.uniquindio.unicine.entidades;

import lombok.*;
import org.springframework.expression.spel.ast.QualifiedIdentifier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = false)
@NoArgsConstructor
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String sinopsis;

    @Column(nullable = false)
    private String url_trailer;

    @Column(nullable = false)
    private String url_imagen;

    @ElementCollection
    @Enumerated (EnumType.STRING)
    private List<Genero> genero;

    @Column(nullable = false)
    private Boolean estado;

    @ElementCollection
    private List<String> Reparto;

    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;

   @ManyToMany
   private List<Formato> formatos;

    @Builder
    public Pelicula(String nombre, String sinopsis, String url_trailer, String url_imagen, List<Genero> genero, Boolean estado, List<String> reparto, List<Formato> formatoPeliculas) {
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.url_trailer = url_trailer;
        this.url_imagen = url_imagen;
        this.genero = genero;
        this.estado = estado;
        Reparto = reparto;
        this.formatos = formatoPeliculas;
    }
}
