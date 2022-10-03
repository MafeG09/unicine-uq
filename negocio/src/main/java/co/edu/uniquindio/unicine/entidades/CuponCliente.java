package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CuponCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Integer codigo;

    private boolean estado;

    @ManyToOne
    private Cupon cupon;

    @ManyToOne
    private Cliente cliente;

    @OneToOne(mappedBy = "cuponCliente")
    private Compra compra;

    public CuponCliente(boolean estado, Cupon cupon) {
        this.estado = estado;
        this.cupon = cupon;
    }
}
