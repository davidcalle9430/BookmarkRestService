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
@Table(name = "c_tempo")
@XmlRootElement
public class CTempo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(nullable = false, precision = 22)
    private Double codigo;
    @Column(name = "NIT_N", precision = 22)
    private Double nitN;
    @Column(name = "CC_N", precision = 22)
    private Double ccN;
    private Integer digitov;

    public CTempo() {
    }

    public CTempo(Double codigo) {
        this.codigo = codigo;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public Double getNitN() {
        return nitN;
    }

    public void setNitN(Double nitN) {
        this.nitN = nitN;
    }

    public Double getCcN() {
        return ccN;
    }

    public void setCcN(Double ccN) {
        this.ccN = ccN;
    }

    public Integer getDigitov() {
        return digitov;
    }

    public void setDigitov(Integer digitov) {
        this.digitov = digitov;
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
        if (!(object instanceof CTempo)) {
            return false;
        }
        CTempo other = (CTempo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.CTempo[ codigo=" + codigo + " ]";
    }
    
}
