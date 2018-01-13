/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.Actividad;
import ec.edu.espe.distribuidas.smartCacao.model.ActividadPK;
import ec.edu.espe.distribuidas.smartCacao.model.TipoActividad;
import ec.edu.espe.distribuidas.smartCacao.service.ActividadService;
import ec.edu.espe.distribuidas.smartCacao.service.TipoActividadService;
import ec.edu.espe.distribuidas.smartCacao.web.util.FacesUtil;
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
public class ActividadBean extends BaseBean implements Serializable {
    
    private List<Actividad> actividades;
    private Actividad actividad;
    private Actividad actividadSel;
    private TipoActividad tipoActividad;
    private List<TipoActividad> tiposActividad;
    private ActividadPK actividadPK;
    
    @Inject
    private ActividadService actividadService;
    
    @Inject
    private TipoActividadService tipoActividadService;
    
    @PostConstruct
    public void init() {
        this.actividades = this.actividadService.obtenerTodos();
        this.actividad = new Actividad();
        this.tipoActividad = new TipoActividad();
        this.tiposActividad = this.tipoActividadService.obtenerTodos();
        
    }
    
    @Override
    public void agregar() {
        this.actividad = new Actividad();
        this.tipoActividad = new TipoActividad();
        this.tiposActividad = this.tipoActividadService.obtenerTodos();
        this.actividadPK = new ActividadPK();
        super.agregar();
    }
    
    public void cancelar() {
        super.reset();
        this.actividad = new Actividad();
        this.tipoActividad = new TipoActividad();
        this.actividadPK = new ActividadPK();
    }
    
    @Override
    public void modificar() {
        this.actividad = new Actividad();
        this.actividadPK = new ActividadPK();
        this.tipoActividad = new TipoActividad();
        this.tiposActividad = this.tipoActividadService.obtenerTodos();
        this.actividad.setActividadPK(this.actividadSel.getActividadPK());
        this.actividad.setCodCosecha(this.actividadSel.getCodCosecha());
        this.actividad.setNota(this.actividadSel.getNota());
        this.actividad.setFechaUltimaEjecucion(this.actividadSel.getFechaUltimaEjecucion());
        this.actividad.setEstado(this.actividadSel.getEstado());
    }
    
    public void eliminar() {
        try {
            this.actividadService.eliminar(this.actividadSel.getActividadPK());
            this.actividades = this.actividadService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.actividadSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }
    
    public void guardar() {
        try {
            
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
    }
    
    public String getActividadNombre(Actividad actividad) {
        String nombre = "null";
        TipoActividad aux = new TipoActividad();
        for (int i = 0; i < tiposActividad.size(); i++) {
            aux = tiposActividad.get(i);
            if (aux.getCodigo() == actividad.getActividadPK().getCodTipoActividad()) {
                nombre = aux.getNombre();
            }
        }
        return nombre;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Actividad getActividadSel() {
        return actividadSel;
    }

    public void setActividadSel(Actividad actividadSel) {
        this.actividadSel = actividadSel;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public List<TipoActividad> getTiposActividad() {
        return tiposActividad;
    }

    public ActividadPK getActividadPK() {
        return actividadPK;
    }

    public void setActividadPK(ActividadPK actividadPK) {
        this.actividadPK = actividadPK;
    }

    
}
