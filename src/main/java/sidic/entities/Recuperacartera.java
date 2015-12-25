/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recuperacartera.findAll", query = "SELECT r FROM Recuperacartera r"),
    @NamedQuery(name = "Recuperacartera.findByNrorecibocaja", query = "SELECT r FROM Recuperacartera r WHERE r.recuperacarteraPK.nrorecibocaja = :nrorecibocaja"),
    @NamedQuery(name = "Recuperacartera.findByUsuario", query = "SELECT r FROM Recuperacartera r WHERE r.recuperacarteraPK.usuario = :usuario"),
    @NamedQuery(name = "Recuperacartera.findByCodigo", query = "SELECT r FROM Recuperacartera r WHERE r.recuperacarteraPK.codigo = :codigo"),
    @NamedQuery(name = "Recuperacartera.findByFecha", query = "SELECT r FROM Recuperacartera r WHERE r.recuperacarteraPK.fecha = :fecha"),
    @NamedQuery(name = "Recuperacartera.findByFactura", query = "SELECT r FROM Recuperacartera r WHERE r.recuperacarteraPK.factura = :factura"),
    @NamedQuery(name = "Recuperacartera.findByObservac", query = "SELECT r FROM Recuperacartera r WHERE r.observac = :observac"),
    @NamedQuery(name = "Recuperacartera.findByFechapago", query = "SELECT r FROM Recuperacartera r WHERE r.fechapago = :fechapago"),
    @NamedQuery(name = "Recuperacartera.findByValor", query = "SELECT r FROM Recuperacartera r WHERE r.valor = :valor"),
    @NamedQuery(name = "Recuperacartera.findByVlrnc", query = "SELECT r FROM Recuperacartera r WHERE r.vlrnc = :vlrnc"),
    @NamedQuery(name = "Recuperacartera.findByVlrnd", query = "SELECT r FROM Recuperacartera r WHERE r.vlrnd = :vlrnd"),
    @NamedQuery(name = "Recuperacartera.findByOtroreccaja", query = "SELECT r FROM Recuperacartera r WHERE r.otroreccaja = :otroreccaja")})
public class Recuperacartera implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecuperacarteraPK recuperacarteraPK;
    @Column(length = 150)
    private String observac;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double valor;
    @Column(precision = 22)
    private Double vlrnc;
    @Column(precision = 22)
    private Double vlrnd;
    @Column(precision = 22)
    private Double otroreccaja;

    public Recuperacartera() {
    }

    public Recuperacartera(RecuperacarteraPK recuperacarteraPK) {
        this.recuperacarteraPK = recuperacarteraPK;
    }

    public Recuperacartera(double nrorecibocaja, String usuario, double codigo, Date fecha, double factura) {
        this.recuperacarteraPK = new RecuperacarteraPK(nrorecibocaja, usuario, codigo, fecha, factura);
    }

    public RecuperacarteraPK getRecuperacarteraPK() {
        return recuperacarteraPK;
    }

    public void setRecuperacarteraPK(RecuperacarteraPK recuperacarteraPK) {
        this.recuperacarteraPK = recuperacarteraPK;
    }

    public String getObservac() {
        return observac;
    }

    public void setObservac(String observac) {
        this.observac = observac;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getVlrnc() {
        return vlrnc;
    }

    public void setVlrnc(Double vlrnc) {
        this.vlrnc = vlrnc;
    }

    public Double getVlrnd() {
        return vlrnd;
    }

    public void setVlrnd(Double vlrnd) {
        this.vlrnd = vlrnd;
    }

    public Double getOtroreccaja() {
        return otroreccaja;
    }

    public void setOtroreccaja(Double otroreccaja) {
        this.otroreccaja = otroreccaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recuperacarteraPK != null ? recuperacarteraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recuperacartera)) {
            return false;
        }
        Recuperacartera other = (Recuperacartera) object;
        if ((this.recuperacarteraPK == null && other.recuperacarteraPK != null) || (this.recuperacarteraPK != null && !this.recuperacarteraPK.equals(other.recuperacarteraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Recuperacartera[ recuperacarteraPK=" + recuperacarteraPK + " ]";
    }
    
}
