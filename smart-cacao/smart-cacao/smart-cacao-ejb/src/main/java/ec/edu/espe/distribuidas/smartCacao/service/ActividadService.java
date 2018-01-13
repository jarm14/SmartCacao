/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.ActividadFacade;
import ec.edu.espe.distribuidas.smartCacao.model.Actividad;
import ec.edu.espe.distribuidas.smartCacao.model.ActividadPK;
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
public class ActividadService {
    
    @EJB
    private ActividadFacade actividadFacade;
    
    public List<Actividad> obtenerTodos()
    {
        return this.actividadFacade.findAll();
    }
    
    public Actividad obtenerPorCodigo(ActividadPK codigo)
    {
        return this.actividadFacade.find(codigo);
    }
    
    public void crear(Actividad actividad)
    {
        this.actividadFacade.create(actividad);
    }
    
    public void modificar(Actividad actividad)
    {
        this.actividadFacade.edit(actividad);
    }
    
    public void eliminar (ActividadPK codigo)
    {
        Actividad actividad = this.actividadFacade.find(codigo);
        this.actividadFacade.remove(actividad);
    }
}
