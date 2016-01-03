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
@Table(name = "notdecre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notdecre.findAll", query = "SELECT n FROM Notdecre n"),
    @NamedQuery(name = "Notdecre.findByFecha", query = "SELECT n FROM Notdecre n WHERE n.fecha = :fecha"),
    @NamedQuery(name = "Notdecre.findByCliente", query = "SELECT n FROM Notdecre n WHERE n.cliente = :cliente"),
    @NamedQuery(name = "Notdecre.findByFactura", query = "SELECT n FROM Notdecre n WHERE n.factura = :factura"),
    @NamedQuery(name = "Notdecre.findByValDeb", query = "SELECT n FROM Notdecre n WHERE n.valDeb = :valDeb"),
    @NamedQuery(name = "Notdecre.findByValCre", query = "SELECT n FROM Notdecre n WHERE n.valCre = :valCre"),
    @NamedQuery(name = "Notdecre.findByIva", query = "SELECT n FROM Notdecre n WHERE n.iva = :iva"),
    @NamedQuery(name = "Notdecre.findByCantidad", query = "SELECT n FROM Notdecre n WHERE n.cantidad = :cantidad"),
    @NamedQuery(name = "Notdecre.findByCodigo", query = "SELECT n FROM Notdecre n WHERE n.codigo = :codigo"),
    @NamedQuery(name = "Notdecre.findByPrecio", query = "SELECT n FROM Notdecre n WHERE n.precio = :precio"),
    @NamedQuery(name = "Notdecre.findByDescue", query = "SELECT n FROM Notdecre n WHERE n.descue = :descue"),
    @NamedQuery(name = "Notdecre.findByCausal", query = "SELECT n FROM Notdecre n WHERE n.causal = :causal"),
    @NamedQuery(name = "Notdecre.findById", query = "SELECT n FROM Notdecre n WHERE n.id = :id")})
public class Notdecre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CLIENTE")
    private Double cliente;
    @Column(name = "FACTURA")
    private Double factura;
    @Column(name = "VAL_DEB")
    private Double valDeb;
    @Column(name = "VAL_CRE")
    private Double valCre;
    @Column(name = "IVA")
    private Double iva;
    @Column(name = "CANTIDAD")
    private Double cantidad;
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "DESCUE")
    private Double descue;
    @Column(name = "CAUSAL")
    private Integer causal;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Notdecre() {
    }

    public Notdecre(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCliente() {
        return cliente;
    }

    public void setCliente(Double cliente) {
        this.cliente = cliente;
    }

    public Double getFactura() {
        return factura;
    }

    public void setFactura(Double factura) {
        this.factura = factura;
    }

    public Double getValDeb() {
        return valDeb;
    }

    public void setValDeb(Double valDeb) {
        this.valDeb = valDeb;
    }

    public Double getValCre() {
        return valCre;
    }

    public void setValCre(Double valCre) {
        this.valCre = valCre;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getDescue() {
        return descue;
    }

    public void setDescue(Double descue) {
        this.descue = descue;
    }

    public Integer getCausal() {
        return causal;
    }

    public void setCausal(Integer causal) {
        this.causal = causal;
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
        if (!(object instanceof Notdecre)) {
            return false;
        }
        Notdecre other = (Notdecre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Notdecre[ id=" + id + " ]";
    }
    
}
