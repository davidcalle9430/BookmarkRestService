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
@Table(name = "nd_dian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NdDian.findAll", query = "SELECT n FROM NdDian n"),
    @NamedQuery(name = "NdDian.findByNrorecibocaja", query = "SELECT n FROM NdDian n WHERE n.nrorecibocaja = :nrorecibocaja"),
    @NamedQuery(name = "NdDian.findByFactura", query = "SELECT n FROM NdDian n WHERE n.factura = :factura"),
    @NamedQuery(name = "NdDian.findByVlrnd", query = "SELECT n FROM NdDian n WHERE n.vlrnd = :vlrnd"),
    @NamedQuery(name = "NdDian.findByVlriva", query = "SELECT n FROM NdDian n WHERE n.vlriva = :vlriva"),
    @NamedQuery(name = "NdDian.findByCausal", query = "SELECT n FROM NdDian n WHERE n.causal = :causal"),
    @NamedQuery(name = "NdDian.findByFecha", query = "SELECT n FROM NdDian n WHERE n.fecha = :fecha"),
    @NamedQuery(name = "NdDian.findByNd", query = "SELECT n FROM NdDian n WHERE n.nd = :nd"),
    @NamedQuery(name = "NdDian.findByValornd", query = "SELECT n FROM NdDian n WHERE n.valornd = :valornd"),
    @NamedQuery(name = "NdDian.findById", query = "SELECT n FROM NdDian n WHERE n.id = :id")})
public class NdDian implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NRORECIBOCAJA")
    private Double nrorecibocaja;
    @Column(name = "FACTURA")
    private Double factura;
    @Column(name = "VLRND")
    private Double vlrnd;
    @Column(name = "VLRIVA")
    private Double vlriva;
    @Column(name = "CAUSAL")
    private Double causal;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "ND")
    private Double nd;
    @Column(name = "valornd")
    private Double valornd;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public NdDian() {
    }

    public NdDian(Integer id) {
        this.id = id;
    }

    public Double getNrorecibocaja() {
        return nrorecibocaja;
    }

    public void setNrorecibocaja(Double nrorecibocaja) {
        this.nrorecibocaja = nrorecibocaja;
    }

    public Double getFactura() {
        return factura;
    }

    public void setFactura(Double factura) {
        this.factura = factura;
    }

    public Double getVlrnd() {
        return vlrnd;
    }

    public void setVlrnd(Double vlrnd) {
        this.vlrnd = vlrnd;
    }

    public Double getVlriva() {
        return vlriva;
    }

    public void setVlriva(Double vlriva) {
        this.vlriva = vlriva;
    }

    public Double getCausal() {
        return causal;
    }

    public void setCausal(Double causal) {
        this.causal = causal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getNd() {
        return nd;
    }

    public void setNd(Double nd) {
        this.nd = nd;
    }

    public Double getValornd() {
        return valornd;
    }

    public void setValornd(Double valornd) {
        this.valornd = valornd;
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
        if (!(object instanceof NdDian)) {
            return false;
        }
        NdDian other = (NdDian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.NdDian[ id=" + id + " ]";
    }
    
}
