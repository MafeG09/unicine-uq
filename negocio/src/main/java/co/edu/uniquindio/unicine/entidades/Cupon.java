package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Cupon implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private String descripcion;

    @Positive
    @Column(nullable = false)
    private Float descuento;

    @Column(nullable = false)
    private String criterio;

    @Column(nullable = false)
    private LocalDateTime fechaVencimiento;

    @OneToMany(mappedBy = "cupon")
    private List<CuponCliente> cuponClientes;

    @Builder

    public Cupon(String descripcion, Float descuento, String criterio, LocalDateTime fechaVencimiento) {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.criterio = criterio;
        this.fechaVencimiento = fechaVencimiento;
    }
}
