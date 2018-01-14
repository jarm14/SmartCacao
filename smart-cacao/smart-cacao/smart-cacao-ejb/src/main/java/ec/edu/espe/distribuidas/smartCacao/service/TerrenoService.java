/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.RegionFacade;
import ec.edu.espe.distribuidas.smartCacao.dao.TerrenoFacade;
import ec.edu.espe.distribuidas.smartCacao.model.Region;
import ec.edu.espe.distribuidas.smartCacao.model.Terreno;
import ec.edu.espe.distribuidas.smartCacao.model.TerrenoPK;
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
public class TerrenoService {
    
    @EJB
    private TerrenoFacade terrenoFacade;

    public List<Terreno> obtenerTodos() {
        return this.terrenoFacade.findAll();
    }

    public Terreno obtenerPorCodigo(TerrenoPK codigo) {
        return this.terrenoFacade.find(codigo);
    }

    public void crear(Terreno terreno) {
        this.terrenoFacade.create(terreno);
    }

    public void modificar(Terreno terreno) {
        this.terrenoFacade.edit(terreno);
    }

    public void eliminar(TerrenoPK codigo) {
        Terreno terreno = this.terrenoFacade.find(codigo);
        this.terrenoFacade.remove(terreno);
    }
}
