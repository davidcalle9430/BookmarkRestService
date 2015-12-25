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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "notasdebito_tmp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasdebitoTmp.findAll", query = "SELECT n FROM NotasdebitoTmp n"),
    @NamedQuery(name = "NotasdebitoTmp.findByNrorecibocaja", query = "SELECT n FROM NotasdebitoTmp n WHERE n.notasdebitoTmpPK.nrorecibocaja = :nrorecibocaja"),
    @NamedQuery(name = "NotasdebitoTmp.findByCliente", query = "SELECT n FROM NotasdebitoTmp n WHERE n.notasdebitoTmpPK.cliente = :cliente"),
    @NamedQuery(name = "NotasdebitoTmp.findByFactura", query = "SELECT n FROM NotasdebitoTmp n WHERE n.notasdebitoTmpPK.factura = :factura"),
    @NamedQuery(name = "NotasdebitoTmp.findByVlrnd", query = "SELECT n FROM NotasdebitoTmp n WHERE n.vlrnd = :vlrnd"),
    @NamedQuery(name = "NotasdebitoTmp.findByVlriva", query = "SELECT n FROM NotasdebitoTmp n WHERE n.vlriva = :vlriva"),
    @NamedQuery(name = "NotasdebitoTmp.findByCausal", query = "SELECT n FROM NotasdebitoTmp n WHERE n.causal = :causal"),
    @NamedQuery(name = "NotasdebitoTmp.findByNd", query = "SELECT n FROM NotasdebitoTmp n WHERE n.nd = :nd"),
    @NamedQuery(name = "NotasdebitoTmp.findByUsuario", query = "SELECT n FROM NotasdebitoTmp n WHERE n.notasdebitoTmpPK.usuario = :usuario"),
    @NamedQuery(name = "NotasdebitoTmp.findByCartera", query = "SELECT n FROM NotasdebitoTmp n WHERE n.cartera = :cartera"),
    @NamedQuery(name = "NotasdebitoTmp.findByReportevtas", query = "SELECT n FROM NotasdebitoTmp n WHERE n.reportevtas = :reportevtas"),
    @NamedQuery(name = "NotasdebitoTmp.findByAcumvtas", query = "SELECT n FROM NotasdebitoTmp n WHERE n.acumvtas = :acumvtas"),
    @NamedQuery(name = "NotasdebitoTmp.findByDescripcion", query = "SELECT n FROM NotasdebitoTmp n WHERE n.descripcion = :descripcion")})
public class NotasdebitoTmp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotasdebitoTmpPK notasdebitoTmpPK;
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

    public NotasdebitoTmp() {
    }

    public NotasdebitoTmp(NotasdebitoTmpPK notasdebitoTmpPK) {
        this.notasdebitoTmpPK = notasdebitoTmpPK;
    }

    public NotasdebitoTmp(double nrorecibocaja, double cliente, double factura, String usuario) {
        this.notasdebitoTmpPK = new NotasdebitoTmpPK(nrorecibocaja, cliente, factura, usuario);
    }

    public NotasdebitoTmpPK getNotasdebitoTmpPK() {
        return notasdebitoTmpPK;
    }

    public void setNotasdebitoTmpPK(NotasdebitoTmpPK notasdebitoTmpPK) {
        this.notasdebitoTmpPK = notasdebitoTmpPK;
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
        hash += (notasdebitoTmpPK != null ? notasdebitoTmpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasdebitoTmp)) {
            return false;
        }
        NotasdebitoTmp other = (NotasdebitoTmp) object;
        if ((this.notasdebitoTmpPK == null && other.notasdebitoTmpPK != null) || (this.notasdebitoTmpPK != null && !this.notasdebitoTmpPK.equals(other.notasdebitoTmpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.NotasdebitoTmp[ notasdebitoTmpPK=" + notasdebitoTmpPK + " ]";
    }
    
}
