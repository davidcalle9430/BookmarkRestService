/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menus.findAll", query = "SELECT m FROM Menus m"),
    @NamedQuery(name = "Menus.findByEmpresa", query = "SELECT m FROM Menus m WHERE m.menusPK.empresa = :empresa"),
    @NamedQuery(name = "Menus.findByMenu", query = "SELECT m FROM Menus m WHERE m.menusPK.menu = :menu"),
    @NamedQuery(name = "Menus.findByDescripcion", query = "SELECT m FROM Menus m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Menus.findByFecha", query = "SELECT m FROM Menus m WHERE m.fecha = :fecha")})
public class Menus implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MenusPK menusPK;
    @Column(length = 100)
    private String descripcion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumns({
        @JoinColumn(name = "Empresa", referencedColumnName = "Empresa", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "usuario", referencedColumnName = "Usuario",insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menus")
    private List<Rolesymenus> rolesymenusList;

    public Menus() {
    }

    public Menus(MenusPK menusPK) {
        this.menusPK = menusPK;
    }

    public Menus(int empresa, String menu) {
        this.menusPK = new MenusPK(empresa, menu);
    }

    public MenusPK getMenusPK() {
        return menusPK;
    }

    public void setMenusPK(MenusPK menusPK) {
        this.menusPK = menusPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @XmlTransient
    public List<Rolesymenus> getRolesymenusList() {
        return rolesymenusList;
    }

    public void setRolesymenusList(List<Rolesymenus> rolesymenusList) {
        this.rolesymenusList = rolesymenusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menusPK != null ? menusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menus)) {
            return false;
        }
        Menus other = (Menus) object;
        if ((this.menusPK == null && other.menusPK != null) || (this.menusPK != null && !this.menusPK.equals(other.menusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Menus[ menusPK=" + menusPK + " ]";
    }
    
}
