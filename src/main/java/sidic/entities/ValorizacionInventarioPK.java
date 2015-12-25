/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author david
 */
@Embeddable
public class ValorizacionInventarioPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(nullable = false)
    private double linea;

    public ValorizacionInventarioPK() {
    }

    public ValorizacionInventarioPK(Date fecha, double linea) {
        this.fecha = fecha;
        this.linea = linea;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getLinea() {
        return linea;
    }

    public void setLinea(double linea) {
        this.linea = linea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) linea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorizacionInventarioPK)) {
            return false;
        }
        ValorizacionInventarioPK other = (ValorizacionInventarioPK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.linea != other.linea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.ValorizacionInventarioPK[ fecha=" + fecha + ", linea=" + linea + " ]";
    }
    
}
