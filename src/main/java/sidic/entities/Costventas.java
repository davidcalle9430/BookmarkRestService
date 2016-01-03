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
@Table(name = "costventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costventas.findAll", query = "SELECT c FROM Costventas c"),
    @NamedQuery(name = "Costventas.findByLinea", query = "SELECT c FROM Costventas c WHERE c.linea = :linea"),
    @NamedQuery(name = "Costventas.findByFecha", query = "SELECT c FROM Costventas c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Costventas.findByCodigo", query = "SELECT c FROM Costventas c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Costventas.findByCantidad", query = "SELECT c FROM Costventas c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "Costventas.findByCostoproim", query = "SELECT c FROM Costventas c WHERE c.costoproim = :costoproim"),
    @NamedQuery(name = "Costventas.findByCostvent", query = "SELECT c FROM Costventas c WHERE c.costvent = :costvent"),
    @NamedQuery(name = "Costventas.findById", query = "SELECT c FROM Costventas c WHERE c.id = :id")})
public class Costventas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LINEA")
    private Double linea;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "CANTIDAD")
    private Double cantidad;
    @Column(name = "COSTOPROIM")
    private Double costoproim;
    @Column(name = "costvent")
    private Double costvent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Costventas() {
    }

    public Costventas(Integer id) {
        this.id = id;
    }

    public Double getLinea() {
        return linea;
    }

    public void setLinea(Double linea) {
        this.linea = linea;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostoproim() {
        return costoproim;
    }

    public void setCostoproim(Double costoproim) {
        this.costoproim = costoproim;
    }

    public Double getCostvent() {
        return costvent;
    }

    public void setCostvent(Double costvent) {
        this.costvent = costvent;
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
        if (!(object instanceof Costventas)) {
            return false;
        }
        Costventas other = (Costventas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Costventas[ id=" + id + " ]";
    }
    
}
