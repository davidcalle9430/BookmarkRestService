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
@Table(name = "recibos_caja")
@XmlRootElement
public class RecibosCaja implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(nullable = false, precision = 22)
    private Double nrorecibocaja;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private Integer cliente;
    @Column(precision = 22)
    private Double valorrecibo;
    @Column(precision = 22)
    private Double nc;
    @Column(precision = 22)
    private Double pagadomas;
    @Column(precision = 22)
    private Double pagadomenos;
    @Column(precision = 22)
    private Double reteica;
    @Column(precision = 22)
    private Double reteiva;
    @Column(precision = 22)
    private Double retefte;
    @Column(precision = 22)
    private Double total;
    @Column(length = 180)
    private String descripcion;
    @Column(precision = 22)
    private Double nd;
    @Column(precision = 22)
    private Double saldo;
    @Column(precision = 22)
    private Double retcree;
    private Integer tiporecibo;
    @Column(length = 255)
    private String nombre;
    @Column(length = 255)
    private String concepto;

    public RecibosCaja() {
    }

    public RecibosCaja(Double nrorecibocaja) {
        this.nrorecibocaja = nrorecibocaja;
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

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Double getValorrecibo() {
        return valorrecibo;
    }

    public void setValorrecibo(Double valorrecibo) {
        this.valorrecibo = valorrecibo;
    }

    public Double getNc() {
        return nc;
    }

    public void setNc(Double nc) {
        this.nc = nc;
    }

    public Double getPagadomas() {
        return pagadomas;
    }

    public void setPagadomas(Double pagadomas) {
        this.pagadomas = pagadomas;
    }

    public Double getPagadomenos() {
        return pagadomenos;
    }

    public void setPagadomenos(Double pagadomenos) {
        this.pagadomenos = pagadomenos;
    }

    public Double getReteica() {
        return reteica;
    }

    public void setReteica(Double reteica) {
        this.reteica = reteica;
    }

    public Double getReteiva() {
        return reteiva;
    }

    public void setReteiva(Double reteiva) {
        this.reteiva = reteiva;
    }

    public Double getRetefte() {
        return retefte;
    }

    public void setRetefte(Double retefte) {
        this.retefte = retefte;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getNd() {
        return nd;
    }

    public void setNd(Double nd) {
        this.nd = nd;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getRetcree() {
        return retcree;
    }

    public void setRetcree(Double retcree) {
        this.retcree = retcree;
    }

    public Integer getTiporecibo() {
        return tiporecibo;
    }

    public void setTiporecibo(Integer tiporecibo) {
        this.tiporecibo = tiporecibo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrorecibocaja != null ? nrorecibocaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecibosCaja)) {
            return false;
        }
        RecibosCaja other = (RecibosCaja) object;
        if ((this.nrorecibocaja == null && other.nrorecibocaja != null) || (this.nrorecibocaja != null && !this.nrorecibocaja.equals(other.nrorecibocaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.RecibosCaja[ nrorecibocaja=" + nrorecibocaja + " ]";
    }
    
}
