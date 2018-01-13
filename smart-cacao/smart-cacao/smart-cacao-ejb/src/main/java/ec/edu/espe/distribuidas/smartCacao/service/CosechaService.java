/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.CosechaFacade;
import ec.edu.espe.distribuidas.smartCacao.model.Cosecha;
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
public class CosechaService {
    @EJB
    private CosechaFacade cosechaFacade;
    
    public List<Cosecha> obtenerTodos()
    {
        return this.cosechaFacade.findAll();
    }
    
    public Cosecha obtenerPorCodigo(Integer codigo)
    {
        return this.cosechaFacade.find(codigo);
    }
    
    public void crear(Cosecha cosecha)
    {
        this.cosechaFacade.create(cosecha);
    }
    
    public void modificar(Cosecha cosecha)
    {
        this.cosechaFacade.edit(cosecha);
    }
    
    public void eliminar (Integer codigo)
    {
        Cosecha cosecha = this.cosechaFacade.find(codigo);
        this.cosechaFacade.remove(cosecha);
    }
}
