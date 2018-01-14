/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.RegionFacade;
import ec.edu.espe.distribuidas.smartCacao.model.Region;
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
public class RegionService {
    
    @EJB
    private RegionFacade regionFacade;

    public List<Region> obtenerTodos() {
        return this.regionFacade.findAll();
    }

    public Region obtenerPorCodigo(String codigo) {
        return this.regionFacade.find(codigo);
    }

    public void crear(Region region) {
        this.regionFacade.create(region);
    }

    public void modificar(Region region) {
        this.regionFacade.edit(region);
    }

    public void eliminar(String codigo) {
        Region region = this.regionFacade.find(codigo);
        this.regionFacade.remove(region);
    }
}
