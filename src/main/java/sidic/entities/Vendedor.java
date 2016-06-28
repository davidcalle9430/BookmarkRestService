/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name="vendedor")
@XmlRootElement
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String codigo;
    @Column(length = 50)
    private String nombre;
    @Column(length = 1)
    private String tipo;
    @Column(length = 50)
    private String direccion;
    @Column(length = 25)
    private String telefonos;
    @Column(length = 50)
    private String observaci1;
    @Column(length = 50)
    private String observaci2;
    @Column(length = 50)
    private String observaci3;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double identifica;
    @OneToMany(mappedBy = "vendedor")
    private List<Clientes> clientesList;
    @OneToMany(mappedBy = "vendedor")
    private List<Cartera> carteraList;

    public Vendedor() {
    }

    public Vendedor(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getObservaci1() {
        return observaci1;
    }

    public void setObservaci1(String observaci1) {
        this.observaci1 = observaci1;
    }

    public String getObservaci2() {
        return observaci2;
    }

    public void setObservaci2(String observaci2) {
        this.observaci2 = observaci2;
    }

    public String getObservaci3() {
        return observaci3;
    }

    public void setObservaci3(String observaci3) {
        this.observaci3 = observaci3;
    }

    public Double getIdentifica() {
        return identifica;
    }

    public void setIdentifica(Double identifica) {
        this.identifica = identifica;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @XmlTransient
    public List<Cartera> getCarteraList() {
        return carteraList;
    }

    public void setCarteraList(List<Cartera> carteraList) {
        this.carteraList = carteraList;
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
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Vendedor[ codigo=" + codigo + " ]";
    }
    
}
