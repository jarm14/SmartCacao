/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.dao;

import ec.edu.espe.distribuidas.smartCacao.model.Alarma;
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
public class AlarmaFacade extends AbstractFacade<Alarma> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas.smartCacao_smart-cacao-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlarmaFacade() {
        super(Alarma.class);
    }

    public List<Alarma> getByActividad(Integer codActividad) {
        Query qry = this.em.createQuery("SELECT obj FROM Alarma obj WHERE obj.actividad.actividadPK.codActividad = ?1");
        qry.setParameter(1, codActividad);
        return qry.getResultList();
    }
}
