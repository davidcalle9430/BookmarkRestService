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
@Table(name = "nc_dian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NcDian.findAll", query = "SELECT n FROM NcDian n"),
    @NamedQuery(name = "NcDian.findByNrorecibocaja", query = "SELECT n FROM NcDian n WHERE n.nrorecibocaja = :nrorecibocaja"),
    @NamedQuery(name = "NcDian.findByFecha", query = "SELECT n FROM NcDian n WHERE n.fecha = :fecha"),
    @NamedQuery(name = "NcDian.findByNc", query = "SELECT n FROM NcDian n WHERE n.nc = :nc"),
    @NamedQuery(name = "NcDian.findByFactura", query = "SELECT n FROM NcDian n WHERE n.factura = :factura"),
    @NamedQuery(name = "NcDian.findByCodigo", query = "SELECT n FROM NcDian n WHERE n.codigo = :codigo"),
    @NamedQuery(name = "NcDian.findById", query = "SELECT n FROM NcDian n WHERE n.id = :id")})
public class NcDian implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NRORECIBOCAJA")
    private Double nrorecibocaja;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "NC")
    private Double nc;
    @Column(name = "FACTURA")
    private Double factura;
    @Column(name = "CODIGO")
    private Double codigo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public NcDian() {
    }

    public NcDian(Integer id) {
        this.id = id;
    }

    public Double getNrorecibocaja() {
        return nrorecibocaja;
    }

    public void setNrorecibocaja(Double nrorecibocaja) {
        this.nrorecibocaja = nrorecibocaja;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getNc() {
        return nc;
    }

    public void setNc(Double nc) {
        this.nc = nc;
    }

    public Double getFactura() {
        return factura;
    }

    public void setFactura(Double factura) {
        this.factura = factura;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
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
        if (!(object instanceof NcDian)) {
            return false;
        }
        NcDian other = (NcDian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.NcDian[ id=" + id + " ]";
    }
    
}
