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
@Table(name = "ventasclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventasclientes.findAll", query = "SELECT v FROM Ventasclientes v"),
    @NamedQuery(name = "Ventasclientes.findByCliente", query = "SELECT v FROM Ventasclientes v WHERE v.cliente = :cliente"),
    @NamedQuery(name = "Ventasclientes.findByRazsoc", query = "SELECT v FROM Ventasclientes v WHERE v.razsoc = :razsoc"),
    @NamedQuery(name = "Ventasclientes.findByClientesCiudad", query = "SELECT v FROM Ventasclientes v WHERE v.clientesCiudad = :clientesCiudad"),
    @NamedQuery(name = "Ventasclientes.findByCiudadesCiudad", query = "SELECT v FROM Ventasclientes v WHERE v.ciudadesCiudad = :ciudadesCiudad"),
    @NamedQuery(name = "Ventasclientes.findByFecha", query = "SELECT v FROM Ventasclientes v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Ventasclientes.findByCodcorr", query = "SELECT v FROM Ventasclientes v WHERE v.codcorr = :codcorr"),
    @NamedQuery(name = "Ventasclientes.findByNombre", query = "SELECT v FROM Ventasclientes v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Ventasclientes.findByLinea", query = "SELECT v FROM Ventasclientes v WHERE v.linea = :linea"),
    @NamedQuery(name = "Ventasclientes.findByDescripcion", query = "SELECT v FROM Ventasclientes v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "Ventasclientes.findByValreal", query = "SELECT v FROM Ventasclientes v WHERE v.valreal = :valreal"),
    @NamedQuery(name = "Ventasclientes.findById", query = "SELECT v FROM Ventasclientes v WHERE v.id = :id")})
public class Ventasclientes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CLIENTE")
    private Double cliente;
    @Column(name = "RAZSOC")
    private String razsoc;
    @Column(name = "CLIENTES_CIUDAD")
    private Short clientesCiudad;
    @Column(name = "CIUDADES_CIUDAD")
    private String ciudadesCiudad;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "CODCORR")
    private Double codcorr;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "LINEA")
    private Double linea;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valreal")
    private Double valreal;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Ventasclientes() {
    }

    public Ventasclientes(Integer id) {
        this.id = id;
    }

    public Double getCliente() {
        return cliente;
    }

    public void setCliente(Double cliente) {
        this.cliente = cliente;
    }

    public String getRazsoc() {
        return razsoc;
    }

    public void setRazsoc(String razsoc) {
        this.razsoc = razsoc;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCodcorr() {
        return codcorr;
    }

    public void setCodcorr(Double codcorr) {
        this.codcorr = codcorr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLinea() {
        return linea;
    }

    public void setLinea(Double linea) {
        this.linea = linea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValreal() {
        return valreal;
    }

    public void setValreal(Double valreal) {
        this.valreal = valreal;
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
        if (!(object instanceof Ventasclientes)) {
            return false;
        }
        Ventasclientes other = (Ventasclientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Ventasclientes[ id=" + id + " ]";
    }
    
}
