/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.TipoActividadFacade;
import ec.edu.espe.distribuidas.smartCacao.model.TipoActividad;
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
public class TipoActividadService {

    @EJB
    private TipoActividadFacade tipoActividadFacade;

    public List<TipoActividad> obtenerTodos() {
        return this.tipoActividadFacade.findAll();
    }

    public TipoActividad obtenerPorCodigo(String codigo) {
        return this.tipoActividadFacade.find(codigo);
    }

    public void crear(TipoActividad tipoActividad) {
        this.tipoActividadFacade.create(tipoActividad);
    }

    public void modificar(TipoActividad tipoActividad) {
        this.tipoActividadFacade.edit(tipoActividad);
    }

    public void eliminar(String codigo) {
        TipoActividad tipoActividad = this.tipoActividadFacade.find(codigo);
        this.tipoActividadFacade.remove(tipoActividad);
    }
}
