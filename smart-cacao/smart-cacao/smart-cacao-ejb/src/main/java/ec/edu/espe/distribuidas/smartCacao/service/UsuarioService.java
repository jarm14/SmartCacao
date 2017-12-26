/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.UsuarioFacade;
import ec.edu.espe.distribuidas.smartCacao.model.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author TMET
 */
@Stateless
@LocalBean
public class UsuarioService {

    @EJB
    private UsuarioFacade usuarioFacade;
    
    public List<Usuario> obtenerTodos()
    {
        return this.usuarioFacade.findAll();
    }
    
    public Usuario obtenerPorCodigo(Integer codigo)
    {
        return this.usuarioFacade.find(codigo);
    }
    
    public void crear(Usuario usuario)
    {
        this.usuarioFacade.create(usuario);
    }
    
    public void modificar(Usuario usuario)
    {
        this.usuarioFacade.edit(usuario);
    }
    
    public void eliminar(Integer codigo)
    {
        Usuario usuario = this.usuarioFacade.find(codigo);
        this.usuarioFacade.remove(usuario);
    }
}
