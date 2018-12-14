package ttps.cartelera.dao.hibernate;

import org.springframework.stereotype.Repository;
import ttps.cartelera.dao.interfaces.ComentarioDAO;
import ttps.cartelera.model.Comentario;

@Repository
public class ComentarioDAOHibernateJPA extends GenericDAOHibernateJPA<Comentario> implements ComentarioDAO {

    public ComentarioDAOHibernateJPA(){
        super(Comentario.class);
    }
}
