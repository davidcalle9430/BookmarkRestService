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
@Table(name = "x2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "X2.findAll", query = "SELECT x FROM X2 x"),
    @NamedQuery(name = "X2.findByCardexCodigo", query = "SELECT x FROM X2 x WHERE x.cardexCodigo = :cardexCodigo"),
    @NamedQuery(name = "X2.findByVendedor", query = "SELECT x FROM X2 x WHERE x.vendedor = :vendedor"),
    @NamedQuery(name = "X2.findByCarteraCodigo", query = "SELECT x FROM X2 x WHERE x.carteraCodigo = :carteraCodigo"),
    @NamedQuery(name = "X2.findByFecha", query = "SELECT x FROM X2 x WHERE x.fecha = :fecha"),
    @NamedQuery(name = "X2.findByModelo1", query = "SELECT x FROM X2 x WHERE x.modelo1 = :modelo1"),
    @NamedQuery(name = "X2.findByReferencia", query = "SELECT x FROM X2 x WHERE x.referencia = :referencia"),
    @NamedQuery(name = "X2.findByCant", query = "SELECT x FROM X2 x WHERE x.cant = :cant"),
    @NamedQuery(name = "X2.findById", query = "SELECT x FROM X2 x WHERE x.id = :id")})
public class X2 implements Serializable {

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public X2() {
    }

    public X2(Integer id) {
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
        if (!(object instanceof X2)) {
            return false;
        }
        X2 other = (X2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.X2[ id=" + id + " ]";
    }
    
}
