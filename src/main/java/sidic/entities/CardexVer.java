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
@Table(name = "cardex_ver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardexVer.findAll", query = "SELECT c FROM CardexVer c"),
    @NamedQuery(name = "CardexVer.findByConsec", query = "SELECT c FROM CardexVer c WHERE c.consec = :consec"),
    @NamedQuery(name = "CardexVer.findByCodigo", query = "SELECT c FROM CardexVer c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CardexVer.findByFecha", query = "SELECT c FROM CardexVer c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CardexVer.findByTipo", query = "SELECT c FROM CardexVer c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "CardexVer.findByDocumento", query = "SELECT c FROM CardexVer c WHERE c.documento = :documento"),
    @NamedQuery(name = "CardexVer.findByCantidad", query = "SELECT c FROM CardexVer c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CardexVer.findByNdoc", query = "SELECT c FROM CardexVer c WHERE c.ndoc = :ndoc"),
    @NamedQuery(name = "CardexVer.findBySaldo", query = "SELECT c FROM CardexVer c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "CardexVer.findBySaldoreal", query = "SELECT c FROM CardexVer c WHERE c.saldoreal = :saldoreal"),
    @NamedQuery(name = "CardexVer.findByDiferencia", query = "SELECT c FROM CardexVer c WHERE c.diferencia = :diferencia")})
public class CardexVer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consec")
    private Integer consec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "DOCUMENTO")
    private String documento;
    @Column(name = "CANTIDAD")
    private Double cantidad;
    @Column(name = "NDOC")
    private Double ndoc;
    @Column(name = "SALDO")
    private Double saldo;
    @Column(name = "SALDOREAL")
    private Double saldoreal;
    @Column(name = "DIFERENCIA")
    private Double diferencia;

    public CardexVer() {
    }

    public CardexVer(Integer consec) {
        this.consec = consec;
    }

    public Integer getConsec() {
        return consec;
    }

    public void setConsec(Integer consec) {
        this.consec = consec;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getNdoc() {
        return ndoc;
    }

    public void setNdoc(Double ndoc) {
        this.ndoc = ndoc;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldoreal() {
        return saldoreal;
    }

    public void setSaldoreal(Double saldoreal) {
        this.saldoreal = saldoreal;
    }

    public Double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(Double diferencia) {
        this.diferencia = diferencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consec != null ? consec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CardexVer)) {
            return false;
        }
        CardexVer other = (CardexVer) object;
        if ((this.consec == null && other.consec != null) || (this.consec != null && !this.consec.equals(other.consec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.CardexVer[ consec=" + consec + " ]";
    }
    
}
