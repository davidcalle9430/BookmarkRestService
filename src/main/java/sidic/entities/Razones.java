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
@Table(name = "razones")
@XmlRootElement
public class Razones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RAZON")
    private Integer razon;
    @Column(name = "DESCRIP")
    private String descrip;

    public Razones() {
    }

    public Razones(Integer razon) {
        this.razon = razon;
    }

    public Integer getRazon() {
        return razon;
    }

    public void setRazon(Integer razon) {
        this.razon = razon;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (razon != null ? razon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Razones)) {
            return false;
        }
        Razones other = (Razones) object;
        if ((this.razon == null && other.razon != null) || (this.razon != null && !this.razon.equals(other.razon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Razones[ razon=" + razon + " ]";
    }
    
}
