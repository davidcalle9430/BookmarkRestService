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
 * por Ahora creo que la i al final hace referencia a que es el cardex del inventario
 * @author david
 */
@Entity
@Table(name = "cardexi")
@XmlRootElement
public class Cardexi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "consec")
    private Long consec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CODIGO")
    private Long codigo;
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
    private Long saldo;

    public Cardexi() {
    }

    public Cardexi(Long consec) {
        this.consec = consec;
    }

    public Long getConsec() {
        return consec;
    }

    public void setConsec(Long consec) {
        this.consec = consec;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
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

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
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
        if (!(object instanceof Cardexi)) {
            return false;
        }
        Cardexi other = (Cardexi) object;
        if ((this.consec == null && other.consec != null) || (this.consec != null && !this.consec.equals(other.consec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Cardexi[ consec=" + consec + " ]";
    }
    
}
