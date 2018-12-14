package ttps.cartelera.dao.hibernate;


import org.springframework.stereotype.Repository;
import ttps.cartelera.dao.interfaces.CarteleraDAO;
import ttps.cartelera.model.Cartelera;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarteleraDAOHibernateJPA extends GenericDAOHibernateJPA<Cartelera> implements CarteleraDAO{

    public CarteleraDAOHibernateJPA(){
        super(Cartelera.class);
    }


    /*
    metodo test, borrar

    public List<Cartelera> recuperarCarteleras(){

        Cartelera cartelera1 = new Cartelera();
        cartelera1.setId(1L);
        cartelera1.setTitulo("cartelera1");
        Cartelera cartelera2 = new Cartelera();
        cartelera2.setId(2L);
        cartelera2.setTitulo("cartelera2");
        List<Cartelera> carteleras = new ArrayList<>();
        carteleras.add(cartelera1);
        carteleras.add(cartelera2);

        return carteleras;
    }
    */

    //arreglar!
    public List<Cartelera> recuperarCarteleras(){

        Query consulta = this.getEntityManager().createQuery(
                "select c from Cartelera c order by c.titulo");
        List<Cartelera> resultado = (List<Cartelera>)consulta.getResultList();
        return resultado;
    }



}