/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author TMET
 */
@Embeddable
public class EstacionPK implements Serializable {

    @Column(name = "COD_ESTACION", length = 10, nullable = false)
    private String codEstacion;

    @Column(name = "COD_MES", nullable = false)
    private int codMes;

    public EstacionPK() {
    }

    public EstacionPK(String codEstacion, int codMes) {
        this.codEstacion = codEstacion;
        this.codMes = codMes;
    }

    public String getCodEstacion() {
        return codEstacion;
    }

    public void setCodEstacion(String codEstacion) {
        this.codEstacion = codEstacion;
    }

    public int getCodMes() {
        return codMes;
    }

    public void setCodMes(int codMes) {
        this.codMes = codMes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstacion != null ? codEstacion.hashCode() : 0);
        hash += (int) codMes;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstacionPK)) {
            return false;
        }
        EstacionPK other = (EstacionPK) object;
        if ((this.codEstacion == null && other.codEstacion != null) || (this.codEstacion != null && !this.codEstacion.equals(other.codEstacion))) {
            return false;
        }
        if (this.codMes != other.codMes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.EstacionPK[ codEstacion=" + codEstacion + ", codMes=" + codMes + " ]";
    }
}
