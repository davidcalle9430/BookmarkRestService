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
@Table(name = "costodeventasjm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costodeventasjm.findAll", query = "SELECT c FROM Costodeventasjm c"),
    @NamedQuery(name = "Costodeventasjm.findByFechai", query = "SELECT c FROM Costodeventasjm c WHERE c.fechai = :fechai"),
    @NamedQuery(name = "Costodeventasjm.findByFechaf", query = "SELECT c FROM Costodeventasjm c WHERE c.fechaf = :fechaf"),
    @NamedQuery(name = "Costodeventasjm.findByLinea", query = "SELECT c FROM Costodeventasjm c WHERE c.linea = :linea"),
    @NamedQuery(name = "Costodeventasjm.findByFecha", query = "SELECT c FROM Costodeventasjm c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Costodeventasjm.findByCodigo", query = "SELECT c FROM Costodeventasjm c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Costodeventasjm.findByNombre", query = "SELECT c FROM Costodeventasjm c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Costodeventasjm.findByReferencia", query = "SELECT c FROM Costodeventasjm c WHERE c.referencia = :referencia"),
    @NamedQuery(name = "Costodeventasjm.findByCantidad", query = "SELECT c FROM Costodeventasjm c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "Costodeventasjm.findByCostopro", query = "SELECT c FROM Costodeventasjm c WHERE c.costopro = :costopro"),
    @NamedQuery(name = "Costodeventasjm.findByCostvent", query = "SELECT c FROM Costodeventasjm c WHERE c.costvent = :costvent"),
    @NamedQuery(name = "Costodeventasjm.findById", query = "SELECT c FROM Costodeventasjm c WHERE c.id = :id")})
public class Costodeventasjm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "fechai")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechai;
    @Column(name = "fechaf")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaf;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LINEA")
    private Double linea;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "CANTIDAD")
    private Double cantidad;
    @Column(name = "COSTOPRO")
    private Double costopro;
    @Column(name = "costvent")
    private Double costvent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Costodeventasjm() {
    }

    public Costodeventasjm(Integer id) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostopro() {
        return costopro;
    }

    public void setCostopro(Double costopro) {
        this.costopro = costopro;
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
        if (!(object instanceof Costodeventasjm)) {
            return false;
        }
        Costodeventasjm other = (Costodeventasjm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Costodeventasjm[ id=" + id + " ]";
    }
    
}
