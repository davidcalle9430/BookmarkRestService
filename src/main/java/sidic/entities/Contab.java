/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
public class Contab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer cliente;
    @Column(length = 14)
    private String nit;
    @Column(length = 14)
    private String cc;
    @Column(length = 70)
    private String direccion;
    @Column(length = 30)
    private String telefono;
    @Column(length = 70)
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double valor;
    @Column(precision = 22)
    private Double ncr;
    @Column(precision = 22)
    private Double ndb;

    public Contab() {
    }

    public Contab(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getNcr() {
        return ncr;
    }

    public void setNcr(Double ncr) {
        this.ncr = ncr;
    }

    public Double getNdb() {
        return ndb;
    }

    public void setNdb(Double ndb) {
        this.ndb = ndb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliente != null ? cliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contab)) {
            return false;
        }
        Contab other = (Contab) object;
        if ((this.cliente == null && other.cliente != null) || (this.cliente != null && !this.cliente.equals(other.cliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Contab[ cliente=" + cliente + " ]";
    }
    
}
