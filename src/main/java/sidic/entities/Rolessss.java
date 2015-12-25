/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rolessss.findAll", query = "SELECT r FROM Rolessss r"),
    @NamedQuery(name = "Rolessss.findByEmpresa", query = "SELECT r FROM Rolessss r WHERE r.rolessssPK.empresa = :empresa"),
    @NamedQuery(name = "Rolessss.findByCodigo", query = "SELECT r FROM Rolessss r WHERE r.rolessssPK.codigo = :codigo"),
    @NamedQuery(name = "Rolessss.findByNombre", query = "SELECT r FROM Rolessss r WHERE r.nombre = :nombre")})
public class Rolessss implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolessssPK rolessssPK;
    @Column(length = 100)
    private String nombre;

    public Rolessss() {
    }

    public Rolessss(RolessssPK rolessssPK) {
        this.rolessssPK = rolessssPK;
    }

    public Rolessss(int empresa, double codigo) {
        this.rolessssPK = new RolessssPK(empresa, codigo);
    }

    public RolessssPK getRolessssPK() {
        return rolessssPK;
    }

    public void setRolessssPK(RolessssPK rolessssPK) {
        this.rolessssPK = rolessssPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolessssPK != null ? rolessssPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolessss)) {
            return false;
        }
        Rolessss other = (Rolessss) object;
        if ((this.rolessssPK == null && other.rolessssPK != null) || (this.rolessssPK != null && !this.rolessssPK.equals(other.rolessssPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Rolessss[ rolessssPK=" + rolessssPK + " ]";
    }
    
}
