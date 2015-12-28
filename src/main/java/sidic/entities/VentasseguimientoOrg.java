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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author david
 */
@Entity
@Table(name = "vo")
@NamedQueries({
    @NamedQuery(name = "VentasseguimientoOrg.findAll", query = "SELECT v FROM VentasseguimientoOrg v"),
    @NamedQuery(name = "VentasseguimientoOrg.findByCliente", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.cliente = :cliente"),
    @NamedQuery(name = "VentasseguimientoOrg.findByFactura", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.ventasseguimientoOrgPK.factura = :factura"),
    @NamedQuery(name = "VentasseguimientoOrg.findByMes", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.mes = :mes"),
    @NamedQuery(name = "VentasseguimientoOrg.findByCodigo", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.ventasseguimientoOrgPK.codigo = :codigo"),
    @NamedQuery(name = "VentasseguimientoOrg.findByCantidad", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "VentasseguimientoOrg.findByValorNeto", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.valorNeto = :valorNeto"),
    @NamedQuery(name = "VentasseguimientoOrg.findByCostoIM", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.costoIM = :costoIM"),
    @NamedQuery(name = "VentasseguimientoOrg.findByCostoJM", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.costoJM = :costoJM"),
    @NamedQuery(name = "VentasseguimientoOrg.findByutilidadBrutaIm", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.utilidadBrutaIm = :utilidadBrutaIm"),
    @NamedQuery(name = "VentasseguimientoOrg.findByUtilidadBrutaJM", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.utilidadBrutaJM = :utilidadBrutaJM"),
    @NamedQuery(name = "VentasseguimientoOrg.findByFletes", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.fletes = :fletes"),
    @NamedQuery(name = "VentasseguimientoOrg.findByAcarreosAlpasarImpordisa", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.acarreosAlpasarImpordisa = :acarreosAlpasarImpordisa"),
    @NamedQuery(name = "VentasseguimientoOrg.findByAcarreosImpordisaCliente", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.acarreosImpordisaCliente = :acarreosImpordisaCliente"),
    @NamedQuery(name = "VentasseguimientoOrg.findByBodegaje", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.bodegaje = :bodegaje"),
    @NamedQuery(name = "VentasseguimientoOrg.findByLogisticaAlpasar", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.logisticaAlpasar = :logisticaAlpasar"),
    @NamedQuery(name = "VentasseguimientoOrg.findByVarios", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.varios = :varios"),
    @NamedQuery(name = "VentasseguimientoOrg.findByDetalle", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.detalle = :detalle"),
    @NamedQuery(name = "VentasseguimientoOrg.findByConcepto7", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.concepto7 = :concepto7"),
    @NamedQuery(name = "VentasseguimientoOrg.findByConcepto8", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.concepto8 = :concepto8"),
    @NamedQuery(name = "VentasseguimientoOrg.findByConcepto9", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.concepto9 = :concepto9"),
    @NamedQuery(name = "VentasseguimientoOrg.findByConcepto10", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.concepto10 = :concepto10"),
    @NamedQuery(name = "VentasseguimientoOrg.findByEstado", query = "SELECT v FROM VentasseguimientoOrg v WHERE v.estado = :estado")})
public class VentasseguimientoOrg implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentasseguimientoOrgPK ventasseguimientoOrgPK;
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
    @Column(precision = 22, name="utilidadBrutaIm")
    public Float utilidadBrutaIm;
    @Column(precision = 22, name="utilidadBrutaJM")
    public Double utilidadBrutaJM;
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

    public VentasseguimientoOrg() {}

    public VentasseguimientoOrg(VentasseguimientoOrgPK ventasseguimientoOrgPK) {
        this.ventasseguimientoOrgPK = ventasseguimientoOrgPK;
    }

    public VentasseguimientoOrg(double factura, double codigo) {
        this.ventasseguimientoOrgPK = new VentasseguimientoOrgPK(factura, codigo);
    }

    public VentasseguimientoOrgPK getVentasseguimientoOrgPK() {
        return ventasseguimientoOrgPK;
    }

    public void setVentasseguimientoOrgPK(VentasseguimientoOrgPK ventasseguimientoOrgPK) {
        this.ventasseguimientoOrgPK = ventasseguimientoOrgPK;
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

    public Float getutilidadBrutaIm() {
        return utilidadBrutaIm;
    }

    public void setutilidadBrutaIm(Float utilidadBrutaIm) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasseguimientoOrgPK != null ? ventasseguimientoOrgPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasseguimientoOrg)) {
            return false;
        }
        VentasseguimientoOrg other = (VentasseguimientoOrg) object;
        if ((this.ventasseguimientoOrgPK == null && other.ventasseguimientoOrgPK != null) || (this.ventasseguimientoOrgPK != null && !this.ventasseguimientoOrgPK.equals(other.ventasseguimientoOrgPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.VentasseguimientoOrg[ ventasseguimientoOrgPK=" + ventasseguimientoOrgPK + " ]";
    }
    
}
