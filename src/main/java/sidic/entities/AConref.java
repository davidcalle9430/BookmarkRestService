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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "a_conref")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AConref.findAll", query = "SELECT a FROM AConref a"),
    @NamedQuery(name = "AConref.findByCodigo", query = "SELECT a FROM AConref a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "AConref.findByCamref", query = "SELECT a FROM AConref a WHERE a.camref = :camref")})
public class AConref implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "CAMREF")
    private String camref;

    public AConref() {
    }

    public AConref(Double codigo) {
        this.codigo = codigo;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public String getCamref() {
        return camref;
    }

    public void setCamref(String camref) {
        this.camref = camref;
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
        if (!(object instanceof AConref)) {
            return false;
        }
        AConref other = (AConref) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.AConref[ codigo=" + codigo + " ]";
    }
    
}
