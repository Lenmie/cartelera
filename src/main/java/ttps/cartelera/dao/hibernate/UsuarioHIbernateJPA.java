package ttps.cartelera.dao.hibernate;;

import org.springframework.stereotype.Repository;
import ttps.cartelera.dao.interfaces.UsuarioPerfilDAO;
import ttps.cartelera.model.Administrador;
import ttps.cartelera.model.UsuarioPerfil;

import java.io.Serializable;

@Repository
public class UsuarioHIbernateJPA extends GenericDAOHibernateJPA<UsuarioPerfil> implements UsuarioPerfilDAO {

    public UsuarioHIbernateJPA(){
        super(UsuarioPerfil.class);
    }

    //metodo test
    @Override
    public boolean existe(Serializable id){
        return (id.equals(1337L));
    }

    //metodo test
    @Override
    public UsuarioPerfil recuperar(Serializable id){
        UsuarioPerfil usuario = new Administrador();
        usuario.setId(Long.valueOf(1337));
        usuario.setPassword("lalala1234");
        usuario.setNombreCompleto("don admin");
        return usuario;
    }
}
