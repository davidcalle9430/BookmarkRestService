/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author david
 */
@Embeddable
public class TipooperacionbasesPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(nullable = false, name="TIPOOPERACION")
    private short tipooperacion;
    @Basic(optional = false)
    @Column(nullable = false, length = 7)
    private String impuesto;

    public TipooperacionbasesPK() {
    }

    public TipooperacionbasesPK(short tipooperacion, String impuesto) {
        this.tipooperacion = tipooperacion;
        this.impuesto = impuesto;
    }

    public short getTipooperacion() {
        return tipooperacion;
    }

    public void setTipooperacion(short tipooperacion) {
        this.tipooperacion = tipooperacion;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tipooperacion;
        hash += (impuesto != null ? impuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipooperacionbasesPK)) {
            return false;
        }
        TipooperacionbasesPK other = (TipooperacionbasesPK) object;
        if (this.tipooperacion != other.tipooperacion) {
            return false;
        }
        if ((this.impuesto == null && other.impuesto != null) || (this.impuesto != null && !this.impuesto.equals(other.impuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.TipooperacionbasesPK[ tipooperacion=" + tipooperacion + ", impuesto=" + impuesto + " ]";
    }
    
}
