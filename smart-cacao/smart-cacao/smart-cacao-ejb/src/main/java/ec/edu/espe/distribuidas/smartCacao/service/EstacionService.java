/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.EstacionFacade;
import ec.edu.espe.distribuidas.smartCacao.model.Estacion;
import ec.edu.espe.distribuidas.smartCacao.model.EstacionPK;
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
public class EstacionService {
    
    @EJB
    private EstacionFacade estacionFacade;
    
    public List<Estacion> obtenerTodos()
    {
        return this.estacionFacade.findAll();
    }
    
    public Estacion obtenerPorCodigo(EstacionPK codigo)
    {
        return this.estacionFacade.find(codigo);
    }
    
    public void crear(Estacion estacion)
    {
        this.estacionFacade.create(estacion);
    }
    
    public void modificar(Estacion estacion)
    {
        this.estacionFacade.edit(estacion);
    }
    
    public void eliminar(EstacionPK codigo)
    {
        Estacion estacion = this.estacionFacade.find(codigo);
        this.estacionFacade.remove(estacion);
    }
    
}
