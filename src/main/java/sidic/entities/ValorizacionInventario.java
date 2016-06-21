/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "valorizacion_inventario")
@XmlRootElement
public class ValorizacionInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ValorizacionInventarioPK valorizacionInventarioPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Long tiporeg;
    @Column(length = 100)
    private String nomlinea;
    @Column(precision = 22)
    private Double codcorr;
    @Column(length = 100)
    private String nomcorr;
    @Column(precision = 22)
    private Double valor;

    public ValorizacionInventario() {
    }

    public ValorizacionInventario(ValorizacionInventarioPK valorizacionInventarioPK) {
        this.valorizacionInventarioPK = valorizacionInventarioPK;
    }

    public ValorizacionInventario(Date fecha, Long linea) {
        this.valorizacionInventarioPK = new ValorizacionInventarioPK(fecha, linea);
    }

    public ValorizacionInventarioPK getValorizacionInventarioPK() {
        return valorizacionInventarioPK;
    }

    public void setValorizacionInventarioPK(ValorizacionInventarioPK valorizacionInventarioPK) {
        this.valorizacionInventarioPK = valorizacionInventarioPK;
    }

    public Long getTiporeg() {
        return tiporeg;
    }

    public void setTiporeg(Long tiporeg) {
        this.tiporeg = tiporeg;
    }

    public String getNomlinea() {
        return nomlinea;
    }

    public void setNomlinea(String nomlinea) {
        this.nomlinea = nomlinea;
    }

    public Double getCodcorr() {
        return codcorr;
    }

    public void setCodcorr(Double codcorr) {
        this.codcorr = codcorr;
    }

    public String getNomcorr() {
        return nomcorr;
    }

    public void setNomcorr(String nomcorr) {
        this.nomcorr = nomcorr;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valorizacionInventarioPK != null ? valorizacionInventarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorizacionInventario)) {
            return false;
        }
        ValorizacionInventario other = (ValorizacionInventario) object;
        if ((this.valorizacionInventarioPK == null && other.valorizacionInventarioPK != null) || (this.valorizacionInventarioPK != null && !this.valorizacionInventarioPK.equals(other.valorizacionInventarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.ValorizacionInventario[ valorizacionInventarioPK=" + valorizacionInventarioPK + " ]";
    }
    
}
