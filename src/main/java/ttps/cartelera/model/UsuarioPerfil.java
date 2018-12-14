package ttps.cartelera.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance
@DiscriminatorColumn(name = "tipo_perfil")
@Table(name = "usuario_perfil")
public abstract class UsuarioPerfil {

    @Id @GeneratedValue
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @ManyToMany(mappedBy = "publicadores")
    private List<Cartelera> carteleras;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cartelera> getCarteleras() {
        return carteleras;
    }

    public void setCarteleras(List<Cartelera> carteleras) {
        this.carteleras = carteleras;
    }

    public UsuarioPerfil(String email, String password, String nombreCompleto) {
        this.email = email;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public UsuarioPerfil(){}
}
