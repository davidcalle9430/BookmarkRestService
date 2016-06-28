/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name="notasdebito")
@XmlRootElement
public class Notasdebito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotasdebitoPK notasdebitoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double vlrnd;
    @Column(precision = 22)
    private Double vlriva;
    @Column(precision = 22)
    private Double causal;
    @Column(precision = 22)
    private Double nd;
    @Column(length = 1)
    private String cartera;
    @Column(length = 1)
    private String reportevtas;
    @Column(length = 1)
    private String acumvtas;
    @Column(length = 250)
    private String descripcion;

    public Notasdebito() {
    }

    public Notasdebito(NotasdebitoPK notasdebitoPK) {
        this.notasdebitoPK = notasdebitoPK;
    }

    public Notasdebito(double nrorecibocaja, double cliente, double factura, String usuario) {
        this.notasdebitoPK = new NotasdebitoPK(nrorecibocaja, cliente, factura, usuario);
    }

    public NotasdebitoPK getNotasdebitoPK() {
        return notasdebitoPK;
    }

    public void setNotasdebitoPK(NotasdebitoPK notasdebitoPK) {
        this.notasdebitoPK = notasdebitoPK;
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

    public Double getNd() {
        return nd;
    }

    public void setNd(Double nd) {
        this.nd = nd;
    }

    public String getCartera() {
        return cartera;
    }

    public void setCartera(String cartera) {
        this.cartera = cartera;
    }

    public String getReportevtas() {
        return reportevtas;
    }

    public void setReportevtas(String reportevtas) {
        this.reportevtas = reportevtas;
    }

    public String getAcumvtas() {
        return acumvtas;
    }

    public void setAcumvtas(String acumvtas) {
        this.acumvtas = acumvtas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notasdebitoPK != null ? notasdebitoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notasdebito)) {
            return false;
        }
        Notasdebito other = (Notasdebito) object;
        if ((this.notasdebitoPK == null && other.notasdebitoPK != null) || (this.notasdebitoPK != null && !this.notasdebitoPK.equals(other.notasdebitoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Notasdebito[ notasdebitoPK=" + notasdebitoPK + " ]";
    }
    
}
