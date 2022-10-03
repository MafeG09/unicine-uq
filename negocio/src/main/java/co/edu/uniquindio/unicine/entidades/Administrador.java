package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@ToString(callSuper = true)
public class Administrador  extends Persona implements Serializable{


    public Administrador(String correo, String password) {
        super(correo, password);
    }
}
