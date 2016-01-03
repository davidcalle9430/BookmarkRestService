/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "malos_h")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MalosH.findAll", query = "SELECT m FROM MalosH m"),
    @NamedQuery(name = "MalosH.findByCiudad", query = "SELECT m FROM MalosH m WHERE m.ciudad = :ciudad"),
    @NamedQuery(name = "MalosH.findByCodcorr", query = "SELECT m FROM MalosH m WHERE m.codcorr = :codcorr"),
    @NamedQuery(name = "MalosH.findByCliente", query = "SELECT m FROM MalosH m WHERE m.cliente = :cliente"),
    @NamedQuery(name = "MalosH.findByPrecio", query = "SELECT m FROM MalosH m WHERE m.precio = :precio"),
    @NamedQuery(name = "MalosH.findByFactura", query = "SELECT m FROM MalosH m WHERE m.factura = :factura"),
    @NamedQuery(name = "MalosH.findByCantidad", query = "SELECT m FROM MalosH m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "MalosH.findByCodigo", query = "SELECT m FROM MalosH m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "MalosH.findByCostoimp", query = "SELECT m FROM MalosH m WHERE m.costoimp = :costoimp"),
    @NamedQuery(name = "MalosH.findByCostojm", query = "SELECT m FROM MalosH m WHERE m.costojm = :costojm"),
    @NamedQuery(name = "MalosH.findByCostopro", query = "SELECT m FROM MalosH m WHERE m.costopro = :costopro"),
    @NamedQuery(name = "MalosH.findByCostoproim", query = "SELECT m FROM MalosH m WHERE m.costoproim = :costoproim"),
    @NamedQuery(name = "MalosH.findByDevolimp", query = "SELECT m FROM MalosH m WHERE m.devolimp = :devolimp"),
    @NamedQuery(name = "MalosH.findByDevoljm", query = "SELECT m FROM MalosH m WHERE m.devoljm = :devoljm"),
    @NamedQuery(name = "MalosH.findByValord", query = "SELECT m FROM MalosH m WHERE m.valord = :valord"),
    @NamedQuery(name = "MalosH.findByValorc", query = "SELECT m FROM MalosH m WHERE m.valorc = :valorc"),
    @NamedQuery(name = "MalosH.findByLinea", query = "SELECT m FROM MalosH m WHERE m.linea = :linea"),
    @NamedQuery(name = "MalosH.findByFecha", query = "SELECT m FROM MalosH m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "MalosH.findByDescue", query = "SELECT m FROM MalosH m WHERE m.descue = :descue"),
    @NamedQuery(name = "MalosH.findByImojm", query = "SELECT m FROM MalosH m WHERE m.imojm = :imojm"),
    @NamedQuery(name = "MalosH.findByFec", query = "SELECT m FROM MalosH m WHERE m.fec = :fec"),
    @NamedQuery(name = "MalosH.findById", query = "SELECT m FROM MalosH m WHERE m.id = :id")})
public class MalosH implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CIUDAD")
    private Short ciudad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CODCORR")
    private Double codcorr;
    @Column(name = "CLIENTE")
    private Double cliente;
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "FACTURA")
    private Double factura;
    @Column(name = "CANTIDAD")
    private Double cantidad;
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "COSTOIMP")
    private Double costoimp;
    @Column(name = "COSTOJM")
    private Double costojm;
    @Column(name = "COSTOPRO")
    private Double costopro;
    @Column(name = "COSTOPROIM")
    private Double costoproim;
    @Column(name = "DEVOLIMP")
    private Double devolimp;
    @Column(name = "DEVOLJM")
    private Double devoljm;
    @Column(name = "VALORD")
    private Double valord;
    @Column(name = "VALORC")
    private Double valorc;
    @Column(name = "LINEA")
    private Double linea;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "DESCUE")
    private Double descue;
    @Column(name = "IMOJM")
    private String imojm;
    @Column(name = "fec")
    private String fec;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public MalosH() {
    }

    public MalosH(Integer id) {
        this.id = id;
    }

    public Short getCiudad() {
        return ciudad;
    }

    public void setCiudad(Short ciudad) {
        this.ciudad = ciudad;
    }

    public Double getCodcorr() {
        return codcorr;
    }

    public void setCodcorr(Double codcorr) {
        this.codcorr = codcorr;
    }

    public Double getCliente() {
        return cliente;
    }

    public void setCliente(Double cliente) {
        this.cliente = cliente;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getFactura() {
        return factura;
    }

    public void setFactura(Double factura) {
        this.factura = factura;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public Double getCostoimp() {
        return costoimp;
    }

    public void setCostoimp(Double costoimp) {
        this.costoimp = costoimp;
    }

    public Double getCostojm() {
        return costojm;
    }

    public void setCostojm(Double costojm) {
        this.costojm = costojm;
    }

    public Double getCostopro() {
        return costopro;
    }

    public void setCostopro(Double costopro) {
        this.costopro = costopro;
    }

    public Double getCostoproim() {
        return costoproim;
    }

    public void setCostoproim(Double costoproim) {
        this.costoproim = costoproim;
    }

    public Double getDevolimp() {
        return devolimp;
    }

    public void setDevolimp(Double devolimp) {
        this.devolimp = devolimp;
    }

    public Double getDevoljm() {
        return devoljm;
    }

    public void setDevoljm(Double devoljm) {
        this.devoljm = devoljm;
    }

    public Double getValord() {
        return valord;
    }

    public void setValord(Double valord) {
        this.valord = valord;
    }

    public Double getValorc() {
        return valorc;
    }

    public void setValorc(Double valorc) {
        this.valorc = valorc;
    }

    public Double getLinea() {
        return linea;
    }

    public void setLinea(Double linea) {
        this.linea = linea;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getDescue() {
        return descue;
    }

    public void setDescue(Double descue) {
        this.descue = descue;
    }

    public String getImojm() {
        return imojm;
    }

    public void setImojm(String imojm) {
        this.imojm = imojm;
    }

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MalosH)) {
            return false;
        }
        MalosH other = (MalosH) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.MalosH[ id=" + id + " ]";
    }
    
}
