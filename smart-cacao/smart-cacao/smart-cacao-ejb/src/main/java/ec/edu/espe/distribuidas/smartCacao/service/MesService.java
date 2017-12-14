/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.MesFacade;
import ec.edu.espe.distribuidas.smartCacao.model.Mes;
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
public class MesService {

    @EJB
    private MesFacade mesFacade;

    public List<Mes> obtenerTodos() {
        return this.mesFacade.findAll();
    }

    public Mes obtenerPorCodigo(Integer codigo) {
        return this.mesFacade.find(codigo);
    }

    public void crear(Mes mes) {
        this.mesFacade.create(mes);
    }

    public void modificar(Mes mes) {
        this.mesFacade.edit(mes);
    }

    public void eliminar(Integer codigo) {
        Mes mes = this.mesFacade.find(codigo);
        this.mesFacade.remove(mes);
    }

}
