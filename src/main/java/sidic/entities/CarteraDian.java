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
@Table(name = "cartera_dian")
@XmlRootElement
public class CarteraDian implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "venta")
    private Double venta;
    @Id
    @Basic(optional = false)
    @Column(name = "FACTURA")
    private Double factura;
    @Column(name = "TOTAL")
    private Double total;
    @Column(name = "DSCTO")
    private Double dscto;
    @Column(name = "FLETES")
    private Double fletes;
    @Column(name = "OTROS")
    private Double otros;
    @Column(name = "IVA")
    private Double iva;

    public CarteraDian() {
    }

    public CarteraDian(Double factura) {
        this.factura = factura;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getVenta() {
        return venta;
    }

    public void setVenta(Double venta) {
        this.venta = venta;
    }

    public Double getFactura() {
        return factura;
    }

    public void setFactura(Double factura) {
        this.factura = factura;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDscto() {
        return dscto;
    }

    public void setDscto(Double dscto) {
        this.dscto = dscto;
    }

    public Double getFletes() {
        return fletes;
    }

    public void setFletes(Double fletes) {
        this.fletes = fletes;
    }

    public Double getOtros() {
        return otros;
    }

    public void setOtros(Double otros) {
        this.otros = otros;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factura != null ? factura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarteraDian)) {
            return false;
        }
        CarteraDian other = (CarteraDian) object;
        if ((this.factura == null && other.factura != null) || (this.factura != null && !this.factura.equals(other.factura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.CarteraDian[ factura=" + factura + " ]";
    }
    
}
