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
@Table(name = "xh")
@XmlRootElement
public class Xh implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CARDEX_CODIGO")
    private Double cardexCodigo;
    @Column(name = "VENDEDOR")
    private String vendedor;
    @Column(name = "CARTERA_CODIGO")
    private Double carteraCodigo;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "MODELO1")
    private String modelo1;
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "cant")
    private Double cant;
    @Column(name = "PRECIO")
    private Double precio;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Xh() {
    }

    public Xh(Integer id) {
        this.id = id;
    }

    public Double getCardexCodigo() {
        return cardexCodigo;
    }

    public void setCardexCodigo(Double cardexCodigo) {
        this.cardexCodigo = cardexCodigo;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Double getCarteraCodigo() {
        return carteraCodigo;
    }

    public void setCarteraCodigo(Double carteraCodigo) {
        this.carteraCodigo = carteraCodigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getModelo1() {
        return modelo1;
    }

    public void setModelo1(String modelo1) {
        this.modelo1 = modelo1;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getCant() {
        return cant;
    }

    public void setCant(Double cant) {
        this.cant = cant;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
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
        if (!(object instanceof Xh)) {
            return false;
        }
        Xh other = (Xh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Xh[ id=" + id + " ]";
    }
    
}
