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
@Table(name="ventasseguimiento")
@XmlRootElement
public class Ventasseguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentasseguimientoPK ventasseguimientoPK;
    @Column(length = 250)
    private String cliente;
    private Integer mes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double cantidad;
    @Column(precision = 22)
    private Double valorNeto;
    @Column(precision = 22)
    private Double costoIM;
    @Column(precision = 22)
    private Double costoJM;
    @Column(precision = 22)
    private Double utilidadBrutaIm;
    @Column(precision = 22)
    private Double utilidadBrutaJM;
    @Column(precision = 22)
    private Double fletes;
    @Column(name = "Acarreos_Alpasar_Impordisa", precision = 22)
    private Double acarreosAlpasarImpordisa;
    @Column(name = "Acarreos_Impordisa_Cliente", precision = 22)
    private Double acarreosImpordisaCliente;
    @Column(precision = 22)
    private Double bodegaje;
    @Column(name = "Logistica_Alpasar", precision = 22)
    private Double logisticaAlpasar;
    @Column(precision = 22)
    private Double varios;
    @Column(length = 250)
    private String detalle;
    @Column(precision = 22)
    private Double concepto7;
    @Column(precision = 22)
    private Double concepto8;
    @Column(precision = 22)
    private Double concepto9;
    @Column(precision = 22)
    private Double concepto10;
    @Column(length = 1)
    private String estado;
    @Column(precision = 22)
    private Double codigoi;
    @Column(precision = 22)
    private Double codigof;
    private Integer aaaa;
    private Integer aafact;

    public Ventasseguimiento() {
    }

    public Ventasseguimiento(VentasseguimientoPK ventasseguimientoPK) {
        this.ventasseguimientoPK = ventasseguimientoPK;
    }

    public Ventasseguimiento(double factura, double codigo) {
        this.ventasseguimientoPK = new VentasseguimientoPK(factura, codigo);
    }

    public VentasseguimientoPK getVentasseguimientoPK() {
        return ventasseguimientoPK;
    }

    public void setVentasseguimientoPK(VentasseguimientoPK ventasseguimientoPK) {
        this.ventasseguimientoPK = ventasseguimientoPK;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(Double valorNeto) {
        this.valorNeto = valorNeto;
    }

    public Double getCostoIM() {
        return costoIM;
    }

    public void setCostoIM(Double costoIM) {
        this.costoIM = costoIM;
    }

    public Double getCostoJM() {
        return costoJM;
    }

    public void setCostoJM(Double costoJM) {
        this.costoJM = costoJM;
    }

    public Double getUtilidadBrutaIm() {
        return utilidadBrutaIm;
    }

    public void setUtilidadBrutaIm(Double utilidadBrutaIm) {
        this.utilidadBrutaIm = utilidadBrutaIm;
    }

    public Double getUtilidadBrutaJM() {
        return utilidadBrutaJM;
    }

    public void setUtilidadBrutaJM(Double utilidadBrutaJM) {
        this.utilidadBrutaJM = utilidadBrutaJM;
    }

    public Double getFletes() {
        return fletes;
    }

    public void setFletes(Double fletes) {
        this.fletes = fletes;
    }

    public Double getAcarreosAlpasarImpordisa() {
        return acarreosAlpasarImpordisa;
    }

    public void setAcarreosAlpasarImpordisa(Double acarreosAlpasarImpordisa) {
        this.acarreosAlpasarImpordisa = acarreosAlpasarImpordisa;
    }

    public Double getAcarreosImpordisaCliente() {
        return acarreosImpordisaCliente;
    }

    public void setAcarreosImpordisaCliente(Double acarreosImpordisaCliente) {
        this.acarreosImpordisaCliente = acarreosImpordisaCliente;
    }

    public Double getBodegaje() {
        return bodegaje;
    }

    public void setBodegaje(Double bodegaje) {
        this.bodegaje = bodegaje;
    }

    public Double getLogisticaAlpasar() {
        return logisticaAlpasar;
    }

    public void setLogisticaAlpasar(Double logisticaAlpasar) {
        this.logisticaAlpasar = logisticaAlpasar;
    }

    public Double getVarios() {
        return varios;
    }

    public void setVarios(Double varios) {
        this.varios = varios;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getConcepto7() {
        return concepto7;
    }

    public void setConcepto7(Double concepto7) {
        this.concepto7 = concepto7;
    }

    public Double getConcepto8() {
        return concepto8;
    }

    public void setConcepto8(Double concepto8) {
        this.concepto8 = concepto8;
    }

    public Double getConcepto9() {
        return concepto9;
    }

    public void setConcepto9(Double concepto9) {
        this.concepto9 = concepto9;
    }

    public Double getConcepto10() {
        return concepto10;
    }

    public void setConcepto10(Double concepto10) {
        this.concepto10 = concepto10;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getCodigoi() {
        return codigoi;
    }

    public void setCodigoi(Double codigoi) {
        this.codigoi = codigoi;
    }

    public Double getCodigof() {
        return codigof;
    }

    public void setCodigof(Double codigof) {
        this.codigof = codigof;
    }

    public Integer getAaaa() {
        return aaaa;
    }

    public void setAaaa(Integer aaaa) {
        this.aaaa = aaaa;
    }

    public Integer getAafact() {
        return aafact;
    }

    public void setAafact(Integer aafact) {
        this.aafact = aafact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasseguimientoPK != null ? ventasseguimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventasseguimiento)) {
            return false;
        }
        Ventasseguimiento other = (Ventasseguimiento) object;
        if ((this.ventasseguimientoPK == null && other.ventasseguimientoPK != null) || (this.ventasseguimientoPK != null && !this.ventasseguimientoPK.equals(other.ventasseguimientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Ventasseguimiento[ ventasseguimientoPK=" + ventasseguimientoPK + " ]";
    }
    
}
