/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CIUDAD")
    private String ciudad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CODCORR")
    private Double codcorr;
    @Column(name = "CLIENTE")
    private Double cliente;
    @Column(name = "VALOR")
    private Double valor;
    @Column(name = "FACTURA")
    private Double factura;
    @Column(name = "CANTIDAD")
    private Double cantidad;
    @Column(name = "VALOR_DEB")
    private Double valorDeb;
    @Column(name = "VALOR_CRE")
    private Double valorCre;
    @Column(name = "DESCUE")
    private Double descue;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Ventas() {
    }

    public Ventas(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getCodcorr() {
        return codcorr;
    }

    public void setCodcorr(Double codcorr) {
        this.codcorr = codcorr;
    }

    public Double getCliente() {
        return cliente;
    }

    public void setCliente(Double cliente) {
        this.cliente = cliente;
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

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorDeb() {
        return valorDeb;
    }

    public void setValorDeb(Double valorDeb) {
        this.valorDeb = valorDeb;
    }

    public Double getValorCre() {
        return valorCre;
    }

    public void setValorCre(Double valorCre) {
        this.valorCre = valorCre;
    }

    public Double getDescue() {
        return descue;
    }

    public void setDescue(Double descue) {
        this.descue = descue;
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
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Ventas[ id=" + id + " ]";
    }
    
}
