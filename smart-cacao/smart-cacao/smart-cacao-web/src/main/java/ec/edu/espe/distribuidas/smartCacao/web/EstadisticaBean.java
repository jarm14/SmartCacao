/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.web;

import ec.edu.espe.distribuidas.smartCacao.model.Cosecha;
import ec.edu.espe.distribuidas.smartCacao.model.Estadistica;
import ec.edu.espe.distribuidas.smartCacao.service.CosechaService;
import ec.edu.espe.distribuidas.smartCacao.service.EstadisticaService;
import ec.edu.espe.distribuidas.smartCacao.web.util.FacesUtil;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class EstadisticaBean extends BaseBean implements Serializable {
    
    private String tipoCosechaBusqueda;
    private List<Estadistica> estadisticas;
    private Estadistica estadistica;
    private Estadistica estadisticaSel;
    private List<Cosecha> cosechas;
    private Cosecha cosecha;
    private String promedioCosecha;
    
    @Inject
    private EstadisticaService estadisticaService;
    
    @Inject 
    private CosechaService cosechaService;

    @PostConstruct
    public void init() {
        this.estadistica = new Estadistica();
        //this.estadisticas = this.estadisticaService.obtenerTodos();
        this.cosecha = new Cosecha();
        this.cosechas = this.cosechaService.obtenerTodos();
    }

    @Override
    public void agregar() {
        this.estadistica = new Estadistica();
        this.estadisticas = this.estadisticaService.obtenerTodos();
        this.cosecha = new Cosecha();
        this.cosechas = this.cosechaService.obtenerTodos();
        super.agregar();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.estadistica = new Estadistica();
        this.estadistica.setCodigo(this.estadisticaSel.getCodigo());
        this.estadistica.setCodCosecha(this.estadisticaSel.getCodCosecha());
        this.estadistica.setFechaUltimaCosecha(this.estadisticaSel.getFechaUltimaCosecha());
        this.estadistica.setNumeroArboles(this.estadisticaSel.getNumeroArboles());
        this.estadistica.setTotalKilos(this.estadisticaSel.getTotalKilos());
    }
    
    public void buscar() {

        this.estadisticas = this.estadisticaService.obtenerPorCosecha(Integer.parseInt(this.tipoCosechaBusqueda));
        Promedio();
    }

    public void Promedio(){
    
      
        double contador= 0.0;  //este contador llevara la suma de todos los valores 
        
        String kilos;
        
        for (int i = 0; i < estadisticas.size(); i++) {

            kilos = estadisticas.get(i).getTotalKilos().toString();
            
            contador = contador + Double.parseDouble(kilos);
        }
        
        contador = contador / estadisticas.size();
        
        this.promedioCosecha = String.valueOf(contador);
        
    }    
    
    public void eliminar() {
        try {
            this.estadisticaService.eliminar(this.estadisticaSel.getCodigo());
            this.estadisticas = this.estadisticaService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro");
            this.estadisticaSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
        }
    }

    public void cancelar() {
        super.reset();
        this.estadistica = new Estadistica();
        this.cosecha = new Cosecha();
    }

    public void guardar() {
        try {

            if (this.enAgregar) {
                this.estadisticaService.crear(this.estadistica);
                FacesUtil.addMessageInfo("Se agrego la Estadistica: " + this.estadistica.getCodigo());
            } else {
                this.estadisticaService.modificar(estadistica);
                FacesUtil.addMessageInfo("Se modific\u00f3 la Estadistica con c\u00f3digo: " + this.estadistica.getCodigo());
            }
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.estadistica = new Estadistica();
        this.estadisticas = this.estadisticaService.obtenerTodos();
        this.cosecha = new Cosecha();
        this.cosechas = this.cosechaService.obtenerTodos();
    }

    public List<Estadistica> getEstadisticas() {
        return estadisticas;
    }

    public List<Cosecha> getCosechas() {
        return cosechas;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

    public Estadistica getEstadisticaSel() {
        return estadisticaSel;
    }

    public void setEstadisticaSel(Estadistica estadisticaSel) {
        this.estadisticaSel = estadisticaSel;
    }

    public Cosecha getCosecha() {
        return cosecha;
    }
    
    public void setCosecha(Cosecha cosecha) {
        this.cosecha = cosecha;
    }

    public String getTipoCosechaBusqueda() {
        return tipoCosechaBusqueda;
    }

    public void setTipoCosechaBusqueda(String tipoCosechaBusqueda) {
        this.tipoCosechaBusqueda = tipoCosechaBusqueda;
    }

    public String getPromedioCosecha() {
        return promedioCosecha;
    }

    public void setPromedioCosecha(String promedioCosecha) {
        this.promedioCosecha = promedioCosecha;
    }
    
    
}
