/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.TipoUsuarioFacade;
import ec.edu.espe.distribuidas.smartCacao.model.TipoUsuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author TMET
 */
@Stateless
@LocalBean
public class TipoUsuarioService {

    @EJB
    private TipoUsuarioFacade tipoUsuarioFacade;

    public List<TipoUsuario> obtenerTodos() {
        return this.tipoUsuarioFacade.findAll();
    }

    public TipoUsuario obtenerPorCodigo(Integer codigo) {
        return this.tipoUsuarioFacade.find(codigo);
    }

    public void crear(TipoUsuario tipoUsuario) {
        this.tipoUsuarioFacade.create(tipoUsuario);
    }

    public void modificar(TipoUsuario tipoUsuario) {
        this.tipoUsuarioFacade.edit(tipoUsuario);
    }

    public void eliminar(Integer codigo) {
        TipoUsuario tipoUsuario = this.tipoUsuarioFacade.find(codigo);
        this.tipoUsuarioFacade.remove(tipoUsuario);
    }
}
