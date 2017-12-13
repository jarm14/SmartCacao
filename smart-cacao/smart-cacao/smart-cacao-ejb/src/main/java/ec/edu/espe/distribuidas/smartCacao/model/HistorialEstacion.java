/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author TMET
 */
@Entity
@Table(name = "HISTORIAL_ESTACION")
public class HistorialEstacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_HISTORIAL_ESTACION", nullable = false)
    private Integer codigo;

    @Column(name = "ANIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date anio;

    @Column(name = "FECHA_INICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "FECHA_FINALIZACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;

    @Column(name = "NOTA", length = 512)
    private String nota;

    @JoinColumns({
        @JoinColumn(name = "COD_ESTACION", referencedColumnName = "COD_ESTACION")
        , @JoinColumn(name = "COD_MES", referencedColumnName = "COD_MES")})
    @ManyToOne
    private Estacion estacion;

    public HistorialEstacion() {
    }

    public HistorialEstacion(Integer codHistorialEstacion) {
        this.codigo = codHistorialEstacion;
    }

    public HistorialEstacion(Integer codHistorialEstacion, Date anio, Date fechaInicio, Date fechaFinalizacion) {
        this.codigo = codHistorialEstacion;
        this.anio = anio;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Integer getCodHistorialEstacion() {
        return codigo;
    }

    public void setCodHistorialEstacion(Integer codHistorialEstacion) {
        this.codigo = codHistorialEstacion;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialEstacion)) {
            return false;
        }
        HistorialEstacion other = (HistorialEstacion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.HistorialEstacion[ codHistorialEstacion=" + codigo + " ]";
    }
}
