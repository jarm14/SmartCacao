/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.TipoTerrenoFacade;
import ec.edu.espe.distribuidas.smartCacao.model.TipoTerreno;
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
public class TipoTerrenoService {

    @EJB
    private TipoTerrenoFacade tipoTerrenoFacade;

    public List<TipoTerreno> obtenerTodos() {
        return this.tipoTerrenoFacade.findAll();
    }

    public TipoTerreno obtenerPorCodigo(String codigo) {
        return this.tipoTerrenoFacade.find(codigo);
    }

    public void crear(TipoTerreno tipoTerreno) {
        this.tipoTerrenoFacade.create(tipoTerreno);
    }

    public void modificar(TipoTerreno tipoTerreno) {
        this.tipoTerrenoFacade.edit(tipoTerreno);
    }

    public void eliminar(String codigo) {
        TipoTerreno tipoTerreno = this.tipoTerrenoFacade.find(codigo);
        this.tipoTerrenoFacade.remove(tipoTerreno);
    }
}
