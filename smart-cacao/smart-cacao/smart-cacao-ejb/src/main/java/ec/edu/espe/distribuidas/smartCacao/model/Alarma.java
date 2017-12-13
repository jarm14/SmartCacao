/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author joel
 */
@Entity
@Table(name = "ALARMA")
public class Alarma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ALARMA", nullable = false)
    private Integer codigo;

    @Column(name = "DESCRIPCION", length = 512)
    private String descripcion;

    @JoinColumns({
        @JoinColumn(name = "COD_ACTIVIDAD", referencedColumnName = "COD_ACTIVIDAD")
        , @JoinColumn(name = "COD_TIPO_ACTIVIDAD", referencedColumnName = "COD_TIPO_ACTIVIDAD")})
    @ManyToOne
    private Actividad actividad;

    public Alarma() {
    }

    public Alarma(Integer codAlarma) {
        this.codigo = codAlarma;
    }

    public Integer getCodAlarma() {
        return codigo;
    }

    public void setCodAlarma(Integer codAlarma) {
        this.codigo = codAlarma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
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
        if (!(object instanceof Alarma)) {
            return false;
        }
        Alarma other = (Alarma) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.Alarma[ codAlarma=" + codigo + " ]";
    }
}
