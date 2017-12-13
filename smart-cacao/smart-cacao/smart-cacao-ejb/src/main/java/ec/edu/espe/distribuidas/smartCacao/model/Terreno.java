/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author TMET
 */
@Entity
@Table(name = "TERRENO")
public class Terreno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TerrenoPK terrenoPK;

    @Column(name = "DESCRIPCION", length = 512)
    private String descripcion;

    @Column(name = "ANCHO", precision = 8, scale = 2, nullable = false)
    private BigDecimal ancho;

    @Column(name = "LARGO", precision = 8, scale = 2, nullable = false)
    private BigDecimal largo;

    @JoinColumn(name = "COD_TIPO_TERRENO", referencedColumnName = "COD_TIPO_TERRENO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoTerreno tipoTerreno;

    @JoinColumn(name = "COD_REGION", referencedColumnName = "COD_REGION")
    @ManyToOne(optional = false)
    private Region codRegion;

    public Terreno() {
    }

    public Terreno(TerrenoPK terrenoPK) {
        this.terrenoPK = terrenoPK;
    }

    public Terreno(TerrenoPK terrenoPK, BigDecimal ancho, BigDecimal largo) {
        this.terrenoPK = terrenoPK;
        this.ancho = ancho;
        this.largo = largo;
    }

    public Terreno(int codTerreno, String codTipoTerreno) {
        this.terrenoPK = new TerrenoPK(codTerreno, codTipoTerreno);
    }

    public TerrenoPK getTerrenoPK() {
        return terrenoPK;
    }

    public void setTerrenoPK(TerrenoPK terrenoPK) {
        this.terrenoPK = terrenoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAncho(BigDecimal ancho) {
        this.ancho = ancho;
    }

    public BigDecimal getLargo() {
        return largo;
    }

    public void setLargo(BigDecimal largo) {
        this.largo = largo;
    }

    public TipoTerreno getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(TipoTerreno tipoTerreno) {
        this.tipoTerreno = tipoTerreno;
    }

    public Region getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(Region codRegion) {
        this.codRegion = codRegion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (terrenoPK != null ? terrenoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terreno)) {
            return false;
        }
        Terreno other = (Terreno) object;
        if ((this.terrenoPK == null && other.terrenoPK != null) || (this.terrenoPK != null && !this.terrenoPK.equals(other.terrenoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.Terreno[ terrenoPK=" + terrenoPK + " ]";
    }
}
