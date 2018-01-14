/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.HistorialEstacionFacade;
import ec.edu.espe.distribuidas.smartCacao.model.HistorialEstacion;
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
public class HistorialEstacionService {
    
    @EJB
    private HistorialEstacionFacade historialEstacionFacade;

    public List<HistorialEstacion> obtenerTodos() {
        return this.historialEstacionFacade.findAll();
    }

    public HistorialEstacion obtenerPorCodigo(Integer codigo) {
        return this.historialEstacionFacade.find(codigo);
    }

    public void crear(HistorialEstacion historalEstacion) {
        this.historialEstacionFacade.create(historalEstacion);
    }

    public void modificar(HistorialEstacion historialEstacion) {
        this.historialEstacionFacade.edit(historialEstacion);
    }

    public void eliminar(Integer codigo) {
        HistorialEstacion historialEstacion = this.historialEstacionFacade.find(codigo);
        this.historialEstacionFacade.remove(historialEstacion);
    }
}
