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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
public class Zonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 3)
    private String zona;
    @Column(length = 50)
    private String nombre;
    @OneToMany(mappedBy = "zona")
    private List<Clientes> clientesList;

    public Zonas() {
    }

    public Zonas(String zona) {
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (zona != null ? zona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zonas)) {
            return false;
        }
        Zonas other = (Zonas) object;
        if ((this.zona == null && other.zona != null) || (this.zona != null && !this.zona.equals(other.zona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Zonas[ zona=" + zona + " ]";
    }
    
}
