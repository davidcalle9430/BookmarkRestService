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
import javax.persistence.GeneratedValue;

/**
 *
 * @author david
 */
@Embeddable
public class RolessssPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(nullable = false)
    private int empresa;
	@GeneratedValue
    @Basic(optional = false)
    @Column(nullable = false)
    private Long codigo;

    public RolessssPK() {
    }

    public RolessssPK(int empresa, Long codigo) {
        this.empresa = empresa;
        this.codigo = codigo;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresa;
        hash += (long) codigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolessssPK)) {
            return false;
        }
        RolessssPK other = (RolessssPK) object;
        if (this.empresa != other.empresa) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.RolessssPK[ empresa=" + empresa + ", codigo=" + codigo + " ]";
    }
    
}
