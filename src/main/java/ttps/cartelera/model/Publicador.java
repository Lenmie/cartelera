package ttps.cartelera.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@DiscriminatorValue("publicador")
public class Publicador extends UsuarioPerfil{

    public Publicador() {
    }

    public Publicador(String email, String password, String nombreCompleto) {
        super(email, password, nombreCompleto);
    }

}
