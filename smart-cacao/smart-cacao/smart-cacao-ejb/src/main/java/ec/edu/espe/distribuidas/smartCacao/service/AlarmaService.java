/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.AlarmaFacade;
import ec.edu.espe.distribuidas.smartCacao.model.Alarma;
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
public class AlarmaService {
    
    @EJB
    private AlarmaFacade alarmaFacade;
    
    public List<Alarma> obtenerTodos() {
        return this.alarmaFacade.findAll();
    }
    
    public Alarma obtenerPorCodigo(Integer codigo) {
        return this.alarmaFacade.find(codigo);
    }
    
    public void crear(Alarma alarma) {
        this.alarmaFacade.create(alarma);
    }
    
    public void modificar(Alarma alarma) {
        this.alarmaFacade.edit(alarma);
    }
    
    public void eliminar(Integer codigo) {
        Alarma alarma = this.alarmaFacade.find(codigo);
        this.alarmaFacade.remove(alarma);
    }
}
