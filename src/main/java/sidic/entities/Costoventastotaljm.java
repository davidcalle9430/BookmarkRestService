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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "costoventastotaljm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costoventastotaljm.findAll", query = "SELECT c FROM Costoventastotaljm c"),
    @NamedQuery(name = "Costoventastotaljm.findByFechai", query = "SELECT c FROM Costoventastotaljm c WHERE c.fechai = :fechai"),
    @NamedQuery(name = "Costoventastotaljm.findByFechaf", query = "SELECT c FROM Costoventastotaljm c WHERE c.fechaf = :fechaf"),
    @NamedQuery(name = "Costoventastotaljm.findByNombre", query = "SELECT c FROM Costoventastotaljm c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Costoventastotaljm.findBySumaDeCANTIDAD", query = "SELECT c FROM Costoventastotaljm c WHERE c.sumaDeCANTIDAD = :sumaDeCANTIDAD"),
    @NamedQuery(name = "Costoventastotaljm.findBySumaDeCOSTOPRO", query = "SELECT c FROM Costoventastotaljm c WHERE c.sumaDeCOSTOPRO = :sumaDeCOSTOPRO"),
    @NamedQuery(name = "Costoventastotaljm.findBySumaDecostvent", query = "SELECT c FROM Costoventastotaljm c WHERE c.sumaDecostvent = :sumaDecostvent"),
    @NamedQuery(name = "Costoventastotaljm.findById", query = "SELECT c FROM Costoventastotaljm c WHERE c.id = :id")})
public class Costoventastotaljm implements Serializable {

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
    @Column(name = "SumaDeCOSTOPRO")
    private Double sumaDeCOSTOPRO;
    @Column(name = "SumaDecostvent")
    private Double sumaDecostvent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Costoventastotaljm() {
    }

    public Costoventastotaljm(Integer id) {
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

    public Double getSumaDeCOSTOPRO() {
        return sumaDeCOSTOPRO;
    }

    public void setSumaDeCOSTOPRO(Double sumaDeCOSTOPRO) {
        this.sumaDeCOSTOPRO = sumaDeCOSTOPRO;
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
        if (!(object instanceof Costoventastotaljm)) {
            return false;
        }
        Costoventastotaljm other = (Costoventastotaljm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Costoventastotaljm[ id=" + id + " ]";
    }
    
}
