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
public class RecuperacarteraPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(nullable = false)
    private double nrorecibocaja;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String usuario;
    @Basic(optional = false)
    @Column(nullable = false)
    private double codigo;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(nullable = false)
    private double factura;

    public RecuperacarteraPK() {
    }

    public RecuperacarteraPK(double nrorecibocaja, String usuario, double codigo, Date fecha, double factura) {
        this.nrorecibocaja = nrorecibocaja;
        this.usuario = usuario;
        this.codigo = codigo;
        this.fecha = fecha;
        this.factura = factura;
    }

    public double getNrorecibocaja() {
        return nrorecibocaja;
    }

    public void setNrorecibocaja(double nrorecibocaja) {
        this.nrorecibocaja = nrorecibocaja;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(double codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (usuario != null ? usuario.hashCode() : 0);
        hash += (int) codigo;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) factura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecuperacarteraPK)) {
            return false;
        }
        RecuperacarteraPK other = (RecuperacarteraPK) object;
        if (this.nrorecibocaja != other.nrorecibocaja) {
            return false;
        }
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.factura != other.factura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.RecuperacarteraPK[ nrorecibocaja=" + nrorecibocaja + ", usuario=" + usuario + ", codigo=" + codigo + ", fecha=" + fecha + ", factura=" + factura + " ]";
    }
    
}
