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
public class VentasseguimientoPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(nullable = false)
    private double factura;
    @Basic(optional = false)
    @Column(nullable = false)
    private double codigo;

    public VentasseguimientoPK() {
    }

    public VentasseguimientoPK(double factura, double codigo) {
        this.factura = factura;
        this.codigo = codigo;
    }

    public double getFactura() {
        return factura;
    }

    public void setFactura(double factura) {
        this.factura = factura;
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(double codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) factura;
        hash += (int) codigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasseguimientoPK)) {
            return false;
        }
        VentasseguimientoPK other = (VentasseguimientoPK) object;
        if (this.factura != other.factura) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.VentasseguimientoPK[ factura=" + factura + ", codigo=" + codigo + " ]";
    }
    
}
