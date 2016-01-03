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
@Table(name = "lvencidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lvencidas.findAll", query = "SELECT l FROM Lvencidas l"),
    @NamedQuery(name = "Lvencidas.findByTipo", query = "SELECT l FROM Lvencidas l WHERE l.tipo = :tipo"),
    @NamedQuery(name = "Lvencidas.findByFechapago", query = "SELECT l FROM Lvencidas l WHERE l.fechapago = :fechapago"),
    @NamedQuery(name = "Lvencidas.findByFecha", query = "SELECT l FROM Lvencidas l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "Lvencidas.findByDias", query = "SELECT l FROM Lvencidas l WHERE l.dias = :dias"),
    @NamedQuery(name = "Lvencidas.findByVendcod", query = "SELECT l FROM Lvencidas l WHERE l.vendcod = :vendcod"),
    @NamedQuery(name = "Lvencidas.findByVendnombre", query = "SELECT l FROM Lvencidas l WHERE l.vendnombre = :vendnombre"),
    @NamedQuery(name = "Lvencidas.findByCodigo", query = "SELECT l FROM Lvencidas l WHERE l.codigo = :codigo"),
    @NamedQuery(name = "Lvencidas.findByRazsoc", query = "SELECT l FROM Lvencidas l WHERE l.razsoc = :razsoc"),
    @NamedQuery(name = "Lvencidas.findByCiudad", query = "SELECT l FROM Lvencidas l WHERE l.ciudad = :ciudad"),
    @NamedQuery(name = "Lvencidas.findByFactura", query = "SELECT l FROM Lvencidas l WHERE l.factura = :factura"),
    @NamedQuery(name = "Lvencidas.findByTipfact", query = "SELECT l FROM Lvencidas l WHERE l.tipfact = :tipfact"),
    @NamedQuery(name = "Lvencidas.findByFpago", query = "SELECT l FROM Lvencidas l WHERE l.fpago = :fpago"),
    @NamedQuery(name = "Lvencidas.findByValor", query = "SELECT l FROM Lvencidas l WHERE l.valor = :valor"),
    @NamedQuery(name = "Lvencidas.findByDescontada", query = "SELECT l FROM Lvencidas l WHERE l.descontada = :descontada"),
    @NamedQuery(name = "Lvencidas.findByVMasDe", query = "SELECT l FROM Lvencidas l WHERE l.vMasDe = :vMasDe"),
    @NamedQuery(name = "Lvencidas.findById", query = "SELECT l FROM Lvencidas l WHERE l.id = :id")})
public class Lvencidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "FECHAPAGO")
    private String fechapago;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "dias")
    private Short dias;
    @Column(name = "VENDCOD")
    private String vendcod;
    @Column(name = "VENDNOMBRE")
    private String vendnombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "RAZSOC")
    private String razsoc;
    @Column(name = "CIUDAD")
    private String ciudad;
    @Column(name = "FACTURA")
    private Double factura;
    @Column(name = "tipfact")
    private String tipfact;
    @Column(name = "FPAGO")
    private String fpago;
    @Column(name = "VALOR")
    private Double valor;
    @Column(name = "DESCONTADA")
    private Double descontada;
    @Column(name = "v_mas_de")
    private Double vMasDe;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Lvencidas() {
    }

    public Lvencidas(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechapago() {
        return fechapago;
    }

    public void setFechapago(String fechapago) {
        this.fechapago = fechapago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Short getDias() {
        return dias;
    }

    public void setDias(Short dias) {
        this.dias = dias;
    }

    public String getVendcod() {
        return vendcod;
    }

    public void setVendcod(String vendcod) {
        this.vendcod = vendcod;
    }

    public String getVendnombre() {
        return vendnombre;
    }

    public void setVendnombre(String vendnombre) {
        this.vendnombre = vendnombre;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public String getRazsoc() {
        return razsoc;
    }

    public void setRazsoc(String razsoc) {
        this.razsoc = razsoc;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getFactura() {
        return factura;
    }

    public void setFactura(Double factura) {
        this.factura = factura;
    }

    public String getTipfact() {
        return tipfact;
    }

    public void setTipfact(String tipfact) {
        this.tipfact = tipfact;
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

    public Double getDescontada() {
        return descontada;
    }

    public void setDescontada(Double descontada) {
        this.descontada = descontada;
    }

    public Double getVMasDe() {
        return vMasDe;
    }

    public void setVMasDe(Double vMasDe) {
        this.vMasDe = vMasDe;
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
        if (!(object instanceof Lvencidas)) {
            return false;
        }
        Lvencidas other = (Lvencidas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Lvencidas[ id=" + id + " ]";
    }
    
}
