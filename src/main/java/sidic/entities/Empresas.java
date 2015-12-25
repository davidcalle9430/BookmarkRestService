/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e"),
    @NamedQuery(name = "Empresas.findByEmpresa", query = "SELECT e FROM Empresas e WHERE e.empresa = :empresa"),
    @NamedQuery(name = "Empresas.findByNombre", query = "SELECT e FROM Empresas e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empresas.findByNit", query = "SELECT e FROM Empresas e WHERE e.nit = :nit"),
    @NamedQuery(name = "Empresas.findByDireccion", query = "SELECT e FROM Empresas e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empresas.findByTelefonos", query = "SELECT e FROM Empresas e WHERE e.telefonos = :telefonos"),
    @NamedQuery(name = "Empresas.findByFax", query = "SELECT e FROM Empresas e WHERE e.fax = :fax"),
    @NamedQuery(name = "Empresas.findByGerente", query = "SELECT e FROM Empresas e WHERE e.gerente = :gerente"),
    @NamedQuery(name = "Empresas.findByRepresentante", query = "SELECT e FROM Empresas e WHERE e.representante = :representante"),
    @NamedQuery(name = "Empresas.findByUsuario", query = "SELECT e FROM Empresas e WHERE e.usuario = :usuario"),
    @NamedQuery(name = "Empresas.findByFecha", query = "SELECT e FROM Empresas e WHERE e.fecha = :fecha")})
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer empresa;
    @Column(length = 100)
    private String nombre;
    @Column(length = 50)
    private String nit;
    @Column(length = 100)
    private String direccion;
    @Column(length = 50)
    private String telefonos;
    @Column(length = 50)
    private String fax;
    @Column(length = 100)
    private String gerente;
    @Column(length = 100)
    private String representante;
    @Column(length = 50)
    private String usuario;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresas")
    private List<Usuarios> usuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresas")
    private List<Niveles> nivelesList;

    public Empresas() {
    }

    public Empresas(Integer empresa) {
        this.empresa = empresa;
    }

    public Integer getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
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

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<Niveles> getNivelesList() {
        return nivelesList;
    }

    public void setNivelesList(List<Niveles> nivelesList) {
        this.nivelesList = nivelesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresa != null ? empresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.empresa == null && other.empresa != null) || (this.empresa != null && !this.empresa.equals(other.empresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Empresas[ empresa=" + empresa + " ]";
    }
    
}
