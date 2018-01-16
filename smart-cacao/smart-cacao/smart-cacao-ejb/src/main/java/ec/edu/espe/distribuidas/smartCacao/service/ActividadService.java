/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.service;

import ec.edu.espe.distribuidas.smartCacao.dao.ActividadFacade;
import ec.edu.espe.distribuidas.smartCacao.dao.CosechaFacade;
import ec.edu.espe.distribuidas.smartCacao.enums.ActividadEnum;
import ec.edu.espe.distribuidas.smartCacao.model.Actividad;
import ec.edu.espe.distribuidas.smartCacao.model.ActividadPK;
import ec.edu.espe.distribuidas.smartCacao.model.Cosecha;
import ec.edu.espe.distribuidas.smartCacao.model.Estadistica;
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
public class ActividadService {

    @EJB
    private ActividadFacade actividadFacade;

    @EJB
    private CosechaFacade cosechaFacade;

    public List<Actividad> obtenerTodos() {
        return this.actividadFacade.findAll();
    }

    public Actividad obtenerPorCodigo(ActividadPK codigo) {
        return this.actividadFacade.find(codigo);
    }

    public void crear(Actividad actividad) {
        this.actividadFacade.create(actividad);
    }

    public void modificar(Actividad actividad) {
        this.actividadFacade.edit(actividad);
    }

    public void eliminar(ActividadPK codigo) {
        Actividad actividad = this.actividadFacade.find(codigo);
        this.actividadFacade.remove(actividad);
    }

    public List<Actividad> obtenerPorFecha(Date date) {
        return this.actividadFacade.getByDate(date);
    }

    public void realizaActividad(Actividad actividad) {
        ActividadPK actividadPK = new ActividadPK();
        actividadPK = actividad.getActividadPK();
        Cosecha cosecha = new Cosecha();
        Date cal = actividad.getFechaUltimaEjecucion();
        Calendar calendar = Calendar.getInstance();
        Calendar calendarDia = Calendar.getInstance();
        calendarDia.setTime(cal);
        calendarDia.add(Calendar.DAY_OF_YEAR, 15);
        calendar.setTime(cal);
        Calendar calendarMes = Calendar.getInstance();
        calendarMes.setTime(cal);
        calendarMes.add(Calendar.MONTH, 7);
        cosecha = cosechaFacade.find(actividad.getCodCosecha());

        if (actividadPK.getCodTipoActividad().equals("CAM")) {
            //Creacion de actividad tipo riego
            actividad.setEstado(ActividadEnum.REA);
            actividadFacade.edit(actividad);
            cosecha.setCodTipoTerreno("PRO");
            cosechaFacade.edit(cosecha);
            actividad = new Actividad();
            actividadPK = new ActividadPK();
            actividadPK.setCodTipoActividad("RIE");
            actividad.setActividadPK(actividadPK);
            actividad.setCodCosecha(cosecha.getCodigo());
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            actividad.setFechaUltimaEjecucion(calendar.getTime());
            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
            actividad.setEstado(ActividadEnum.NRE);
            actividadFacade.create(actividad);
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
            actividadFacade.create(actividad);
            //Creacion de actividad tipo Cosecha
            actividad = new Actividad();
            actividadPK = new ActividadPK();
            actividadPK.setCodTipoActividad("COS");
            actividad.setActividadPK(actividadPK);
            actividad.setCodCosecha(cosecha.getCodigo());
            calendar.add(Calendar.YEAR, 3);
            actividad.setFechaUltimaEjecucion(calendar.getTime());
            actividad.setNota("Plantacion: " + cosecha.getCodigo() + ", Terreno: " + cosecha.getCodTipoTerreno());
            actividad.setEstado(ActividadEnum.NRE);
            actividadFacade.create(actividad);
        } else if (cosecha.getCodTipoTerreno().equals("NUR")) {
            if (actividadPK.getCodTipoActividad().equals("RIE") && calendar.before(calendarDia)) {
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                actividad.setFechaUltimaEjecucion(calendar.getTime());
                actividadFacade.edit(actividad);
            } else if (actividadPK.getCodTipoActividad().equals("RIE") && calendar.before(calendarMes)) {
                calendar.add(Calendar.DAY_OF_YEAR, 2);
                actividad.setFechaUltimaEjecucion(calendar.getTime());
                actividadFacade.edit(actividad);
            } else if (actividadPK.getCodTipoActividad().equals("RIE") && calendar.after(calendarMes)) {
                actividad.setEstado(ActividadEnum.REA);
                actividadFacade.edit(actividad);
            }
        } else if (cosecha.getCodTipoTerreno().equals("PRO")) {
            if (actividadPK.getCodTipoActividad().equals("RIE")) {
                calendar.add(Calendar.DAY_OF_YEAR, 4);
                actividad.setFechaUltimaEjecucion(calendar.getTime());
                actividadFacade.edit(actividad);
            } else if (actividadPK.getCodTipoActividad().equals("COS")) {
                calendar.add(Calendar.MONTH, 6);
                actividad.setFechaUltimaEjecucion(calendar.getTime());
                actividadFacade.edit(actividad);
                Estadistica estadistica = new Estadistica();
                estadistica.setCodCosecha(cosecha.getCodigo());
            } else if (actividadPK.getCodTipoActividad().equals("DES")) {
                calendar.add(Calendar.MONTH, 4);
                actividad.setFechaUltimaEjecucion(calendar.getTime());
                actividadFacade.edit(actividad);
            }
        }
    }
}
