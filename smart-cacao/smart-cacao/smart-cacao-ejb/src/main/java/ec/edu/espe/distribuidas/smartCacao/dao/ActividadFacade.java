/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.dao;

import ec.edu.espe.distribuidas.smartCacao.model.Actividad;
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
public class ActividadFacade extends AbstractFacade<Actividad> {

    @PersistenceContext(unitName = "ec.edu.espe.distribuidas.smartCacao_smart-cacao-ejb_ejb_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadFacade() {
        super(Actividad.class);
    }

    public List<Actividad> findByCosechaTipo(String codTipoActividad, Integer codCosecha) {
        Query qry = this.em.createQuery("SELECT obj FROM Actividad obj WHERE obj.actividadPK.codTipoActividad = ?1 AND obj.codCosecha = ?2");
        qry.setParameter(1, codTipoActividad);
        qry.setParameter(2, codCosecha);
        return qry.getResultList();
    }
}
