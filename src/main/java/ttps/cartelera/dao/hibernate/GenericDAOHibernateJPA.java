package ttps.cartelera.dao.hibernate;
import org.springframework.stereotype.Repository;
import ttps.cartelera.dao.interfaces.GenericDAO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;

@Transactional
@Repository
public abstract class GenericDAOHibernateJPA<T> implements GenericDAO<T> {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    protected Class<T> persistentClass;

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public T actualizar(T entity) {
        entity = this.getEntityManager().merge(entity);
        return entity;
    }

    @Override
    public void borrar(T entity) {
        this.getEntityManager().remove(entity);
    }

    @Override
    public T borrar(Serializable id) {
        T entity = this.getEntityManager().find(this.persistentClass,id);
        if (entity != null){
            this.borrar(entity);
        }
        return entity;
    }

    @Override
    public boolean existe(Serializable id) {
        T entity = this.getEntityManager().find(this.persistentClass,id);
        if (entity != null){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public T persistir(T entity) {
        this.getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T recuperar(Serializable id) {
        T entity = this.getEntityManager().find(this.persistentClass,id);
        return entity;
    }


    public List<T> recuperarTodos(String columnOrder){

        Query consulta = this.getEntityManager().createQuery(
                "select e from" + getPersistentClass().getSimpleName()+"e order by e."+columnOrder);
        List<T> resultado = (List<T>)consulta.getResultList();
        return resultado;
    }

    public GenericDAOHibernateJPA(Class<T> persistentClass) {
        this.setPersistentClass(persistentClass);
    }
}
