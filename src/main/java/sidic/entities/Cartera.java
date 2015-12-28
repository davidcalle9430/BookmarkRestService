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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartera.findAll", query = "SELECT c FROM Cartera c"),
    @NamedQuery(name = "Cartera.findByCodigo", query = "SELECT c FROM Cartera c WHERE c.carteraPK.codigo = :codigo"),
    @NamedQuery(name = "Cartera.findByFecha", query = "SELECT c FROM Cartera c WHERE c.carteraPK.fecha = :fecha"),
    @NamedQuery(name = "Cartera.findByProductos", query = "SELECT c FROM Cartera c WHERE c.productos = :productos"),
    @NamedQuery(name = "Cartera.findByFpago", query = "SELECT c FROM Cartera c WHERE c.fpago = :fpago"),
    @NamedQuery(name = "Cartera.findByValor", query = "SELECT c FROM Cartera c WHERE c.valor = :valor"),
    @NamedQuery(name = "Cartera.findByFactura", query = "SELECT c FROM Cartera c WHERE c.carteraPK.factura = :factura"),
    @NamedQuery(name = "Cartera.findByNotad", query = "SELECT c FROM Cartera c WHERE c.notad = :notad"),
    @NamedQuery(name = "Cartera.findByNotac", query = "SELECT c FROM Cartera c WHERE c.notac = :notac"),
    @NamedQuery(name = "Cartera.findByObservac", query = "SELECT c FROM Cartera c WHERE c.observac = :observac"),
    @NamedQuery(name = "Cartera.findByFechapago", query = "SELECT c FROM Cartera c WHERE c.fechapago = :fechapago"),
    @NamedQuery(name = "Cartera.findByDescontada", query = "SELECT c FROM Cartera c WHERE c.descontada = :descontada"),
    @NamedQuery(name = "Cartera.findBySaldo", query = "SELECT c FROM Cartera c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "Cartera.findBySubtot", query = "SELECT c FROM Cartera c WHERE c.subtot = :subtot"),
    @NamedQuery(name = "Cartera.findByAceites", query = "SELECT c FROM Cartera c WHERE c.aceites = :aceites"),
    @NamedQuery(name = "Cartera.findByCorreria", query = "SELECT c FROM Cartera c WHERE c.correria = :correria"),
    @NamedQuery(name = "Cartera.findByLinea", query = "SELECT c FROM Cartera c WHERE c.linea = :linea"),
    @NamedQuery(name = "Cartera.findByZona", query = "SELECT c FROM Cartera c WHERE c.zona = :zona"),
    @NamedQuery(name = "Cartera.findByCiudad", query = "SELECT c FROM Cartera c WHERE c.ciudad = :ciudad"),
    @NamedQuery(name = "Cartera.findByC1", query = "SELECT c FROM Cartera c WHERE c.c1 = :c1"),
    @NamedQuery(name = "Cartera.findByC2", query = "SELECT c FROM Cartera c WHERE c.c2 = :c2"),
    @NamedQuery(name = "Cartera.findByC3", query = "SELECT c FROM Cartera c WHERE c.c3 = :c3"),
    @NamedQuery(name = "Cartera.findByC4", query = "SELECT c FROM Cartera c WHERE c.c4 = :c4"),
    @NamedQuery(name = "Cartera.findByC5", query = "SELECT c FROM Cartera c WHERE c.c5 = :c5"),
    @NamedQuery(name = "Cartera.findByC6", query = "SELECT c FROM Cartera c WHERE c.c6 = :c6"),
    @NamedQuery(name = "Cartera.findByTotal", query = "SELECT c FROM Cartera c WHERE c.total = :total"),
    @NamedQuery(name = "Cartera.findByDscto", query = "SELECT c FROM Cartera c WHERE c.dscto = :dscto"),
    @NamedQuery(name = "Cartera.findByFletes", query = "SELECT c FROM Cartera c WHERE c.fletes = :fletes"),
    @NamedQuery(name = "Cartera.findByOtros", query = "SELECT c FROM Cartera c WHERE c.otros = :otros"),
    @NamedQuery(name = "Cartera.findByIva", query = "SELECT c FROM Cartera c WHERE c.iva = :iva"),
    @NamedQuery(name = "Cartera.findByCodtexto", query = "SELECT c FROM Cartera c WHERE c.codtexto = :codtexto"),
    @NamedQuery(name = "Cartera.findByDias", query = "SELECT c FROM Cartera c WHERE c.dias = :dias"),
    @NamedQuery(name = "Cartera.findByPorcentaje", query = "SELECT c FROM Cartera c WHERE c.porcentaje = :porcentaje")})
