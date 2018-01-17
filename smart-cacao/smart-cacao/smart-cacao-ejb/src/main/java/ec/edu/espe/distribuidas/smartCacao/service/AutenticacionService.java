/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.UsuarioFacade;
import ec.edu.espe.distribuidas.smartCacao.model.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Hendrix
 */
@LocalBean
@Stateless
public class AutenticacionService {
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    public Usuario login(String email, String clave) {
        List<Usuario> usuarios = this.usuarioFacade.findAll();
        
        Usuario usuario = new Usuario();
        Usuario aux;
        
        for(int i = 0; i<usuarios.size(); i++)
        {
            aux = new Usuario();
            aux= usuarios.get(i);
            if(aux.getEmail().equals(email))
            {
                usuario = aux;
            }
        }
            
        if (usuario!=null && usuario.getPassword().equals(clave)) {
            return usuario;
        } else {
            return null;
        }
    }
}
