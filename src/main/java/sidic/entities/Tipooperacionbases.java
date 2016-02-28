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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
public class Tipooperacionbases implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipooperacionbasesPK tipooperacionbasesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double base;
    @Column(precision = 22)
    private Double porcentaje;
    @Column(length = 1)
    private String tipo;
    @JoinColumn(name = "TIPOOPERACION", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipooperacion tipooperacion1;

    public Tipooperacionbases() {
    }

    public Tipooperacionbases(TipooperacionbasesPK tipooperacionbasesPK) {
        this.tipooperacionbasesPK = tipooperacionbasesPK;
    }

    public Tipooperacionbases(short tipooperacion, String impuesto) {
        this.tipooperacionbasesPK = new TipooperacionbasesPK(tipooperacion, impuesto);
    }

    public TipooperacionbasesPK getTipooperacionbasesPK() {
        return tipooperacionbasesPK;
    }

    public void setTipooperacionbasesPK(TipooperacionbasesPK tipooperacionbasesPK) {
        this.tipooperacionbasesPK = tipooperacionbasesPK;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Tipooperacion getTipooperacion1() {
        return tipooperacion1;
    }

    public void setTipooperacion1(Tipooperacion tipooperacion1) {
        this.tipooperacion1 = tipooperacion1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipooperacionbasesPK != null ? tipooperacionbasesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Tipooperacionbases)) {
            return false;
        }
        Tipooperacionbases other = (Tipooperacionbases) object;
        if ((this.tipooperacionbasesPK == null && other.tipooperacionbasesPK != null) || (this.tipooperacionbasesPK != null && !this.tipooperacionbasesPK.equals(other.tipooperacionbasesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Tipooperacionbases[ tipooperacionbasesPK=" + tipooperacionbasesPK + " ]";
    }
    
}
