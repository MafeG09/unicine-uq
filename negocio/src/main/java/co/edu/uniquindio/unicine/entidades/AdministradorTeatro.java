package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString(callSuper = true)
public class AdministradorTeatro extends Persona implements Serializable {

    @ToString.Exclude
    @OneToMany(mappedBy = "administradorTeatro")
    //@JoinColumn(nullable = false)
    private List<Teatro> teatros;

    @Builder
    public AdministradorTeatro(String correo, String password) {
        super(correo, password);

    }
}
