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
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
public class Ctasproveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue
    @Basic(optional = false)
    @Column(nullable = false)
    private int consec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(nullable = false, precision = 22)
    private Double nrodocumento;
    @Column(precision = 22)
    private Double identificacion;
    @Column(length = 255)
    private String concepto;
    @Column(precision = 22)
    private Double valor;
    @Column(precision = 22)
    private Double reterenta;
    @Column(precision = 22)
    private Double reteiva;
    @Column(precision = 22)
    private Double reteica;
    @Column(precision = 22)
    private Double netoapagar;
    @Column(precision = 22)
    private Double impuestoasumido;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(precision = 22)
    private Double porcrenta;
    @Column(precision = 22)
    private Double porciva;
    @Column(precision = 22)
    private Double porcica;
    @Column(length = 50)
    private String actividad;

    public Ctasproveedores() {
    }

    public Ctasproveedores(Double nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

    public Ctasproveedores(Double nrodocumento, int consec) {
        this.nrodocumento = nrodocumento;
        this.consec = consec;
    }

    public int getConsec() {
        return consec;
    }

    public void setConsec(int consec) {
        this.consec = consec;
    }

    public Double getNrodocumento() {
        return nrodocumento;
    }

    public void setNrodocumento(Double nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

    public Double getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Double identificacion) {
        this.identificacion = identificacion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getReterenta() {
        return reterenta;
    }

    public void setReterenta(Double reterenta) {
        this.reterenta = reterenta;
    }

    public Double getReteiva() {
        return reteiva;
    }

    public void setReteiva(Double reteiva) {
        this.reteiva = reteiva;
    }

    public Double getReteica() {
        return reteica;
    }

    public void setReteica(Double reteica) {
        this.reteica = reteica;
    }

    public Double getNetoapagar() {
        return netoapagar;
    }

    public void setNetoapagar(Double netoapagar) {
        this.netoapagar = netoapagar;
    }

    public Double getImpuestoasumido() {
        return impuestoasumido;
    }

    public void setImpuestoasumido(Double impuestoasumido) {
        this.impuestoasumido = impuestoasumido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPorcrenta() {
        return porcrenta;
    }

    public void setPorcrenta(Double porcrenta) {
        this.porcrenta = porcrenta;
    }

    public Double getPorciva() {
        return porciva;
    }

    public void setPorciva(Double porciva) {
        this.porciva = porciva;
    }

    public Double getPorcica() {
        return porcica;
    }

    public void setPorcica(Double porcica) {
        this.porcica = porcica;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrodocumento != null ? nrodocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ctasproveedores)) {
            return false;
        }
        Ctasproveedores other = (Ctasproveedores) object;
        if ((this.nrodocumento == null && other.nrodocumento != null) || (this.nrodocumento != null && !this.nrodocumento.equals(other.nrodocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Ctasproveedores[ nrodocumento=" + nrodocumento + " ]";
    }
    
}
