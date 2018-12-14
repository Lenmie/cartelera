package ttps.cartelera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttps.cartelera.dao.hibernate.UsuarioHIbernateJPA;
import ttps.cartelera.dao.interfaces.UsuarioPerfilDAO;
import ttps.cartelera.model.Administrador;
import ttps.cartelera.model.UsuarioPerfil;

import java.io.Serializable;
import java.security.acl.LastOwnerException;


@RestController
public class UsuarioRestController {

    @Autowired
    UsuarioPerfilDAO usuarioPerfilDAO = new UsuarioHIbernateJPA();

    @RequestMapping(value = "/autenticacion",method = RequestMethod.POST)
    public ResponseEntity<Void> autenticarUsuario(String id, String password){
        if(usuarioPerfilDAO.existe(Long.valueOf(id))){
            UsuarioPerfil usuario =  usuarioPerfilDAO.recuperar(Long.valueOf(id));
            if (usuario.getPassword().equals(password)){
                HttpHeaders headers = new HttpHeaders();
                String usuario_id = String.valueOf(usuario.getId());
                headers.add("token", usuario_id + "12345");
                headers.add("id",usuario_id);
                return new ResponseEntity<Void>(headers,HttpStatus.OK);
            }else {
                return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
            }
        }else{
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public ResponseEntity<Void> crearUsuario(@RequestBody UsuarioPerfil usuario){
        if(usuarioPerfilDAO.existe(usuario.getId())){
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }else{
            usuarioPerfilDAO.persistir(usuario);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

    //falta hacer un if por si id es nan
    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioPerfil> obtenerUsuario(@PathVariable(name = "id") String id){
        UsuarioPerfil usuario = usuarioPerfilDAO.recuperar(Long.valueOf(id));
        if(usuario != null){
            return new ResponseEntity<UsuarioPerfil>(usuario, HttpStatus.OK);
        }else{
            return new ResponseEntity<UsuarioPerfil>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/usuarios/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizarUsuario(@RequestBody String id, String password){
        if(true){
            UsuarioPerfil usuario = usuarioPerfilDAO.recuperar(Long.valueOf(id));
            //horrrrrible
            if(usuario.getClass() == Administrador.class){
                if(usuarioPerfilDAO.existe(Long.valueOf(id))){
                    UsuarioPerfil usuarioActualizar = usuarioPerfilDAO.recuperar(Long.valueOf(id));
                    usuarioActualizar.setPassword(password);
                    usuarioPerfilDAO.actualizar(usuarioActualizar);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                }
            }else{
                return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
            }
        }
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);

    }


}
