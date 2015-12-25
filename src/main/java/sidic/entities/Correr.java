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
    @NamedQuery(name = "Correr.findAll", query = "SELECT c FROM Correr c"),
    @NamedQuery(name = "Correr.findByCodigo", query = "SELECT c FROM Correr c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Correr.findByNombre", query = "SELECT c FROM Correr c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Correr.findByFecha", query = "SELECT c FROM Correr c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Correr.findByIva", query = "SELECT c FROM Correr c WHERE c.iva = :iva")})
public class Correr implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(nullable = false, precision = 22)
    private Double codigo;
    @Column(length = 30)
    private String nombre;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean iva;
    @OneToMany(mappedBy = "codcorr")
    private List<Clientes> clientesList;

    public Correr() {
    }

    public Correr(Double codigo) {
        this.codigo = codigo;
    }

    public Correr(Double codigo, boolean iva) {
        this.codigo = codigo;
        this.iva = iva;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getIva() {
        return iva;
    }

    public void setIva(boolean iva) {
        this.iva = iva;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correr)) {
            return false;
        }
        Correr other = (Correr) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Correr[ codigo=" + codigo + " ]";
    }
    
}
