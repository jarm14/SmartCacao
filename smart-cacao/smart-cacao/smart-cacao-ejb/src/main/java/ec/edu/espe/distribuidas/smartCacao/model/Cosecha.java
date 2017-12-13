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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "COSECHA")
public class Cosecha implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_COSECHA", nullable = false)
    private Integer codigo;

    @Column(name = "FECHA_PLANTACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPlantacion;

    @JoinColumns({
        @JoinColumn(name = "COD_TERRENO", referencedColumnName = "COD_TERRENO")
        , @JoinColumn(name = "COD_TIPO_TERRENO", referencedColumnName = "COD_TIPO_TERRENO")})
    @ManyToOne(optional = false)
    private Terreno terreno;

    public Cosecha() {
    }

    public Cosecha(Integer codCosecha) {
        this.codigo = codCosecha;
    }

    public Cosecha(Integer codCosecha, Date fechaPlantacion) {
        this.codigo = codCosecha;
        this.fechaPlantacion = fechaPlantacion;
    }

    public Integer getCodCosecha() {
        return codigo;
    }

    public void setCodCosecha(Integer codCosecha) {
        this.codigo = codCosecha;
    }

    public Date getFechaPlantacion() {
        return fechaPlantacion;
    }

    public void setFechaPlantacion(Date fechaPlantacion) {
        this.fechaPlantacion = fechaPlantacion;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
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
        if (!(object instanceof Cosecha)) {
            return false;
        }
        Cosecha other = (Cosecha) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.Cosecha[ codCosecha=" + codigo + " ]";
    }  
}
