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
@Table(name = "salidasmayor5")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salidasmayor5.findAll", query = "SELECT s FROM Salidasmayor5 s"),
    @NamedQuery(name = "Salidasmayor5.findByConsec", query = "SELECT s FROM Salidasmayor5 s WHERE s.consec = :consec"),
    @NamedQuery(name = "Salidasmayor5.findByCodigo", query = "SELECT s FROM Salidasmayor5 s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Salidasmayor5.findByFecha", query = "SELECT s FROM Salidasmayor5 s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Salidasmayor5.findByTipo", query = "SELECT s FROM Salidasmayor5 s WHERE s.tipo = :tipo"),
    @NamedQuery(name = "Salidasmayor5.findByDocumento", query = "SELECT s FROM Salidasmayor5 s WHERE s.documento = :documento"),
    @NamedQuery(name = "Salidasmayor5.findByCantidad", query = "SELECT s FROM Salidasmayor5 s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "Salidasmayor5.findByNdoc", query = "SELECT s FROM Salidasmayor5 s WHERE s.ndoc = :ndoc"),
    @NamedQuery(name = "Salidasmayor5.findBySaldo", query = "SELECT s FROM Salidasmayor5 s WHERE s.saldo = :saldo")})
public class Salidasmayor5 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
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

    public Salidasmayor5() {
    }

    public Salidasmayor5(Integer consec) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consec != null ? consec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salidasmayor5)) {
            return false;
        }
        Salidasmayor5 other = (Salidasmayor5) object;
        if ((this.consec == null && other.consec != null) || (this.consec != null && !this.consec.equals(other.consec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Salidasmayor5[ consec=" + consec + " ]";
    }
    
}
