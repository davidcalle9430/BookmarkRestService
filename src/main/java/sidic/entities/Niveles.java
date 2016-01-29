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
public class Niveles implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NivelesPK nivelesPK;
    @Column(length = 100)
    private String descripcion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "niveles")
    private List<Opciones> opcionesList;
    @JoinColumn(name = "Empresa", referencedColumnName = "Empresa", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresas empresas;
    @JoinColumns({
        @JoinColumn(name = "Empresa", referencedColumnName = "Empresa", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "usuario", referencedColumnName = "Usuario",insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public Niveles() {
    }

    public Niveles(NivelesPK nivelesPK) {
        this.nivelesPK = nivelesPK;
    }

    public Niveles(int empresa, int nivel) {
        this.nivelesPK = new NivelesPK(empresa, nivel);
    }

    public NivelesPK getNivelesPK() {
        return nivelesPK;
    }

    public void setNivelesPK(NivelesPK nivelesPK) {
        this.nivelesPK = nivelesPK;
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

    @XmlTransient
    public List<Opciones> getOpcionesList() {
        return opcionesList;
    }

    public void setOpcionesList(List<Opciones> opcionesList) {
        this.opcionesList = opcionesList;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
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
        hash += (nivelesPK != null ? nivelesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveles)) {
            return false;
        }
        Niveles other = (Niveles) object;
        if ((this.nivelesPK == null && other.nivelesPK != null) || (this.nivelesPK != null && !this.nivelesPK.equals(other.nivelesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nivelesPK.getNivel()+"";
    }
    
}
