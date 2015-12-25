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
public class NotascreditodsctoPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(nullable = false)
    private double nrorecibocaja;
    @Basic(optional = false)
    @Column(nullable = false)
    private double cliente;
    @Basic(optional = false)
    @Column(nullable = false)
    private double factura;

    public NotascreditodsctoPK() {
    }

    public NotascreditodsctoPK(double nrorecibocaja, double cliente, double factura) {
        this.nrorecibocaja = nrorecibocaja;
        this.cliente = cliente;
        this.factura = factura;
    }

    public double getNrorecibocaja() {
        return nrorecibocaja;
    }

    public void setNrorecibocaja(double nrorecibocaja) {
        this.nrorecibocaja = nrorecibocaja;
    }

    public double getCliente() {
        return cliente;
    }

    public void setCliente(double cliente) {
        this.cliente = cliente;
    }

    public double getFactura() {
        return factura;
    }

    public void setFactura(double factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nrorecibocaja;
        hash += (int) cliente;
        hash += (int) factura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotascreditodsctoPK)) {
            return false;
        }
        NotascreditodsctoPK other = (NotascreditodsctoPK) object;
        if (this.nrorecibocaja != other.nrorecibocaja) {
            return false;
        }
        if (this.cliente != other.cliente) {
            return false;
        }
        if (this.factura != other.factura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.NotascreditodsctoPK[ nrorecibocaja=" + nrorecibocaja + ", cliente=" + cliente + ", factura=" + factura + " ]";
    }
    
}
