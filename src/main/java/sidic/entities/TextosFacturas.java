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
@Table(name = "textos_facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TextosFacturas.findAll", query = "SELECT t FROM TextosFacturas t"),
    @NamedQuery(name = "TextosFacturas.findByCodigo", query = "SELECT t FROM TextosFacturas t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TextosFacturas.findByTexto1", query = "SELECT t FROM TextosFacturas t WHERE t.texto1 = :texto1"),
    @NamedQuery(name = "TextosFacturas.findByTexto2", query = "SELECT t FROM TextosFacturas t WHERE t.texto2 = :texto2"),
    @NamedQuery(name = "TextosFacturas.findByTexto3", query = "SELECT t FROM TextosFacturas t WHERE t.texto3 = :texto3"),
    @NamedQuery(name = "TextosFacturas.findByDias", query = "SELECT t FROM TextosFacturas t WHERE t.dias = :dias"),
    @NamedQuery(name = "TextosFacturas.findByPorcentaje", query = "SELECT t FROM TextosFacturas t WHERE t.porcentaje = :porcentaje")})
public class TextosFacturas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(nullable = false, precision = 22)
    private Double codigo;
    @Column(length = 80)
    private String texto1;
    @Column(length = 80)
    private String texto2;
    @Column(length = 80)
    private String texto3;
    private Integer dias;
    @Column(precision = 22)
    private Double porcentaje;

    public TextosFacturas() {
    }

    public TextosFacturas(Double codigo) {
        this.codigo = codigo;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public String getTexto1() {
        return texto1;
    }

    public void setTexto1(String texto1) {
        this.texto1 = texto1;
    }

    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }

    public String getTexto3() {
        return texto3;
    }

    public void setTexto3(String texto3) {
        this.texto3 = texto3;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
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
        if (!(object instanceof TextosFacturas)) {
            return false;
        }
        TextosFacturas other = (TextosFacturas) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.TextosFacturas[ codigo=" + codigo + " ]";
    }
    
}
