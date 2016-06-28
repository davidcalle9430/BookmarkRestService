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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name="remision")
@XmlRootElement
public class Remision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(length = 50)
    private String codigo;
    @Column(length = 35)
    private String nombre;
    @Column(length = 35)
    private String referencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double descuen;
    @Column(precision = 22)
    private Double precio;
    @Column(precision = 22)
    private Double cantidad;
    @Column(length = 18)
    private String modelo;
    @Column(length = 11)
    private String marca;
    private Integer remision;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer consec;

    public Remision() {
    }

    public Remision(Integer consec) {
        this.consec = consec;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getDescuen() {
        return descuen;
    }

    public void setDescuen(Double descuen) {
        this.descuen = descuen;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getRemision() {
        return remision;
    }

    public void setRemision(Integer remision) {
        this.remision = remision;
    }

    public Integer getConsec() {
        return consec;
    }

    public void setConsec(Integer consec) {
        this.consec = consec;
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
        if (!(object instanceof Remision)) {
            return false;
        }
        Remision other = (Remision) object;
        if ((this.consec == null && other.consec != null) || (this.consec != null && !this.consec.equals(other.consec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Remision[ consec=" + consec + " ]";
    }
    
}
