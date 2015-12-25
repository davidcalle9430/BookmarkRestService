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
public class NotascreditoPK implements Serializable {

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
    @Basic(optional = false)
    @Column(nullable = false)
    private double articulo;
    @Basic(optional = false)
    @Column(nullable = false)
    private double nc;
    @Basic(optional = false)
    @Column(nullable = false)
    private double secuencia;

    public NotascreditoPK() {
    }

    public NotascreditoPK(double nrorecibocaja, double cliente, double factura, double articulo, double nc, double secuencia) {
        this.nrorecibocaja = nrorecibocaja;
        this.cliente = cliente;
        this.factura = factura;
        this.articulo = articulo;
        this.nc = nc;
        this.secuencia = secuencia;
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

    public double getArticulo() {
        return articulo;
    }

    public void setArticulo(double articulo) {
        this.articulo = articulo;
    }

    public double getNc() {
        return nc;
    }

    public void setNc(double nc) {
        this.nc = nc;
    }

    public double getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(double secuencia) {
        this.secuencia = secuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nrorecibocaja;
        hash += (int) cliente;
        hash += (int) factura;
        hash += (int) articulo;
        hash += (int) nc;
        hash += (int) secuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotascreditoPK)) {
            return false;
        }
        NotascreditoPK other = (NotascreditoPK) object;
        if (this.nrorecibocaja != other.nrorecibocaja) {
            return false;
        }
        if (this.cliente != other.cliente) {
            return false;
        }
        if (this.factura != other.factura) {
            return false;
        }
        if (this.articulo != other.articulo) {
            return false;
        }
        if (this.nc != other.nc) {
            return false;
        }
        if (this.secuencia != other.secuencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.NotascreditoPK[ nrorecibocaja=" + nrorecibocaja + ", cliente=" + cliente + ", factura=" + factura + ", articulo=" + articulo + ", nc=" + nc + ", secuencia=" + secuencia + " ]";
    }
    
}
