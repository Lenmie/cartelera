package ttps.cartelera.dao.interfaces;


import ttps.cartelera.model.Cartelera;

import java.util.List;

public interface CarteleraDAO extends GenericDAO<Cartelera> {

    public List<Cartelera> recuperarCarteleras();
}
