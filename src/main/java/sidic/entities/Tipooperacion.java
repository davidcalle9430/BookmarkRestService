/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
public class Tipooperacion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Short codigo;
    
    @Column(length = 30)
    private String nombre;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipooperacion1")
    private List<Tipooperacionbases> tipooperacionbasesList;

    public Tipooperacion() {
    }

    public Tipooperacion(Short codigo) {
        this.codigo = codigo;
    }

    public Short getCodigo() {
        return codigo;
    }

    public void setCodigo(Short codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Tipooperacionbases> getTipooperacionbasesList() {
        return tipooperacionbasesList;
    }

    public void setTipooperacionbasesList(List<Tipooperacionbases> tipooperacionbasesList) {
        this.tipooperacionbasesList = tipooperacionbasesList;
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
        if (!(object instanceof Tipooperacion)) {
            return false;
        }
        Tipooperacion other = (Tipooperacion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Tipooperacion[ codigo=" + codigo + " ]";
    }
    
}
