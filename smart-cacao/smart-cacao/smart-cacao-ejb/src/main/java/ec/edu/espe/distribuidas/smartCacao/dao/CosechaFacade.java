/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.dao;

import ec.edu.espe.distribuidas.smartCacao.model.Cosecha;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author TMET
 */
@Stateless
public class CosechaFacade extends AbstractFacade<Cosecha> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas.smartCacao_smart-cacao-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CosechaFacade() {
        super(Cosecha.class);
    }

    public List<Cosecha> findByTerreno(Integer codTerreno) {
        Query qry = this.em.createQuery("SELECT obj FROM Cosecha obj WHERE obj.terreno.terrenoPK.codTerreno = ?1");
        qry.setParameter(1, codTerreno);
        return qry.getResultList();
    }
}
