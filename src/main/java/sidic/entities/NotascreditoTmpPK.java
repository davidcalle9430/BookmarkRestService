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
public class NotascreditoTmpPK implements Serializable {

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
    @Column(nullable = false, length = 50)
    private String usuario;
    @Basic(optional = false)
    @Column(nullable = false)
    private double nc;
    @Basic(optional = false)
    @Column(nullable = false)
    private int secuencia;

    public NotascreditoTmpPK() {
    }

    public NotascreditoTmpPK(double nrorecibocaja, double cliente, double factura, double articulo, String usuario, double nc, int secuencia) {
        this.nrorecibocaja = nrorecibocaja;
        this.cliente = cliente;
        this.factura = factura;
        this.articulo = articulo;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getNc() {
        return nc;
    }

    public void setNc(double nc) {
        this.nc = nc;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nrorecibocaja;
        hash += (int) cliente;
        hash += (int) factura;
        hash += (int) articulo;
        hash += (usuario != null ? usuario.hashCode() : 0);
        hash += (int) nc;
        hash += (int) secuencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotascreditoTmpPK)) {
            return false;
        }
        NotascreditoTmpPK other = (NotascreditoTmpPK) object;
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
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
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
        return "sidic.entities.NotascreditoTmpPK[ nrorecibocaja=" + nrorecibocaja + ", cliente=" + cliente + ", factura=" + factura + ", articulo=" + articulo + ", usuario=" + usuario + ", nc=" + nc + ", secuencia=" + secuencia + " ]";
    }
    
}
