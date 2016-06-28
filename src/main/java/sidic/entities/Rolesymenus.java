/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name="rolesymenus")
@XmlRootElement
public class Rolesymenus implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolesymenusPK rolesymenusPK;
    @Column(length = 50)
    private String usuario;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumns({
        @JoinColumn(name = "empresa", referencedColumnName = "Empresa", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "menu", referencedColumnName = "menu", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Menus menus;

    public Rolesymenus() {
    }

    public Rolesymenus(RolesymenusPK rolesymenusPK) {
        this.rolesymenusPK = rolesymenusPK;
    }

    public Rolesymenus(int empresa, Long rol, String menu) {
        this.rolesymenusPK = new RolesymenusPK(empresa, rol, menu);
    }

    public RolesymenusPK getRolesymenusPK() {
        return rolesymenusPK;
    }

    public void setRolesymenusPK(RolesymenusPK rolesymenusPK) {
        this.rolesymenusPK = rolesymenusPK;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Menus getMenus() {
        return menus;
    }

    public void setMenus(Menus menus) {
        this.menus = menus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolesymenusPK != null ? rolesymenusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolesymenus)) {
            return false;
        }
        Rolesymenus other = (Rolesymenus) object;
        if ((this.rolesymenusPK == null && other.rolesymenusPK != null) || (this.rolesymenusPK != null && !this.rolesymenusPK.equals(other.rolesymenusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Rolesymenus[ rolesymenusPK=" + rolesymenusPK + " ]";
    }
    
}
