/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.CosechaFacade;
import ec.edu.espe.distribuidas.smartCacao.enums.ActividadEnum;
import ec.edu.espe.distribuidas.smartCacao.model.Actividad;
import ec.edu.espe.distribuidas.smartCacao.model.ActividadPK;
import ec.edu.espe.distribuidas.smartCacao.model.Alarma;
import ec.edu.espe.distribuidas.smartCacao.model.Cosecha;
import java.util.Calendar;
import java.util.Date;
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
public class CosechaService {

    @EJB
    private ActividadService actividadService;

    @EJB
    private CosechaFacade cosechaFacade;

    public List<Cosecha> obtenerTodos() {
        return this.cosechaFacade.findAll();
    }

    public Cosecha obtenerPorCodigo(Integer codigo) {
        return this.cosechaFacade.find(codigo);
    }

    public void crear(Cosecha cosecha) {
        this.cosechaFacade.create(cosecha);
    }

    public void modificar(Cosecha cosecha) {
        this.cosechaFacade.edit(cosecha);
    }

    public void eliminar(Integer codigo) {
        Cosecha cosecha = this.cosechaFacade.find(codigo);
        this.cosechaFacade.remove(cosecha);
    }

    public void generaActividad(Cosecha cosecha) {
        Actividad actividad = new Actividad();
        ActividadPK actividadPK = new ActividadPK();
        Alarma alarma = new Alarma();
        Date cal = cosecha.getFechaPlantacion();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cal);
        calendar.add(Calendar.DAY_OF_YEAR, 1);

        if (cosecha.getCodTipoTerreno().equals("NUR")) {
            //Creacion de actividad tipo riego
            actividadPK.setCodTipoActividad("RIE");
            actividad.setActividadPK(actividadPK);
            actividad.setCodCosecha(cosecha.getCodigo());
            actividad.setFechaUltimaEjecucion(calendar.getTime());
            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
            actividad.setEstado(ActividadEnum.NRE);
            actividadService.crear(actividad);
            //Creacion de actividad tipo cambio de terreno
            actividad = new Actividad();
            actividadPK = new ActividadPK();
            actividadPK.setCodTipoActividad("CAM");
            actividad.setActividadPK(actividadPK);
            actividad.setCodCosecha(cosecha.getCodigo());
            calendar.add(Calendar.MONTH, 7);
            actividad.setFechaUltimaEjecucion(calendar.getTime());
            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
            actividad.setEstado(ActividadEnum.NRE);
            actividadService.crear(actividad);
        } else {
            //Creacion de actividad tipo riego
            actividad = new Actividad();
            actividadPK = new ActividadPK();
            actividadPK.setCodTipoActividad("RIE");
            actividad.setActividadPK(actividadPK);
            actividad.setCodCosecha(cosecha.getCodigo());
            actividad.setFechaUltimaEjecucion(calendar.getTime());
            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
            actividad.setEstado(ActividadEnum.NRE);
            actividadService.crear(actividad);
            //Creacion de actividad tipo Deshierbado
            actividad = new Actividad();
            actividadPK = new ActividadPK();
            actividadPK.setCodTipoActividad("DES");
            actividad.setActividadPK(actividadPK);
            actividad.setCodCosecha(cosecha.getCodigo());
            calendar.add(Calendar.MONTH, 4);
            actividad.setFechaUltimaEjecucion(calendar.getTime());
            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
            actividad.setEstado(ActividadEnum.NRE);
            actividadService.crear(actividad);
            //Creacion de actividad tipo Deshierbado
            actividad = new Actividad();
            actividadPK = new ActividadPK();
            actividadPK.setCodTipoActividad("COS");
            actividad.setActividadPK(actividadPK);
            actividad.setCodCosecha(cosecha.getCodigo());
            calendar.add(Calendar.MONTH, 6);
            actividad.setFechaUltimaEjecucion(calendar.getTime());
            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
            actividad.setEstado(ActividadEnum.NRE);
            actividadService.crear(actividad);
        }
    }
}
