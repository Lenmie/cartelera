package ttps.cartelera.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "publicacion")
public class Publicacion {

    @Id @GeneratedValue
    @Column(name = "publicacion_id")
    private Long id;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "texto")
    private String texto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "publicacion_id")
    private List<Comentario> comentarios;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Comentario> getComentarios(){return this.comentarios;}

    public void setComentarios(List<Comentario> comentarios) { this.comentarios = comentarios; }

    public Publicacion(){

    }

    public Publicacion(Date fechaCreacion, String titulo, String texto) {
        this.comentarios = new ArrayList<Comentario>();
        this.fechaCreacion = fechaCreacion;
        this.titulo = titulo;
        this.texto = texto;
    }
}