public class Cartera implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CarteraPK carteraPK;
    @Column(length = 30)
    private String productos;
    @Column(length = 5)
    private String fpago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double valor;
    @Column(precision = 22)
    private Double notad;
    @Column(precision = 22)
    private Double notac;
    @Column(length = 150)
    private String observac;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapago;
    @Column(precision = 22)
    private Double descontada;
    @Column(precision = 22)
    private Double saldo;
    @Column(precision = 22)
    private Double subtot;
    @Column(length = 1)
    private String aceites;
    @Column(precision = 22)
    private Double correria;
    @Column(precision = 22)
    private Double linea;
    @Column(length = 3)
    private String zona;
    @Column(length = 30)
    private String ciudad;
    private Integer c1;
    private Integer c2;
    private Integer c3;
    private Integer c4;
    private Integer c5;
    private Integer c6;
    @Column(precision = 22)
    private Double total;
    @Column(precision = 22)
    private Double dscto;
    @Column(precision = 22)
    private Double fletes;
    @Column(precision = 22)
    private Double otros;
    @Column(precision = 22)
    private Double iva;
    @Column(precision = 22)
    private Double codtexto;
    @Column(precision = 22)
    private Double dias;
    @Column(precision = 22)
    private Double porcentaje;
    
    @JsonIgnore
    @JoinColumn(name = "CODIGO", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clientes clientes;
    @JsonIgnore
    @JoinColumn(name = "VENDEDOR", referencedColumnName = "CODIGO")
    @ManyToOne
    private Vendedor vendedor;

    public Cartera() {
    }

    public Cartera(CarteraPK carteraPK) {
        this.carteraPK = carteraPK;
    }

    public Cartera(Long codigo, Date fecha, Long factura) {
        this.carteraPK = new CarteraPK(codigo, fecha, factura);
    }

    public CarteraPK getCarteraPK() {
        return carteraPK;
    }

    public void setCarteraPK(CarteraPK carteraPK) {
        this.carteraPK = carteraPK;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getFpago() {
        return fpago;
    }

    public void setFpago(String fpago) {
        this.fpago = fpago;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getNotad() {
        return notad;
    }

    public void setNotad(Double notad) {
        this.notad = notad;
    }

    public Double getNotac() {
        return notac;
    }

    public void setNotac(Double notac) {
        this.notac = notac;
    }

    public String getObservac() {
        return observac;
    }

    public void setObservac(String observac) {
        this.observac = observac;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Double getDescontada() {
        return descontada;
    }

    public void setDescontada(Double descontada) {
        this.descontada = descontada;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSubtot() {
        return subtot;
    }

    public void setSubtot(Double subtot) {
        this.subtot = subtot;
    }

    public String getAceites() {
        return aceites;
    }

    public void setAceites(String aceites) {
        this.aceites = aceites;
    }

    public Double getCorreria() {
        return correria;
    }

    public void setCorreria(Double correria) {
        this.correria = correria;
    }

    public Double getLinea() {
        return linea;
    }

    public void setLinea(Double linea) {
        this.linea = linea;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getC1() {
        return c1;
    }

    public void setC1(Integer c1) {
        this.c1 = c1;
    }

    public Integer getC2() {
        return c2;
    }

    public void setC2(Integer c2) {
        this.c2 = c2;
    }

    public Integer getC3() {
        return c3;
    }

    public void setC3(Integer c3) {
        this.c3 = c3;
    }

    public Integer getC4() {
        return c4;
    }

    public void setC4(Integer c4) {
        this.c4 = c4;
    }

    public Integer getC5() {
        return c5;
    }

    public void setC5(Integer c5) {
        this.c5 = c5;
    }

    public Integer getC6() {
        return c6;
    }

    public void setC6(Integer c6) {
        this.c6 = c6;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDscto() {
        return dscto;
    }

    public void setDscto(Double dscto) {
        this.dscto = dscto;
    }

    public Double getFletes() {
        return fletes;
    }

    public void setFletes(Double fletes) {
        this.fletes = fletes;
    }

    public Double getOtros() {
        return otros;
    }

    public void setOtros(Double otros) {
        this.otros = otros;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getCodtexto() {
        return codtexto;
    }

    public void setCodtexto(Double codtexto) {
        this.codtexto = codtexto;
    }

    public Double getDias() {
        return dias;
    }

    public void setDias(Double dias) {
        this.dias = dias;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carteraPK != null ? carteraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartera)) {
            return false;
        }
        Cartera other = (Cartera) object;
        if ((this.carteraPK == null && other.carteraPK != null) || (this.carteraPK != null && !this.carteraPK.equals(other.carteraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Cartera[ carteraPK=" + carteraPK + " ]";
    }
    
}
