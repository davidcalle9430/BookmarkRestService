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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "t_discriminado")
@XmlRootElement
public class TDiscriminado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Column(name = "RAZSOC")
    private String razsoc;
    @Column(name = "CIUDAD")
    private String ciudad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ac0")
    private Double ac0;
    @Column(name = "ac30")
    private Double ac30;
    @Column(name = "ac45")
    private Double ac45;
    @Column(name = "ac60")
    private Double ac60;
    @Column(name = "ac75")
    private Double ac75;
    @Column(name = "ac90")
    private Double ac90;
    @Column(name = "pag")
    private Integer pag;

    public TDiscriminado() {
    }

    public TDiscriminado(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRazsoc() {
        return razsoc;
    }

    public void setRazsoc(String razsoc) {
        this.razsoc = razsoc;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getAc0() {
        return ac0;
    }

    public void setAc0(Double ac0) {
        this.ac0 = ac0;
    }

    public Double getAc30() {
        return ac30;
    }

    public void setAc30(Double ac30) {
        this.ac30 = ac30;
    }

    public Double getAc45() {
        return ac45;
    }

    public void setAc45(Double ac45) {
        this.ac45 = ac45;
    }

    public Double getAc60() {
        return ac60;
    }

    public void setAc60(Double ac60) {
        this.ac60 = ac60;
    }

    public Double getAc75() {
        return ac75;
    }

    public void setAc75(Double ac75) {
        this.ac75 = ac75;
    }

    public Double getAc90() {
        return ac90;
    }

    public void setAc90(Double ac90) {
        this.ac90 = ac90;
    }

    public Integer getPag() {
        return pag;
    }

    public void setPag(Integer pag) {
        this.pag = pag;
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
        if (!(object instanceof TDiscriminado)) {
            return false;
        }
        TDiscriminado other = (TDiscriminado) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.TDiscriminado[ codigo=" + codigo + " ]";
    }
    
}
