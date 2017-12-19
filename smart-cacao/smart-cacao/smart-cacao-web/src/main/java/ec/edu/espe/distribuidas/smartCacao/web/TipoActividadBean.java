/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.TipoActividad;
import ec.edu.espe.distribuidas.smartCacao.service.TipoActividadService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author TMET
 */
@Named
@ViewScoped
public class TipoActividadBean implements Serializable {

    private List<TipoActividad> tiposActividad;
    private TipoActividad tipoActividad;
    private boolean enAgregar;

    @Inject
    private TipoActividadService tipoActividadService;

    @PostConstruct
    public void init() {
        this.tiposActividad = this.tipoActividadService.obtenerTodos();
        this.tipoActividad = new TipoActividad();
    }

    public void agregar() {
        this.tipoActividad = new TipoActividad();
        this.enAgregar = true;
    }

    public void cancelar() {
        this.enAgregar = false;
    }

    public void guardar() {
        this.tipoActividadService.crear(tipoActividad);
        this.enAgregar = false;
        this.tiposActividad = this.tipoActividadService.obtenerTodos();
    }

    public List<TipoActividad> getTiposActividad() {
        return tiposActividad;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public boolean isEnAgregar() {
        return enAgregar;
    }
}
