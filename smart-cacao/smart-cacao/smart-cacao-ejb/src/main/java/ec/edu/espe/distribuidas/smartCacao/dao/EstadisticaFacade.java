/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.dao;

import ec.edu.espe.distribuidas.smartCacao.model.Estadistica;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author TMET
 */
@Stateless
@LocalBean
public class EstadisticaFacade extends AbstractFacade<Estadistica> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas.smartCacao_smart-cacao-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadisticaFacade() {
        super(Estadistica.class);
    }
    
     public List<Estadistica> findByCosecha(Integer codCosecha) {
        Query qry = this.em.createQuery("SELECT obj FROM Estadistica obj WHERE obj.codCosecha = ?1");
        qry.setParameter(1, codCosecha);
        return qry.getResultList();
    }
    
}
