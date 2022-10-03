package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@NoArgsConstructor
@ToString(callSuper = true)
public class Cliente extends Persona implements Serializable{

    @Column(nullable = false, length =100)
    private String nombre;
    @Column(nullable = false, length = 200)
    private String urlFoto;

    @Column(nullable = false)
    private boolean estado;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<CuponCliente> cuponClientes;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
    @ElementCollection
    private List<String> telefonos;

    @Builder

    public Cliente(String nombre, String correo, String password, String urlFoto, List<String> telefonos) {
        super(correo, password);
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.estado = false;
        this.telefonos = telefonos;

    }
}
