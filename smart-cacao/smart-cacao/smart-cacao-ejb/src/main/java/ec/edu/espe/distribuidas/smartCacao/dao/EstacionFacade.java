/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.dao;

import ec.edu.espe.distribuidas.smartCacao.model.Estacion;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author TMET
 */
@Stateless
@LocalBean
public class EstacionFacade extends AbstractFacade<Estacion> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas.smartCacao_smart-cacao-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstacionFacade() {
        super(Estacion.class);
    }
    
}
