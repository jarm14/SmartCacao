/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.EstadisticaFacade;
import ec.edu.espe.distribuidas.smartCacao.model.Estadistica;
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
public class EstadisticaService {
    
    @EJB
    private EstadisticaFacade estadisticaFacade;
    
    public List<Estadistica> obtenerTodos()
    {
        return this.estadisticaFacade.findAll();
    }
    
    public Estadistica obtenerPorCodigo(Integer codigo)
    {
        return this.estadisticaFacade.find(codigo);
    }
    
    public void crear(Estadistica estadistica)
    {
        this.estadisticaFacade.create(estadistica);
    }
    
    public void modificar(Estadistica estadistica)
    {
        this.estadisticaFacade.edit(estadistica);
    }
    
    public void eliminar(Integer codigo)
    {
        Estadistica estadistica = this.estadisticaFacade.find(codigo);
        this.estadisticaFacade.remove(estadistica);
    }
}
