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
@Table(name = "revisar")
@XmlRootElement
public class Revisar implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "PRODUCTOS")
    private String productos;
    @Column(name = "FPAGO")
    private String fpago;
    @Column(name = "VALOR")
    private Double valor;
    @Column(name = "FACTURA")
    private Double factura;
    @Column(name = "NOTAD")
    private Double notad;
    @Column(name = "NOTAC")
    private Double notac;
    @Column(name = "OBSERVAC")
    private String observac;
    @Column(name = "FECHAPAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapago;
    @Column(name = "DESCONTADA")
    private Double descontada;
    @Column(name = "VENDEDOR")
    private String vendedor;
    @Column(name = "SALDO")
    private Double saldo;
    @Column(name = "SUBTOT")
    private Double subtot;
    @Column(name = "ACEITES")
    private String aceites;
    @Column(name = "CORRERIA")
    private Double correria;
    @Column(name = "LINEA")
    private Double linea;
    @Column(name = "ZONA")
    private String zona;
    @Column(name = "CIUDAD")
    private String ciudad;
    @Column(name = "Expr1")
    private String expr1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Revisar() {
    }

    public Revisar(Integer id) {
        this.id = id;
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

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getFpago() {
        return fpago;
    }

    public void setFpago(String fpago) {
        this.fpago = fpago;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getFactura() {
        return factura;
    }

    public void setFactura(Double factura) {
        this.factura = factura;
    }

    public Double getNotad() {
        return notad;
    }

    public void setNotad(Double notad) {
        this.notad = notad;
    }

    public Double getNotac() {
        return notac;
    }

    public void setNotac(Double notac) {
        this.notac = notac;
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

    public Double getDescontada() {
        return descontada;
    }

    public void setDescontada(Double descontada) {
        this.descontada = descontada;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSubtot() {
        return subtot;
    }

    public void setSubtot(Double subtot) {
        this.subtot = subtot;
    }

    public String getAceites() {
        return aceites;
    }

    public void setAceites(String aceites) {
        this.aceites = aceites;
    }

    public Double getCorreria() {
        return correria;
    }

    public void setCorreria(Double correria) {
        this.correria = correria;
    }

    public Double getLinea() {
        return linea;
    }

    public void setLinea(Double linea) {
        this.linea = linea;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getExpr1() {
        return expr1;
    }

    public void setExpr1(String expr1) {
        this.expr1 = expr1;
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
        if (!(object instanceof Revisar)) {
            return false;
        }
        Revisar other = (Revisar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Revisar[ id=" + id + " ]";
    }
    
}
