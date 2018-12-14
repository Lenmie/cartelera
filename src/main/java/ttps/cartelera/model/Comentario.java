package ttps.cartelera.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id @GeneratedValue
    @Column(name = "comentario_id")
    private Long id;

    @ManyToOne(optional = false)
    private UsuarioPerfil creador;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "texto")
    private String texto;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public UsuarioPerfil getCreador() {
        return creador;
    }

    public void setCreador(UsuarioPerfil creador) {
        this.creador = creador;
    }

    public Comentario(UsuarioPerfil creador, Date fechaCreacion, String texto) {
        this.creador = creador;
        this.fechaCreacion = fechaCreacion;
        this.texto = texto;
    }

    public Comentario(){}
}
