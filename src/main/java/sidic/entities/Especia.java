/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especia.findAll", query = "SELECT e FROM Especia e"),
    @NamedQuery(name = "Especia.findByCodigo", query = "SELECT e FROM Especia e WHERE e.especiaPK.codigo = :codigo"),
    @NamedQuery(name = "Especia.findByArticulo", query = "SELECT e FROM Especia e WHERE e.especiaPK.articulo = :articulo"),
    @NamedQuery(name = "Especia.findByReferencia", query = "SELECT e FROM Especia e WHERE e.referencia = :referencia"),
    @NamedQuery(name = "Especia.findByPrecio", query = "SELECT e FROM Especia e WHERE e.precio = :precio")})
public class Especia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EspeciaPK especiaPK;
    @Column(length = 35)
    private String referencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double precio;
    @JoinColumn(name = "CODIGO", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clientes clientes;

    public Especia() {
    }

    public Especia(EspeciaPK especiaPK) {
        this.especiaPK = especiaPK;
    }

    public Especia(double codigo, double articulo) {
        this.especiaPK = new EspeciaPK(codigo, articulo);
    }

    public EspeciaPK getEspeciaPK() {
        return especiaPK;
    }

    public void setEspeciaPK(EspeciaPK especiaPK) {
        this.especiaPK = especiaPK;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especiaPK != null ? especiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especia)) {
            return false;
        }
        Especia other = (Especia) object;
        if ((this.especiaPK == null && other.especiaPK != null) || (this.especiaPK != null && !this.especiaPK.equals(other.especiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Especia[ especiaPK=" + especiaPK + " ]";
    }
    
}
