/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opciones.findAll", query = "SELECT o FROM Opciones o"),
    @NamedQuery(name = "Opciones.findByEmpresa", query = "SELECT o FROM Opciones o WHERE o.opcionesPK.empresa = :empresa"),
    @NamedQuery(name = "Opciones.findByNivel", query = "SELECT o FROM Opciones o WHERE o.opcionesPK.nivel = :nivel"),
    @NamedQuery(name = "Opciones.findByMenu", query = "SELECT o FROM Opciones o WHERE o.opcionesPK.menu = :menu"),
    @NamedQuery(name = "Opciones.findByFecha", query = "SELECT o FROM Opciones o WHERE o.fecha = :fecha")})
public class Opciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpcionesPK opcionesPK;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumns({
        @JoinColumn(name = "Empresa", referencedColumnName = "Empresa", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "nivel", referencedColumnName = "nivel", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Niveles niveles;
    @JoinColumns({
        @JoinColumn(name = "Empresa", referencedColumnName = "Empresa", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "usuario", referencedColumnName = "Usuario", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public Opciones() {
    }

    public Opciones(OpcionesPK opcionesPK) {
        this.opcionesPK = opcionesPK;
    }

    public Opciones(int empresa, int nivel, String menu) {
        this.opcionesPK = new OpcionesPK(empresa, nivel, menu);
    }

    public OpcionesPK getOpcionesPK() {
        return opcionesPK;
    }

    public void setOpcionesPK(OpcionesPK opcionesPK) {
        this.opcionesPK = opcionesPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Niveles getNiveles() {
        return niveles;
    }

    public void setNiveles(Niveles niveles) {
        this.niveles = niveles;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcionesPK != null ? opcionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opciones)) {
            return false;
        }
        Opciones other = (Opciones) object;
        if ((this.opcionesPK == null && other.opcionesPK != null) || (this.opcionesPK != null && !this.opcionesPK.equals(other.opcionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Opciones[ opcionesPK=" + opcionesPK + " ]";
    }
    
}
