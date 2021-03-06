/*
 * Smart Cacao
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) TMET.
 */
package ec.edu.espe.distribuidas.smartCacao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author TMET
 */
@Entity
@Table(name = "TIPO_TERRENO")
public class TipoTerreno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_TIPO_TERRENO", length = 10, nullable = false)
    private String codigo;

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 512, nullable = false)
    private String descripcion;

    public TipoTerreno() {
    }

    public TipoTerreno(String codTipoTerreno) {
        this.codigo = codTipoTerreno;
    }

    public TipoTerreno(String codTipoTerreno, String nombre, String descripcion) {
        this.codigo = codTipoTerreno;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codTipoTerreno) {
        this.codigo = codTipoTerreno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof TipoTerreno)) {
            return false;
        }
        TipoTerreno other = (TipoTerreno) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.smartCacao.model.TipoTerreno[ codTipoTerreno=" + codigo + " ]";
    }
}
