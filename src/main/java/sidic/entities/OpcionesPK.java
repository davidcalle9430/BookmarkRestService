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
public class OpcionesPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(nullable = false, name="Empresa")
    private int empresa;
    @Basic(optional = false)
    @Column(nullable = false)
    private int nivel;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String menu;

    public OpcionesPK() {
    }

    public OpcionesPK(int empresa, int nivel, String menu) {
        this.empresa = empresa;
        this.nivel = nivel;
        this.menu = menu;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresa;
        hash += (int) nivel;
        hash += (menu != null ? menu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionesPK)) {
            return false;
        }
        OpcionesPK other = (OpcionesPK) object;
        if (this.empresa != other.empresa) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        if ((this.menu == null && other.menu != null) || (this.menu != null && !this.menu.equals(other.menu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.OpcionesPK[ empresa=" + empresa + ", nivel=" + nivel + ", menu=" + menu + " ]";
    }
    
}
