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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name="notascreditodscto")
@XmlRootElement
public class Notascreditodscto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotascreditodsctoPK notascreditodsctoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double vlrnc;
    @Column(precision = 22)
    private Double vlriva;
    @Column(precision = 22)
    private Double causal;
    @Column(precision = 22)
    private Double nc;
    @Column(length = 50)
    private String usuario;
    @Column(length = 250)
    private String descripcion;

    public Notascreditodscto() {
    }

    public Notascreditodscto(NotascreditodsctoPK notascreditodsctoPK) {
        this.notascreditodsctoPK = notascreditodsctoPK;
    }

    public Notascreditodscto(double nrorecibocaja, double cliente, double factura) {
        this.notascreditodsctoPK = new NotascreditodsctoPK(nrorecibocaja, cliente, factura);
    }

    public NotascreditodsctoPK getNotascreditodsctoPK() {
        return notascreditodsctoPK;
    }

    public void setNotascreditodsctoPK(NotascreditodsctoPK notascreditodsctoPK) {
        this.notascreditodsctoPK = notascreditodsctoPK;
    }

    public Double getVlrnc() {
        return vlrnc;
    }

    public void setVlrnc(Double vlrnc) {
        this.vlrnc = vlrnc;
    }

    public Double getVlriva() {
        return vlriva;
    }

    public void setVlriva(Double vlriva) {
        this.vlriva = vlriva;
    }

    public Double getCausal() {
        return causal;
    }

    public void setCausal(Double causal) {
        this.causal = causal;
    }

    public Double getNc() {
        return nc;
    }

    public void setNc(Double nc) {
        this.nc = nc;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notascreditodsctoPK != null ? notascreditodsctoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notascreditodscto)) {
            return false;
        }
        Notascreditodscto other = (Notascreditodscto) object;
        if ((this.notascreditodsctoPK == null && other.notascreditodsctoPK != null) || (this.notascreditodsctoPK != null && !this.notascreditodsctoPK.equals(other.notascreditodsctoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Notascreditodscto[ notascreditodsctoPK=" + notascreditodsctoPK + " ]";
    }
    
}
