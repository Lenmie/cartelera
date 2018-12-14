package ttps.cartelera.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cartelera")
public class Cartelera {
    @Id @GeneratedValue
    @Column(name = "cartelera_id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "interesado_cartelera",
            joinColumns = @JoinColumn(name = "cartelera_id", referencedColumnName = "cartelera_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"))
    private List<Alumno> alumnosInteresados;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cartelera_id")
    private List<Publicacion> publicaciones;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "publicador_cartelera",
            joinColumns = @JoinColumn(name = "cartelera_id", referencedColumnName = "cartelera_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"))
    private List<Publicador> publicadores;

    public List<Publicador> getPublicadores() {
        return publicadores;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Alumno> getAlumnosInteresados() {
        return alumnosInteresados;
    }

    public Cartelera(String titulo, String descripcion){
        this.publicaciones = new ArrayList<Publicacion>();
        this.publicadores = new ArrayList<Publicador>();
        this.alumnosInteresados = new ArrayList<Alumno>();
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Cartelera(){
        this.publicaciones = new ArrayList<Publicacion>();
        this.publicadores = new ArrayList<Publicador>();
        this.alumnosInteresados = new ArrayList<Alumno>();
    }

}
