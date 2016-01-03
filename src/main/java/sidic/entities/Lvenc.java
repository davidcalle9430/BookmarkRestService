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
@Table(name = "lvenc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lvenc.findAll", query = "SELECT l FROM Lvenc l"),
    @NamedQuery(name = "Lvenc.findByTipo", query = "SELECT l FROM Lvenc l WHERE l.tipo = :tipo"),
    @NamedQuery(name = "Lvenc.findByFechapago", query = "SELECT l FROM Lvenc l WHERE l.fechapago = :fechapago"),
    @NamedQuery(name = "Lvenc.findByFecha", query = "SELECT l FROM Lvenc l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "Lvenc.findByDias", query = "SELECT l FROM Lvenc l WHERE l.dias = :dias"),
    @NamedQuery(name = "Lvenc.findByVendedorCodigo", query = "SELECT l FROM Lvenc l WHERE l.vendedorCodigo = :vendedorCodigo"),
    @NamedQuery(name = "Lvenc.findByNombre", query = "SELECT l FROM Lvenc l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Lvenc.findByCarteraCodigo", query = "SELECT l FROM Lvenc l WHERE l.carteraCodigo = :carteraCodigo"),
    @NamedQuery(name = "Lvenc.findByFactura", query = "SELECT l FROM Lvenc l WHERE l.factura = :factura"),
    @NamedQuery(name = "Lvenc.findByTipfact", query = "SELECT l FROM Lvenc l WHERE l.tipfact = :tipfact"),
    @NamedQuery(name = "Lvenc.findByFpago", query = "SELECT l FROM Lvenc l WHERE l.fpago = :fpago"),
    @NamedQuery(name = "Lvenc.findBySubtot", query = "SELECT l FROM Lvenc l WHERE l.subtot = :subtot"),
    @NamedQuery(name = "Lvenc.findByDescontada", query = "SELECT l FROM Lvenc l WHERE l.descontada = :descontada"),
    @NamedQuery(name = "Lvenc.findByVMasDe", query = "SELECT l FROM Lvenc l WHERE l.vMasDe = :vMasDe"),
    @NamedQuery(name = "Lvenc.findById", query = "SELECT l FROM Lvenc l WHERE l.id = :id")})
public class Lvenc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "FECHAPAGO")
    private String fechapago;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "dias")
    private Short dias;
    @Column(name = "VENDEDOR_CODIGO")
    private String vendedorCodigo;
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CARTERA_CODIGO")
    private Double carteraCodigo;
    @Column(name = "FACTURA")
    private Double factura;
    @Column(name = "tipfact")
    private String tipfact;
    @Column(name = "FPAGO")
    private String fpago;
    @Column(name = "SUBTOT")
    private Double subtot;
    @Column(name = "DESCONTADA")
    private Double descontada;
    @Column(name = "v_mas_de")
    private Double vMasDe;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Lvenc() {
    }

    public Lvenc(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechapago() {
        return fechapago;
    }

    public void setFechapago(String fechapago) {
        this.fechapago = fechapago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Short getDias() {
        return dias;
    }

    public void setDias(Short dias) {
        this.dias = dias;
    }

    public String getVendedorCodigo() {
        return vendedorCodigo;
    }

    public void setVendedorCodigo(String vendedorCodigo) {
        this.vendedorCodigo = vendedorCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCarteraCodigo() {
        return carteraCodigo;
    }

    public void setCarteraCodigo(Double carteraCodigo) {
        this.carteraCodigo = carteraCodigo;
    }

    public Double getFactura() {
        return factura;
    }

    public void setFactura(Double factura) {
        this.factura = factura;
    }

    public String getTipfact() {
        return tipfact;
    }

    public void setTipfact(String tipfact) {
        this.tipfact = tipfact;
    }

    public String getFpago() {
        return fpago;
    }

    public void setFpago(String fpago) {
        this.fpago = fpago;
    }

    public Double getSubtot() {
        return subtot;
    }

    public void setSubtot(Double subtot) {
        this.subtot = subtot;
    }

    public Double getDescontada() {
        return descontada;
    }

    public void setDescontada(Double descontada) {
        this.descontada = descontada;
    }

    public Double getVMasDe() {
        return vMasDe;
    }

    public void setVMasDe(Double vMasDe) {
        this.vMasDe = vMasDe;
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
        if (!(object instanceof Lvenc)) {
            return false;
        }
        Lvenc other = (Lvenc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Lvenc[ id=" + id + " ]";
    }
    
}
