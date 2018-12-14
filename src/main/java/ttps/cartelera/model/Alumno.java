package ttps.cartelera.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("alumno")
public class Alumno extends UsuarioPerfil{

    @ManyToMany(mappedBy = "alumnosInteresados")
    private List<Cartelera> cartelerasSelectas;

    @ElementCollection
    private List<String> mediosComunicacion;

    public List<String> getMediosComunicacion() {
        return mediosComunicacion;
    }

    public void setMediosComunicacion(List<String> mediosComunicacion) {
        this.mediosComunicacion = mediosComunicacion;
    }

    public Alumno(List<Cartelera> cartelerasSelectas) {
        this.cartelerasSelectas = cartelerasSelectas;
    }

    public List<Cartelera> getCartelerasSelectas() {
        return cartelerasSelectas;
    }

    public Alumno() {
        this.cartelerasSelectas = new ArrayList<Cartelera>();
        this.mediosComunicacion = new ArrayList<String>();
    }

    public Alumno(String email, String password, String nombreCompleto) {
        super(email, password, nombreCompleto);
        this.cartelerasSelectas = new ArrayList<Cartelera>();
        this.mediosComunicacion = new ArrayList<String>();
    }

}
