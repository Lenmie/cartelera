package ttps.cartelera.dao.hibernate;


import org.springframework.stereotype.Repository;
import ttps.cartelera.dao.interfaces.PublicacionDAO;
import ttps.cartelera.model.Comentario;
import ttps.cartelera.model.Publicacion;

@Repository
public class PublicacionDAOHibernateJPA extends GenericDAOHibernateJPA<Publicacion> implements PublicacionDAO {

    public PublicacionDAOHibernateJPA(){
        super(Publicacion.class);
    }


    public void insertarComentario(Comentario comentario, Publicacion publicacion){
        publicacion.getComentarios().add(comentario);

        actualizar(publicacion);

    }

    public void eliminarComentario(Comentario comentario, Long idPublicacion){
        Publicacion publicacion = recuperar(idPublicacion);
        publicacion.getComentarios().remove(comentario);
        actualizar(publicacion);
    }
}
