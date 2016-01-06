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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "nfact")
@XmlRootElement
public class Nfact implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FACTIVA")
    private Double factiva;
    @Column(name = "FACTSINIVA")
    private Double factsiniva;
    @Column(name = "ACUMIVA")
    private Double acumiva;
    @Column(name = "ACUMSINIVA")
    private Double acumsiniva;
    @Column(name = "MES")
    private Double mes;
    @Column(name = "ANO")
    private Double ano;
    @Column(name = "ANOCOPIA")
    private Double anocopia;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "CLAVEC")
    private String clavec;
    @Column(name = "PORCPREC")
    private Double porcprec;
    @Column(name = "JMQCL")
    private String jmqcl;
    @Column(name = "FECCORLVEN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccorlven;
    @Column(name = "PORCFACTUR")
    private Double porcfactur;
    @Column(name = "VALRET")
    private Double valret;
    @Column(name = "REMISION")
    private Double remision;
    @Column(name = "FECHISTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechisto;
    @Column(name = "PEDIDO")
    private Double pedido;
    @Column(name = "PORCFACMAS")
    private Double porcfacmas;
    @Column(name = "IVA")
    private Double iva;
    @Column(name = "PORCPLUS")
    private Double porcplus;
    @Column(name = "RECIBOCAJA")
    private Double recibocaja;
    @Column(name = "NC")
    private Integer nc;
    @Column(name = "ND")
    private Integer nd;
    @Column(name = "cuenta1")
    private String cuenta1;
    @Column(name = "cuenta2")
    private String cuenta2;
    @Column(name = "FACtPROVEEDORES")
    private Double fACtPROVEEDORES;
    @Column(name = "NUEVOFORMATO")
    private String nuevoformato;
    @Column(name = "aaaaseguimiento")
    private Integer aaaaseguimiento;
    @Column(name = "FacturaEnproceso")
    private String facturaEnproceso;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Nfact() {
    }

    public Nfact(Integer id) {
        this.id = id;
    }

    public Double getFactiva() {
        return factiva;
    }

    public void setFactiva(Double factiva) {
        this.factiva = factiva;
    }

    public Double getFactsiniva() {
        return factsiniva;
    }

    public void setFactsiniva(Double factsiniva) {
        this.factsiniva = factsiniva;
    }

    public Double getAcumiva() {
        return acumiva;
    }

    public void setAcumiva(Double acumiva) {
        this.acumiva = acumiva;
    }

    public Double getAcumsiniva() {
        return acumsiniva;
    }

    public void setAcumsiniva(Double acumsiniva) {
        this.acumsiniva = acumsiniva;
    }

    public Double getMes() {
        return mes;
    }

    public void setMes(Double mes) {
        this.mes = mes;
    }

    public Double getAno() {
        return ano;
    }

    public void setAno(Double ano) {
        this.ano = ano;
    }

    public Double getAnocopia() {
        return anocopia;
    }

    public void setAnocopia(Double anocopia) {
        this.anocopia = anocopia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClavec() {
        return clavec;
    }

    public void setClavec(String clavec) {
        this.clavec = clavec;
    }

    public Double getPorcprec() {
        return porcprec;
    }

    public void setPorcprec(Double porcprec) {
        this.porcprec = porcprec;
    }

    public String getJmqcl() {
        return jmqcl;
    }

    public void setJmqcl(String jmqcl) {
        this.jmqcl = jmqcl;
    }

    public Date getFeccorlven() {
        return feccorlven;
    }

    public void setFeccorlven(Date feccorlven) {
        this.feccorlven = feccorlven;
    }

    public Double getPorcfactur() {
        return porcfactur;
    }

    public void setPorcfactur(Double porcfactur) {
        this.porcfactur = porcfactur;
    }

    public Double getValret() {
        return valret;
    }

    public void setValret(Double valret) {
        this.valret = valret;
    }

    public Double getRemision() {
        return remision;
    }

    public void setRemision(Double remision) {
        this.remision = remision;
    }

    public Date getFechisto() {
        return fechisto;
    }

    public void setFechisto(Date fechisto) {
        this.fechisto = fechisto;
    }

    public Double getPedido() {
        return pedido;
    }

    public void setPedido(Double pedido) {
        this.pedido = pedido;
    }

    public Double getPorcfacmas() {
        return porcfacmas;
    }

    public void setPorcfacmas(Double porcfacmas) {
        this.porcfacmas = porcfacmas;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getPorcplus() {
        return porcplus;
    }

    public void setPorcplus(Double porcplus) {
        this.porcplus = porcplus;
    }

    public Double getRecibocaja() {
        return recibocaja;
    }

    public void setRecibocaja(Double recibocaja) {
        this.recibocaja = recibocaja;
    }

    public Integer getNc() {
        return nc;
    }

    public void setNc(Integer nc) {
        this.nc = nc;
    }

    public Integer getNd() {
        return nd;
    }

    public void setNd(Integer nd) {
        this.nd = nd;
    }

    public String getCuenta1() {
        return cuenta1;
    }

    public void setCuenta1(String cuenta1) {
        this.cuenta1 = cuenta1;
    }

    public String getCuenta2() {
        return cuenta2;
    }

    public void setCuenta2(String cuenta2) {
        this.cuenta2 = cuenta2;
    }

    public Double getFACtPROVEEDORES() {
        return fACtPROVEEDORES;
    }

    public void setFACtPROVEEDORES(Double fACtPROVEEDORES) {
        this.fACtPROVEEDORES = fACtPROVEEDORES;
    }

    public String getNuevoformato() {
        return nuevoformato;
    }

    public void setNuevoformato(String nuevoformato) {
        this.nuevoformato = nuevoformato;
    }

    public Integer getAaaaseguimiento() {
        return aaaaseguimiento;
    }

    public void setAaaaseguimiento(Integer aaaaseguimiento) {
        this.aaaaseguimiento = aaaaseguimiento;
    }

    public String getFacturaEnproceso() {
        return facturaEnproceso;
    }

    public void setFacturaEnproceso(String facturaEnproceso) {
        this.facturaEnproceso = facturaEnproceso;
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
        if (!(object instanceof Nfact)) {
            return false;
        }
        Nfact other = (Nfact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Nfact[ id=" + id + " ]";
    }
    
}
