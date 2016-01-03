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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "ajustes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ajustes.findAll", query = "SELECT a FROM Ajustes a"),
    @NamedQuery(name = "Ajustes.findByCodigo", query = "SELECT a FROM Ajustes a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Ajustes.findByCantidad", query = "SELECT a FROM Ajustes a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "Ajustes.findByCostojm", query = "SELECT a FROM Ajustes a WHERE a.costojm = :costojm"),
    @NamedQuery(name = "Ajustes.findByCostoim", query = "SELECT a FROM Ajustes a WHERE a.costoim = :costoim"),
    @NamedQuery(name = "Ajustes.findByCantfinal", query = "SELECT a FROM Ajustes a WHERE a.cantfinal = :cantfinal"),
    @NamedQuery(name = "Ajustes.findByDia", query = "SELECT a FROM Ajustes a WHERE a.dia = :dia")})
public class Ajustes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costojm")
    private Double costojm;
    @Column(name = "costoim")
    private Double costoim;
    @Column(name = "cantfinal")
    private Integer cantfinal;
    @Column(name = "dia")
    private Integer dia;

    public Ajustes() {
    }

    public Ajustes(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostojm() {
        return costojm;
    }

    public void setCostojm(Double costojm) {
        this.costojm = costojm;
    }

    public Double getCostoim() {
        return costoim;
    }

    public void setCostoim(Double costoim) {
        this.costoim = costoim;
    }

    public Integer getCantfinal() {
        return cantfinal;
    }

    public void setCantfinal(Integer cantfinal) {
        this.cantfinal = cantfinal;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ajustes)) {
            return false;
        }
        Ajustes other = (Ajustes) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Ajustes[ codigo=" + codigo + " ]";
    }
    
}
