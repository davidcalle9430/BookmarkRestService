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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name="causalreciboscaja")
@XmlRootElement
public class Causalreciboscaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer codigo;
    @Column(length = 255)
    private String descripcion;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean afectarecuperacion;

    public Causalreciboscaja() {
    }

    public Causalreciboscaja(Integer codigo) {
        this.codigo = codigo;
    }

    public Causalreciboscaja(Integer codigo, boolean afectarecuperacion) {
        this.codigo = codigo;
        this.afectarecuperacion = afectarecuperacion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getAfectarecuperacion() {
        return afectarecuperacion;
    }

    public void setAfectarecuperacion(boolean afectarecuperacion) {
        this.afectarecuperacion = afectarecuperacion;
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
        if (!(object instanceof Causalreciboscaja)) {
            return false;
        }
        Causalreciboscaja other = (Causalreciboscaja) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Causalreciboscaja[ codigo=" + codigo + " ]";
    }
    
}
