/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
