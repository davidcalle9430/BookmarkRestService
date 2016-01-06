/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "costoventastotal")
@XmlRootElement
public class Costoventastotal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "fechai")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechai;
    @Column(name = "fechaf")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaf;
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SumaDeCANTIDAD")
    private Double sumaDeCANTIDAD;
    @Column(name = "SumaDeCOSTOPROIM")
    private Double sumaDeCOSTOPROIM;
    @Column(name = "SumaDecostvent")
    private Double sumaDecostvent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Costoventastotal() {
    }

    public Costoventastotal(Integer id) {
        this.id = id;
    }

    public Date getFechai() {
        return fechai;
    }

    public void setFechai(Date fechai) {
        this.fechai = fechai;
    }

    public Date getFechaf() {
        return fechaf;
    }

    public void setFechaf(Date fechaf) {
        this.fechaf = fechaf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSumaDeCANTIDAD() {
        return sumaDeCANTIDAD;
    }

    public void setSumaDeCANTIDAD(Double sumaDeCANTIDAD) {
        this.sumaDeCANTIDAD = sumaDeCANTIDAD;
    }

    public Double getSumaDeCOSTOPROIM() {
        return sumaDeCOSTOPROIM;
    }

    public void setSumaDeCOSTOPROIM(Double sumaDeCOSTOPROIM) {
        this.sumaDeCOSTOPROIM = sumaDeCOSTOPROIM;
    }

    public Double getSumaDecostvent() {
        return sumaDecostvent;
    }

    public void setSumaDecostvent(Double sumaDecostvent) {
        this.sumaDecostvent = sumaDecostvent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costoventastotal)) {
            return false;
        }
        Costoventastotal other = (Costoventastotal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Costoventastotal[ id=" + id + " ]";
    }
    
}
