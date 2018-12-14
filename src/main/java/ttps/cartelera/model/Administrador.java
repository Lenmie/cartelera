package ttps.cartelera.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@DiscriminatorValue("administrador")
public class Administrador extends UsuarioPerfil {

    public Administrador() {
    }

    public Administrador(String email, String password, String nombreCompleto) {
        super(email, password, nombreCompleto);
    }
}
