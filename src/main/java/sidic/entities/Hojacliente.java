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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "hojacliente")
@XmlRootElement
public class Hojacliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "RAZSOC")
    private String razsoc;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "PROPTARIO")
    private String proptario;
    @Column(name = "NIT")
    private String nit;
    @Column(name = "FECHAING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaing;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "GERENTE")
    private String gerente;
    @Column(name = "fechamodif")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodif;
    @Column(name = "CLIENTES_CIUDAD")
    private Short clientesCiudad;
    @Column(name = "CIUDADES_CIUDAD")
    private String ciudadesCiudad;
    @Column(name = "CUPO")
    private String cupo;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "Descipcion")
    private String descipcion;
    @Column(name = "Plazodepago")
    private String plazodepago;
    @Column(name = "Valor")
    private Double valor;
    @Column(name = "Factura")
    private Double factura;
    @Column(name = "Dias")
    private Integer dias;
    @Column(name = "Observaciones")
    private String observaciones;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Hojacliente() {
    }

    public Hojacliente(Integer id) {
        this.id = id;
    }

    public String getRazsoc() {
        return razsoc;
    }

    public void setRazsoc(String razsoc) {
        this.razsoc = razsoc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProptario() {
        return proptario;
    }

    public void setProptario(String proptario) {
        this.proptario = proptario;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Date getFechaing() {
        return fechaing;
    }

    public void setFechaing(Date fechaing) {
        this.fechaing = fechaing;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public Date getFechamodif() {
        return fechamodif;
    }

    public void setFechamodif(Date fechamodif) {
        this.fechamodif = fechamodif;
    }

    public Short getClientesCiudad() {
        return clientesCiudad;
    }

    public void setClientesCiudad(Short clientesCiudad) {
        this.clientesCiudad = clientesCiudad;
    }

    public String getCiudadesCiudad() {
        return ciudadesCiudad;
    }

    public void setCiudadesCiudad(String ciudadesCiudad) {
        this.ciudadesCiudad = ciudadesCiudad;
    }

    public String getCupo() {
        return cupo;
    }

    public void setCupo(String cupo) {
        this.cupo = cupo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public String getPlazodepago() {
        return plazodepago;
    }

    public void setPlazodepago(String plazodepago) {
        this.plazodepago = plazodepago;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getFactura() {
        return factura;
    }

    public void setFactura(Double factura) {
        this.factura = factura;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        if (!(object instanceof Hojacliente)) {
            return false;
        }
        Hojacliente other = (Hojacliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Hojacliente[ id=" + id + " ]";
    }
    
}
