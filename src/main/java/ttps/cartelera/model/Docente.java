package ttps.cartelera.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("docente")
public class Docente extends UsuarioPerfil {

    @OneToMany
    private List<Cartelera> cartelerasHabilitadas;

    public List<Cartelera> getCartelerasHabilitadas() {
        return cartelerasHabilitadas;
    }

    public void setCartelerasHabilitadas(List<Cartelera> cartelerasHabilitadas) {
        this.cartelerasHabilitadas = cartelerasHabilitadas;
    }

    public List<Alumno> getAlumnosInteresados(Cartelera unaCartelera){
        return new ArrayList<Alumno>();
    }

    public Docente(List<Cartelera> cartelerasHabilitadas) {
        this.cartelerasHabilitadas = cartelerasHabilitadas;
    }

    public Docente(String email, String password, String nombreCompleto, long carteleraId, List<Cartelera> cartelerasHabilitadas) {
        super(email, password, nombreCompleto);
        this.cartelerasHabilitadas = cartelerasHabilitadas;
    }

    public Docente() {
    }

}
