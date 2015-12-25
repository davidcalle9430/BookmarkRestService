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
public class EspeciaPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(nullable = false, name="CODIGO")
    private double codigo;
    @Basic(optional = false)
    @Column(nullable = false)
    private double articulo;

    public EspeciaPK() {
    }

    public EspeciaPK(double codigo, double articulo) {
        this.codigo = codigo;
        this.articulo = articulo;
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(double codigo) {
        this.codigo = codigo;
    }

    public double getArticulo() {
        return articulo;
    }

    public void setArticulo(double articulo) {
        this.articulo = articulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigo;
        hash += (int) articulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspeciaPK)) {
            return false;
        }
        EspeciaPK other = (EspeciaPK) object;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.articulo != other.articulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.EspeciaPK[ codigo=" + codigo + ", articulo=" + articulo + " ]";
    }
    
}
