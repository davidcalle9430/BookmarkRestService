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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
public class Notascredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotascreditoPK notascreditoPK;
    @Column(length = 200)
    private String nombre;
    @Column(length = 200)
    private String referencia;
    @Column(length = 200)
    private String modelo;
    @Column(length = 200)
    private String marca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double cantidad;
    @Column(precision = 22)
    private Double valorunitario;
    @Column(precision = 22)
    private Double porcdscto;
    @Column(precision = 22)
    private Double porciva;
    @Column(precision = 22)
    private Double valortotal;
    @Column(length = 50)
    private String usuario;
    @Column(length = 250)
    private String descripcion;

    public Notascredito() {
    }

    public Notascredito(NotascreditoPK notascreditoPK) {
        this.notascreditoPK = notascreditoPK;
    }

    public Notascredito(double nrorecibocaja, double cliente, double factura, double articulo, double nc, double secuencia) {
        this.notascreditoPK = new NotascreditoPK(nrorecibocaja, cliente, factura, articulo, nc, secuencia);
    }

    public NotascreditoPK getNotascreditoPK() {
        return notascreditoPK;
    }

    public void setNotascreditoPK(NotascreditoPK notascreditoPK) {
        this.notascreditoPK = notascreditoPK;
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

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(Double valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Double getPorcdscto() {
        return porcdscto;
    }

    public void setPorcdscto(Double porcdscto) {
        this.porcdscto = porcdscto;
    }

    public Double getPorciva() {
        return porciva;
    }

    public void setPorciva(Double porciva) {
        this.porciva = porciva;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
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
        hash += (notascreditoPK != null ? notascreditoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notascredito)) {
            return false;
        }
        Notascredito other = (Notascredito) object;
        if ((this.notascreditoPK == null && other.notascreditoPK != null) || (this.notascreditoPK != null && !this.notascreditoPK.equals(other.notascreditoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Notascredito[ notascreditoPK=" + notascreditoPK + " ]";
    }
    
}
