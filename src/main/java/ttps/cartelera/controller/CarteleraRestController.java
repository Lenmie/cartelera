package ttps.cartelera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.cartelera.dao.hibernate.CarteleraDAOHibernateJPA;
import ttps.cartelera.dao.hibernate.UsuarioHIbernateJPA;
import ttps.cartelera.dao.interfaces.CarteleraDAO;
import ttps.cartelera.dao.interfaces.UsuarioPerfilDAO;
import ttps.cartelera.model.*;

import java.util.Date;
import java.util.List;

@RestController
public class CarteleraRestController {

    @Autowired
    CarteleraDAO carteleraDao;

    @Autowired
    UsuarioPerfilDAO usuarioPerfilDAO;

    @RequestMapping(value = "/cartelera", method = RequestMethod.POST)
    public ResponseEntity<Void> crearCartelera(@RequestBody Cartelera cartelera,@RequestHeader String token, @RequestHeader String id){
        String verificar = id + "123456";
        if (verificar.equals(token)) {
            UsuarioPerfil usuario = usuarioPerfilDAO.recuperar(Long.valueOf(1));
            if(usuario.getClass() == Administrador.class){
                //if(!carteleraDao.existe(cartelera.getId())){
                    carteleraDao.persistir(cartelera);
                    return new ResponseEntity<Void>(HttpStatus.CREATED);
                //}else{
                  //  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                //}
            }else{
                return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
            }
        }else{
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        }
    }

    //preguntar como acceder a sesion para obtener el usuario
    //arreglar la query recuperarCarteleras
/*
    @RequestMapping(value = "/carteleras", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cartelera>> listarCarteleras(@RequestHeader("token") String token, @RequestHeader("id") String id){
        String res = id + "12345";
        if(res.equals(token)){
            List<Cartelera> carteleras = carteleraDao.recuperarCarteleras();
            if(carteleras.isEmpty()){
                return new ResponseEntity<List<Cartelera>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Cartelera>>(carteleras, HttpStatus.OK);
        }else{
           return new ResponseEntity<List<Cartelera>>(HttpStatus.FORBIDDEN);
       }

    }
   */
}